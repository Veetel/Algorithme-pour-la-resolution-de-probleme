package roadTrip;
import java.util.ArrayList;
import java.util.List;

public class State {
    static GraphParser graph = new GraphParser();

    private final List<Integer> chemin;
    double score;
    


    public static State initialState() {
        return new State(new ArrayList<>(),0);
    }

    public boolean isGoalState() {
        return this.chemin.size() == 48;
    }

    public static List<Edge> getActions() {
        return State.graph.getEdges();
    }

    public int getSize() {
        return this.chemin.size();
    }

    public State successor(Edge action) {
        List<Integer> newChemin = new ArrayList<>();
        newChemin.addAll(this.chemin);
        newChemin.add(action.dest);
        return new State(newChemin, this.score + action.weight);
    }

    /*------------ Constructors -------------- */

    public State(List<Integer> villes, double score) {
        this.chemin = villes;
        this.score = score;
    }


}
