package com.kainos.ea.employee_stuff;

public class SalaryTooLowException extends IllegalArgumentException {
    public SalaryTooLowException() {
    }

    public SalaryTooLowException(String s) {
        super(s);
    }
}
