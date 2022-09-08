package com.kainos.ea.employee_stuff;

public class PayrollSystem {
    private float taxRate = 0.25f;

    public String netPay(Payable payee) {
        int grossPay = payee.calcPay();
        int taxToPay = Math.round(grossPay * taxRate);
        double netPay = grossPay - taxToPay;
        return "Payee Name: " + payee.getName() + "\nPayee Net Pay: " + netPay + "\n";
    }
}
