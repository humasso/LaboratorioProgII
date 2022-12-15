/*
1. Nella AF è corretto ripetere in parte l'overview? Nel caso possiamo lasciarla vuota s
 fosse identica all'overview?
2. Nel costruttore, possiamo chiamare i metodi setter per impostare i parametri in modo da risparmiare righe di codice?
*/

//Overview: Questa classe si occuperà di rappresentare un giocattolo definito con i campi nome e materiale
public class Giocattolo {
    // IR: nome e materiale non devono essere null/vuote
    //
    // AF: (nome, materiale) : rappresenta un giocattolo chiamato name e di un certo
    // materiale

    // Campi
    private String nome;
    private String materiale;

    // Costruttori
    /**
     * Costruttore che crea un'istanza giocatto partendo dai parametri nome e
     * materiale. Qual'ora dovessero essere vuoti o null richiamiamo la
     * IllegalArgumentException
     * 
     * @param nome
     * @param materiale
     * @throws IllegalArgumentException
     */
    public Giocattolo(String nome, String materiale) throws IllegalArgumentException {
        if (nome.equals(null) || nome.equals("") || materiale.equals(null) || materiale.equals(""))
            throw new IllegalArgumentException();

        this.nome = nome;
        this.materiale = materiale;
        // setNome(nome);
        // setMateriale(materiale);
    }

    /**
     * Metogo get che restituisce il nome del giocattolo
     * 
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metogo get che restituisce il materiale del giocattolo
     * 
     * @return materiale
     */
    public String getMateriale() {
        return materiale;
    }

    /**
     * Metodo set che si occupa si settare il campo nome lancio un eccezione se il
     * parametro è nullo / vuoto
     * 
     * @param nome
     * @throws IllegalArgumentException
     */
    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.equals(null) || nome.equals(""))
            throw new IllegalArgumentException();

        this.nome = nome;
    }

    /**
     * Metodo set che si occupa si settare il campo materiale lancio un eccezione se
     * il parametro è nullo / vuoto
     * 
     * @return materiale
     * @throws IllegalArgumentException
     */
    public void setMateriale(String materiale) throws IllegalArgumentException {
        if (materiale.equals(null) || materiale.equals(""))
            throw new IllegalArgumentException();

        this.materiale = materiale;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Giocattolo) {
            Giocattolo ogg = (Giocattolo) obj;
            if (nome.equals(ogg.nome) && materiale.equals(ogg.materiale)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Giocattolo [nome=" + nome + ", materiale=" + materiale + "]";
    }
}