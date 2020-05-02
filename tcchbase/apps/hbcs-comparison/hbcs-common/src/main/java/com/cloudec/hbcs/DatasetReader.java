package com.cloudec.hbcs;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-01
 */
public class DatasetReader {

  public void readXmlTable(final String pathXml, final Process process) {
    HbcsFileUtils.verifyIfExist(pathXml);
    try (InputStream xmlStream = new FileInputStream(pathXml);) {
      readXmlTable(xmlStream, process);
    } catch (IOException ex) {
      throw new HbcsException("erro_when_create_file_inputstream", ex);
    }
  }

  public void readXmlTable(final InputStream xmlStream, final Process process) {
    BufferedReader readerFile = new BufferedReader(new InputStreamReader(xmlStream));
    try {
      readerFile.lines().forEach(line -> {
        // process liness
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        try {
          reader = factory.createXMLStreamReader(
              new ByteArrayInputStream(line.getBytes("UTF-8")));
          while (reader.hasNext()) {
            switch (reader.next()) {
              case XMLEvent.START_ELEMENT:
                readRow(reader, process);
                break;
              default:
                break;
            }
          }
        } catch (Exception e) {
          //throw new HbcsException("erro_read_xml", e);
        } finally {
          closeXml(reader);
        }
      });
    } finally {
      closeFile(readerFile);
    }
  }

  private void readRow(final XMLStreamReader reader, final Process process) {
    if ("row".equals(reader.getLocalName())) {
      Map<String, String> row = new HashMap<>();
      for (int i = 0; i < reader.getAttributeCount(); i++) {
        row.put(reader.getAttributeLocalName(i),
            reader.getAttributeValue(i));
      }
      process.exec(row);
    }
  }

  private void closeXml(final XMLStreamReader reader) {
    if (reader != null) {
      try {
        reader.close();
      } catch (XMLStreamException ex) {
        throw new HbcsException("erro_when_close_reader", ex);
      }
    }
  }

  private void closeFile(final BufferedReader reader) {
    if (reader != null) {
      try {
        reader.close();
      } catch (IOException ex) {
        throw new HbcsException("erro_when_close_reader", ex);
      }
    }
  }

  public interface Process {

    void exec(Map<String, String> row);
  }

}
