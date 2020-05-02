'use strict';
const _ = require('lodash'),
    cheerio = require('cheerio'),
    request = require('request'),
    rp = require('request-promise'),
    queryString = require('querystring'),
    SolrUpdate = require('solrClientApi').SolrUpdate;

const baseUri = 'http://aplicacao.saude.gov.br/sargsus/login!'
const actionShowForm = 'consultarRelatorioExterno.action';
const actionGetReport = 'baixarArquivo.action'

const defaultParams =  {
  tipoRelatorio: "01",
  codUf:"23",
  codTpRel:"01",
  ano:"2016",
  municipio:"231330",
}

const _makeUriShowForm = () => {
   return baseUri + actionShowForm + '?' + queryString.stringify(defaultParams);
}

const _makeUriGetReport = function (fileId) {
    let params =  {
      codArquivo: fileId,
      tpArquivo: defaultParams.codTpRel
    }
   return baseUri + actionGetReport + '?' + queryString.stringify(params);
}

const extractFileIds =  function (body) {
  // login!baixarArquivo.action?codArquivo="+coArquivo+"&tpArquivo="+tpArquivo;
  return body.match(/gerarArquivo\('[\d\w]*'\)/g).map((str) => {
    return str.replace("gerarArquivo('", "").replace("')","")
  });
}

const options = {
    uri: _makeUriShowForm(),
    transform: function (body) {
        return extractFileIds(body);
    }
};

const solrConfig = {
    host: "127.0.0.1:8983/solr",
    core: "collection_relatorio_1076"
};

const solrUpdate = new SolrUpdate(solrConfig);

rp(options).then(function (fileIds){
  return fileIds.map((id) => {
    return {
      "id": id,
      "url": _makeUriGetReport(id)
    }
  })
}).then(function(solrDocs){
  let indexSolrDocPromises = solrDocs.map(solrUpdate.downloadAndUpdateExtract);
  return Promise.all(indexSolrDocPromises);
}).then(function (){
  solrUpdate.commit();
}).catch(function (err) {
  console.log(err);
});
