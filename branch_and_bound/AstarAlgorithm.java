package branch_and_bound;
import java.util.*;

public class AstarAlgorithm {
    public static void  main(String[] args) {
        AstarAlgorithm.search();
        
    }

    public static Node search() {
        List<Node> frontier = new ArrayList<>();
        Node root = new Node(State.initialState(),null);
        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.get(0);
            for (Node test : frontier) {
                if (AstarAlgorithm.f(test) < AstarAlgorithm.f(current, false)) {
                    current = test;
                }
            }
            frontier.remove(current);

            int i = 0;
            while (i < frontier.size()) {
                if (frontier.get(i).poidsMin > current.poidsMax) {
                    frontier.remove(i);
                } else {
                    i++;
                }
            }
            
            for (Node child : current.expand()) {
                if (child.getState().isGoalState()) {
                    return child;
                }
                frontier.add(child);
            }
        }
        return null;
    }
    private static double f(Node n) {
        return AstarAlgorithm.f(n, true);
    }
    private static double f(Node n, boolean verifyMax) {
        List<Edge> edges = State.graph.getEdges();
        List<Edge> remove = new ArrayList<>();
        List<Integer> chemin = n.getState().getChemin();
        for (Edge e : edges) {
            if (chemin.contains((Integer)e.dest) || (chemin.contains((Integer)e.src) && !(((Integer)e.src).equals(chemin.getLast())))) {
                remove.add(e);
            }
        }
        for (Edge e : remove) {
            edges.remove(e);
        }
        n.poidsMin = Kruskal.run(48-n.getDepth(), edges);
        if (verifyMax){
            n.poidsMax = Kruskal.run(48-n.getDepth(), edges);
        }
        return n.getState().score + n.poidsMin;
    }
    
}



