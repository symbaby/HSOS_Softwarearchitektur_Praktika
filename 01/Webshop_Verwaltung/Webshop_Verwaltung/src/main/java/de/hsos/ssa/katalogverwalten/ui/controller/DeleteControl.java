package de.hsos.ssa.katalogverwalten.ui.controller;

import de.hsos.ssa.katalogverwalten.al.IDelete;
import de.hsos.ssa.katalogverwalten.ui.model.DeleteModel;
import de.hsos.ssa.katalogverwalten.ui.view.DeleteView;

public class DeleteControl {
    private DeleteModel deleteModel;
    private DeleteView deleteView;
    private IDelete delete;

    public DeleteControl(IDelete delete){
        this.deleteModel = new DeleteModel();
        this.deleteView = new DeleteView();
        this.delete = delete;
    }

    public void menueAnzeige() {
        int deleteId = this.deleteView.menueAnzeige();
        this.delete.delete(deleteId);
    }
}
