package Cavaliers;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithmDFSitere {

    public static Node search(KnightsTourProblem problem, int maxDepth){
        int counter = 0;
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null,0);
        
        for (int allowedDepth = 1; allowedDepth < maxDepth; allowedDepth++) {
            frontier.add(root);
            while(!frontier.isEmpty()){
                Node currentNode = frontier.remove(frontier.size() - 1); // LIFO => DFS
                counter += 1;
                if (problem.isGoalState(currentNode.getState())){
                    System.out.println("Found a solution after evaluating " + counter + " nodes.");
                    return currentNode;
                } else if (currentNode.getDepth() < allowedDepth){
                    frontier.addAll(currentNode.expand(problem));
                }
            }
        }
        return null;
    }
}
