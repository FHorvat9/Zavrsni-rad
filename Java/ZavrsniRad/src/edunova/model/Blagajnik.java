package edunova.model;

public class Blagajnik extends Entitet {

	private String Ime;

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public Blagajnik(int sifra, String ime) {
		super(sifra);
		Ime = ime;
	}

	public Blagajnik() {
		super();
	}

}
