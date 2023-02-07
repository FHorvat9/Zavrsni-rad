package horvat.obrada;

import java.util.ArrayList;
import java.util.List;

import horvat.model.Proizvod;
import horvat.terminal.Pomocno;
import horvat.terminal.Start;

public class Proizvodi {

	private List<Proizvod> proizvodi;
	private Start start;

	public void izbornik() {

		System.out.println("\n******Proizvodi izbornik******\n");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Unesi novi proizvod");
		System.out.println("2. Pogledaj sve proizvode");
		System.out.println("3. Izmjeni proizvod");
		System.out.println("4. Obrisi prizvod");
		System.out.println("5. Povratak na glavni izbornik\n");
		odabirProizvodi();

	}

	private void odabirProizvodi() {
		switch (Pomocno.unosBrojRaspon("Unesite zeljeni odabir: ", 1, 5)) {
		case 1:
			unosProizvoda();
			break;
		case 2:
			if (proizvodi.size() == 0) {
				System.out.println("\n------------------------");
				System.out.println("Nema upisanih proizvoda");
				System.out.println("------------------------");
				izbornik();
			}
			pregledProizvoda(true);
			break;
		case 3:
			if (proizvodi.size() == 0) {
				System.out.println("\n------------------------");
				System.out.println("Nema upisanih proizvoda");
				System.out.println("------------------------");
				izbornik();
			}
//			izmjeniProizvod();
			break;
		case 4:
			if (proizvodi.size() == 0) {
				System.out.println("\n------------------------");
				System.out.println("Nema upisanih proizvoda");
				System.out.println("------------------------");
				izbornik();
			}
//			obrisiProizvod();
			break;
		case 5:
			start.glavniIzbornik();
			break;

		}

	}

	private void pregledProizvoda(boolean b) {
		int n = 0;
		for (Proizvod proizvod : proizvodi) {
			System.out.println(++n + ". " + proizvod.toString());
		}
		if (b) {
			izbornik();
		}

	}

	private void unosProizvoda() {
		while (true) {
			proizvodi.add(podatciProizvoda());
			if (Pomocno.nastavankDaNe("Zelite li dodati jos jedan proizvod Y/N")) {
				unosProizvoda();
			} else {
				break;
			}
		}
		izbornik();

	}

	private Proizvod podatciProizvoda() {

		Proizvod p = new Proizvod();

		vanjska: while (true) {
			p.setSifra(Pomocno.unosBrojRaspon("Unesi sifru proizvoda ", 0, Integer.MAX_VALUE));
			for (Proizvod sifra : proizvodi) {
				if (sifra.getSifra() == p.getSifra()) {
					System.out.println("Postoji proizvod s tom sifrom");
					continue vanjska;
				}

			}
			break;
		}
		;

		vanjska: while (true) {
			p.setImeProizvoda(Pomocno.unosTeksta("Unesi ime proizvoda "));
			for (Proizvod ime : proizvodi) {
				if (ime.getImeProizvoda().equalsIgnoreCase(p.getImeProizvoda())) {
					System.out.println("Postoji proizvod s tim imenom");
					continue vanjska;
				}

			}
			break;
		}
		;

		p.setCijena(Pomocno.unosPozBigDecimal("Unesi cijenu proizvoda u Kn "));

		return p;

	}

	public List<Proizvod> getProizvodi() {
		return proizvodi;
	}

	public void setProizvodi(List<Proizvod> proizvodi) {
		this.proizvodi = proizvodi;
	}

	public Proizvodi(Start start) {
		super();
		this.start = start;
		proizvodi = new ArrayList<>();
	}

	public Proizvodi(ArrayList<Proizvod> proizvodi, Start start) {
		super();
		this.proizvodi = proizvodi;
		this.start = start;
	}

}
