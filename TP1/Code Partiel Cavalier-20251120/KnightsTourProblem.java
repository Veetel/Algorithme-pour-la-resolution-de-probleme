import java.util.ArrayList;
import java.util.List;

public class KnightsTourProblem {
    private final int NB_ROWS;
    private final int NB_COLS;

    public KnightsTourProblem(int n, int m){
        if (n <= 0 || m <= 0){
            throw new IllegalArgumentException("Number of rows and columns must be positive.");
        }
        this.NB_ROWS = n;
        this.NB_COLS = m;
    }
    
    /** Retourne l'état initial : une grille vide avec le cavalier sur un coin */
    public State initialState(){
        int [][] grille_initiale = new int[this.NB_ROWS][this.NB_COLS];
        for (int i = 0 ; i < this.NB_ROWS; i++) {
            for (int e = 0; e < this.NB_COLS; i++) {
                grille_initiale[i][e] = 0;
            }
        }
        grille_initiale[0][0] = 1;
        return new State(grille_initiale, new Position(), 0);
    }

    /** Retourne la liste des actions */
    public List<Action> actions(){
        ArrayList<Action> out = new ArrayList<>();

        int [] distances = {-2,-1,1,2};

        for (int d1 : distances) {
            for (int d2 : distances) {
                if (Math.abs(d1*d2) == 2) {
                    out.add(new Action(d1,d2));
                }
            }
        }

        return out;
    }

    /** Vérifie si l'état est terminal */
    public boolean isGoalState(State state){

        int [][] grille = state.getBoard();
        for(int i = 0 ; i < NB_ROWS; i ++){
            for(int j = 0 ; j < NB_COLS; j ++){
                if( grille[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }


    /** Retourne l'état successeur après avoir appliqué une action */
    public State succession(State state, Action action){ //action doit etre validée au préalable
        int [][] grille = state.getBoard();
        Position knight = state.getKnight();
        Position new_pos = knight.move(action.dx, action.dy);
        grille[new_pos.x][new_pos.y] = grille[knight.x][knight.y] + 1;

        return new State(grille, knight, state.getScore() + 1);
    }


    class Action {
        public final int dx;
        public final int dy;
        
        public Action(int nbRows, int nbCols){
            this.dx = nbRows;
            this.dy = nbCols;
        }

        /** Coût de l'action (toujours 1 dans ce problème) */
        public int cout(){
            return 1;
        }
    }
}
