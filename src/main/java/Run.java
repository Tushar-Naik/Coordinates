import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by tushar.naik on 05/01/15.
 */
public class Run {

    Set<Line> lines;

    public Run() {
        lines = populateLines("input.txt");
    }

    private Set<Line> populateLines(String fileName) {
        Set<Line> lineSet = new HashSet<Line>();
        try {
            List linesInFile = getFileContents(fileName);
            for (Object aLineInFile : linesInFile) {
                String s = aLineInFile.toString();
                Point p1 = getPoint(s.split(";")[0].trim());
                Point p2 = getPoint(s.split(";")[1].trim());
                lineSet.add(new Line(p1, p2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidCoordinatesException e) {
            e.printStackTrace();
        }
        return lineSet;
    }

    private Point getPoint(String point) throws InvalidCoordinatesException {
        int x = Integer.parseInt(point.split(",")[0].trim());
        int y = Integer.parseInt(point.split(",")[1].trim());
        return new Point(x, y);
    }

    List getFileContents(String fileName) throws IOException {
        InputStream in = this.getClass().getResourceAsStream("/" + fileName);
        return IOUtils.readLines(in);
    }

    public static void main(String[] args) {
        Run run = new Run();
    }
}
