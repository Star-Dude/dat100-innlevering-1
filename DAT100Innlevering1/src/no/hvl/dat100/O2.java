package no.hvl.dat100;

import java.util.Scanner;

public class O2 {

    public static Scanner listener = new Scanner(System.in);

    public static void calculateBracketTax() {

        System.out.print("Skriv inn inntekt: \n > ");
        double income = listener.nextDouble();

        listener.close();

        double taxDecimal = 0;
        double paidTax = 0;

        String bracket = null;

        double[] bracket1 = {208051, 292850};
        double[] bracket2 = {bracket1[1] + 1, 670000};
        double[] bracket3 = {bracket2[1] + 1, 937900};
        double[] bracket4 = {bracket3[1] + 1, 1350000};

        double maxTax1 = (bracket1[1] - bracket1[0]) * 1.7 / 100;
        double maxTax2 = (bracket2[1] - bracket2[0]) * 4.0 / 100 + maxTax1;
        double maxTax3 = (bracket3[1] - bracket3[0]) * 13.6 / 100 + maxTax2;
        double maxTax4 = (bracket4[1] - bracket4[0]) * 16.6 / 100 + maxTax3;
        
        if (income > bracket1[0]) {
            if (income <= bracket1[1]) {
                taxDecimal = 1.7 / 100;
                paidTax = (income - bracket1[0] - 1) * taxDecimal;
                bracket = "trinn 1";
            }
            else if (income <= bracket2[1]) {
                taxDecimal = 4.0 / 100;
                paidTax = (income - bracket2[0] - 1) * taxDecimal;
                bracket = "trinn 2";
            }
            else if (income <= bracket3[1]) {
                taxDecimal = 13.6 / 100;
                paidTax = (income - bracket3[0] - 1) * taxDecimal;
                bracket = "trinn 3";
            }
            else if (income <= bracket4[1]) {
                taxDecimal = 16.6 / 100;
                paidTax = (income - bracket4[0] - 1) * taxDecimal;
                bracket = "trinn 4";
            }
            else if (income > bracket4[1]) {
                taxDecimal = 17.6 / 100;
                paidTax = (income - bracket4[1] + 1) * taxDecimal;
                bracket = "trinn 5";
            }
        }
        
        if (bracket == null) {
            System.out.println("Med en inntekt på under 208 051 kroner i året, betaler du ikke skatt. Hurra!");
        }
        else {
            switch (bracket) {
                case "trinn 2":
                    paidTax += maxTax1;
                    break;
                case "trinn 3":
                    paidTax += maxTax2;
                    break;
                case "trinn 4":
                    paidTax += maxTax3;
                    break;
                case "trinn 5":
                    paidTax += maxTax4;
                    break;
                default:
            }

            System.out.printf("Med en inntekt på %.2fkr, ligger du på %s med %.1f%% i trinnskatt, og du må betale %.2fkr i skatt.", income, bracket, taxDecimal*100, paidTax);
        }
    }

    public static void main(String[] args) {
        calculateBracketTax();
    }
}