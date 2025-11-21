import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        System.out.println("Hello, this program should solve the Knights Tour!");
        int NB_ROWS = 5;
        int NB_COLS = 5;
        
        KnightsTourProblem problem = new KnightsTourProblem(NB_ROWS, NB_COLS);
        List<Node> solutionNodes = ResearchAlgorithm.search(problem);
        for (Node solutionNode : solutionNodes) {
            if (solutionNode != null) {
                System.out.println("Search has found a solution:");
                solutionNode.printSolution();
            } else {
                System.out.println("Could not find a solution.");
            }
        }
        System.out.println(String.format(" NB solutions totales %d", solutionNodes.size()) );
    }
}
