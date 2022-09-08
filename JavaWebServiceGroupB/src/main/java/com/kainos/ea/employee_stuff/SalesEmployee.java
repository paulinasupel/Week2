package com.kainos.ea.employee_stuff;

public class SalesEmployee extends Employee {
    public SalesEmployee() {
    }

    private float commissionRate;
    private int salesTotal;

    public SalesEmployee(short number, int salary, String firstName, String lastName, String bankAccountNumber, String niNumber, String phoneNumber, String email, float commissionRate, int salesTotal) {
        super(number, salary, firstName, lastName, bankAccountNumber, niNumber, phoneNumber, email);
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
    public int calcPay() {
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