package Cannibales;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {

    public static Node search(CannibalProblem problem){
        int counter = 0;
        List<Node> out = new ArrayList<>();
        List<Node> visited = new ArrayList<>();
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        visited.add(root);
        
        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(0);
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
            }
            for (Node child : currentNode.expand(problem)) {
                boolean unique = true;
                for (Node v : visited) {
                    if (child.getState().getScore() == v.getState().getScore()) {
                        unique == false;
                        break;
                    }
                }
                if (unique) {
                    frontier.add(child);
                    visited.add(child);
                }
            }
        }
        return null;
    }
    
}


