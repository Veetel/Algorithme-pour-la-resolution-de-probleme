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

        int [][] grille = new int [NB_ROWS][NB_COLS];
        return new State(grille, null, NB_COLS);
    }

    /** Retourne la liste des actions */
    public List<Action> actions(){
        throw new UnsupportedOperationException("You must implement the actions() method !");
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
    public State succession(State state, Action action){
        throw new UnsupportedOperationException("You must implement the succession() method !");
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
