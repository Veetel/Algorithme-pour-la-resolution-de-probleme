package roadTrip;

import java.util.LinkedList;
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
    public List<Node> expand (problem){
        List<Node> children = new LinkedList();
        for( AstarAlgorithm.Action  action : problem.actions()){
            Node child = this.buildChild();
            if(child !⁼ null){
                children.add(child);
            
            }
        
        }
        return children;
    }

    private Node buildChild(problem, action){
        if(!this.isActionValid(action)){
            return null;
        }
    }

    State childState = problem.succession(this.state, action);
    return new Node(childState,this.action);
}