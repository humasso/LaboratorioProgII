
public class Registers {
	// OVERVIEW
	/*
	 * Questa classe contiene due contatori, l'IP e l'RBP
	 */

	/*
	 * IR: IP => 0, RBP => 0
	 * AF: (IP, RBP): due contatori
	 */

	// ATTRIBUTI
	private int IP;
	private int RBP;

	// COSTRUTTORI
	/**
	 * 
	 * Costruisco l'oggeto Register inizializzando IP e RBP =0
	 *
	 * @param IP
	 * @param RBP
	 * 
	 */
	public Registers() {
		IP = 0;
		RBP = 0;
	}

	/**
	 * 
	 * Costruisco l'oggeto Register inizializzando IP e RBP tramite i valori passati
	 * come parametro lancio un eccezione se i valori sono < 0
	 *
	 * @param IP
	 * @param RBP
	 * @throws IllegalArgumentException
	 */
	public Registers(int IP, int RBP) throws IllegalArgumentException {
		if (IP < 0 || RBP < 0)
			throw new IllegalArgumentException("IP e RBP devono essere maggiori di zero brutte merde");

		this.IP = IP;
		this.RBP = RBP;
	}

	/**
	 * 
	 * Imposto il valore di IP pari al parametro passato. Sollevo un eccezione se il
	 * parametro è minore di zero
	 *
	 * @param i
	 * @throws IllegalArgumentException
	 */
	public void jumpIP(int i) {
		if (i < 0)
			throw new IllegalArgumentException("Il nuovo valore di IP deve essere maggiore di zero brutte merde");

		IP = i;
	}

	/**
	 * 
	 * Sommo ad IP il valore del parametro i. Il parametro deve essere maggiore d
	 * -IP
	 *
	 * @param i
	 * @throws IllegalArgumentException
	 */
	public void adderIP(int i) {
		if (i <= -1 * IP)
			throw new IllegalArgumentException("Il nuovo valore di IP deve essere maggiore di zero brutte merde");
		IP += i;
	}

	/**
	 * 
	 * Sommo uno al valore di IP
	 *
	 * @throws IllegalArgumentException
	 */
	public void nextIP() {
		adderIP(1);
	}

	/**
	 * Restituisco il valore di IP
	 * 
	 * @return IP
	 */
	public int getIP() {
		return IP;
	}

	/**
	 * 
	 * Imposto il valore di RBP pari al parametro passato. Sollevo un eccezione se
	 * il
	 * parametro è minore di zero
	 *
	 * @param i
	 * @throws IllegalArgumentException
	 */
	public void jumpRBP(int i) {
		if (i < 0)
			throw new IllegalArgumentException("Il nuovo valore di RBP deve essere maggiore di zero brutte merde");

		RBP = i;
	}

	/**
	 * 
	 * Sommo ad RBP il valore del parametro i. Il parametro deve essere maggiore d
	 * -RBP
	 *
	 * @param i
	 * @throws IllegalArgumentException
	 */
	public void adderRBP(int i) {
		if (i <= -1 * RBP)
			throw new IllegalArgumentException("Il nuovo valore di RBP deve essere maggiore di zero brutte merde");
		RBP += i;
	}

	/**
	 * 
	 * Sommo uno al valore di RBP
	 */
	public void nextRBP() {
		adderRBP(1);
	}

	/**
	 * Restituisco il valore di RBP
	 * 
	 * @return RBP
	 */
	public int getRBP() {
		return RBP;
	}

	@Override
	public String toString() {
		int i = IP + 1;
		return "[IP = " + i + ", RBP = " + RBP + "]";
	}
}