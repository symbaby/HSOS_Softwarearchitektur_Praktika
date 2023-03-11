package de.hsos.swa.ssa.ui.view;

import java.util.Scanner;

public class SimpleShoppingAppView {
    public int begruessung() {
        StringBuilder s = new StringBuilder();

        s.append("*** SimpleShoppingApp View ***" + "\n")
                .append("Herzlich Willkommen in der Simple Shopping App!" + "\n")
                .append("(1) Programm starten").toString();
        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
