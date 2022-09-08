package com.kainos.ea.employee_stuff;

public class BadNumber extends NumberFormatException {
    public BadNumber() {
    }

    public BadNumber(String s) {
        super(s);
    }
}
