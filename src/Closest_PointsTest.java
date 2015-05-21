import junit.framework.JUnit4TestCaseFacade;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static junit.framework.TestCase.fail;


public class Closest_PointsTest  {
    private File folder;
    @Before
    public void setUp(){
       folder = new File(System.getProperty("user.dir") + "\\src\\test");
    }
    @Test
    public void test () throws FileNotFoundException{
        File f = new File(System.getProperty("user.dir") + "\\src\\closest-pair.out");

        Scanner scan = new Scanner(f);
        ArrayList<Double> values = new ArrayList<Double>();
        while(scan.hasNext()){
            scan.next();
            scan.next();
            values.add(scan.nextDouble());
        }
        ArrayList<Double> distances = new ArrayList<Double>();
        System.out.println(folder.getAbsolutePath());
        String[] s = new String[1];
        long startTime = System.nanoTime();
        ArrayList<Long> time = new ArrayList<Long>();
        for (final File fileEntry : folder.listFiles()) {
                 s[0] = fileEntry.getName();

            distances.add(Closest_Points.main(s));

            }
        long estimatedTime = System.nanoTime() - startTime;
        for(int i = 0; i < values.size(); i++){
            double ab = distances.get(i);
            float a = (float) ab;
            double abc = values.get(i);
            float b = (float) abc;

        if(a != b)
            fail("The output from the algorithm didn't match the given output from the files");
//            System.out.println(ab);
        }
//        Object obj = Collections.max(time);


        System.out.println("Longest processing time for the algorithm: " + estimatedTime);
    }
    }
