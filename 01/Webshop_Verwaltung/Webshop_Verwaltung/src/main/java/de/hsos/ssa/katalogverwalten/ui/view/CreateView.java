package de.hsos.ssa.katalogverwalten.ui.view;

import java.sql.SQLOutput;
import java.util.Scanner;

public class CreateView {
    public void menueAnzeige() {
        StringBuilder s = new StringBuilder();

        s.append("*** Create View ***" + "\n")
                .append(" Ware in Katalog hinzufuegen" + "\n")
                .toString();

        System.out.println(s);
    }

    public String nameAbfragen() {
        System.out.println("Name eingeben");

        Scanner scan = new Scanner(System.in);

        return scan.next();
    }

    public int preisAbfragen() {
        System.out.println("Preis eingeben");

        Scanner scan = new Scanner(System.in);

        return scan.nextInt();
    }

    public String beschreibungAbfragen() {
        System.out.println("Beschreibung eingeben");
        Scanner scan = new Scanner(System.in);

        return scan.next();
    }
}
