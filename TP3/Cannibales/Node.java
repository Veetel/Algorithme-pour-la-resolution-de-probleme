package Cannibales;
import java.util.LinkedList;
import java.util.List;


public class Node {

    private final State state;  // l'état associé à ce nœud
    private final Node parent;  // le nœud parent
    private final CannibalProblem.Action parentAction; // l'action qui a conduit à cet état

    
    /* ------------------ constructeurs ------------------ */
    public Node(State state, Node node, CannibalProblem.Action action){
        this.state = state;
        this.parent = node;
        this.parentAction = action;
    }


    /* -------------------- getteurs -------------------- */
    public State getState() {
        return this.state;
    }
    
    public Node getParent() {
        return parent;
    }

    public CannibalProblem.Action getParentAction() {
        return parentAction;
    }


    /* -------------------- methods --------------------- */
    /** Génère la liste des noeuds enfants */
    public List<Node> expand(CannibalProblem problem){
        List<Node> children = new LinkedList<>();

        for (CannibalProblem.Action action : problem.actions()) {
            Node child = this.buildChild(problem, action);
            if (child != null) {
                children.add(child);
            }
        }
        return children;
    }

    /** Vérifie si une action est valide pour ce noeud */
    private boolean isActionValid(CannibalProblem.Action action){
        int [] currentBoard = this.getState().getBoard();
        if ((currentBoard[2]==1) == action.needsBoatOnLeftSide) {
            int missionairesRestants = currentBoard[0] - action.missionaires;
            int cannibalesRestants = currentBoard[1] - action.cannibales;
            return  0 <= missionairesRestants && missionairesRestants <= 3
                    && 0 <= cannibalesRestants && cannibalesRestants <= 3
                    &&( (missionairesRestants >= cannibalesRestants) || (missionairesRestants == 0))
                    &&( (3 - missionairesRestants >= 3 - cannibalesRestants )||( missionairesRestants == 3 ));
        } else {
            return false;
        }
    }

    /** Génère un nœud enfant pour une action donnée. Si l'action n'est pas valide, retourne null */
    private Node buildChild(CannibalProblem problem, CannibalProblem.Action action){
        if (!this.isActionValid(action)){
            return null;
        }
    
        State childState = problem.succession(this.state, action);
        return new Node(childState, this, action);
        
    }

    /** Retourne la liste des noeuds formant le chemin de la racine à ce noeud */
    private List<Node> path() {
        List<Node> path_back = new LinkedList<>();
        Node node = this;
        while (node != null) {
            path_back.add(0, node); // ajoute au début pour inverser l'ordre
            node = node.getParent();
        }
        return path_back;
    }

    /** Affiche la solution menant à ce noeud */
    public void printSolution() {
        List<Node> solutionPath = this.path();
        for (Node node : solutionPath) {
            System.out.println("Action leading to this state: " + node.parentAction);
            System.out.println("State with score: " + node.getState().getScore());
            System.out.println(node.getState());
            System.out.println();
        }
    }

    boolean equals(Node other) {
        return this.state.equals(other.getState());
    }
}

