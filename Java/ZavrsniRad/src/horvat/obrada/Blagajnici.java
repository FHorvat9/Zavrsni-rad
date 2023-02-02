package horvat.obrada;

import java.util.ArrayList;
import java.util.List;

import horvat.model.Blagajnik;
import horvat.terminal.Pomocno;
import horvat.terminal.Start;

public class Blagajnici {
	
	private	List<Blagajnik> blagajnici;
	private Start start;
	
	public void izbornik() {
		System.out.println("******Blagajnici izbornik******\n");
		System.out.println("Dostupne opcije: ");
		System.out.println("1. Unesi novog blagajnika");
		System.out.println("2. Pogledaj sve blagajnike");
		System.out.println("3. Izmjeni blagajnika");
		System.out.println("4. Obrisi blagajnika");
		System.out.println("5. Povratak na glavni izbornik\n");
		odabirBlaganici();
	}
	
	

	private void odabirBlaganici() {
		switch(Pomocno.unosBrojRaspon("Unesite zeljeni odabir: ", 1, 5)) {
		case 1:
			unosBlagajnika();
			break;
		case 2:
			pregledBlagajnika(true);
			break;
			
		case 4:
			obrisiBlagajnika();
			break;
		case 5:
			start.glavniIzbornik();
			
		}
		
	}

	private void obrisiBlagajnika() {
		pregledBlagajnika(false);
		blagajnici.remove(Pomocno.unosBrojRaspon("Kojeg blagajnika zelite obrisati? ", 1,blagajnici.size())-1);
//		napravi da mozemo vise puta brisat
		izbornik();
	}



	private void pregledBlagajnika(boolean a) {
		int broj=0;
		for (Blagajnik blagajnik : blagajnici) {
			System.out.println(++broj+". "+blagajnik);
		}
		if (a) {
			izbornik();
		}
		
		
	}



	private void unosBlagajnika() {
		blagajnici.add(podatciBlagajnika());
//		napravi da vise puta moze unjet
		izbornik();
		
	}

	private Blagajnik podatciBlagajnika() {
		Blagajnik b = new Blagajnik();
		b.setIme(Pomocno.unosTeksta("Ime bagajnika: "));
		b.setPrezime(Pomocno.unosTeksta("Prezime blagajnika: "));
		b.setSifra(Pomocno.unosBrojRaspon("Sifra blagajnika: ", 1, Integer.MAX_VALUE));
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
	}

	public Blagajnici(Start start) {
		super();
		this.start = start;
		blagajnici = new ArrayList<>();
	}


}
