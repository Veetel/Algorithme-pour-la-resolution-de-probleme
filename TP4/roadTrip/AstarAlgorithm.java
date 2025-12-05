package roadTrip;

public class AstarAlgorithm {
    
    public static Node search(){ //TODO
        return null;
    }
}


class Action{
    public final int num_city;

    public Action(int num_city){
        this.num_city = num_city;
    }

    public int cost(State state){
        return getDistance(this.state.g);
    }
}