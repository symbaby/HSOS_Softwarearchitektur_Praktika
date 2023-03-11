package de.hsos.swa.ssa.ui.view;

import java.sql.SQLException;

public class SimpleShoppingAppControl {
    private SimpleShoppingAppView simpleShoppingAppView;
    private SimpleShoppingAppModel simpleShoppingAppModel;
    private MenuControl menuControl;

    public SimpleShoppingAppControl() {
        this.simpleShoppingAppView = new SimpleShoppingAppView();
        this.simpleShoppingAppModel = new SimpleShoppingAppModel();

        this.menuControl = new MenuControl();
    }

    public void begruessung() throws SQLException {
        int input = this.simpleShoppingAppView.begruessung();

        if (input == 1) {
            this.menueAuswahl();
        } else {
            System.err.println("Bitte etwas korrektes eingeben!");
            this.begruessung();
        }
    }

    public void menueAuswahl() throws SQLException {
        this.menuControl.menueAuswahl();
    }


}
