// ID: 206628794

/**
 * @author Amit Shavit
 * Velocity specifies the change in position on the `x` and the `y` axes.
 */

public class Velocity {
    private double dx;
    private double dy;
    /**
     * Constructor.
     * @param dx change in position on the 'x'
     * @param dy change in position on the 'y'
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * Constructor.
     * @return new Velocity
     * @param angle  degrees direction (assuming up is angle 0)
     * @param speed units
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }

    /**
     * @return the dx coordinate of the point
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * @return the x coordinate of the point
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Take a point with position (x,y) and return a new point, with position (x+dx, y+dy).
     * @return new point
     * @param p point
     */
    public Point applyToPoint(Point p) {
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }
}