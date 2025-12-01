package roadTrip;
public class Node{

    private final State state;
    private final Node parent;
    private final int depth;




    /*-------------------- Constructors ----------------------- */
    public Node(State state, Node parent,int depth){
        this.state = state;
        this.parent = parent;
        this.depth = depth;
        
    }

    /*------------------------- Getters ---------------------- */

    public State getState(){
        return this.state;
    }
    public Node getParent(){
        return this.parent;
    }

    public int getDepth() {
        return this.depth;
    }


    /*-------------------------- Methods ------------------- */


}