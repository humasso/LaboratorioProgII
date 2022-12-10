import java.util.Scanner;

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

	public void executeCode() {
		while (memory.getAt(registers.getIP()) != 99) {
			String instruction = (memory.getAt(registers.getIP()).toString());

			while (instruction.length() < 5)
				instruction = "0" + instruction;

			String[] parts = instruction.split("");
			AccessMode acm1 = AccessMode.fromCode(Integer.parseInt(parts[2]));
			AccessMode acm2 = AccessMode.fromCode(Integer.parseInt(parts[1]));
			AccessMode acm3 = AccessMode.fromCode(Integer.parseInt(parts[0]));

			int arg1;
			int arg2;
			int arg3;

			switch (parts[3] + parts[4]) {
				case "01":
					arg1 = memory.readValue(registers.getIP() + 1, registers, acm1);
					arg2 = memory.readValue(registers.getIP() + 2, registers, acm2);
					arg3 = memory.getAt(registers.getIP() + 3);

					System.out.println(arg1);
					System.out.println(arg2);
					System.out.println(arg3);
					memory.setAt(arg3, arg1 + arg2);
					registers.adderIP(4);

					break;
				case "02":

					arg1 = memory.readValue(registers.getIP() + 1, registers, acm1);
					arg2 = memory.readValue(registers.getIP() + 2, registers, acm2);
					arg3 = memory.getAt(registers.getIP() + 3);
					// System.out.println(arg1);
					// System.out.println(arg2);
					// System.out.println(arg3);
					memory.setAt(arg3, arg1 * arg2);
					registers.adderIP(4);

					break;
				case "03":
					// Legge in input (da standard input) un numero intero e lo memorizza nella
					// cella di memoria indicata dall'argomento.
					// Giova
					/*
					 * arg1 = memory.readValue(registers.getIP() + 1, registers, acm1);
					 * System.out.println(arg1);
					 * Scanner scr = new Scanner(System.in);
					 * memory.setAt(arg1, scr.nextInt());
					 */
					// tino
					arg1 = memory.getAt(registers.getIP() + 1);
					System.out.println(arg1);
					Scanner scr = new Scanner(System.in);
					memory.setAt(arg1, scr.nextInt());
					registers.adderIP(2);

					break;
				case "04":
					// System.out.println("ciO");
					// System.out.println(memory.getAt(registers.getIP() + 1));
					System.out.println(memory.readValue(registers.getIP() + 1, registers, acm1));
					registers.adderIP(2);

					break;
				case "05":
					// System.out.println("ho 05");
					if (memory.readValue(registers.getIP() + 1, registers, acm1) != 0) {
						registers.jumpIP(memory.readValue(registers.getIP() + 2, registers, acm2));
					} else {
						registers.nextIP();

					}

					break;
				case "06":
					// System.out.println("ho 06");
					if (memory.readValue(registers.getIP() + 1, registers, acm1) == 0) {
						registers.jumpIP(memory.readValue(registers.getIP() + 2, registers, acm2));
					}

					registers.adderIP(2);

					break;
				case "07":
					// System.out.println("ho 07");
					arg1 = memory.readValue(registers.getIP() + 1, registers, acm1);
					arg2 = memory.readValue(registers.getIP() + 2, registers, acm2);
					arg3 = memory.getAt(registers.getIP() + 3);
					// System.out.println(arg1 + "<" + arg2);
					// System.out.println(arg3);

					if (arg1 < arg2) {
						memory.setAt(arg3, 1);

					} else {
						memory.setAt(arg3, 0);

					}
					registers.adderIP(4);

					break;
				case "08":
					// System.out.println("ho 08");
					arg1 = memory.readValue(registers.getIP() + 1, registers, acm1);
					arg2 = memory.readValue(registers.getIP() + 2, registers, acm2);
					arg3 = memory.getAt(registers.getIP() + 3);
					if (arg1 == arg2) {
						memory.setAt(arg3, 1);

					} else {
						memory.setAt(arg3, 0);

					}
					registers.adderIP(4);

					break;
				case "09":
					// System.out.println("ho 09");
					registers.adderRBP(memory.readValue(registers.getIP() + 1, registers, acm1));
					registers.adderIP(2);

					break;
			}
			// registers.nextIP();

			// System.out.println("eee");
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

	public void printArr(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

		}
	}

	@Override
	public String toString() {
		// IntcodeVM :
		// Memory :
		// [4,3,101,0,28,3,101,1,4,4,5,3,16,99,29,7,0,3,-67,-12,87,-8,3,-6,-8,-67,-23,-10]
		// Registers : [IP = 14, RBP = 0]
		String str = "";
		str += "IntCodeVM :";
		str += "  Memory : ";
		str += memory.toString() + "\n";
		str += "  Registers : ";
		str += registers.toString() + "\n";
		return str;

	}
}