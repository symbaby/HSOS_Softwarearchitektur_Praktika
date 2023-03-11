package de.hsos.ssa.katalogverwalten.ui.controller;

import de.hsos.ssa.katalogverwalten.al.IUpdate;
import de.hsos.ssa.katalogverwalten.ui.model.UpdateModel;
import de.hsos.ssa.katalogverwalten.ui.view.UpdateView;

public class UpdateControl {
    private UpdateModel updateModel;
    private UpdateView updateView;
    private IUpdate update;

    public UpdateControl(IUpdate update){
        this.updateModel = new UpdateModel();
        this.updateView = new UpdateView();
        this.update = update;
    }

    public void menueAnzeige() {
        int updateId = this.updateView.menueAnzeige();
        String name = this.updateView.nameAbfragen();
        int preis = this.updateView.preisAbfragen();
        String beschreibung = this.updateView.beschreibungAbfragen();


        this.update.update(updateId,name,preis,beschreibung);
    }
}
