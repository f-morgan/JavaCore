import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String fileName = "data.xml";
        List<Employee> list = parseXML(fileName);
        String json = listToJson(list);
        writeString(json);
    }

    private static List<Employee> parseXML(String fileName) {
        try {
            List<Employee> list = new ArrayList<>();
            File file = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            Node root = doc.getDocumentElement();
            read(root, list);
            return list;

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static void read(Node node, List<Employee> list) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                Element element = (Element) node_;
                NamedNodeMap attributes = element.getAttributes();
                Employee employee = new Employee(
                        Long.parseLong(attributes.getNamedItem("id").getNodeValue()),
                        attributes.getNamedItem("firstName").getNodeValue(),
                        attributes.getNamedItem("lastName").getNodeValue(),
                        attributes.getNamedItem("country").getNodeValue(),
                        Integer.parseInt(attributes.getNamedItem("age").getNodeValue())
                );
                list.add(employee);
                read(node_, list);
            }
        }
    }


    private static String listToJson(List<Employee> list) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {}.getType();
        return gson.toJson(list, listType);
    }

    private static void writeString(String json) {
        try (FileWriter fw = new FileWriter("data.json")) {
            fw.write(json);
            fw.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}