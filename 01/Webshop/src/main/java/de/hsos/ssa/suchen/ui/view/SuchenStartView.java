package de.hsos.ssa.suchen.ui.view;

import java.util.Scanner;

public class SuchenStartView {

    public int menuAnzeige() {
        StringBuilder s = new StringBuilder();

        s.append("*** SuchenStart View ***" + "\n")
                .append("Hole zuerst deinen Warenkorb" + "\n")
                .append("(1) Warenkorb fuer suche holen" + "\n")
                .toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int holeWarenkorbAuswahl(){
        StringBuilder s = new StringBuilder();

        s.append("*** SuchenStart View ***" + "\n")
                .append("Wie moechtest du deinen Warenkorb holen?" + "\n")
                .append("(1) per Nummer suchen" + "\n")
                .append("(2) automatisch (Falls Warenkorb existiert)" + "\n")
                .toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int auswahlWarenkorbnummer(){
        System.out.println("*** SuchenStart View *** ");
        System.out.println("Bitte deine Warenkorbnummer eingeben");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
