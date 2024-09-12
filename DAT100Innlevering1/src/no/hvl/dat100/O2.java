package no.hvl.dat100;

import java.util.Scanner;

public class O2 {

    public static Scanner listener = new Scanner(System.in);

    public static void calculateBracketTax() {

        System.out.print("Skriv inn inntekt: \n > ");
        int income = listener.nextInt();

        listener.close();

        double tax = 0;

        String bracket = null;

        if (income >= 208051 && income <= 292850) {
            tax = 1.7;
            bracket = "trinn 1";
        }
        else if (income >= 292851 && income <= 670000) {
            tax = 4.0;
            bracket = "trinn 2";
        }
        else if (income >= 670001 && income <= 937900) {
            tax = 13.6;
            bracket = "trinn 3";
        }
        else if (income >= 937901 && income <= 1350000) {
            tax = 16.6;
            bracket = "trinn 4";
        }
        else if (income >= 1350001) {
            tax = 17.6;
            bracket = "trinn 5";
        }

        double taxDecimal = tax / 100;
        double paidTax = income * taxDecimal;
        
        if (bracket == null) {
            System.out.println("Med en inntekt på under 208 051 kroner i året, betaler du ikke skatt. Hurra!");
        }
        else {
            System.out.printf("Med en inntekt på %dkr, ligger du på %s med %.1f%% i trinnskatt, og du må betale %.2fkr i skatt.", income, bracket, tax, paidTax);
        }
    }

    public static void main(String[] args) {
        calculateBracketTax();
    }
}