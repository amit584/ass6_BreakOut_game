// ID: 206628794.

/**
 * @author Amit Shavit.
 * A line connects two points - a start point and an end point.
 * Lines have lengths, and may intersect with other lines. It can also tell if it is the same
 * as another line segment.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * Constructor.
     * @param start the start point of line
     * @param end the end point of line
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Constructor.
     * @param x1 the x coordinate of the start point
     * @param x2 the x coordinate of the end point
     * @param y1 the y coordinate of the start point
     * @param y2 the y coordinate of the end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * @return the length of the line using Point distance method
     */
    public double length() {
        return start.distance(end);
    }

    /**
     * @return the middle point of the line.
     */
    public Point middle() {
        double startX = this.start.getX();
        double startY = this.start.getY();
        double endX = this.end.getX();
        double endY = this.end.getY();
        return  new Point((startX + endX) / 2, (startY + endY) / 2);
    }

    /**
     * checks if a point is on this line.
     * @param point - given point
     * @return true if point is on this line.
     */
    public boolean isOn(Point point) {
        if (isVertical()) {
            return point.getX() == this.start.getX()
                    && point.getY() <= Math.max(this.start.getY(), this.end.getY())
                    && point.getY() >= Math.min(this.start.getY(), this.end.getY());
        }
        return point.getY() == point.getX() * this.getSlop() + this.getN();
    }

    /**
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * check if intersecting point between 2 lines is at the start/end.
     * @return the shared point or null if doesnt exists.
     * @param other line to check if has the same build points
     */
    private Point sameBuildPoints(Line other) {
        if (this.start().equals(other.end()) || this.start().equals(other.start())) {
            return this.start;
        }
        if (this.end().equals(other.start()) || this.end().equals(other.end())) {
            return this.end;
        }
        return null;
    }

    /**
     * checks if a line is vertical.
     * @return true if is, otherwise false
     */
    public boolean isVertical() {
        return start.getX() == end().getX();
    }

    /**
     * calculates the linear equation of each line, if lines have the same slop- check if they connect at
     * start/ end point. otherwise, finding an intersecting point using the equation and checking
     *  if the point is on both segments.
     * @return the intersection point if the lines intersect, and null otherwise.
     * @param other line to check intersection with
     */
    public Point intersectionWith(Line other) {
        double m1 = this.getSlop();
        double n1 = this.getN();
        double m2 = other.getSlop();
        double n2 = other.getN();
        //case of intersecting point is at start or end.
        if (m1 == m2) {
            return this.sameBuildPoints(other);
        }
        double xa;
        double ya;
        if (this.isVertical()) {
            xa = this.start.getX();
            ya = m2 * xa + n2;
        } else if (other.isVertical()) {
            xa = other.start.getX();
            ya = m1 * xa + n1;
        }  else {
            // finding an intersecting point using the equation
            xa = (n2 - n1) / (m1 - m2);
            ya = m1 * xa + n1;
        }
        //check if the point is on both segments.
        double firstLineX1 = Math.min(this.start.getX(), this.end.getX());
        double firstLineX2 = Math.min(other.start.getX(), other.end.getX());
        double startInterX = Math.max(firstLineX1, firstLineX2);
        double secondLineX1 = Math.max(this.start.getX(), this.end.getX());
        double secondLineX2 = Math.max(other.start.getX(), other.end.getX());
        double endInterX = Math.min(secondLineX1, secondLineX2);
        double firstLineY1 = Math.min(this.start.getY(), this.end.getY());
        double firstLineY2 = Math.min(other.start.getY(), other.end.getY());
        double startInterY = Math.max(firstLineY1, firstLineY2);
        double secondLineY1 = Math.max(this.start.getY(), this.end.getY());
        double secondLineY2 = Math.max(other.start.getY(), other.end.getY());
        double endInterY = Math.min(secondLineY1, secondLineY2);
        if (startInterX <= xa && endInterX >= xa && startInterY <= ya && endInterY >= ya) {
            return new Point(xa, ya);
        }
        return null;
    }
    /**
     * finds the n of a this linear equation  - Y-Intercept of a Straight Line.
     * @return int (Where a line crosses the y-axis of a graph).
     */
    public double getN() {
        return this.start.getY() - this.getSlop() * this.start.getX();
    }
    /**
     * finds the slop of this linear equation.
     * @return int (slop)
     */
    public double getSlop() {
        double startX = this.start.getX();
        double startY = this.start.getY();
        double endX = this.end.getX();
        double endY = this.end.getY();
        return (startY - endY) / (startX - endX);
    }
    /**
     * @return true if the lines intersect, false otherwise.
     * @param other - other line
     */
    private boolean isIntersecting(Line other) {
        return intersectionWith(other) != null;
    }

    /**
     * compare start/end points to check if lines are the same.
     * @return true is the lines are equal, false otherwise
     * @param other the line to check if equals to
     */
    public boolean equals(Line other) {
        if (this.start().equals(other.start()) && this.end.equals(other.end())) {
            return true;
        }
        return this.start.equals(other.end) && this.end.equals(other.start);
    }

    /**
     * @return null - If this line does not intersect with the rectangle
     * Otherwise, return the closest intersection point to the start of the line.
     * @param rect - rectangle
     **/
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        java.util.List<Point> intersections = rect.intersectionPoints(this);
        if (intersections.isEmpty()) {
            return null;
        }
        if (intersections.size() ==  1) {
            return intersections.get(0);
        }
        if (this.start.distance(intersections.get(0))  >= this.start.distance(intersections.get(1))) {
            return intersections.get(0);
        } else {
            return intersections.get(1);
        }
    }
}
