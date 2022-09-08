package com.kainos.ea.employee_stuff;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SalesEmployee extends Employee {
    public SalesEmployee() {
    }

    private float commissionRate;
    private int salesTotal;

    public SalesEmployee(@JsonProperty("salary") double salary,
                         @JsonProperty("firstname") String firstName, @JsonProperty("lastname") String lastName,
                         @JsonProperty("bankAccountNumber") String bankAccountNumber, @JsonProperty("niNumber") String niNumber,
                         @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("email") String email ,@JsonProperty("Commision") float commissionRate,@JsonProperty("salesThisMonth") int salesTotal) {
        super( salary, firstName, lastName, bankAccountNumber, niNumber, phoneNumber, email);
        this.commissionRate = commissionRate;
        this.salesTotal = salesTotal;
    }

    public float getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(float commissionRate) {
        this.commissionRate = commissionRate;
    }

    public int getSalesTotal() {
        return salesTotal;
    }

    public void setSalesTotal(int salesTotal) {
        this.salesTotal = salesTotal;
    }

    @Override
    public double calcPay() {
        return super.calcPay() + Math.round(commissionRate * salesTotal);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SalesEmployee) {
            SalesEmployee emp = (SalesEmployee) obj;
            return super.equals(obj) && this.commissionRate == emp.getCommissionRate() && this.salesTotal == emp.getSalesTotal();
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nSalesEmployee" +
                "{commissionRate=" + commissionRate +
                ", salesTotal=" + salesTotal +
                '}';
    }


}