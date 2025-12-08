package TP6;

import java.util.ArrayList;
import java.util.List;

public class State {
    public final int N;
    public final int player;

    /*------- Constructors ------- */
    public State(int player, int N) {
        this.player = player;
        this.N = N;
    }

    /*---------- Methods --------- */

    public boolean is_goal(){
        return this.N == 0;
    }
    public int utility(){
        
        
        if( this.N == 0  ){
             return (-2) * this.player + 3;
        }

        return 0;

    }
    List <Action> actions(){

        List<Action> out = new ArrayList<>();
        out.add(new Action(this.N-1));
        out.add(new Action((int)(this.N/2)));

        return out;

    }

    State succ(Action a){
        
        return new State(player, N)
*

        

    }

    public void display(){
        System.out.println(String.format("Joueur : %d , N = %d", this.player, this.N));
    }

    class Action{
        public final int N;

        public Action(int N){
            this.N = N;
        }

        public int cout(){
            return 1;
        }
    }
}
