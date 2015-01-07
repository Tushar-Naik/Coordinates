/**
 * Created by tushar.naik on 07/01/15.
 */
public class Intersection {
    Point P;
    Line L1, L2;

    public Intersection(Line l1, Line l2) throws InvalidCoordinatesException {
        L1 = l1;
        L2 = l2;
        P = findIntersection(l1, l2);
    }

    private Point findIntersection(Line l1, Line l2) throws InvalidCoordinatesException {
        float m1 = l1.getSlope();
        float c1 = l1.getyIntercept();
        float m2 = l2.getSlope();
        float c2 = l2.getyIntercept();
        float x = (c2 - c1) / (m1 - m2);
        float y = m1 * x + c1;
        return new Point(x, y);
    }
}
