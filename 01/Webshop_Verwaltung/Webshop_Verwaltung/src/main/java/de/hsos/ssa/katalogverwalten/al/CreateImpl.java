package de.hsos.ssa.katalogverwalten.al;

import de.hsos.ssa.katalogverwalten.dal.KatalogRepository;

import java.sql.SQLException;

public class CreateImpl implements ICreate {

    private UpdateInModul updateInModul;
    private ParallelUpdate parallelUpdate;

    public CreateImpl() {
        this.updateInModul = new UpdateInModul(new KatalogRepository());
        this.parallelUpdate = new ParallelUpdate();

    }

    @Override
    public void create(String name, int preis, String beschreibung) throws SQLException {
        this.updateInModul.createUpdate(name, preis, beschreibung);
        this.parallelUpdate.createUpdate(name, preis, beschreibung);
    }
}
