public enum AccessMode {
    POSITION(0),
    IMMEDIATE(1),
    RELATIVE(2);

    private final int code;

    private AccessMode(int code) {
        this.code = code;
    }

    /*
     * EFFECTS: Restituisce l'AccessCode con codice code
     * Solleva un'eccezione di tipo nel caso il codice non corrisponde a nessuna
     * modalità d'accesso
     */

    public static AccessMode fromCode(int code) {
        for (AccessMode m : values())
            if (m.code == code)
                return m;
        throw new IllegalArgumentException("Invalid Mode: " + code);
    }

    public boolean equals(AccessMode t) {
        return t.code == this.code;
    }

    public int getCode() {
        return this.code;
    }
}