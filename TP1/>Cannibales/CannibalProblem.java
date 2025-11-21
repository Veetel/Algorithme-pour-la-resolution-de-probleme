import java.util.ArrayList;
import java.util.List;

public class CannibalProblem {
    private final int NB_miss;
    private final int NB_cann;

    public CannibalProblem(int n, int m){
        if (n <= 0 || m <= 0){
            throw new IllegalArgumentException("Number of rows and columns must be positive.");
        }
        this.NB_miss = n;
        this.NB_cann = m;
    }
    
    /** Retourne l'état initial : une grille vide avec le cavalier sur un coin */
    public State initialState(){
        int [] grille_initiale = {NB_miss, NB_cann, 1};
        return new State(grille_initiale, 0);
    }

    /** Retourne la liste des actions */
    public List<Action> actions(){ //a faire
        ArrayList<Action> out = new ArrayList<>();
        return out;
    }

    /** Vérifie si l'état est terminal */
    public boolean isGoalState(State state){
        return state.getBoard()[0] == 0 && state.getBoard()[1] == 0;
    }


    /** Retourne l'état successeur après avoir appliqué une action */
    public State succession(State state, Action action){//WIP

    }


    class Action {
        public final int x;
        public final int y;
        
        public Action(int miss, int cann){
            this.x = miss;
            this.y = cann;
        }

        /** Coût de l'action (toujours 1 dans ce problème) */
        public int cout(){
            return 1;
        }
    }
}
