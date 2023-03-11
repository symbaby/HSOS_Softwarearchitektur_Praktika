package de.hsos.ssa.katalogverwalten.ui.view;

import java.util.Scanner;

public class DeleteView {
    public int menueAnzeige() {
        StringBuilder s = new StringBuilder();
        s.append("*** Delete View ***" + "\n")
                .append(" Ware aus Katalog loeschen" + "\n")
                .append(" Nummer eingeben" + "\n")
                .toString();

        System.out.println(s);

        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
