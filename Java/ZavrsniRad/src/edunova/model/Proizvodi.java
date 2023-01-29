package edunova.model;

public class Proizvodi extends Entitet {

	private String ime;
	private double cijena;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public double getCijena() {
		return cijena;
	}

	public void setCijena(double cijena) {
		this.cijena = cijena;
	}

	public Proizvodi() {
		super();
	}

	public Proizvodi(int sifra, String ime, double cijena) {
		super(sifra);
		this.ime = ime;
		this.cijena = cijena;
	}

}
