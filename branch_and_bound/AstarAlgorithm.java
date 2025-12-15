package branch_and_bound;
import java.util.*;

public class AstarAlgorithm {
    public static void  main(String[] args) {
        long t1 = System.nanoTime();
        System.out.println(AstarAlgorithm.search(true));
        long t2 = System.nanoTime();
        System.out.println(String.format("&B s'execute en %d ms\n", t2-t1));

        t1 = System.nanoTime();
        System.out.println("Calcul avec A* veuillez patientez...");
        System.out.println(AstarAlgorithm.search());
        t2 = System.nanoTime();
        System.out.println(String.format("A* s'execute en %d ms\n", t2-t1));
    }

    public static Node search() {
        return search(false);
    }
    public static Node search(boolean bnb) {
        List<Node> frontier = new ArrayList<>();
        Node root = new Node(State.initialState(),null);
        frontier.add(root);

        while (!frontier.isEmpty()) {
            Node current = frontier.get(0);
            for (Node test : frontier) {
                if (AstarAlgorithm.f(test, bnb) < AstarAlgorithm.f(current, false)) {
                    current = test;
                }
            }
            frontier.remove(current);

            if (bnb) {
                int i = 0;
                while (i < frontier.size()) {
                    if (frontier.get(i).poidsMin > current.poidsMax) {
                        frontier.remove(i);
                    } else {
                        i++;
                    }
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
        int nbVertices = Math.min(48, 49 - n.getDepth());
        n.poidsMin = Kruskal.run(nbVertices, edges);
        if (verifyMax){
            n.poidsMax = Kruskal.run(nbVertices, edges);
        }
        return n.getState().score + n.poidsMin;
    }
    
}



