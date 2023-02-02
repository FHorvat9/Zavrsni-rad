package horvat.model;

import java.math.BigDecimal;

public class Proizvodi extends Entitet {

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

	public Proizvodi() {
		super();
	}

	public Proizvodi(int sifra, String imeProizvoda, BigDecimal cijena) {
		super(sifra);
		this.imeProizvoda = imeProizvoda;
		this.cijena = cijena;
	}
	

}
