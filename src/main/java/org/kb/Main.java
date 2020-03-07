package org.kb;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot("Marian");
        Scanner scanner = new Scanner(System.in);
        String komenda;
        do {
            System.out.println("Podaj komendę:");
            System.out.println(" - [KROK_LEWA, KROK_PRAWA, RUCH_REKA_LEWA, RUCH_REKA_PRAWA, SKOK]");
            System.out.println(" - naladuj");
            System.out.println(" - wlacz");
            System.out.println(" - wylacz");
            komenda = scanner.nextLine();
            if (komenda.equalsIgnoreCase("wlacz")) {
                robot.wlacz();
            } else if (komenda.equalsIgnoreCase("wylacz")) {
                robot.wylacz();
            } else if (komenda.equalsIgnoreCase("naladuj")) {
                robot.naladuj();
            } else if (komenda.startsWith("ruch")) {
                String[] slowa = komenda.split(" "); // dzielę komendę na słowa
                String rodzajRuchu = slowa[1]; // wyciągam słowo, w którym znajduje się rodzaj ruchu

                RuchRobota ruch = RuchRobota.valueOf(rodzajRuchu.toUpperCase()); //konwersja
                robot.poruszRobotem(ruch);
            } else if (!komenda.equalsIgnoreCase("quit")) {
                System.err.println("Nie rozpoznaję komendy");
            }
        } while (!komenda.equalsIgnoreCase("quit"));
    }
}
