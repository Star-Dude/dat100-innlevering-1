package no.hvl.dat100;

import java.util.Scanner;

public class O1 {
    
    public static Scanner listener = new Scanner(System.in);

    public static void calculateGrade(int num) {
        String pointsInput = "";
        int points = 0;

        System.out.printf("Skriv inn poengsum %d: \n > ", num);
        pointsInput = listener.nextLine();

        try {
            points = Integer.parseInt(pointsInput);
        } 
        catch (NumberFormatException e) {
            System.out.println("Du må skrive inn en poengsum mellom 1 til 100.");
            calculateGrade(num);
            return;
        }

        if (points > 100 || points < 0) {
            System.out.println("Feil, ugyldig poengsum.");
            calculateGrade(num);
            return;
        }

        String grade = "F";

        if (points >= 90) {
            grade = "A";
        } 
        else if (points >= 80) {
            grade = "B";
        } 
        else if (points >= 60) {
            grade = "C";
        } 
        else if (points >= 50) {
            grade = "D";
        } 
        else if (points >= 40) {
            grade = "E";
        }
        System.out.printf("Med en poengsum på %d, får du karakteren %s\n\n", points, grade);
    }   

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) { // dette gjør saken
            calculateGrade(i);
        }

        listener.close();
    }
}

