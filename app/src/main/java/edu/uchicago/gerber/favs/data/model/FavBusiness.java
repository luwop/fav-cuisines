package edu.uchicago.gerber.favs.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.Gson;
import com.google.gson.JsonObject;



public class FavBusiness extends Business {
    @SerializedName("sessionEmail")
    @Expose
    private String sessionEmail;

    public FavBusiness(Business business, String sessionEmail) {
        // Initialize the inherited fields using the Business's getter methods
        this.setId(business.getId());
        this.setAlias(business.getAlias());
        this.setName(business.getName());
        this.setImageUrl(business.getImageUrl());
        this.setIsClosed(business.getIsClosed());
        this.setUrl(business.getUrl());
        this.setReviewCount(business.getReviewCount());
        this.setCategories(business.getCategories());
        this.setRating(business.getRating());
        this.setCoordinates(business.getCoordinates());
        this.setTransactions(business.getTransactions());
        this.setPrice(business.getPrice());
        this.setLocation(business.getLocation());
        this.setPhone(business.getPhone());
        this.setDisplayPhone(business.getDisplayPhone());
        this.setDistance(business.getDistance());
        this.setBusinessHours(business.getBusinessHours());
        this.setAttributes(business.getAttributes());

        // Initialize the new field
        this.sessionEmail = sessionEmail;
    }


    public String getSessionEmail() {
        return sessionEmail;
    }

    public void setSessionEmail(String sessionEmail) {
        this.sessionEmail = sessionEmail;
    }

    public JsonObject toJson() {
        Gson gson = new Gson();
        return gson.toJsonTree(this).getAsJsonObject();
    }
}