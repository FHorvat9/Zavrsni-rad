package horvat.terminal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Test {
	public Test() {
		
		Pomocno.ulaz = new Scanner(System.in);
		Pomocno.nastavankDaNe("Unesi Y za Da, N za ne");
		BigDecimal a = Pomocno.unosPozBigDecimal("Unesi broj");
		System.out.println(a);
		
		a=a.add(a);
		System.out.println(a);
		
		List<Integer> sifre = new ArrayList<>();
		sifre.add(Pomocno.unosBrojRaspon("1", 0, 1000));
		sifre.add(Pomocno.unosBrojRaspon("2", 0, 1000));
		
		for (Integer integer : sifre) {
			System.out.println("prva");
			System.out.println(integer);
		}
		sifre = new ArrayList<>();
		System.out.println("help");
		sifre.add(Pomocno.unosBrojRaspon("1", 0, 1000));
		sifre.add(Pomocno.unosBrojRaspon("2", 0, 1000));
		
		for (Integer integer : sifre) {
			System.out.println("Druga");
			System.out.println(integer);
		}
		
		
	}
	public static void main(String[] args) {
		new Test();
	}
}
