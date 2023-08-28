package factory.route;

import common.Constant;
import data.DataGenerator;
import factory.RouteBase;
import model.Route;

import java.util.ArrayList;
import java.util.HashMap;

public class Route2 extends RouteBase {

    @Override
    public String getMaximumCost() {
        HashMap<String, Double> costRoute = new HashMap<>();
        costRoute.put(Constant.STOP1, 3.25);
        costRoute.put(Constant.STOP3, 5.50);
        return String.valueOf(Math.max(costRoute.get(Constant.STOP1), costRoute.get(Constant.STOP3)));
    }

    @Override
    public String getCostBetweenTwoStops(String endRouteId) {
        HashMap<String, ArrayList<Route>> routes = DataGenerator.generateRoutes();

        if (endRouteId.isEmpty()) {
            return null;
        }

        ArrayList<Route> routeList = routes.get(Constant.STOP2);
        for (Route route : routeList) {
            if (route.getStop2().equals(endRouteId)) {
                return route.getCost();
            }
        }

        return null;
    }

}
