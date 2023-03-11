package de.hsos.ssa.katalogverwalten.ui.view;

import java.util.Scanner;

public class UpdateView {

    public int menueAnzeige() {
        StringBuilder s = new StringBuilder();
        s.append("*** Update View ***" + "\n")
                .append(" Ware aus Katalog aktualisieren" + "\n")
                .append(" Nummer eingeben" + "\n")
                .toString();

        System.out.println(s);

        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }


    public String nameAbfragen() {
        System.out.println("Neuen Namen eingeben");

        Scanner scan = new Scanner(System.in);

        return scan.next();
    }

    public int preisAbfragen() {
        System.out.println("Neuen Preis eingeben");

        Scanner scan = new Scanner(System.in);

        return scan.nextInt();
    }

    public String beschreibungAbfragen() {
        System.out.println("Neue Beschreibung eingeben");
        Scanner scan = new Scanner(System.in);

        return scan.next();
    }
}
