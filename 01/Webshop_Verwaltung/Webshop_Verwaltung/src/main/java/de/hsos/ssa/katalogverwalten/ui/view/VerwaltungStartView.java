package de.hsos.ssa.katalogverwalten.ui.view;

import java.util.Scanner;

public class VerwaltungStartView {

    public int menueAnzeigen() {
        StringBuilder s = new StringBuilder();

        s.append("*** VerwaltungStart View ***" + "\n")
                .append("(1) create" + "\n")
                .append("(2) update" + "\n")
                .append("(3) delete" + "\n")
                .append("(-1) abbrechen" + "\n")
                .toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
