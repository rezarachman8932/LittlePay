package common;

import factory.RouteCallback;
import factory.RouteFactory;
import model.Trip;
import model.TripLog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Util {

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

    public static ArrayList<TripLog> generateFinalTripLogs(HashMap<String, ArrayList<Trip>> generatedTripLogs) {
        ArrayList<TripLog> tripLogs = new ArrayList<>();

        for (Map.Entry<String, ArrayList<Trip>> set : generatedTripLogs.entrySet()) {
            ArrayList<Trip> trips = set.getValue();

            if (trips.size() == 1 && trips.get(0).getTapType().equals(Constant.OFF)) {
                continue;
            }

            if (trips.size() == 2) {
                Trip startTripStops = trips.get(0);
                Trip endTripStops = trips.get(1);

                TripLog newTripLog = new TripLog(
                        getDateString(startTripStops.getDate(), Constant.DD_M_YYYY_HH_MM_SS),
                        getDateString(endTripStops.getDate(), Constant.DD_M_YYYY_HH_MM_SS),
                        generateDurationInSecond(startTripStops.getDate(), endTripStops.getDate()),
                        startTripStops.getStopId(),
                        endTripStops.getStopId(),
                        getCompleteRouteCost(startTripStops.getStopId(), endTripStops.getStopId()),
                        startTripStops.getCompanyId(),
                        endTripStops.getBusId(),
                        startTripStops.getPanNumber(),
                        Constant.COMPLETE
                );

                tripLogs.add(newTripLog);
            } else {
                Trip startTripStops = trips.get(0);

                TripLog newTripLog = new TripLog(
                        getDateString(startTripStops.getDate(), Constant.DD_M_YYYY_HH_MM_SS),
                        null,
                        0,
                        startTripStops.getStopId(),
                        null,
                        getMaxIncompleteRouteCost(startTripStops.getStopId()),
                        startTripStops.getCompanyId(),
                        startTripStops.getBusId(),
                        startTripStops.getPanNumber(),
                        Constant.INCOMPLETE
                );

                tripLogs.add(newTripLog);
            }
        }

        return tripLogs;
    }

    public static Date getDateFromString(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(Constant.DD_M_YYYY_HH_MM_SS, Locale.getDefault());
        try {
            return formatter.parse(strDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getCompleteRouteCost(String startRouteId, String endRouteId) {
        RouteFactory factory = new RouteFactory();
        RouteCallback route = factory.getRoute(startRouteId);
        return route.getCostBetweenTwoStops(endRouteId);
    }

    private static String getMaxIncompleteRouteCost(String startRouteId) {
        RouteFactory factory = new RouteFactory();
        RouteCallback route = factory.getRoute(startRouteId);
        return route.getMaximumCost();
    }

    private static long generateDurationInSecond(Date date1, Date date2) {
        long diffInSeconds = Math.abs(date2.getTime() - date1.getTime());
        return TimeUnit.DAYS.convert(diffInSeconds, TimeUnit.SECONDS);
    }

    private static String getDateString(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        return formatter.format(date);
    }

    private static String generateId(Date date, String companyId, String busId, String panNumber) {
        return getDateString(date, Constant.DD_M_YYYY) +
                companyId +
                busId +
                panNumber;
    }

}
