import java.util.ArrayList;

public class Memory {
	private final ArrayList<Integer> data;

	public Memory() {
		data = new ArrayList<Integer>();
	}

	public Memory(int data[]) {
		this();
		addData(data);
	}

	public void addData(int data[]) {
		for (int i = 0; i < data.length; i++) {
			this.data.add(data[i]);
		}
	}

	public Integer getAt(int pos) throws IllegalArgumentException {
		if (pos > data.size() || pos < 0)
			throw new IllegalArgumentException(
					"La posizione deve essere maggiore di zero e minore della lunghezza di data");

		return data.get(pos);
	}

	public void setAt(int pos, int value) throws IllegalArgumentException {
		if (pos > data.size() || pos < 0)
			throw new IllegalArgumentException(
					"La posizione deve essere maggiore di zero e minore della lunghezza di data");

		data.set(pos, value);
	}

	public int readValue(int arg, Registers reg, AccessMode acm) {
		switch (acm) {
			case POSITION:
				// System.out.println("position");
				return getAt(getAt(arg));

			case IMMEDIATE:
				// System.out.println("immediare");
				return getAt(arg);

			case RELATIVE:
				// System.out.println("relative");

				reg.adderRBP(getAt(arg));
				return getAt(reg.getRBP());

			default:
				return 0;
		}
	}

	@Override
	public String toString() {
		String str = "[";

		for (int i = 0; i < data.size(); i++)
			str += data.get(i).toString() + ", ";

		str = str.substring(0, str.length() - 2);
		return str += "]";
	}
}