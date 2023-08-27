package model;

import java.util.Date;

public class Trip {

    int id;
    Date date;
    String tapType;
    String stopId;
    String companyId;
    String busId;
    String panNumber;

    public Trip(int id, Date date, String tapType, String stopId, String companyId, String busId, String panNumber) {
        this.id = id;
        this.date = date;
        this.tapType = tapType;
        this.stopId = stopId;
        this.companyId = companyId;
        this.busId = busId;
        this.panNumber = panNumber;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getTapType() {
        return tapType;
    }

    public String getStopId() {
        return stopId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getBusId() {
        return busId;
    }

    public String getPanNumber() {
        return panNumber;
    }

}
