package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaTasquesManteniment implements InLlistaTasquesManteniment {
    private ArrayList<TascaManteniment> llista;

    public LlistaTasquesManteniment() {
        llista = new ArrayList<>();
    }

    @Override
    public void afegirTascaManteniment(int num, String tipus, Allotjament allotjament, String data, int dies) throws ExcepcioCamping {
        // Comprovar si l'allotjament ja té tasca activa
        for (TascaManteniment t : llista) {
            if (t.getAllotjament().equals(allotjament)) {
                throw new ExcepcioCamping("L'allotjament " + allotjament.getId() + " ja té una tasca de manteniment activa.");
            }
        }
        // Convertir String a enum
        TascaManteniment.TipusTascaManteniment tipusEnum;
        try {
            tipusEnum = TascaManteniment.TipusTascaManteniment.valueOf(tipus);
        } catch (IllegalArgumentException e) {
            throw new ExcepcioCamping("Tipus de tasca no vàlid: " + tipus);
        }
        TascaManteniment tasca = new TascaManteniment(num, allotjament, data, tipusEnum, dies);
        llista.add(tasca);
        // Actualitzar estat de l'allotjament: no operatiu i canviar il·luminació segons tasca
        allotjament.setEstat(false);
        String illumStr = tasca.getIluminacioAllotjament(); // ex: "50%"
        int percent = Integer.parseInt(illumStr.replace("%", ""));
        allotjament.setIlluminacio(percent);
    }

    @Override
    public void completarTascaManteniment(TascaManteniment tasca) throws ExcepcioCamping {
        if (!llista.contains(tasca)) throw new ExcepcioCamping("La tasca no existeix a la llista");
        llista.remove(tasca);
        // Restaurar allotjament: operatiu i il·luminació al 100%
        tasca.getAllotjament().setEstat(true);
        tasca.getAllotjament().setIlluminacio(100);
    }

    @Override
    public String llistarTasquesManteniment() throws ExcepcioCamping {
        if (llista.isEmpty()) throw new ExcepcioCamping("No hi ha tasques de manteniment actives");
        StringBuilder sb = new StringBuilder();
        for (TascaManteniment t : llista) {
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public TascaManteniment getTascaManteniment(int num) throws ExcepcioCamping {
        for (TascaManteniment t : llista) {
            if (t.getNum() == num) return t;
        }
        throw new ExcepcioCamping("No s'ha trobat cap tasca amb número " + num);
    }
}
