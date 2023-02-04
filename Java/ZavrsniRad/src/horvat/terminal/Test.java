package horvat.terminal;

import java.util.Scanner;

public class Test {
	public Test() {
		Pomocno.ulaz = new Scanner(System.in);
		Pomocno.nastavankDaNe("Unesi Y za Da, N za ne");
	}
	public static void main(String[] args) {
		new Test();
	}
}
