package Cannibales;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithmDFS {

    public static Node search(CannibalProblem problem){
        int counter = 0;
        HashSet<Node> visited = new HashSet<>();
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        visited.add(root);
        
        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(frontier.size() - 1);
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
            }
            
            for (Node child : currentNode.expand(problem)) {
                int uniqueAttribute = 3;
                for (Node v : visited) {
                    for(int j = 0 ; j < 3; j++){
                        if (child.getState().getBoard()[j] == v.getState().getBoard()[j]){
                            uniqueAttribute --;
                            
                        }
                    }
                }
                if (uniqueAttribute == 0) {   
                    frontier.add(child);
                    visited.add(child);
                }
            }
            
        }
        return null;
    }
}
