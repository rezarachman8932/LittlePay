import common.Util;
import model.Trip;
import model.TripLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String file = "res/input.csv";
        String line;
        ArrayList<Trip> tripLogs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while((line = br.readLine()) != null) {
                String[] splitStr = line.split(",");
                if (!splitStr[0].equals("ID")) {
                    tripLogs.add(new Trip(
                            Integer.parseInt(splitStr[0]),
                            Util.getDateFromString(splitStr[1]),
                            splitStr[2],
                            splitStr[3],
                            splitStr[4],
                            splitStr[5],
                            splitStr[6])
                    );
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        HashMap<String, ArrayList<Trip>> generatedTripLogs = Util.generateTrips(tripLogs);
        ArrayList<TripLog> finalTripLog = Util.generateFinalTripLogs(generatedTripLogs);
        for (TripLog item : finalTripLog) {
            System.out.println(
                    item.getStatus() + " " +
                    item.getStartTimeStr() + " " +
                    item.getEndTimeStr() + " " +
                    item.getDurationSec() + " " +
                    item.getFromStopId() + " " +
                    item.getToStopId() + " " +
                    item.getChargeAmount() + " " +
                    item.getCompanyId() + " " +
                    item.getBusId() + " " +
                    item.getPanNumber()
            );
        }
    }

}