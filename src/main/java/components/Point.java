package components;

/**
 * Created by tushar.naik on 05/01/15.
 */
public class Point {
    float X,Y;
    public Point(float x, float y) throws InvalidCoordinatesException {
        X = x;
        Y = y;
        if (X > 100 || X < 0) {
            throw new InvalidCoordinatesException();
        } else if ( Y > 100 || Y < 0) {
            throw new InvalidCoordinatesException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Float.compare(point.X, X) != 0) return false;
        if (Float.compare(point.Y, Y) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (X != +0.0f ? Float.floatToIntBits(X) : 0);
        result = 31 * result + (Y != +0.0f ? Float.floatToIntBits(Y) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
