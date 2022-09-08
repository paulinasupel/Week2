package com.kainos.ea.employee_stuff;

public class PayrollSystem {
    private float taxRate = 0.25f;

    public String netPay(Payable payee) {
        double grossPay = payee.calcPay();
        double taxToPay = Math.round(grossPay * taxRate);
        double netPay = grossPay - taxToPay;
        return "Payee Name: " + payee.getFirstName() + payee.getLastName() + "\nPayee Net Pay: " + netPay + "\n";
    }
}
