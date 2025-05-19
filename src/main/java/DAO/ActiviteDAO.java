package DAO;

import Entity.APied;
import Entity.AVelo;
import Entity.Activite;

import java.util.List;


public class ActiviteDAO extends DAO<Activite>{

    @Override
    protected String getFilename() {
        return "activites.dat";
    }

    public List<APied> getActivitesAPied() {
        return elements.values().stream().filter(a -> a instanceof APied).map(a -> (APied) a).toList();
    }

    public List<AVelo> getActivitesAVelo() {
        return elements.values().stream().filter(a -> a instanceof AVelo).map(a -> (AVelo) a).toList();
    }
}
