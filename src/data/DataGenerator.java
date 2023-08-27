package data;

import common.Constant;
import model.Route;

import java.util.ArrayList;
import java.util.HashMap;

public class DataGenerator {

    public static HashMap<String, ArrayList<Route>> generateRoutes() {
        HashMap<String, ArrayList<Route>> mapRoutes = new HashMap<>();

        ArrayList<Route> route1 = new ArrayList<>();
        route1.add(new Route("", Constant.STOP2, Constant.COST_325));
        route1.add(new Route("", Constant.STOP3, Constant.COST_730));

        ArrayList<Route> route2 = new ArrayList<>();
        route2.add(new Route("", Constant.STOP1, Constant.COST_325));
        route2.add(new Route("", Constant.STOP3, Constant.COST_550));

        ArrayList<Route> route3 = new ArrayList<>();
        route3.add(new Route("", Constant.STOP1, Constant.COST_730));
        route3.add(new Route("", Constant.STOP2, Constant.COST_550));

        mapRoutes.put(Constant.STOP1, route1);
        mapRoutes.put(Constant.STOP2, route2);
        mapRoutes.put(Constant.STOP3, route3);

        return mapRoutes;
    }

}
