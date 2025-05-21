package DAO;

import Entity.Materiel;

public class MaterielDAO extends DAO<Materiel>{
    @Override
    protected String getFilename() {
        return "../../../ressources/saveFiles/materiels.dat";
    }

}
