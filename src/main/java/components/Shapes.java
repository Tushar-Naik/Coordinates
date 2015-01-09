package components;

/**
 * Created by tushar.naik on 09/01/15.
 */
public class Shapes {

    public static enum Shape {
        TRIANGLE, QUADRILATERAL, PENTAGON, HEXAGON, HEPTAGON, OCTAGON
    }

    Shape shape;

    public Shapes(Shape shape) {
        this.shape = shape;
    }

    public Shapes(int index) {
        this.shape = Shape.values()[index - 2];
    }

    public String getShapeName() {
        return getShapeName(shape);
    }

    public String getShapeName(int index) {
        return new Shapes(index).getShapeName();
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
}