package com.example.techpex.beautyapplication.home.models;

import java.io.Serializable;
import java.util.ArrayList;

public class SchemeModel implements Serializable {

    private ArrayList<Integer> imageList;
    private ArrayList<String> descriptionList;
    private String schemePrice;

    public ArrayList<Integer> getImageList() {
        return imageList;
    }

    public void setImageList(ArrayList<Integer> imageList) {
        this.imageList = imageList;
    }

    public ArrayList<String> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(ArrayList<String> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public String getSchemePrice() {
        return schemePrice;
    }

    public void setSchemePrice(String schemePrice) {
        this.schemePrice = schemePrice;
    }
}
