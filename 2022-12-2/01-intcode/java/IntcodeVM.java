public class IntcodeVM {
	Memory memory;
	Registers registers;

	public IntcodeVM(Memory memory, Registers registers) {
		this.memory = memory;
		this.registers = registers;
	}

	public IntcodeVM() {
		this(new Memory(), new Registers());
	}

	public IntcodeVM(int data[]) {
		this(new Memory(), new Registers());
		writeCode(data);
	}

	public void writeCode(int data[]) {
		memory.addData(data);
	}

	public String executeCode() {
		while (memory.getAt(register.IP) != 99) {
			System.out.println(memory.getAt(register.IP).toString());
		}
		/*
		 * While prossimo opcode != 99 do
		 * leggi opcode
		 * leggi parametri
		 * decidi il metodo di accesso
		 * elabora i dati letti
		 * eventualmente salva output
		 */
	}

	public String toString() {

	}
}