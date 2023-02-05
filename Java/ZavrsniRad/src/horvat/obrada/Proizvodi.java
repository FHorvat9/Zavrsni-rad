package horvat.obrada;

import java.util.ArrayList;
import java.util.List;

import horvat.model.Proizvod;
import horvat.terminal.Start;

public class Proizvodi {
	
private ArrayList<Proizvod> proizvodi;
private Start start;
	
public void izbornik() {
	start.glavniIzbornik();
	
}




public ArrayList<Proizvod> getProizvodi() {
	return proizvodi;
}

public void setProizvodi(ArrayList<Proizvod> proizvodi) {
	this.proizvodi = proizvodi;
}

public Proizvodi(Start start) {
	super();
	this.start = start;
	new ArrayList<Proizvod>();
}

public Proizvodi(ArrayList<Proizvod> proizvodi, Start start) {
	super();
	this.proizvodi = proizvodi;
	this.start = start;
}


}



