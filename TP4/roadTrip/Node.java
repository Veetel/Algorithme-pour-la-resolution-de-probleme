package roadTrip;

import java.util.ArrayList;
import java.util.List;

public class Node{

    private final State state;
    private final Node parent;




    /*-------------------- Constructors ----------------------- */
    public Node(State state, Node parent){
        this.state = state;
        this.parent = parent;
        
        
    }

    /*------------------------- Getters ---------------------- */

    public State getState(){
        return this.state;
    }
    public Node getParent(){
        return this.parent;
    }

    public int getDepth() {
        return this.state.getSize();
    }


    /*-------------------------- Methods ------------------- */
    public List<Node> expand (){
        List<Node> children = new ArrayList<>();
        for(Edge action : State.getActions()){
            Node child = this.buildChild(action);
            if(child != null){
                children.add(child);
            
            }
        
        }
        return children;
    }

    private Node buildChild(Edge action){
        if(!this.state.isActionValid(action)){
            return null;
        }
        return new Node(this.state.successor(action),this);
    }

}