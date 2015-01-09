package components;

public class Line {
    private String lineName;
    private Point P1, P2;
    private float slope;
    private float yIntercept;

    public Line(Point p1, Point p2) {
        this(p1, p2, null);
    }

    public Line(Point p1, Point p2, String lineName) {
        P1 = p1;
        P2 = p2;
        slope = getSlope(p1, p2);
        yIntercept = getyIntercept(p1, slope);
        this.lineName = lineName;
    }

    public float getSlope() {
        return slope;
    }

    public float getSlope(Point p1, Point p2) {
        if (P2.X - P1.X == 0) return Float.MAX_VALUE;
        return (P2.Y - P1.Y) / (P2.X - P1.X);
    }

    public Point getP1() {
        return P1;
    }

    public Point getP2() {
        return P2;
    }

    @Override
    public String toString() {
        if (lineName == null) {
            return "L[" + P1 +
                    ", " + P2 +
                    ", m=" + slope +
                    ']';
        } else {
            return lineName +
                    "[" + P1 +
                    ", " + P2 +
                    ", m=" + slope +
                    ']';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (slope != line.slope) return false;
        if (!P1.equals(line.P1)) return false;
        if (!P2.equals(line.P2)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = P1.hashCode();
        result = 31 * result + P2.hashCode();
        result = 31 * result + (slope != +0.0f ? Float.floatToIntBits(slope) : 0);
        result = 31 * result + (yIntercept != +0.0f ? Float.floatToIntBits(yIntercept) : 0);
        return result;
    }

    public float getyIntercept() {
        return yIntercept;
    }

    public float getyIntercept(Point p, float slope) {
        return p.Y - slope * p.X;
    }
}
