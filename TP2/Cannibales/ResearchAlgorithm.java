package Cannibales;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {

    public static List<Node> search(CannibalProblem problem){
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
                out.add(currentNode);
            }
            for (Node child : currentNode.expand(problem)) {
                boolean contenance = false;
                for (Node n : visited) {
                    if (n.getState().getBoard().equals(child.getState().getBoard())) {
                        contenance = true;
                    }
                }
                if (!contenance) {
                    frontier.add(child);
                    visited.add(child);
                }
            }
        }
        return out;
    }
    
}



