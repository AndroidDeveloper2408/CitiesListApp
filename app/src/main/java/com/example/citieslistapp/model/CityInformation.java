package com.example.citieslistapp.model;

import com.google.gson.annotations.Expose;

/**
 * Created by Серёга on 07.07.2017.
 */

public class CityInformation {

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public double getLatitude() {
        return lat;
    }

    public void setLatitude(double latitude) {
        this.lat = latitude;
    }

    public double getLongitude() {
        return lng;
    }

    public void setLongitude(double longitude) {
        this.lng = longitude;
    }

    public String getThumbnailImg() {
        return thumbnailImg;
    }

    public void setThumbnailImg(String thumbnailImg) {
        this.thumbnailImg = thumbnailImg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Expose
    private String summary;

    @Expose
    private int elevation;

    @Expose
    private double lat;

    @Expose
    private double lng;

    @Expose
    private String thumbnailImg;

    @Expose
    private String title;
}
