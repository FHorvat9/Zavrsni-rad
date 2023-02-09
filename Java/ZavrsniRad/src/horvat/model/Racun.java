package horvat.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Racun extends Entitet {
	
	private Blagajnik blagajnik;
	private int brojRacuna;
	private Date datum;
	private List<StavkaRacuna> stavkeRacuna;
	private BigDecimal zaPlatiti;
	
	
	@Override
	public String toString() {
		SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy. - HH:mm:ss");
		return brojRacuna+" " +blagajnik+" "+df.format(datum)+" "+zaPlatiti;
	}


	public Racun(int sifra, Blagajnik blagajnik, int brojRacuna, Date datum, List<StavkaRacuna> stavkeRacuna,
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
		stavkeRacuna = new ArrayList<>();
	}


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


	public List<StavkaRacuna> getStavkeRacuna() {
		return stavkeRacuna;
	}


	public void setStavkeRacuna(List<StavkaRacuna> stavkeRacuna) {
		this.stavkeRacuna = stavkeRacuna;
	}


	public BigDecimal getZaPlatiti() {
		return zaPlatiti;
	}


	public void setZaPlatiti(BigDecimal zaPlatiti) {
		this.zaPlatiti = zaPlatiti;
	}
	
	
	
	
	
	
	
	
	
	
	

}
