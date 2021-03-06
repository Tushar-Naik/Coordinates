package components;

public class Intersection {
    private Point P;
    private Line L1, L2;

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
        float x = (m1 - m2) == 0 ? Float.MAX_VALUE : (c2 - c1) / (m1 - m2);
        float y = m1 * x + c1;
        if ((x < l1.getP1().X && x < l1.getP2().X)
                | (x > l1.getP1().X && x > l1.getP2().X)
                | (y > l1.getP1().Y && y > l1.getP2().Y)
                | (y < l1.getP1().Y && y < l1.getP2().Y)) {
            throw new InvalidCoordinatesException();
        }
        if ((x < l2.getP1().X && x < l2.getP2().X)
                | (x > l2.getP1().X && x > l2.getP2().X)
                | (y > l2.getP1().Y && y > l2.getP2().Y)
                | (y < l2.getP1().Y && y < l2.getP2().Y)) {
            throw new InvalidCoordinatesException();
        }
        return new Point(x, y);
    }

    public Point getP() {
        return P;
    }

    public Line getL1() {
        return L1;
    }

    public Line getL2() {
        return L2;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "P=" + P +
                ", L1=" + L1 +
                ", L2=" + L2 +
                '}';
    }
}
