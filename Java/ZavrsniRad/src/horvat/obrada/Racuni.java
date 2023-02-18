package horvat.obrada;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.List;


import horvat.model.Racun;
import horvat.model.StavkaRacuna;
import horvat.terminal.Pomocno;
import horvat.terminal.Start;

public class Racuni {

	private List<Racun> racuni;
	private Start start;
	private Blagajnici blagajnici;
	private Proizvodi proizvodi;

	public void izbornik() {
		System.out.println("\n******Racuni izbornik******\n");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Unesi novoi racun");
		System.out.println("2. Pogledaj sve racune");
		System.out.println("3. Izmjeni racun");
		System.out.println("4. Obrisi racun");
		System.out.println("5. Povratak na glavni izbornik\n");
		odabirRacuni();

	}

	private void odabirRacuni() {
		switch (Pomocno.unosBrojRaspon("Unesite zeljeni odabir: ", 1, 5)) {
		case 1:
			unosRacun();
			break;
		case 2:
			provjeraPrazno(racuni);
			pregledRacuna(false);
			break;
		case 3:
			provjeraPrazno(racuni);
			izmjeniRacun();
			break;
		case 4:
			provjeraPrazno(racuni);
			obrisiRacun();
			break;
		case 5:
			start.glavniIzbornik();
			break;

		}
	}

	private void izmjeniRacun() {
		pregledRacuna(true);
		int unos = (Pomocno.unosBrojRaspon("\nKoji racun zelite izmjeniti? ", 1, racuni.size()) - 1);
		racuni.remove(unos);
		racuni.add(unos, podatciRacuna());
		izbornik();

	}

	private void obrisiRacun() {
		pregledRacuna(true);
		while (true) {
			racuni.remove(Pomocno.unosBrojRaspon("\nKoji racun zelite obrisati? ", 1, racuni.size()) - 1);
			if (Pomocno.nastavankDaNe("Zelite li obrisati jos jedan racun? Y/N")) {
				provjeraPrazno(racuni);
				obrisiRacun();
			}
			break;
		}
		izbornik();

	}

	private void pregledRacuna(boolean b) {
		for (Racun racun : racuni) {
			System.out.println(racun.toString());
		}
		if(b) {
			return;
		}
		if (!Pomocno.nastavankDaNe("Zelite li pogledati stavke od nekog racuna? Y/N")) {
				izbornik();
			
		} else {
			int unos = Pomocno.unosBrojRaspon("Koji racun zelite pogledati? ", 1, racuni.size()) - 1;
			System.out.println(racuni.get(unos).toString());
			for (StavkaRacuna stavkaRacuna : racuni.get(unos).getStavkeRacuna()) {
				System.out.println(stavkaRacuna.toString());
			}
			izbornik();

		}

	}

	private void provjeraPrazno(List<Racun> racuni) {
		if (racuni.size() == 0) {
			System.out.println("\n------------------------");
			System.out.println("Nema upisanih racuna");
			System.out.println("------------------------");
			izbornik();
		}

	}

	private void unosRacun() {
		while (true) {
			racuni.add(podatciRacuna());

			if (Pomocno.nastavankDaNe("Zelite li dodati jos jedan racun? Y/N")) {
				unosRacun();
			} else {
				break;
			}
		}
		izbornik();

	}

	private Racun podatciRacuna() {

		Racun r = new Racun();

		r.setBrojRacuna(Pomocno.unosBrojRaspon("Unesi broj racuna ", 0, Integer.MAX_VALUE));

		blagajnici.pregledBlagajnika(false);
		r.setBlagajnik(blagajnici.getBlagajnici().get(
				Pomocno.unosBrojRaspon("Koji blagajnik je ispisao racun? ", 1, blagajnici.getBlagajnici().size()) - 1));

		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		r.setDatum(gc.getTime());

		r.setStavkeRacuna(noveStavke(r.getBrojRacuna()));

		BigDecimal zaPlatit = BigDecimal.valueOf(0);
		for (StavkaRacuna stavka : r.getStavkeRacuna()) {
			zaPlatit = zaPlatit.add(stavka.getUkupnaCijenaProizvoda());
		}
		r.setZaPlatiti(zaPlatit);

		return r;
	}

	private List<StavkaRacuna> noveStavke(int brracuna) {

		List<StavkaRacuna> stavkeRacuna = new ArrayList<>();
		List<Integer> sifre = new ArrayList<>();
		
		
		while (true) {
			
			
			StavkaRacuna stavka = new StavkaRacuna();
			vanjska: while (true) {
				int sifrastavke = Pomocno.unosBrojRaspon("Upisi sifru stavke ", 0, Integer.MAX_VALUE);
				for (Integer integer : sifre) {
					if (sifrastavke == integer) {
						System.out.println("Postoji stavka s tom sifrom");
						continue vanjska;
					}
				}
				sifre.add(sifrastavke);
				stavka.setSifra(sifrastavke);
				for (Racun racun : racuni) {
					for (StavkaRacuna sifra : racun.getStavkeRacuna()) {
						if (stavka.getSifra() == sifra.getSifra()) {
							System.out.println("Postoji stavka s tom sifrom");
							continue vanjska;
						}
					}
				}
				break;
			}

			proizvodi.pregledProizvoda(false);
			int unos = Pomocno.unosBrojRaspon("Koji proizvod ", 1, proizvodi.getProizvodi().size()) - 1;
			stavka.setProizvod(proizvodi.getProizvodi().get(unos));
			stavka.setCijenaProizvoda(proizvodi.getProizvodi().get(unos).getCijena());
			stavka.setKolicina(Pomocno.unosBrojRaspon("Kolicina ", 0, 20));
			stavka.setUkupnaCijenaProizvoda(stavka.getCijenaProizvoda().multiply(BigDecimal.valueOf(stavka.getKolicina())));
			stavka.setBrojRacuna(brracuna);
			stavkeRacuna.add(stavka);

			if (Pomocno.nastavankDaNe("Unesi jos stavki racuna? Y/N")) {
				
				continue;
			} else {
				sifre = new ArrayList<>();
				return stavkeRacuna;
			}
		}
	}

	public Racuni(Start start, Blagajnici blagajnici, Proizvodi proizvodi, StavkaRacuna stavkeRacuna) {
		super();
		this.start = start;
		this.blagajnici = blagajnici;
		this.proizvodi = proizvodi;

		racuni = new ArrayList<>();
	}

	public Racuni(List<Racun> racuni, Start start, Blagajnici blagajnici, Proizvodi proizvodi,
			StavkaRacuna stavkeRacuna) {
		super();
		this.racuni = racuni;
		this.start = start;
		this.blagajnici = blagajnici;
		this.proizvodi = proizvodi;

	}

	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}

}
