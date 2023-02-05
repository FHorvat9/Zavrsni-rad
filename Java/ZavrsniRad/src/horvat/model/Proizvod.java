package horvat.model;

import java.math.BigDecimal;

public class Proizvod extends Entitet {

	private String imeProizvoda;
	private BigDecimal cijena;

	public String getImeProizvoda() {
		return imeProizvoda;
	}

	public void setImeProizvoda(String imeProizvoda) {
		this.imeProizvoda = imeProizvoda;
	}

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}

	public Proizvod() {
		super();
	}

	public Proizvod(int sifra, String imeProizvoda, BigDecimal cijena) {
		super(sifra);
		this.imeProizvoda = imeProizvoda;
		this.cijena = cijena;
	}
	

}
