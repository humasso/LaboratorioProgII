import java.util.ArrayList;

public class Memory {
	private ArrayList<Integer> data;

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
}