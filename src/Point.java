// ID: 206628794

/**
 * @author Amit Shavit
 * one dimensional point.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructor.
     *
     * @param x the x coordinate of the point
     * @param y the y coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * sets x coordinates.
     * @param x - new x coordinates
     */
    public void setX(double x) {
        this.x = x;
    }
    /**

     * @param other Point to calculate distance from
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        double x1 = this.getX();
        double y1 = this.getY();
        double x2 = other.getX();
        double y2 = other.getY();
        double distance = Math.abs((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2));
        return Math.sqrt(distance);
    }

    /**
     * @param other Point
     * @return true is the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return this.x == other.x && this.y == other.y;
    }

    /**
     * @return the x coordinate of this point
     */
    public double getX() {
        return this.x;
    }

    /**
     * @return the y coordinate of this point
     */
    public double getY() {
        return this.y;
    }
}
