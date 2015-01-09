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

public class Problem {
    private List<Intersection> intersections;
    private List<Line> lines;

    public Problem() {
        try {
            lines = FileHelper.populateLines(getFileContents("input.txt"));
            intersections = getIntersections();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Problem(List<Line> lines) {
        this.lines = lines;
        intersections = getIntersections();
    }

    private List<Intersection> getIntersections() {
        List<Intersection> intersectionList = new ArrayList<Intersection>();
        for (int i = 0; i < lines.size(); i++) {
            Line l1 = lines.get(i);
            for (int j = i+1; j < lines.size(); j++) {
                Line l2 = lines.get(j);
                if (!l2.equals(l1)) {
                    try {
                        Intersection intersection = new Intersection(l1, l2);
                        intersectionList.add(intersection);
                    } catch (InvalidCoordinatesException e) {
                        System.out.println("Intersection out of bounds");
                    }
                }
            }
        }
        for (Intersection intersection : intersectionList) {
            System.out.println("Intersection: " + intersection);
        }
        return intersectionList;
    }

    List getFileContents(String fileName) throws IOException {
        InputStream in = this.getClass().getResourceAsStream("/" + fileName);
        return IOUtils.readLines(in);
    }

    public Set<Shapes> solve() {
        Set<Shapes> solutionSet = new HashSet<Shapes>();
        if (intersections.size() < 3) {
            System.out.println("No Shapes Present");
            return solutionSet;
        }
        for (int i = 3; i <= intersections.size(); i++) {
            Set<List<Integer>> permutations = Helper.generatePermutations(Helper.range(i));
            LineCollectionMap lineCollectionMap = new LineCollectionMap();
            for (List<Integer> permutation : permutations) {
                for (Integer perm : permutation) {
                    lineCollectionMap.add(intersections.get(perm));
                }
                if (lineCollectionMap.isEnclosingAShape()) {
                    solutionSet.add(new Shapes(i));
                }
            }
        }
        return solutionSet;
    }


    public static void main(String[] args) {
        List<Line> lines = new ArrayList<Line>();
        try {
            lines.add(new Line(new Point(1, 1), new Point(4, 4), "l1"));
            lines.add(new Line(new Point(1, 4), new Point(4, 4), "l2"));
            lines.add(new Line(new Point(1, 1), new Point(1, 4), "l3"));
        } catch (InvalidCoordinatesException e) {
            e.printStackTrace();
        }
        Problem problem = new Problem(lines);
        Set<Shapes> solutionSet = problem.solve();
        System.out.println("#######################");
        System.out.println("final solution, the shapes present are:");
        if(solutionSet.isEmpty()) {
            System.out.println("There are no shapes present");
        }
        for (Shapes shapes : solutionSet) {
            System.out.println("Shape: " + shapes.getShapeName());
        }
    }
}
