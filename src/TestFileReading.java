import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by Tank on 4/16/2015.
 */
public class TestFileReading
{
    final static File folder = new File(System.getProperty("user.dir") + "\\Lab4\\src\\test");

    public static void runnable() throws FileNotFoundException {
        System.out.println("User dir: " + System.getProperty("user.dir"));
        listFilesForFolder(folder);

    }
    public static void listFilesForFolder ( final File folder) throws FileNotFoundException{
        String[] s = new String[1];
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                s[0] = fileEntry.getName();
                Closest_Points.main(s);
            }
        }
    }


}
