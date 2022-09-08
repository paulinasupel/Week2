package com.kainos.ea.employee_stuff;

public class DeliveryEmployee extends Employee{
    private String cv;
    private String image;
    private String favTech;

    public DeliveryEmployee(short number, double salary, String firstName, String lastName, String bankAccountNumber, String niNumber, String phoneNumber, String email, String cv, String image, String favTech) {
        super(number, salary, firstName, lastName, bankAccountNumber, niNumber, phoneNumber, email);
        this.cv = cv;
        this.image = image;
        this.favTech = favTech;
    }

    public DeliveryEmployee(String cv, String image, String favTech) {
        this.cv = cv;
        this.image = image;
        this.favTech = favTech;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFavTech() {
        return favTech;
    }

    public void setFavTech(String favTech) {
        this.favTech = favTech;
    }
}
