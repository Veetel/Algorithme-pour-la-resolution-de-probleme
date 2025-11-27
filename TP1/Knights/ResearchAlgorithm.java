package Knights;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ResearchAlgorithm {

    public static List<Node> search(KnightsTourProblem problem){
        int counter = 0;
        List<Node> out = new ArrayList<>();
        List<Node> frontier = new LinkedList<>();
        Node root = new Node(problem.initialState(), null, null);
        frontier.add(root);
        
        while(!frontier.isEmpty()){
            Node currentNode = frontier.remove(0);
            counter += 1;
            if (problem.isGoalState(currentNode.getState())){
                System.out.println("Found a solution after evaluating " + counter + " nodes.");
                out.add(currentNode);
            }
            frontier.addAll(currentNode.expand(problem));
        }
        return out;
    }
    
}
