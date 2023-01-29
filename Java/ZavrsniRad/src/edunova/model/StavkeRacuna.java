package edunova.model;

public class StavkeRacuna extends Proizvodi {

	private int brRacuna;
	private int kolicina;
	private double ukupnaCijena;

	public int getBrRacuna() {
		return brRacuna;
	}

	public void setBrRacuna(int brRacuna) {
		this.brRacuna = brRacuna;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getUkupnaCijena() {
		return ukupnaCijena;
	}

	public void setUkupnaCijena(double ukupnaCijena) {
		this.ukupnaCijena = ukupnaCijena;
	}

	public StavkeRacuna(int sifra, String ime, int cijena, int brRacuna, int kolicina, double ukupnaCijena) {
		super(sifra, ime, cijena);
		this.brRacuna = brRacuna;
		this.kolicina = kolicina;
		this.ukupnaCijena = ukupnaCijena;
	}

	public StavkeRacuna() {
		super();
	}

}
