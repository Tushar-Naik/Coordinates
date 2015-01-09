package components;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tushar.naik on 09/01/15.
 */
public class LineCollectionMap {

    private Map<Line, Integer> linesInvolved;

    public LineCollectionMap() {
        linesInvolved = new HashMap<Line, Integer>();
    }

    public void add(Intersection intersection) {
        addLine(intersection.getL1());
        addLine(intersection.getL2());
    }

    private void addLine(Line line) {
        if(linesInvolved.containsKey(line)) {
            Integer count = linesInvolved.get(line);
            count++;
            linesInvolved.remove(line);
            linesInvolved.put(line, count);
        } else {
            linesInvolved.put(line, 1);
        }
    }

    public boolean isEnclosingAShape() {
        Collection<Integer> values = linesInvolved.values();
        System.out.println("values = " + values);
        return true;
    }

}
