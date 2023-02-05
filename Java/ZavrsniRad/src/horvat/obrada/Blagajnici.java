package horvat.obrada;

import java.util.ArrayList;
import java.util.List;

import horvat.model.Blagajnik;
import horvat.terminal.Pomocno;
import horvat.terminal.Start;

public class Blagajnici {

	private List<Blagajnik> blagajnici;
	private Start start;

	public void izbornik() {
		System.out.println("\n******Blagajnici izbornik******\n");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Unesi novog blagajnika");
		System.out.println("2. Pogledaj sve blagajnike");
		System.out.println("3. Izmjeni blagajnika");
		System.out.println("4. Obrisi blagajnika");
		System.out.println("5. Povratak na glavni izbornik\n");
		odabirBlaganici();

	}

	private void odabirBlaganici() {
		switch (Pomocno.unosBrojRaspon("Unesite zeljeni odabir: ", 1, 5)) {
		case 1:
			unosBlagajnika();
			break;
		case 2:
			if (blagajnici.size() == 0) {
				System.out.println("\n------------------------");
				System.out.println("Nema upisanih blagajnika");
				System.out.println("------------------------");
				izbornik();
			}
			pregledBlagajnika(true);
			break;
		case 3:
			if (blagajnici.size() == 0) {
				System.out.println("\n------------------------");
				System.out.println("Nema upisanih blagajnika");
				System.out.println("------------------------");
				izbornik();
			}
			izmjeniBlagajnika();
			break;
		case 4:
			if (blagajnici.size() == 0) {
				System.out.println("\n------------------------");
				System.out.println("Nema upisanih blagajnika");
				System.out.println("------------------------");
				izbornik();
			}
			obrisiBlagajnika();
			break;
		case 5:
			start.glavniIzbornik();
			break;

		}

	}

	private void izmjeniBlagajnika() {
		
		pregledBlagajnika(false);
		int unos = (Pomocno.unosBrojRaspon("\nKojeg blagajnika zelite izmjeniti? ", 1, blagajnici.size()) - 1);
		blagajnici.remove(unos);
		blagajnici.add(unos, podatciBlagajnika());
		izbornik();

	}

	private void obrisiBlagajnika() {
		if (blagajnici.size() == 0) {
			System.out.println("\n------------------------");
			System.out.println("Nema upisanih blagajnika");
			System.out.println("------------------------");
			izbornik();
		}
		pregledBlagajnika(false);
		while (true) {
			blagajnici.remove(Pomocno.unosBrojRaspon("Kojeg blagajnika zelite obrisati? ", 1, blagajnici.size()) - 1);
			if (Pomocno.nastavankDaNe("Zelite li obrisati jos jednog blagajnika Y/N")) {
				obrisiBlagajnika();
			} else {
				break;
			}
		}
		izbornik();
	}

	private void pregledBlagajnika(boolean a) {
		System.out.println("\n******Blagajnici******");
		int broj = 0;
		for (Blagajnik blagajnik : blagajnici) {
			System.out.println(++broj + ". " + blagajnik);
		}
		System.out.println();
		if (a) {
			izbornik();
		}

	}

	private void unosBlagajnika() {
		while (true) {
			blagajnici.add(podatciBlagajnika());
			if (Pomocno.nastavankDaNe("Zelite li dodati jos jednog blagajnika Y/N")) {
				unosBlagajnika();
			} else {
				break;
			}
		}
		izbornik();

	}

	private Blagajnik podatciBlagajnika() {
		Blagajnik b = new Blagajnik();
		b.setIme(Pomocno.unosTeksta("Ime bagajnika: "));
		b.setPrezime(Pomocno.unosTeksta("Prezime blagajnika: "));
			
		vanjska:
		 while (true) {
			b.setSifra(Pomocno.unosBrojRaspon("Sifra blagajnika: ", 1, Integer.MAX_VALUE));
			for (Blagajnik sifra : blagajnici) {
				if (sifra.getSifra() == b.getSifra()) {
					System.out.println("Postoji blagajnik s tom sifrom!");
					continue vanjska;
				}
			}
			break;
		}

		return b;
	}

	public List<Blagajnik> getBlagajnici() {
		return blagajnici;
	}

	public void setBlagajnici(List<Blagajnik> blagajnici) {
		this.blagajnici = blagajnici;
	}

	public Blagajnici(List<Blagajnik> blagajnici, Start start) {
		super();
		this.blagajnici = blagajnici;
		this.start = start;
		if (Pomocno.DEV) {
			blagajnici.add(new Blagajnik(1, "Filip", "horvat"));
			blagajnici.add(new Blagajnik(2, "Ivan", "Marulic"));
			blagajnici.add(new Blagajnik(3, "ivica", "ivicic"));
		}
	}

	public Blagajnici(Start start) {
		super();
		this.start = start;
		blagajnici = new ArrayList<>();
		if (Pomocno.DEV) {
			blagajnici.add(new Blagajnik(1, "Filip", "horvat"));
			blagajnici.add(new Blagajnik(2, "Ivan", "Marulic"));
			blagajnici.add(new Blagajnik(3, "ivica", "ivicic"));
		}

	}

}
