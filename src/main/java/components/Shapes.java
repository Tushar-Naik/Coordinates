package components;

import java.util.Set;

public class Shapes {

    public static enum Shape {
        TRIANGLE, QUADRILATERAL, PENTAGON, HEXAGON, HEPTAGON, OCTAGON;
    }

    Shape shape;
    Set<Point> endPoints;

    public Shapes(Shape shape, Set<Point> endPoints) {
        this.shape = shape;
        this.endPoints = endPoints;
    }

    public Shapes(int index, Set<Point> endPoints) {
        this.shape = Shape.values()[index - 3];
        this.endPoints = endPoints;
    }

    public String getShapeName() {
        return getShapeName(shape);
    }

    public String getShapeName(Shape shape) {
        switch (shape) {
            case TRIANGLE:
                return "Triangle";
            case QUADRILATERAL:
                return "Quadrilateral";
            case PENTAGON:
                return "Pentagon";
            case HEXAGON:
                return "Hexagon";
            case HEPTAGON:
                return "Heptagon";
            case OCTAGON:
                return "Octagon";
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        String p = "";
        for (Point point : endPoints) {
            p = p + point + " ";
        }
        return shape + ", with vertices= " + endPoints ;
    }
}
