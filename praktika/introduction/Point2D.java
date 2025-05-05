package introduction;

public class Point2D {
    //declaration of variables
    private int x;
    private int y;

    //getter for x_Coordinate
    public int getX() {
        return x;
    }

    //getter  for y-Coordinate
    public int getY() {
        return y;
    }

    //constructor for object with determined coordinates
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Standard constructor (constructor for undefined Coordinates)
    public Point2D(){
    }

    //add coordinates of a2 to the specific object
    public Point2D add(Point2D a2) {
        this.x += a2.x;
        this.y += a2.y;
        return this;
    }

    //calculate the distance from a point to the origin
    public double getDistanceFromOrigin() {
        return Math.sqrt(x * x + y * y);
    }
}
