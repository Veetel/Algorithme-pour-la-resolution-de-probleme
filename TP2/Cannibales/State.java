package Cannibales;
public class State {
    /**
    Un état est décrit par une grille NxM d'entiers. 
    O indique le fait que la case n'a pas encore été visité.
    1 indique le fait que la case a déjà été visité
    2 indique le fait que le cavalier se trouve sur la case
    */

    /* -------------------- attributs -------------------- */
    // a state is immutable : all fields are final
    private final int score;
    private final int[] board;


    /* ------------------ constructeurs ------------------ */

    public State(int[] board, int score){

        this.board = new int[3];
        for (int i=0; i<3; i++) {
            this.board[i] = board[i];  // deep copy
        }
        this.score = score;
    }

    /* -------------------- getteurs -------------------- */
    public int[] getBoard() {
        return this.board;
    }

    public int getScore() {
        return this.score;
    }

    /* ------------------ query methods------------------- */

    /** Vérifie si la position est à l'intérieur de la grille */
    public boolean isValidPosition(int[] board){
        return board[0] >= board[1] && (3-board[0]) >= (3-board[1]);
    }

    /** Fournit une description de l'état */
    @Override
    public String toString(){
        StringBuffer description = new StringBuffer();
        // description.append("Nb moves : ").append(this.getScore()).append("\n");
        
        for (int i = 0; i < 3; i++) {
                description.append(this.board[i]).append(" ");               
            }
            description.append(";");
        return description.toString();
    }

    


    
}