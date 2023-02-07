package horvat.terminal;

import java.math.BigDecimal;
import java.util.Scanner;

public class Test {
	public Test() {
		
		Pomocno.ulaz = new Scanner(System.in);
		Pomocno.nastavankDaNe("Unesi Y za Da, N za ne");
		BigDecimal a = Pomocno.unosPozBigDecimal("Unesi broj");
		System.out.println(a);
	}
	public static void main(String[] args) {
		new Test();
	}
}
