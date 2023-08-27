package common;

import factory.RouteCallback;
import factory.RouteFactory;
import model.Trip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {

    public static String getCompleteRouteCost(String startRouteId, String endRouteId) {
        RouteFactory factory = new RouteFactory();
        RouteCallback route = factory.getRoute(startRouteId);
        return route.getCostBetweenTwoStops(endRouteId);
    }

    public static String getMaxIncompleteRouteCost(String startRouteId) {
        RouteFactory factory = new RouteFactory();
        RouteCallback route = factory.getRoute(startRouteId);
        return route.getMaximumCost();
    }

    public static HashMap<String, ArrayList<Trip>> generateTrips(ArrayList<Trip> trips) {
        HashMap<String, ArrayList<Trip>> hashTrips = new HashMap<>();

        if (trips.isEmpty()) {
            return hashTrips;
        }

        for (Trip trip : trips) {
            String generatedId = generateId(
                    trip.getDate(),
                    trip.getCompanyId(),
                    trip.getBusId(),
                    trip.getPanNumber()
            );

            if (!hashTrips.containsKey(generatedId)) {
                ArrayList<Trip> arrRoutes = new ArrayList<>();
                arrRoutes.add(trip);
                hashTrips.put(generatedId, arrRoutes);
            } else {
                ArrayList<Trip> arrExistingRoutes = hashTrips.get(generatedId);
                arrExistingRoutes.add(trip);
                hashTrips.put(generatedId, arrExistingRoutes);
            }
        }

        return hashTrips;
    }

    public static Date getDateFromString(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.getDefault());
        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getDateString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy", Locale.getDefault());
        return formatter.format(date);
    }

    private static String generateId(Date date, String companyId, String busId, String panNumber) {
        return getDateString(date) +
                companyId +
                busId +
                panNumber;
    }

}
