import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

    public class ArchiveFiles {

        // Driver Method
        public static void main(String[] args)
        {

            // dd is the infinite while loop variable
            int dd = 1;
            while (dd==1){

                // Provide full path for directory(change accordingly)
                String filePath = "/Users/tishafouzia/Desktop/Canary_Project/";
                String fileName = "tmp";

                // File object
                File maindir = new File(filePath);

                if(maindir.exists() && maindir.isDirectory()){

                    //System.out.println("Files from main directory : " + maindir);

                    String[] directories = maindir.list(new FilenameFilter() {

                        public boolean accept(File current, String name) {
                            return new File(current, name).isDirectory();
                        }
                    });

                    //System.out.println(Arrays.toString(directories));

                    if(Arrays.asList(directories).contains(fileName)){
                        System.out.println("found");
 //For the tester to check
                    }
                    else {
 //For the tester to check
                        System.out.println("not found");

                        File f = null;
                        boolean bool = false;


                        f = new File(filePath +fileName);
                        // create directories
                        bool = f.mkdirs();

                    }

                    File folder = new File(filePath +fileName);

                    String[] files = folder.list();

                    for (String file : files) {
//For the tester to check
                        System.out.println(fileName+ ": " + file);
                    }

                    int arrayLength = files.length;
//For the tester to check
                    System.out.println("files.length: " + arrayLength);

                    //If there are 10 folders in tmp file then trigger creating a zip file with the 10 files
                    //deposit the zip file into main working directory set previously and
                    //delete content of the tmp file
                    if (arrayLength >= 10){

                        CompressFiles2Zip.mainZip();
                        CompressFiles2Zip.ClearFolder();


                    }
                }
            }
        }
    }


