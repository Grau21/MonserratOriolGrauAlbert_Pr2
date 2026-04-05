package prog2.model;

public class TascaManteniment implements InTascaManteniment{

    // Atributs
    //------------

    private int num;
    private Allotjament allotjament;
    private String data;
    private TipusTascaManteniment tipus;
    private int dies;

    // Constructors
    //---------------

    /**
     * Constructor per defecte de la classe.
     * @param num
     * @param allotjament
     * @param data
     * @param tipus
     * @param dies
     */
    TascaManteniment(int num, TipusTascaManteniment tipus,
                     Allotjament allotjament, String data,
                     int dies){
        this.num = num;
        this.allotjament = allotjament;
        this.data = data;
        this.tipus = tipus;
        this.dies = dies;
    }

    // Getters i Setters.
    //---------------------

    /**
     * Retorna el número identificador de la tasca.
     * @return int
     */
    @Override
    public int getNum() { return num; }

    /**
     * Retorna el tipus de tasca de manteniment.
     * @return TipusTascaManteniment
     */
    @Override
    public TascaManteniment.TipusTascaManteniment getTipus() { return tipus; }

    /**
     * Retorna l'allotjament associat a la tasca.
     * @return Allotjament
     */
    @Override
    public Allotjament getAllotjament() { return allotjament; }

    /**
     * Retorna la data de registre de la tasca.
     * @return String
     */
    @Override
    public String getData() { return data; }

    /**
     * Retorna el nombre de dies previstos per completar la tasca.
     * @return int
     */
    @Override
    public int getDies() { return dies; }

    /**
     * Assigna un nou número identificador a la tasca.
     * @param num_ Número identificador de la tasca.
     */
    @Override
    public void setNum(int num_) { num = num_; }

    /**
     * Assigna el tipus de tasca de manteniment.
     * @param tipus_ Tipus de tasca.
     */
    @Override
    public void setTipus(TascaManteniment.TipusTascaManteniment tipus_) { tipus = tipus_; }

    /**
     * Assigna l'allotjament associat a la tasca.
     * @param allotjament_ Allotjament afectat.
     */
    @Override
    public void setAllotjament(Allotjament allotjament_) { allotjament = allotjament_; }

    /**
     * Assigna la data de registre de la tasca.
     * @param data_ Data de la tasca.
     */
    @Override
    public void setData(String data_) { data = data_; }

    /**
     * Assigna el nombre de dies previstos per completar la tasca.
     * @param dies_ Nombre de dies.
     */
    @Override
    public void setDies(int dies_) { dies = dies_; }

    // Mètodes
    //---------

    /**
     * Retorna el percentatge d'il·luminació que ha de tenir l'allotjament
     * segons el tipus de tasca de manteniment.
     * @return String amb el percentatge d'il·luminació.
     */
    @Override
    public String getIluminacioAllotjament() {

        switch (tipus) {
            case Reparacio:
            case RevisioTecnica:
                return "50%";
            case Neteja:
                return "100%";
            case Desinfeccio:
                return "0%";
        }

        // Si no s'ha retornart correctament returnem ERROR
        return "ERROR: Iluminacio";
    }

    /**
     * Retorna un String amb la informació de la Tasca de Manteniment.
     * @return
     */
    @Override
    public String toString() {
        return "Num=" + num + ", Allotjament=" + allotjament +
               ", Data=" + data + ", Tipus=" + tipus +
               ", Dies=" + dies + ".";
    }

    // Enums
    //---------

    /**
     * Enum que defineix la tasca de manteniment.
     */
    public static enum TipusTascaManteniment {
        Reparacio,
        Neteja,
        RevisioTecnica,
        Desinfeccio
    }
}
