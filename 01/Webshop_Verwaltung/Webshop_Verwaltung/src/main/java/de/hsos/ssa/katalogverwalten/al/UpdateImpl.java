package de.hsos.ssa.katalogverwalten.al;

import de.hsos.ssa.katalogverwalten.dal.KatalogRepository;

public class UpdateImpl implements IUpdate {
    private UpdateInModul updateInModul;
    private ParallelUpdate parallelUpdate;

    public UpdateImpl(){
        this.updateInModul = new UpdateInModul(new KatalogRepository());
        this.parallelUpdate = new ParallelUpdate();
    }

    @Override
    public void update(int nummer, String name, int preis, String beschreibung) {
        this.updateInModul.updateUpdate(nummer, name, preis, beschreibung);
        this.parallelUpdate.updateUpdate(nummer, name, preis, beschreibung);

    }
}
