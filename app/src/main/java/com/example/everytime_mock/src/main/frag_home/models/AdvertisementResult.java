package com.example.everytime_mock.src.main.frag_home.models;

public class AdvertisementResult {

    int adIdx;
    String adThumbnaillURL;

    public AdvertisementResult(int adIdx, String adThumbnaillURL) {
        this.adIdx = adIdx;
        this.adThumbnaillURL = adThumbnaillURL;
    }

    public int getAdIdx() {
        return adIdx;
    }

    public String getAdThumbnaillURL() {
        return adThumbnaillURL;
    }
}
