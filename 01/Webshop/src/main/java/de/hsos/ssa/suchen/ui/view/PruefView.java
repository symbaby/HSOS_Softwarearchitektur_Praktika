package de.hsos.ssa.suchen.ui.view;

import java.util.Scanner;

public class PruefView {
    public int menuAnzeige() {
        StringBuilder s = new StringBuilder();

        s.append("*** Pruef View ***" + "\n")
                .append("(1) Hole Detailinformationen" + "\n")
                .toString();

        System.out.println(s);

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
