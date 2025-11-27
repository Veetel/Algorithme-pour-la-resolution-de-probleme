package Cavaliers;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithmDFS {

    public static Node search(KnightsTourProblem problem){
        int counter = 0;
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        
        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(frontier.size() - 1); //LIFO => DFS
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                return currentNode;
            }
            frontier.addAll(currentNode.expand(problem));
        }
        return null;
    }
    
}


