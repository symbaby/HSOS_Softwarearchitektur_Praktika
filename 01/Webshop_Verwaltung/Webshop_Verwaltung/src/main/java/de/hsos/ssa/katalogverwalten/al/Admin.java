package de.hsos.ssa.katalogverwalten.al;

import java.sql.SQLException;

public class Admin implements ICreate, IUpdate, IDelete {
    private ICreate createImpl;
    private IUpdate updateImpl;
    private IDelete deleteImpl;

    public Admin() {
        this.createImpl = new CreateImpl();
        this.updateImpl = new UpdateImpl();
        this.deleteImpl = new DeleteImpl();
    }


    //ToDo delegationsmethoden von den Implementationen
    @Override
    public void create(String name, int preis, String beschreibung) throws SQLException {
        this.createImpl.create(name, preis, beschreibung);
    }

    @Override
    public void delete(int id) {
        this.deleteImpl.delete(id);
    }

    @Override
    public void update(int nummer, String name, int preis, String beschreibung) {
        this.updateImpl.update(nummer, name, preis, beschreibung);
    }
}
