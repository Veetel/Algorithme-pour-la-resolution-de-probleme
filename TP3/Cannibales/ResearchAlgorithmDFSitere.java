package Cannibales;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithmDFSitere {

    public static Node search(CannibalProblem problem, int maxDepth){
        int counter = 0;
        List<Node> visited = new ArrayList<>();
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        int uniqueAttribute = 0;
        
        for (int allowedDepth = 1; allowedDepth < maxDepth; allowedDepth++) {
            frontier.clear();
            visited.clear();
            frontier.add(root);
            visited.add(root);
            while(!frontier.isEmpty()){
                Node currentNode = frontier.remove(frontier.size() - 1);
                counter += 1;
                if (problem.isGoalState(currentNode.getState())){
                    System.out.println("Found a solution after evaluating " + counter + " nodes.");
                    return currentNode;
                }
                if (currentNode.getState().getScore() < allowedDepth) {
                    for (Node child : currentNode.expand(problem)) {
                        for (Node v : visited) {
                            uniqueAttribute = 3;
                            for(int j = 0 ; j < 3; j++){
                                if (child.getState().getBoard()[j] == v.getState().getBoard()[j]){
                                    uniqueAttribute --;   
                                }
                            }
                        }
                        if (uniqueAttribute ==0) {
                            frontier.add(child);
                            visited.add(child);
                        }
                        
                    }
                }
            }
        }
        return null;
    }
}
