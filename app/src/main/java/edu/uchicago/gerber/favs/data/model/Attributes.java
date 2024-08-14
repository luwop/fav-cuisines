
package edu.uchicago.gerber.favs.data.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("business_temp_closed")
    @Expose
    private Object businessTempClosed;
    @SerializedName("menu_url")
    @Expose
    private String menuUrl;
    @SerializedName("open24_hours")
    @Expose
    private Object open24Hours;
    @SerializedName("waitlist_reservation")
    @Expose
    private Object waitlistReservation;

    public Object getBusinessTempClosed() {
        return businessTempClosed;
    }

    public void setBusinessTempClosed(Object businessTempClosed) {
        this.businessTempClosed = businessTempClosed;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public Object getOpen24Hours() {
        return open24Hours;
    }

    public void setOpen24Hours(Object open24Hours) {
        this.open24Hours = open24Hours;
    }

    public Object getWaitlistReservation() {
        return waitlistReservation;
    }

    public void setWaitlistReservation(Object waitlistReservation) {
        this.waitlistReservation = waitlistReservation;
    }

}
