/**
 * Created by tushar.naik on 06/01/15.
 */
public class Line {
    private Point P1, P2;
    private int slope;

    public Line(Point p1, Point p2) {
        P1 = p1;
        P2 = p2;
        slope = (P2.Y - P1.Y)/(P2.X - P1.Y);
    }

    public int getSlope() {
        return slope;
    }

    @Override
    public String toString() {
        return "Line{" +
                "P1=" + P1 +
                ", P2=" + P2 +
                ", slope=" + slope +
                '}';
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
        result = 31 * result + slope;
        return result;
    }
}
