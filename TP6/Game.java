package TP6;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Scanner;

public class Game {
    int N;
    Map<Integer,Function<State,State.Action>> policies;

    public Game(int N) {
        if (N >= 0) {
            this.N = N;
            this.policies = new HashMap<>();
            this.policies.put(1,minimaxPolicy);
        } else {
            throw new IllegalArgumentException("N ne peut pas etre negatif");
        }
    }

    public State initialState() {
        return new State(1 , this.N);
    }

    boolean isOver(State s) {
        return s.isGoal();
    }

    State.Action customPolicy(State s) {
        int input = 0;
        Scanner thatScan = new Scanner(System.in);
        System.out.println("choisir 1 -> n-1 ou 2->n/2");
        while (input != 1 && input != 2) {
            input = thatScan.nextInt();
        }
        return s.actions().get(input);
    }

    State.Action minimaxPolicy(State s) {
        int utility = 0;
        State.Action out = null;
        for (State.Action a : s.actions()) {
            int childUtility = s.succ(a).utility();
            if ((utility == 0) || ((childUtility < utility) ^ (s.player == 1))) {
                utility = childUtility;
                out = a;
            }
        }
        return out;
    }

    int play() {
        State s = this.initialState();
        while (!this.isOver(s)) {
            s.display();
            s = s.succ(policies.get(s.player).apply(s));
        }
        System.out.println(String.format("Le joueur %d a gagné", s.player));
        return s.player;
    }
}
