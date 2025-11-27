package Cannibales;
import java.util.List;

public class Exercise {
    public static void main(String[] args) {
        System.out.println("Hello, this program should solve the Cannibalist problem!");
        int NB_MISS = 3;
        int NB_CANN = 3;
        
        CannibalProblem problem = new CannibalProblem(NB_MISS, NB_CANN);
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
