package factory;

public interface RouteCallback {
    String getMaximumCost();
    String getCostBetweenTwoStops(String endRouteId);
}
