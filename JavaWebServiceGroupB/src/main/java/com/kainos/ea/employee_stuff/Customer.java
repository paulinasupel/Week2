package com.kainos.ea.employee_stuff;

public class Customer {
    private short custID;
    private String name;
    private String keyContact;
    private String phoneNumber;

    public Customer(short custID, String name, String keyContact, String phoneNumber) {
        this.custID = custID;
        this.name = name;
        this.keyContact = keyContact;
        this.phoneNumber = phoneNumber;
    }

    public short getCustID() {
        return custID;
    }

    public void setCustID(short custID) {
        this.custID = custID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyContact() {
        return keyContact;
    }

    public void setKeyContact(String keyContact) {
        this.keyContact = keyContact;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
