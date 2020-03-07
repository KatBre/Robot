package org.kb;

public class Robot {
    private double poziomBaterii = 100.00;
    private String name;
    private boolean enabled = false;

    public Robot(String name) {
        this.name = name;
    }

    public void poruszRobotem(RuchRobota ruchRobota) {
        if (!enabled) {
            System.err.println("Robot jest wyłączony");
            return;
        }
        if (poziomBaterii >= ruchRobota.getZuzycieEnergii()) {
            System.out.println("Wykonuję ruch robota: " + ruchRobota);
            poziomBaterii -= ruchRobota.getZuzycieEnergii();
        } else {
            System.err.println("Niewystarczająca ilość energii.");
        }
        System.out.println(poziomBaterii);
    }

    public void naladuj() {
        if (enabled) {
            System.out.println("Nie można ładować robota gdy jest włączony.");
        } else {
            poziomBaterii = 100.00;
            System.out.println("Robot naładowany");
        }
    }

    public void wlacz() {
        if (enabled) {
            System.out.println("Robot jest już włączony.");
        } else {
            enabled = true;
            System.out.println("Włączam robota.");
        }
    }

    public void wylacz() {
        if (!enabled) {
            System.out.println("Robot jest już wyłączony.");
        } else {
            enabled = false;
            System.out.println("Wyłączam robota.");
        }
    }

}
