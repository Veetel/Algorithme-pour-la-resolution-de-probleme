package roadTrip;
import java.util.List;

public class State {
    static GraphParser graph = new GraphParser();

    private final List<int> chemin;
    double score;
    


    public static State initialState() {
        return new State(new ArrayList<int>());
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
        List<int> newChemin = this.chemin.clone().add(action.dest);
        return new State(newChemin, this.score + action.weight);
    }

    /*------------ Constructors -------------- */

    public State(List<int> villes, double score) {
        this.chemin = villes;
        this.score = score;
    }


}
