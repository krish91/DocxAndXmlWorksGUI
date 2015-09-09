package ZipWorks;

import Templates.Credit;
import Templates.Name;
import Templates.RegistrationInfo;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

import java.io.*;

public class ParseXml {
    /**
     * Все переменные, начинающиеся с "template" содержат в своем массиве слова-шаблоны, по которым парсится XML.
     * Вместо слов-шаблонов подставляются значения из массива (без слова "template") соответственно.
     */
    private String[] templateName = Name.getTemplateName();
    private String[] name = Name.getName();

    private String[] templateCredit = Credit.getTemplateCredit();
    private String[] credit = Credit.getCredit();

    private String[] templatePassportInfo = RegistrationInfo.getTemplatePassportInfo();
    private String[] passportInfo = RegistrationInfo.getPassportInfo();

    public void parseXml(String xml_path) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        /**
         * Построение объектной модели исходного XML
         */

        File xmlFile = new File(xml_path);
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(xmlFile);
        doc.normalize();
        /**
         * Собираем все элементы с тегом w:t
         */
        NodeList nodeList = doc.getElementsByTagName("w:t");
        /**
         * Пробегаемся по списку и меняем данные на нужные нам
         */
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node nextNode = nodeList.item(i);

            for (int j = 0; j < templateName.length; j++) {
                if (nextNode.getTextContent().trim().equals(templateName[j])) {
                    nextNode.setTextContent(name[j]);
                }
            }

            for (int j = 0; j < templateCredit.length; j++) {
                if (nextNode.getTextContent().trim().equals(templateCredit[j])) {
                    nextNode.setTextContent(credit[j]);
                }
            }

            for (int j = 0; j < templatePassportInfo.length; j++) {
                if (nextNode.getTextContent().trim().equals(templatePassportInfo[j])) {
                    nextNode.setTextContent(passportInfo[j]);
                }
            }
        }
        /**
         * Записываем изменения в XML
         */
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new FileOutputStream(xml_path));
        transformer.transform(source, result);
    }
}