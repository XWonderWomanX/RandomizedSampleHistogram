import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.sql.Timestamp;


public class CompressFiles2Zip {

    List<String> fileList;
    String timestamp = new Timestamp(System.currentTimeMillis()).toString();

    private static final String OUTPUT_ZIP_FILE = "/Users/tishafouzia/Desktop/Canary_Project/"+ "ArchiveFile" + new Timestamp(System.currentTimeMillis()) +"files.tar.gz";
    private static final String SOURCE_FOLDER = "/Users/tishafouzia/Desktop/Canary_Project/tmp";

    CompressFiles2Zip() {
        fileList = new ArrayList<String>();
    }

    public static void mainZip() {
        CompressFiles2Zip appZip = new CompressFiles2Zip();
        appZip.generateFileList(new File(SOURCE_FOLDER));
        appZip.zipIt(OUTPUT_ZIP_FILE);
    }

    //Zip it
    //@param zipFile output ZIP file location
    public void zipIt(String zipFile) {

        byte[] buffer = new byte[1024];

        try {

            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);

            System.out.println("Output to Zip : " + zipFile);

            for (String file : this.fileList) {

                System.out.println("File Added : " + file);
                ZipEntry ze = new ZipEntry(file);
                zos.putNextEntry(ze);

                FileInputStream in =
                        new FileInputStream(SOURCE_FOLDER + File.separator + file);

                int len;
                while ((len = in.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }

                in.close();
            }

            zos.closeEntry();
            //remember close it
            zos.close();

//For the tester to check
            System.out.println("Archiving done");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*Traverse a directory and get all files,
     and add the file into fileList
     @param node file or directory*/

    public void generateFileList(File node) {

        //add file only
        if (node.isFile()) {
            fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
        }

        if (node.isDirectory()) {
            String[] subNote = node.list();
            for (String filename : subNote) {
                generateFileList(new File(node, filename));
            }
        }
    }

    /*Format the file path for zip
    @param file file path
    @return Formatted file path */
    private String generateZipEntry(String file) {
        return file.substring(SOURCE_FOLDER.length() + 1, file.length());
    }

//*******************************************CLEAR FOLDER******************************************

    public static void ClearFolder() {
        File directory = new File("/Users/tishafouzia/Desktop/Canary_Project/tmp");
// Get all files in directory
        File[] files = directory.listFiles();
        for (File file : files) {
// Delete each file
            if (!file.delete()) {
//For the tester to check
                System.out.println("Failed to delete " + file);
            }
        }
    }
}