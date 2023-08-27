package model;

import java.util.Date;

public class TripLog {

    String startTimeStr;
    String endTimeStr;
    long durationSec;
    String fromStopId;
    String toStopId;
    String chargeAmount;
    String companyId;
    String busId;
    String panNumber;
    String status;

    public TripLog(String startTimeStr, String endTimeStr, long durationSec, String fromStopId, String toStopId, String chargeAmount, String companyId, String busId, String panNumber, String status) {
        this.startTimeStr = startTimeStr;
        this.endTimeStr = endTimeStr;
        this.durationSec = durationSec;
        this.fromStopId = fromStopId;
        this.toStopId = toStopId;
        this.chargeAmount = chargeAmount;
        this.companyId = companyId;
        this.busId = busId;
        this.panNumber = panNumber;
        this.status = status;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public long getDurationSec() {
        return durationSec;
    }

    public String getFromStopId() {
        return fromStopId;
    }

    public String getToStopId() {
        return toStopId;
    }

    public String getChargeAmount() {
        return chargeAmount;
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

    public String getStatus() {
        return status;
    }

}
