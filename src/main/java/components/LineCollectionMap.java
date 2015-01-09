package components;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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

}
