package horvat.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Racun extends Entitet {
	
	private Blagajnik blagajnik;
	private int brojRacuna;
	private Date datum;
	private ArrayList<StavkaRacuna> stavkeRacuna;
	private BigDecimal zaPlatiti;
	
	public Blagajnik getBlagajnik() {
		return blagajnik;
	}
	public void setBlagajnik(Blagajnik blagajnik) {
		this.blagajnik = blagajnik;
	}
	public int getBrojRacuna() {
		return brojRacuna;
	}
	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public ArrayList<StavkaRacuna> getStavkeRacuna() {
		return stavkeRacuna;
	}
	public void setStavkeRacuna(ArrayList<StavkaRacuna> stavkeRacuna) {
		this.stavkeRacuna = stavkeRacuna;
	}
	public BigDecimal getZaPlatiti() {
		return zaPlatiti;
	}
	public void setZaPlatiti(BigDecimal zaPlatiti) {
		this.zaPlatiti = zaPlatiti;
	}
	public Racun(int sifra, Blagajnik blagajnik, int brojRacuna, Date datum, ArrayList<StavkaRacuna> stavkeRacuna,
			BigDecimal zaPlatiti) {
		super(sifra);
		this.blagajnik = blagajnik;
		this.brojRacuna = brojRacuna;
		this.datum = datum;
		this.stavkeRacuna = stavkeRacuna;
		this.zaPlatiti = zaPlatiti;
	}
	public Racun() {
		super();

	}
	
	
	
	
	
	
	
	
	

}
