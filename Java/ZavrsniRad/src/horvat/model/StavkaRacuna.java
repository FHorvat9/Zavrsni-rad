package horvat.model;

import java.math.BigDecimal;

public class StavkaRacuna extends Entitet{
	
	private int brRacuna;
	private Proizvodi proizvod;
	private int kolicina;
	private BigDecimal cijenaProizvoda;
	private BigDecimal ukupnaCijenaProizvoda;
	
	public int getBrRacuna() {
		return brRacuna;
	}
	public void setBrRacuna(int brRacuna) {
		this.brRacuna = brRacuna;
	}
	public Proizvodi getProizvod() {
		return proizvod;
	}
	public void setProizvod(Proizvodi proizvod) {
		this.proizvod = proizvod;
	}
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public BigDecimal getCijenaProizvoda() {
		return cijenaProizvoda;
	}
	public void setCijenaProizvoda(BigDecimal cijenaProizvoda) {
		this.cijenaProizvoda = cijenaProizvoda;
	}
	public BigDecimal getUkupnaCijenaProizvoda() {
		return ukupnaCijenaProizvoda;
	}
	public void setUkupnaCijenaProizvoda(BigDecimal ukupnaCijenaProizvoda) {
		this.ukupnaCijenaProizvoda = ukupnaCijenaProizvoda;
	}
	public StavkaRacuna(int sifra, int brRacuna, Proizvodi proizvod, int kolicina, BigDecimal cijenaProizvoda,
			BigDecimal ukupnaCijenaProizvoda) {
		super(sifra);
		this.brRacuna = brRacuna;
		this.proizvod = proizvod;
		this.kolicina = kolicina;
		this.cijenaProizvoda = cijenaProizvoda;
		this.ukupnaCijenaProizvoda = ukupnaCijenaProizvoda;
	}
	public StavkaRacuna() {
		super();
	}
	
	

}
