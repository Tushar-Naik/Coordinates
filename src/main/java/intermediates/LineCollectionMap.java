package intermediates;

import components.Intersection;
import components.Line;
import components.Point;

import java.util.*;

public class LineCollectionMap {

    /**
     * For every k intersections, a linesInvolved map is maintained.
     * This ever line in this map must have a count of 2, to be enclosing a shape
     */

    private Map<Line, Integer> linesInvolved;

    public LineCollectionMap() {
        linesInvolved = new HashMap<Line, Integer>();
    }

    public void add(Intersection intersection) {
        addLine(intersection.getL1());
        addLine(intersection.getL2());
    }

    private void addLine(Line line) {
        if (linesInvolved.containsKey(line)) {
            Integer count = linesInvolved.get(line);
            count++;
            linesInvolved.remove(line);
            linesInvolved.put(line, count);
        } else {
            linesInvolved.put(line, 1);
        }
    }

    public boolean isEnclosingAShape() {
        // check if all keys have values=2 in the map, else return false
        Collection<Integer> values = linesInvolved.values();
        for (int value : values) {
            if (value != 2) {
                return false;
            }
        }
        return true;
    }

    public Set<Point> getShapeEndPoints() {
        Set<Point> points = new HashSet<Point>();
        Set<Line> lines = linesInvolved.keySet();
        for(Line line: lines) {
            points.add(line.getP1());
            points.add(line.getP2());
        }
        return points;
    }

}
