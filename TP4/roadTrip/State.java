package roadTrip;
import java.util.List;

public class State{


    private final List<int> chemin;
    


    public State initialState() {
        return new State(new ArrayList<int>());
    }

    public boolean isGoalState() {
        return this.chemin.size() == 48;
    }

    public List<Action> getActions() {
        
    }

    public int getSize() {
        return this.chemin.size();
    }

    /*------------ Constructors -------------- */

    public State(List<int> dejavues, int ville){
        this.chemin = dejavues.clone().add(ville);
    }
    public State(List<int> villes) {
        this.chemin = villes
    }


}
