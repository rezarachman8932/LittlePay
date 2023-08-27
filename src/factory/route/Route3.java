package factory.route;

import common.Constant;
import data.DataGenerator;
import factory.RouteCallback;
import model.Route;

import java.util.ArrayList;
import java.util.HashMap;

public class Route3 implements RouteCallback {

    @Override
    public String getMaximumCost() {
        HashMap<String, Double> costRoute = new HashMap<>();
        costRoute.put(Constant.STOP1, 7.30);
        costRoute.put(Constant.STOP2, 5.50);
        return String.valueOf(Math.max(costRoute.get(Constant.STOP1), costRoute.get(Constant.STOP2)));
    }

    @Override
    public String getCostBetweenTwoStops(String endRouteId) {
        HashMap<String, ArrayList<Route>> routes = DataGenerator.generateRoutes();

        if (endRouteId.isEmpty()) {
            return null;
        }

        ArrayList<Route> routeList = routes.get(Constant.STOP3);
        for (Route route : routeList) {
            if (route.getStop2().equals(endRouteId)) {
                return route.getCost();
            }
        }

        return null;
    }

}
