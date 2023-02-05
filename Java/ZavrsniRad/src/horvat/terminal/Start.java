package horvat.terminal;

import java.util.Scanner;

import horvat.obrada.Blagajnici;
import horvat.obrada.Proizvodi;


public class Start {
	
	private Blagajnici blagajnici;
	private Proizvodi proizvodi;
	
	public Start() {
		Pomocno.ulaz = new Scanner(System.in);
		blagajnici = new Blagajnici(this);
		proizvodi = new Proizvodi(this);
		pozdravi();
		glavniIzbornik();
	}

	private void pozdravi() {
		System.out.println("Dobrodosli u program za obradu racuna!\n");

	}

	public void glavniIzbornik() {
		System.out.println("\n******Glavni izbornik******\n");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Blagajnici");
		System.out.println("2. Proizvodi");
		System.out.println("3. Racuni");
		System.out.println("4. Izlaz\n");
		izborOpcija();

	}

	private void izborOpcija() {
		switch (Pomocno.unosBrojRaspon("Unesite zeljenu opciju: ", 1, 4)) {
		case 1:
			System.out.println("1");
			blagajnici.izbornik();
			break;
		case 2:
			System.out.println("2");
			proizvodi.izbornik();
			break;
		case 3:
			System.out.println("3");
			glavniIzbornik();
			break;
		case 4:
			System.out.println("Doviđenja!");
			break;
		}
	}

	public static void main(String[] args) {
		if(args.length==1) {
			Pomocno.DEV=true;
		}else {
			Pomocno.DEV=false;
		}
		new Start();
	}
}
