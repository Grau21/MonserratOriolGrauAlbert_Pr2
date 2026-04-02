package prog2.model;

import prog2.vista.ExcepcioCamping;
import java.util.ArrayList;

public class LlistaAccessos implements InLlistaAccessos {
    private ArrayList<Acces> llista;

    public LlistaAccessos() {
        llista = new ArrayList<>();
    }

    @Override
    public void afegirAcces(Acces acc) throws ExcepcioCamping {
        if (acc == null) throw new ExcepcioCamping("Accés nul");
        llista.add(acc);
    }

    @Override
    public void buidar() {
        llista.clear();
    }

    @Override
    public String llistarAccessos(boolean estat) throws ExcepcioCamping {
        StringBuilder sb = new StringBuilder();
        boolean trobat = false;
        for (Acces a : llista) {
            if (a.getEstat() == estat) {
                sb.append(a.toString()).append("\n");
                trobat = true;
            }
        }
        if (!trobat) throw new ExcepcioCamping("No hi ha accessos amb estat " + (estat ? "obert" : "tancat"));
        return sb.toString();
    }

    @Override
    public void actualitzaEstatAccessos() throws ExcepcioCamping {
        for (Acces a : llista) {
            // Si l'accés dona accés a algun allotjament operatiu -> obrir, sinó tancar
            if (a.getAAllotjaments().containsAllotjamentOperatiu()) {
                a.obrirAcces();
            } else {
                a.tancarAcces();
            }
        }
    }

    @Override
    public int calculaAccessosNoAccessibles() throws ExcepcioCamping {
        int count = 0;
        for (Acces a : llista) {
            if (!a.isAccessibilitat()) count++;
        }
        return count;
    }

    @Override
    public float calculaMetresTerra() throws ExcepcioCamping {
        float total = 0;
        for (Acces a : llista) {
            if (a instanceof AccesTerra) {
                total += ((AccesTerra) a).getLongitud();
            }
        }
        return total;
    }
}
