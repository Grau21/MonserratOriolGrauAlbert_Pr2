package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaAllotjaments implements InLlistaAllotjaments {
    private ArrayList<Allotjament> llista;

    public LlistaAllotjaments() {
        llista = new ArrayList<>();
    }

    public int size() {
        return llista.size();
    }

    public void add(Allotjament allotjament) {
        llista.add(allotjament);
    }

    public ArrayList<Allotjament> getLlistaAllotjaments() { return llista; }

    @Override
    public void afegirAllotjament(Allotjament allotjament) throws ExcepcioCamping {
        if (allotjament == null) throw new ExcepcioCamping("Allotjament nul");
        llista.add(allotjament);
    }

    @Override
    public void buidar() {
        llista.clear();
    }

    @Override
    public String llistarAllotjaments(String estat) throws ExcepcioCamping {
        boolean operatiu = estat.equalsIgnoreCase("Operatiu");
        StringBuilder sb = new StringBuilder();
        boolean trobat = false;
        for (Allotjament a : llista) {
            if (a.isEstat() == operatiu) {
                sb.append(a.toString()).append("\n");
                trobat = true;
            }
        }
        if (!trobat) throw new ExcepcioCamping("No hi ha allotjaments en estat " + estat);
        return sb.toString();
    }

    @Override
    public boolean containsAllotjamentOperatiu() {
        for (Allotjament a : llista) {
            if (a.isEstat()) return true;
        }
        return false;
    }

    @Override
    public boolean contains(Allotjament allotjament) {
        return llista.contains(allotjament);
    }

    @Override
    public Allotjament getAllotjament(String id) throws ExcepcioCamping {
        for (Allotjament a : llista) {
            if (a.getId().equals(id)) return a;
        }
        throw new ExcepcioCamping("Allotjament amb id " + id + " no trobat");
    }
}
