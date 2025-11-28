package Cannibales;

public class Exercise {
    public static void main(String[] args) {
        System.out.println("Hello, this program should solve the Cannibalist problem!");
        int NB_MISS = 3;
        int NB_CANN = 3;
        
        CannibalProblem problem = new CannibalProblem(NB_MISS, NB_CANN);
        Node solutionNode = ResearchAlgorithm.search(problem);
            if (solutionNode != null) {
                System.out.println("Search has found a solution:");
                solutionNode.printSolution();
            } else {
                System.out.println("Could not find a solution.");
            }
        
        solutionNode = ResearchAlgorithmDFS.search(problem);
            if (solutionNode != null) {
                System.out.println("DDFS Search has found a solution:");
                solutionNode.printSolution();
            } else {
                System.out.println("Could not find a solution.");
            }
        solutionNode = ResearchAlgorithm.search(problem);
            if (solutionNode != null) {
                System.out.println("DFS Iter Search has found a solution:");
                solutionNode.printSolution();
            } else {
                System.out.println("Could not find a solution.");
            }
        
    }
}
