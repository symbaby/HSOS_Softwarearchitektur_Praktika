package de.hsos.ssa.suchen.ui.view;

import java.util.Scanner;

public class AuswahlView {
    public int menuAnzeige() {
        StringBuilder s = new StringBuilder();

        s.append("*** Auswahl View ***" + "\n")
                .append("(1) Ware zu Warenkorb hinzufuegen" + "\n")
                .toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
