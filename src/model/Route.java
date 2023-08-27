package model;

public class Route {

    String stop1;
    String stop2;
    String cost;

    public Route(String stop1, String stop2, String cost) {
        this.stop1 = stop1;
        this.stop2 = stop2;
        this.cost = cost;
    }

    public String getStop1() {
        return stop1;
    }

    public String getStop2() {
        return stop2;
    }

    public String getCost() {
        return cost;
    }

}
