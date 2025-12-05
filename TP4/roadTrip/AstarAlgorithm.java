package roadTrip;
import java.util.*;

public class AstarAlgorithm {
    public void static main(String[] args) {
    }

    public Node search() {
        List<Node> frontier = new ArrayList<>();
        Node root = new Node(State.initialState(),null);
        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.get(0);

            for (Node test : frontier) {
                if (AstarAlgorithm.f(test) < AstarAlgorithm.f(current)) {
                    current = test;
                }
            }
            frontier.remove(current);
            for (Node child : current.expand()) {
                if (child.getState().isGoalState()) {
                    return child;
                }
                frontier.add(child);
            }
        }
    }

    private static double f(Node n) {
        edges = State.graph.getEdges();
        List<Edge> remove = new ArrayList<>();
        List<Integer> chemin = n.getState().chemin;
        for (Edge e : edges) {
            if (chemin.contains(e.dest) || (chemin.contains(e.src) && !(e.src.equals(chemin.getLast())))) {
                remove.add(e);
            }
        }
        for (Edge e : remove) {
            edges.remove(e);
        }
        return n.getState().score + Kruskal(48-n.getDepth(), edges);
    }
    
}



