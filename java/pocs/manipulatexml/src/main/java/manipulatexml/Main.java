package manipulatexml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class Main {

    public static void main(String [] args) {
      Main main = new Main();
      main.readXmlTable((row) -> System.out.println(row));
    }

    public void readXmlTable(Main.Process process){
      XMLInputFactory factory = XMLInputFactory.newInstance();
      try{
        XMLStreamReader reader = factory.createXMLStreamReader(
            Main.class.getClassLoader().getResourceAsStream("Tags_min.xml"));
        while(reader.hasNext()) {
          switch(reader.next()){
            case XMLEvent.START_ELEMENT:
              Map<String, String> row = new HashMap<>();
              if("row".equals(reader.getLocalName())){
                for(int i = 0; i < reader.getAttributeCount(); i++){
                  row.put(reader.getAttributeLocalName(i),
                      reader.getAttributeValue(i));
                }
                process.run(row);
              }
              break;
            case XMLEvent.END_ELEMENT:
              break;
            default:
              break;
          }
        }
      }catch(Exception e){
        e.printStackTrace();
      }
    }

    public interface Process {
      void run(Map<String, String> row);
    }

}
