package ZipWorks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipInDocx {
    List<String> fileList;
    private static final byte[] BUFFER = new byte[1024];
    private String sourceFolder;

    public ZipInDocx(String sourceFolder) {
        fileList = new ArrayList<>();
        this.sourceFolder = sourceFolder;
    }

//    public static void main(String[] args) throws IOException {
//        ZipInDocx zipInDocx = new ZipInDocx();
//        zipInDocx.generateFileList(new File("C:\\Java Programs\\DocxConvert\\src\\ZipWorks\\unzipped"));
//        zipInDocx.zip("C:\\Java Programs\\DocxConvert\\Готовый файл.docx");
//    }

    public void generateFileList(File node) {
        if (node.isDirectory()) {
            String[] nodeList = node.list();
            for (String s : nodeList) {
                generateFileList(new File(node, s));
            }
        }
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }
    }

    public String generateZipEntry(String file) {
        return file.substring(sourceFolder.length() + 1, file.length());
    }

    public void zip(String outputFile) throws IOException {
        /**
         * входящие данные - файлы, которые расположены в папке unzipped
         * исходящий файл - "Готовый файл.docx"
         */
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outputFile))) {
            for (String file : fileList) {
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);

                try (FileInputStream writeFiles = new FileInputStream(sourceFolder + File.separator + file)) {

                    int len;
                    while ((len = writeFiles.read(BUFFER)) > 0) {
                        zos.write(BUFFER, 0, len);
                    }
                }
            }
        }
    }
}