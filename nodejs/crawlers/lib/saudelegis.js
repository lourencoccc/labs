
const http = require('http'),
      https = require('https');

const DEFAULT_CONFIG = {
    saudeLegis : {
        baseUri: 'http://portal2.saude.gov.br/saudelegis/leg_norma_pesq_consulta.cfm?',
        defaultParams: {
            assunto: '',
            tipoBusca: 'get',
            sqlcTipoNorma: '27',
            hdTipoNorma: '',
            numero: '',
            data: '03/07/2017',
            dataFim:'06/07/2017',
            ano: '',
            slcOrigem: 122,
            slcFonte: 105,
            sit: 0,
            qtd: 10,
            assunto_: '',
            logica_: 'E',
            assunto1_: '',
            pesquisa: 'PESQUISAR',
            ordenacao: 'ASC',
            cont: 2,
            buscaForm: 'get',
            startrow: 1,
            frompage: 1,
            qtdAssunto: 0
        }
    }
};
