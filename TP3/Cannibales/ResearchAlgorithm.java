package Cannibales;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {

    public static Node search(CannibalProblem problem){
        int counter = 0;
        HashSet<State> visited = new HashSet<>();
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        
        frontier.add(root);
        visited.add(root.getState());
        
        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(0);
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
            }
            for (Node child : currentNode.expand(problem)) {

                if (!visited.contains(child.getState())) {
                    frontier.add(child);
                    visited.add(child.getState());
                }
            }
        }
        return null;
    }
    
}





