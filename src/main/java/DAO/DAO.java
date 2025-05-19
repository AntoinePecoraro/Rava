package DAO;

import Entity.Identifiable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class DAO<T extends Serializable & Identifiable> {
    protected Map<Integer, T> elements = new HashMap<>();
    protected int nextId = 1;

    protected abstract String getFilename();

    public DAO() {
        try {
            load();
        } catch (Exception e) {
            System.err.println("Erreur au chargement : " + e.getMessage());
        }
    }

    //region CRUD
    public boolean create(T obj) {
        if (obj.getId() == 0) {
            obj.setId(nextId);
            nextId++;
        }

        elements.put(obj.getId(), obj);

        try {
            save();
            return true;
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
            return false;
        }
    }

    
    public T read(int id) {
        return elements.get(id);
    }

    
    public List<T> readAll() {
        return new ArrayList<>(elements.values());
    }

    
    public boolean update(T obj) {
        if (!elements.containsKey(obj.getId())) {
            return false;
        }

        elements.put(obj.getId(), obj);

        try {
            save();
            return true;
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
            return false;
        }
    }

    
    public boolean delete(int id) {
        T removed = elements.remove(id);

        if (removed != null) {
            try {
                save();
                return true;
            } catch (IOException e) {
                elements.put(id, removed);
                System.err.println("Erreur lors de la sauvegarde: " + e.getMessage());
                return false;
            }
        }
        return false;
    }

    
    public void save() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getFilename()))) {
            oos.writeInt(nextId);
            oos.writeInt(elements.size());
            for (T obj : elements.values()) {
                oos.writeObject(obj);
            }
        }
    }

    
    public void load() throws IOException, ClassNotFoundException {
        File file = new File(getFilename());
        if (!file.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(getFilename()))) {
            nextId = ois.readInt();
            int count = ois.readInt();
            elements.clear();
            for (int i = 0; i < count; i++) {
                T obj = (T) ois.readObject();
                elements.put(obj.getId(), obj);
            }
        }
    }
    //endregion
}
