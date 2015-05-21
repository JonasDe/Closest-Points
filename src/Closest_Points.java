import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Closest_Points {
    public static Double main(String[] args) throws FileNotFoundException {

        if (args.length > 0) {
            File f = new File( "\\Development\\Algoritmer_Datastrukturer\\Lab4\\src\\test\\" + args[0]);
            // System.out.println("Absolute path " + f.getAbsolutePath());
            Scanner scan = new Scanner(f);
            // System.out.println(args[0]);
            String s = "NODE_COORD_SECTION";
            String next = scan.next();
            while (!next.equals(s)) {
                next = scan.next().trim();

            }
            int a = 0;

            ArrayList<Point> points = new ArrayList<Point>();

            while (scan.hasNext()) {
                String firstToken = scan.next();
                //System.out.println(firstToken);
                if(!firstToken.equals("EOF")) {
                    points.add(new Point(firstToken, scan.nextDouble(), scan
                            .nextDouble()));

            }}
            points = mergeSort(points, 'x');
            // Algorithm
            double maxDist = divideAndConquer(points);
//            System.out.println(args[0] +" " + points.size() + " " + maxDist);
            System.out.println(args[0]);
            System.out.println("Min distance " + maxDist);
            System.out.println();
            return maxDist;

        } else {
            System.out.println("Must enter a valid path");
            System.exit(0);
        }
        return 0.0;
    }

    public static double divideAndConquer(ArrayList<Point> points) {
        if (points.size() <= 1) {
            return -1;
        }
        if (points.size() == 2) {
            return points.get(0).distanceTo(points.get(1));
        }
        double left = divideAndConquer(new ArrayList<Point>(points.subList(0,
                points.size() / 2 - 1)));
        double right = divideAndConquer(new ArrayList<Point>(points.subList(
                points.size() / 2, points.size())));
        double smallest = min(left, right);
        double separationLine = (points.get(points.size() / 2).getX()
                + points.get(points.size() / 2 + 1).getX())/2;

        ArrayList<Point> strip = new ArrayList<Point>();
        for (int i = 0; i <  points.size(); i++) {
            if (points.get(i).distanceTo(separationLine) < smallest){
                strip.add(points.get(i));
            }
        }
        strip = mergeSort(strip, 'y');
        for (int i = 0; i < strip.size(); i++) {
            for(int j = i+1; j < strip.size(); j++ ) {
                double dist = strip.get(i).distanceTo(strip.get(j));
                if(j > i+6) break;
                if (dist < smallest || smallest == -1) {
                    smallest = dist;
                }
            }
        }
        return smallest;

    }

    private static double min(double left, double right) {
        if(left >= 0 && right >=0){
                return (left < right) ? left : right;
        } else if(left >= 0){
            return left;
        } else if(right >= 0){
            return right;
        } else{
            return -1;
        }
    }


    public static ArrayList<Point> mergeSort(ArrayList<Point> list, char c) {

        if (list.size() < 2)
            return new ArrayList<Point>(list);

        ArrayList<Point> first = new ArrayList<Point>(list.subList(0,
                list.size() / 2));
        ArrayList<Point> second = new ArrayList<Point>(list.subList(
                list.size() / 2, list.size()));

        return merge(mergeSort(first, c), mergeSort(second, c), c);
    }

    public static ArrayList<Point> merge(ArrayList<Point> first,
                                         ArrayList<Point> second, char c) {
        ArrayList<Point> mergedList = new ArrayList<Point>();
        int headFirst = 0;
        int headSecond = 0;
        if (c == 'x') { //sortera efter x-värde
            while (headFirst < first.size() && headSecond < second.size()) {
                Point a = first.get(headFirst);
                Point b = second.get(headSecond);
                if (a.getX() < b.getX()) {
                    mergedList.add(a);
                    headFirst++;
                } else {
                    mergedList.add(b);
                    headSecond++;
                }
            }
        } else if (c == 'y') { //sortera efter y-värde
            while (headFirst < first.size() && headSecond < second.size()) {
                Point a = first.get(headFirst);
                Point b = second.get(headSecond);
                if (a.getY() < b.getY()) {
                    mergedList.add(a);
                    headFirst++;
                } else {
                    mergedList.add(b);
                    headSecond++;
                }
            }

        }
        if (headFirst < headSecond) {
            for (int i = headFirst; i < first.size(); i++) {
                mergedList.add(first.get(i));
            }
        } else {
            for (int i = headSecond; i < second.size(); i++) {
                mergedList.add(second.get(i));
            }
        }
        return mergedList;
    }

}