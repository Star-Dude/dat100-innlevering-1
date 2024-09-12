package no.hvl.dat100;
import java.util.Scanner;

public class O3 {
    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);

        System.out.print("Skriv inn inntekt: \n > ");
        int n = listener.nextInt();

        listener.close();

        long sum = 1;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                sum *= i;
            }
        }
        else {
            System.out.println("Feil, tallet må være større enn 0.");
        }

        System.out.printf("Fakultet til %d is: %d ", n, sum);
    }
}

// Lag et program som leser inn et heltall n > 0, beregner verdien n! (n fakultet) og skriver verdien til n! ut på skjermen, der n! = 1*2*3* … *(n-1)*n.