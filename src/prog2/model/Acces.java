package prog2.model;

import java.util.ArrayList;

public abstract class Acces implements InAcces {
    // Atributs
    private String nom;
    private boolean estat;
    private LlistaAllotjaments acces;

    /**
     * Constructor per defecte de la classe.,
     * @param nom
     * @param estat
     */
    Acces(String nom, boolean estat) {
        this.nom = nom;
        this.estat = estat;
    }

    /**
     * Afegeix un allotjament rebut com a paràmetre a la llista d'allotjaments de l'accés
     * @param allotjament
     */
    public void afegirAllotjament(Allotjament allotjament) {
        acces.add(allotjament);
    }

    /**
     * Canvia l'estat de l'accés a tancat
     */
    public void tancarAcces() {
        estat = false;
    }

    /**
     * Canvia l'estat de l'accés a obert
     */
    public void obrirAcces() {
        estat = true;
    }

    /**
     * Retorna el nom de l'accés
     * @return
     */
    public String getNom() { return nom; }

    /**
     * Retorna l'estat de l'accés (obert o tancat)
     * @return
     */
    public boolean getEstat() { return estat; }

    /**
     * Retorna la llista d'allotjaments associats a l'accés
     * @return
     */
    public LlistaAllotjaments getAAllotjaments() { return acces; }

    // Hem d'afegir el mètode "public abstract String toString()" que retorni la info dels atributs
}
