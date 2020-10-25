package co.edu.udea.compumovil.gr05_20201.lab1.data;


import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import java.io.Serializable;

public class POI implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "information")
    public String information;
    @ColumnInfo(name = "temperature")
    public String temperature;
    @ColumnInfo(name = "recommendation")
    public String recommendation;
    @ColumnInfo(name = "image")
    public String image;
    @ColumnInfo(name = "address")
    public String address;
    @ColumnInfo(name = "currency")
    public String currency;
    @ColumnInfo(name = "city")
    public String city;
    @ColumnInfo(name = "country")
    public String country;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "score")
    public String score;


    public POI(String name, String information, String temperature, String image, String address, String city, String score, String currency, String recommendation, String country, String description) {
        this.name = name;
        this.information = information;
        this.temperature = temperature;
        this.currency = currency;
        this.recommendation = recommendation;
        this.image = image;
        this.address = address;
        this.city = city;
        this.country = country;
        this.description = description;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getTemperature() {
        return temperature;
    }   

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }


    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
