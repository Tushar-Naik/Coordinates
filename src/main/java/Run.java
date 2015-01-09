/**
 * Created by tushar.naik on 05/01/15.
 */
public class Run {

    Problem problem;

    public Run() {
        problem = new Problem();
        problem.solve();
    }

    public static void main(String[] args) {
        Run run = new Run();
    }
}
