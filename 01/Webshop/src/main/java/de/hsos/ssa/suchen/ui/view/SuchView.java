package de.hsos.ssa.suchen.ui.view;

import java.util.Scanner;

public class SuchView {


    public int holeAuswahloption() {
        StringBuilder s = new StringBuilder();

        s.append("*** Such View ***" + "\n")
                .append("(1) Suche Ware per Name" + "\n")
                .append("(2) Suche Ware per Nummer").toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public String auswahlWarenname() {
        System.out.println("Warenname eingeben: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public int auswahlWarennummer() {
        System.out.println("Warennummer eingeben: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int suchalgorithmusFestlegen() {
        System.out.println("Suche nach [KONTEXT]: ");
        System.out.println("Suche nach [WORTGRUPPE]: ");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int auswahlPruefenOderWarenkorbLegen() {
        StringBuilder s = new StringBuilder();

        s.append("*** Such View ***" + "\n")
                .append("(-1) Abbrechen" + "\n")
                .append("(1) Mehr Informationen zum Artikel" + "\n")
                .append("(2) Artikel in Warenkorb legen").toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
