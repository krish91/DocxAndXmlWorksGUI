package ZipWorks;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Кирилл on 05.09.2015.
 */
public class UnZipDocx {
    private static final byte[] BUFFER = new byte[1024];

    public void unzip(String docx_path, String unzipped_folder) throws IOException {
        File folder = new File(unzipped_folder);
        /**
         * Проверка на существование директории, куда собираемся распаковывать наш .docx
         */
        if (!folder.exists()) {
            folder.mkdir();
        }
        /**
         * Приступаем к распаковке.
         */
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(docx_path))) {
            ZipEntry ze;

            while ((ze = zis.getNextEntry()) != null) {
                String nameOfFile = ze.getName();
                File newFile = new File(unzipped_folder + File.separator + nameOfFile);
                /**
                 * Делаем проверку на существование папок/подпапок в директории, куда распаковываем наш .docx
                 */
                File innerFolder = new File(newFile.getParent());
                if (!innerFolder.exists()) {
                    checkFolders(new File(newFile.getParent()));
                }

                try (OutputStream writeFile = new FileOutputStream(newFile)) {
                    int len;
                    while ((len = zis.read(BUFFER)) > 0) {
                        writeFile.write(BUFFER, 0, len);
                    }
                }
            }
        }
    }

    /**
     * Метод создает отсутствующие папки/подпапки
     *
     * @param node
     */
    public void checkFolders(File node) {
        String[] folders = node.toString().split("\\\\");
        StringBuilder path = new StringBuilder();
        String dir = folders[0] + File.separator;
        if (!(new File(dir)).exists()) {
            (new File(dir)).mkdir();
        }
        path.append(dir);

        for (int i = 1; i < folders.length; i++) {
            File check = new File(path.toString() + folders[i] + File.separator);
            if (!check.exists()) {
                check.mkdir();
                path.append(folders[i] + File.separator);
                System.out.println("Добавлена папка: " + folders[i]);
            } else {
                path.append(folders[i] + File.separator);
            }
        }
    }
}
