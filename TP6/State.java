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

        
        
        if(this.N == 0){
            return -2 *this.N +3;
            
        }


        else{
            List <State> successors = new ArrayList<>();
            int utility = 0;
            
            for(Action a : this.actions()){
                successors.add(succ(a));
                
            }

            for(State s : successors){
                int childUtility = s.utility();
                 if((utility == 0) || ((childUtility< utility)^(this.player == 1))){
                    utility = childUtility;
                    
                 }
            }
            return utility;

        }


    }
    List <Action> actions(){

        List<Action> out = new ArrayList<>();
        out.add(new Action(this.N-1));
        out.add(new Action(this.N/2));

        return out;

    }

    State succ(Action a){
        
        return new State(player, a.N);

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
