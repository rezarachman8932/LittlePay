package factory;

import common.Constant;
import factory.route.Route1;
import factory.route.Route2;
import factory.route.Route3;

public class RouteFactory {

    public static RouteBase getRoute(String startStopsId) {
        switch (startStopsId) {
            case Constant.STOP1 -> {
                return new Route1();
            }
            case Constant.STOP2 -> {
                return new Route2();
            }
            case Constant.STOP3 -> {
                return new Route3();
            }
        }

        return null;
    }

}
