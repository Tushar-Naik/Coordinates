import components.*;
import helpers.FileHelper;
import helpers.Helper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tushar.naik on 09/01/15.
 */
public class Problem {
    private List<Intersection> intersections;
    private Set<Line> lines;

    public Problem() {
        try {
            lines = FileHelper.populateLines(getFileContents("input.txt"));
            intersections = getIntersections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Problem(Set<Line> lines) {
        this.lines = lines;
        intersections = getIntersections();
    }

    private List<Intersection> getIntersections() {
        List<Intersection> intersectionSet = new ArrayList<Intersection>();
        for (Line l1 : lines) {
            for (Line l2 : lines) {
                try {
                    Intersection intersection = new Intersection(l1, l2);
                    intersectionSet.add(intersection);
                } catch (InvalidCoordinatesException e) {
                    System.out.println("Intersection out of bounds");
                }
            }
        }
        return intersectionSet;
    }

    List getFileContents(String fileName) throws IOException {
        InputStream in = this.getClass().getResourceAsStream("/" + fileName);
        return IOUtils.readLines(in);
    }

    public void solve() {
        Set<Shapes> solutionSet = new HashSet<Shapes>();
        if (intersections.size() < 3) {
            System.out.println("No Shapes Present");
            return;
        }

        for (int i = 3; i < intersections.size(); i++) {
            Set<List<Integer>> permutations = Helper.generatePermutations(Helper.range(i));
            LineCollectionMap lineCollectionMap = new LineCollectionMap();
            for (List<Integer> permutation : permutations) {
                for(Integer perm : permutation) {
                    lineCollectionMap.add(intersections.get(perm));
                }
                if(lineCollectionMap.isEnclosingAShape()) {
                    solutionSet.add(new Shapes(i));
                }
            }
        }

        System.out.println("#######################");
        System.out.println("final solution, the shapes present are:");
        for(Shapes shapes : solutionSet) {
            System.out.println("Shape:"+shapes.getShapeName());
        }
    }


    public static void main(String[] args) {
        Set<Line> lines = new HashSet<Line>();
        try {
            lines.add(new Line(new Point(1, 1), new Point(4, 4)));
            lines.add(new Line(new Point(1, 4), new Point(4, 4)));
            lines.add(new Line(new Point(1, 1), new Point(1, 4)));
        } catch (InvalidCoordinatesException e) {
            e.printStackTrace();
        }
        Problem problem = new Problem(lines);
        problem.solve();
    }
}
