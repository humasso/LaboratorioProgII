public class Test {

	public static void main(String[] args) {
		// IntcodeVM vm = new IntcodeVM(new int[] { 1, 0, 0, 0, 99 });
		// IntcodeVM vm = new IntcodeVM(new int[] { 2, 3, 0, 3, 99 });
		// IntcodeVM vm = new IntcodeVM(new int[] { 3, 0, 99 });
		// IntcodeVM vm = new IntcodeVM(new int[] { 4, 0, 99 });
		// IntcodeVM vm = new IntcodeVM(new int[] { 5, 0, 4, 0, 99 });
		// IntcodeVM vm = new IntcodeVM(new int[] { 7, 1, 3, 0, 99 });
		// IntcodeVM vm = new IntcodeVM(new int[] { 8, 0, 0, 1, 99 });
		IntcodeVM vm = new IntcodeVM(new int[] { 4, 3, 101, 72, 14, 3, 101, 1, 4, 4, 5, 3, 16, 99, 29, 7, 0, 3, -67,
				-12, 87, -8, 3, -6, -8, -67, -23, -10 });

		vm.executeCode();
		System.out.println(vm.toString());
		// Memory memory = new Memory();
		// Registers reg = new Registers();
		// memory.readValue(0, reg, AccessMode.POSITION);
		// System.out.println(reg.getIP());
	}
}