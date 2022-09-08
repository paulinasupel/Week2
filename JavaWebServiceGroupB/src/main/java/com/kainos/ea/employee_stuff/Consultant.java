package com.kainos.ea.employee_stuff;

public class Consultant implements Payable {
    private String name;
    private float dailyRate;
    private int daysWorked;

    public Consultant() {
    }

    public Consultant(String name, float dailyRate, int daysWorked) {
        this.name = name;
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(float dailyRate) {
        this.dailyRate = dailyRate;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    @Override
    public int calcPay() {
        return (int) (dailyRate * daysWorked);
    }
}
