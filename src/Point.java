/**
 * Created by Tank on 4/16/2015.
 */
public class Point {
    String name;
    double x;
    double  y;
    public Point(String name, double
                         x, double y){
        this.name = name;
        this.x = x;
        this.y = y;

    }
    public double distanceTo(Point p){
        return Math.sqrt((x - p.x)*(x- p.x) + (y-p.y)*(y-p.y)); //Pythagorian theorem
    }

    public double distanceTo(double seperationLine) {
        return Math.min(Math.abs(x - seperationLine), Math.abs(y - seperationLine));
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString(){
        return name + " x " + x + " y " + y;
    }
}
