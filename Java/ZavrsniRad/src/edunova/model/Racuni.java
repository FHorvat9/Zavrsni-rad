package edunova.model;

import java.util.Date;

public class Racuni extends Blagajnik {

	private double zaPlatiti;
	private Date datumIzdatka;
	private int brRacuna;

	public double getZaPlatiti() {
		return zaPlatiti;
	}

	public void setZaPlatiti(double zaPlatiti) {
		this.zaPlatiti = zaPlatiti;
	}

	public Date getDatumIzdatka() {
		return datumIzdatka;
	}

	public void setDatumIzdatka(Date datumIzdatka) {
		this.datumIzdatka = datumIzdatka;
	}

	public int getBrRacuna() {
		return brRacuna;
	}

	public void setBrRacuna(int brRacuna) {
		this.brRacuna = brRacuna;
	}

	public Racuni(int sifra, String ime, double zaPlatiti, Date datumIzdatka, int brRacuna) {
		super(sifra, ime);
		this.zaPlatiti = zaPlatiti;
		this.datumIzdatka = datumIzdatka;
		this.brRacuna = brRacuna;
	}

	public Racuni() {
		super();
	}

}
