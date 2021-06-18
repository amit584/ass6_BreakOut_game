//ID: 206628794
package Sprites;
import java.util.ArrayList;
import Behavior.*;

/**
 * @author Amit Shavit
 * rectangle class with location,width,height.
 */
public class Rectangle {
    static final int TOP = 0;
    static final int BOTTOM = 1;
    static final int LEFT = 2;
    static final int RIGHT = 3;

    private Point upperLeft;
    private double width;
    private double height;


    /**
     * Constructor.
     * @param upperLeft - point of  upper left
     * @param width - width  of rectangle
     * @param height - height of rectangle
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }
    /**
     * sets the upper-left point of this rectangle.
     * @param upperLeft - new start location point
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     * 'breaks' the rectangle to 4 edges (4 lines).
     * @return an array with 4 lines that creat the rectangle in irs current position
     */
    public Line[] getEdges() {
        Line[] edges = new Line[4];
        //top
        edges[TOP] = new Line(upperLeft.getX(), upperLeft.getY(), upperLeft.getX() + width, upperLeft.getY());
        //left
        edges[LEFT] = new Line(upperLeft.getX(), upperLeft.getY() + 1, upperLeft.getX(), upperLeft.getY()
                + height - 1);
        //right
        edges[RIGHT] = new Line(upperLeft.getX() + width, upperLeft.getY() + 1, upperLeft.getX()
                + width, upperLeft.getY() + height - 1);
        //bottom
        edges[BOTTOM] = new Line(upperLeft.getX(), upperLeft.getY() + height, upperLeft.getX() + width,
                upperLeft.getY() + height);
        return edges;
    }

    /**
     * @return  a (possibly empty) List of intersection points with the specified line.
     * @param line - line to check if intersecting with
     * **/
    public java.util.List<Point> intersectionPoints(Line line) {
        Line[] edges = getEdges();
        java.util.List<Point> intersections = new ArrayList<>();
        for (Line edge : edges) {
            Point intersection = edge.intersectionWith(line);
            if (intersection != null) {
                intersections.add(intersection);
            }
        }
        return intersections;
    }


    /**
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     *  @return the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     *  @return the upper-right point of the rectangle.
     */
    public Point getUpperRight() {
        Point p = new Point(this.getUpperLeft().getX() + this.getWidth() - 1, this.getUpperLeft().getY());
        return p;
    }
    /**
     *  @return the bottom-right point of the rectangle.
     */
    public Point getBottomRight() {
        Point p = new Point(this.getUpperLeft().getX() + this.getWidth() - 1, this.getUpperLeft().getY()
                + this.height - 1);
        return p;
    }
    /**
     *  @return the bottom-left point of the rectangle.
     */
    public Point getBottomLeft() {
        Point p = new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.height - 1);;
        return p;

    }
    /**
     * checks if the given point is in this rectangle.
     * @return true if inside otherwise false
     * @param p - point
     */
    public boolean isInside(Point p) {
        return p.getX() >= getUpperLeft().getX() && p.getX() <= getUpperRight().getX()
                && p.getY() >= getUpperRight().getY() && p.getY() <= getBottomRight().getY();
    }
}