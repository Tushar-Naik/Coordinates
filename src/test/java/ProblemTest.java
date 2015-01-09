import components.InvalidCoordinatesException;
import components.Line;
import components.Point;
import components.Shapes;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProblemTest {

    @Test
    public void testProblem1() {
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
        System.out.println(solutionSet);
    }

    @Test
    public void testProblem2() {
        List<Line> lines = new ArrayList<Line>();
        try {
            lines.add(new Line(new Point(1, 1), new Point(4, 4), "l1"));
            lines.add(new Line(new Point(1, 2), new Point(4, 4), "l2"));
            lines.add(new Line(new Point(1, 1), new Point(1, 4), "l3"));
        } catch (InvalidCoordinatesException e) {
            e.printStackTrace();
        }
        Problem problem = new Problem(lines);
        Set<Shapes> solutionSet = problem.solve();
        System.out.println(solutionSet);
    }


}