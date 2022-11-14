
public class contatto {
    String telefono;
    String nome;

    public contatto(String telefono, String nome) {
        this.telefono = telefono;
        this.nome = nome;
    }

    public contatto() {
        this.telefono = "";
        this.nome = "";
    }

    /**
     * 
     * @return String restituisce il telefono
     * 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @return String
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return String
     */

    public String toString() {
        return "l'utente: " + nome + "ha il telefono associato: " + telefono;
    }

    /**
     * @param telefono
     */
    public void changeTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @param nome
     */
    public void changeNome(String nome) {
        this.nome = nome;
    }

}
