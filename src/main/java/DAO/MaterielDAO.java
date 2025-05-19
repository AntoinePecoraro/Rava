package DAO;

import Entity.Materiel;

public class MaterielDAO extends DAO<Materiel>{
    @Override
    protected String getFilename() {
        return "materiels.dat";
    }

}
