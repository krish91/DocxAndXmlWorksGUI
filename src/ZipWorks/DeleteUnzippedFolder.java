package ZipWorks;

import java.io.File;
import java.io.IOException;

public class DeleteUnzippedFolder {

    public void delete(String unzipped_docx_folder) throws IOException {
        File folder = new File(unzipped_docx_folder);
        if (!folder.exists()) {
            System.out.println("Директория \"" + (folder.getName() + "\" не существует "));
            System.exit(0);
        } else {
            deleteAll(new File(unzipped_docx_folder));
        }
    }

    /**
     * Рекурсивный метод удаления файлов и папок
     * @param node - узел, который мы передаем (файл, либо папка)
     */
    private void deleteAll(File node) throws IOException {
        if (node.isDirectory()) {
            if (node.list().length == 0) {
                node.delete();
            } else {
                String[] files = node.list();
                for (String file : files) {
                    deleteAll(new File(node, file));
                }
                // еще раз проверяем - пустая ли папка. Если да - удаляем
                if (node.list().length == 0) {
                    node.delete();
                }
            }
        }

        if (node.isFile()) {
            node.delete();
        }
    }
}
