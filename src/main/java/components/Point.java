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
}
