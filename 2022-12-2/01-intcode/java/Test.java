public class Test {

	public static void main(String[] args) {
		// IntcodeVM vm = new IntcodeVM(new int[] { 1, 0, 0, 0, 99 });
		// IntcodeVM vm = new IntcodeVM(new int[] { 2, 3, 0, 3, 99 });
		IntcodeVM vm = new IntcodeVM(new int[] { 3, 0, 99 });

		vm.executeCode();
		System.out.println(vm.toString());
		// Memory memory = new Memory();
		// Registers reg = new Registers();
		// memory.readValue(0, reg, AccessMode.POSITION);
		// System.out.println(reg.getIP());
	}
}