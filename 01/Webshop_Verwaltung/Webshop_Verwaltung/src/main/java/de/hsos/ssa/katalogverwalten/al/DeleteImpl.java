package de.hsos.ssa.katalogverwalten.al;

import de.hsos.ssa.katalogverwalten.dal.KatalogRepository;

public class DeleteImpl implements IDelete{
    private UpdateInModul updateInModul;
    private ParallelUpdate parallelUpdate;

    public DeleteImpl(){
        this.updateInModul = new UpdateInModul(new KatalogRepository());
        this.parallelUpdate = new ParallelUpdate();
    }

    @Override
    public void delete(int id) {
        this.updateInModul.deleteUpdate(id);
        this.parallelUpdate.deleteUpdate(id);
    }
}
