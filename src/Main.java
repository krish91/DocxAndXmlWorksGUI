import ZipWorks.DeleteUnzippedFolder;
import ZipWorks.ParseXml;
import ZipWorks.UnZipDocx;
import ZipWorks.ZipInDocx;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;


public class Main {
    private static final String MAIN_PATH = "C:\\Java Programs\\DocxConvert\\";
    private static final String[] DOCX_NAME = {"man0.docx", "woman0.docx"};
    private static final String[] DOCX_PATH = {MAIN_PATH + DOCX_NAME[0], MAIN_PATH + DOCX_NAME[1]};
    private static final int MAN_ID = 0, WOMAN_ID = 1;
    private static final String UNZIPPED_FOLDER = MAIN_PATH + "src\\ZipWorks\\unzipped";
    private static final String XML_PATH = UNZIPPED_FOLDER + "\\word\\document.xml";
    private static final String NEW_DOCX_FILE = MAIN_PATH + "Готовый файл.docx";

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        unzipDocx(DOCX_PATH, UNZIPPED_FOLDER);
        parseXml(XML_PATH);
        zipInDocx(NEW_DOCX_FILE, UNZIPPED_FOLDER);
        deleteUnzippedFolder(UNZIPPED_FOLDER);
    }

    public static void unzipDocx(String[] docx_path, String unzipped_folder) throws IOException {
        String manROwoman = docx_path[MAN_ID];
        UnZipDocx unzip = new UnZipDocx();
        unzip.unzip(manROwoman, unzipped_folder);
    }

    public static void parseXml(String xml_path) throws IOException, SAXException, ParserConfigurationException, TransformerException {
        ParseXml parse = new ParseXml();
        parse.parseXml(xml_path);
    }

    public static void zipInDocx(String new_docx_file, String unzipped_folder) throws IOException {
        ZipInDocx zipInDocx = new ZipInDocx(UNZIPPED_FOLDER);
        zipInDocx.generateFileList(new File(unzipped_folder));
        zipInDocx.zip(new_docx_file);
    }

    public static void deleteUnzippedFolder(String unzipped_folder) throws IOException {
        DeleteUnzippedFolder delete = new DeleteUnzippedFolder();
        delete.delete(unzipped_folder);
    }
}
