package DAO;

import Entity.Materiel;

public class MaterielDAO extends DAO<Materiel>{
    @Override
    protected String getFilename() {
        return "./src/ressources/saveFiles/materiels.dat";
    }

}
