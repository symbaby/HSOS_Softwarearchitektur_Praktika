package de.hsos.swa.ssa.ui.view;

import java.util.Scanner;

public class MenuView {

    public int menuAnzeige() {
        StringBuilder s = new StringBuilder();

        s.append("*** Menue View ***" + "\n")
                .append("(1) Ware Suchen" + "\n")
                .append("(2) Warenkorb" + "\n")
                .append("(3) Zur Kasse")
                .toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
