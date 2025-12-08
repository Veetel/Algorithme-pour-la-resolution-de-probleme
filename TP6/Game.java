package TP6;

public class Game {
    int N;
    Map<Integer,Function<State,Action>> policies;

    public Game(int N) {
        if (N >= 0) {
            this.N = N;
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

    Action customPolicy(State s) {
        int input = 0;
        Scanner thatScan = new Scanner(System.in);
        System.out.println("choisir 1 -> n-1 ou 2->n/2");
        while (input != 1 && input != 2) {
            input = thatScan.nextInt();
        }
        return s.actions().get(input);
    }

    Action minimaxPolicy(State s) {
        int utility = 0;
        Action out;
        for (Action a : s.actions()) {
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
        while (!this.isOver()) {
            s.display();
            s = s.succ(policies.get(s.player)(s));
        }
        System.out.println(String.format("Le joueur %d a gagné", s.player));
        return s.player;
    }
}
