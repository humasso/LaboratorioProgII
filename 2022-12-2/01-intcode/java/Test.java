public class Test {
	
	public static void main(String[] args){
		IntcodeVM vm = new IntcodeVM(new int[]{1, 0, 0, 0, 99});
		vm.executeCode();
	}
}