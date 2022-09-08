package com.kainos.ea.employee_stuff;

public class Project {
    private short custID;
    private short projID;
    private String name;

    public Project(short custID, short projID, String name) {
        this.custID = custID;
        this.projID = projID;
        this.name = name;
    }

    public short getCustID() {
        return custID;
    }

    public void setCustID(short custID) {
        this.custID = custID;
    }

    public short getProjID() {
        return projID;
    }

    public void setProjID(short projID) {
        this.projID = projID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
