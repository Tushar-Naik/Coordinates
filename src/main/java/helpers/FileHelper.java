package helpers;

import components.Intersection;
import components.InvalidCoordinatesException;
import components.Line;
import components.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tushar.naik on 09/01/15.
 */
public class FileHelper {

    private static Point getPoint(String point) throws InvalidCoordinatesException {
        int x = Integer.parseInt(point.split(",")[0].trim());
        int y = Integer.parseInt(point.split(",")[1].trim());
        return new Point(x, y);
    }


    public static Set<Line> populateLines(List linesInFile) {
        Set<Line> lineSet = new HashSet<Line>();
        try {
            for (Object aLineInFile : linesInFile) {
                String s = aLineInFile.toString();
                Point p1 = getPoint(s.split(";")[0].trim());
                Point p2 = getPoint(s.split(";")[1].trim());
                lineSet.add(new Line(p1, p2));
            }
        } catch (InvalidCoordinatesException e) {
            e.printStackTrace();
        }
        Set<Intersection> intersectionSet = new HashSet<Intersection>();
        for (Line l1 : lineSet) {
            for (Line l2 : lineSet) {
                try {
                    intersectionSet.add(new Intersection(l1, l2));
                } catch (InvalidCoordinatesException e) {
                    e.printStackTrace();
                }
            }
        }
        return lineSet;
    }
}
