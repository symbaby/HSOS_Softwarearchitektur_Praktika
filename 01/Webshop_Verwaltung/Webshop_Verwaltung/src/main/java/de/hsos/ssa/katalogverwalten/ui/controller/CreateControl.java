package de.hsos.ssa.katalogverwalten.ui.controller;

import de.hsos.ssa.katalogverwalten.al.ICreate;
import de.hsos.ssa.katalogverwalten.ui.model.CreateModel;
import de.hsos.ssa.katalogverwalten.ui.view.CreateView;

import java.sql.SQLException;

public class CreateControl {
    private CreateModel createModel;
    private CreateView createView;
    private ICreate create;

    public CreateControl(ICreate create) {
        this.createModel = new CreateModel();
        this.createView = new CreateView();
        this.create = create;
    }

    public void menueAuswahl() throws SQLException {
        this.createView.menueAnzeige();

        String name = this.createView.nameAbfragen();
        int preis = this.createView.preisAbfragen();
        String beschreibung = this.createView.beschreibungAbfragen();

        this.create.create(name, preis, beschreibung);
    }


}
