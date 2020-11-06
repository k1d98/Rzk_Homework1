package rzk;

import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Adresar
 */
@Stateless
@LocalBean
public class Adresar implements AdresarRemote {
	class Korisnik{
		private String adresa;
		private String ime;
		public Korisnik(String ime, String adresa) {
			this.ime = ime;
			this.adresa = adresa;
		}
		public String getAdresa() {
			return adresa;
		}
		public void setAdresa(String adresa) {
			this.adresa = adresa;
		}
		public String getIme() {
			return ime;
		}
		public void setIme(String ime) {
			this.ime = ime;
		}
		
	}
    public Adresar() {
        this.adresar = new ArrayList<Adresar.Korisnik>();
        adresar.add(new Korisnik("keti","dom c"));
        adresar.add(new Korisnik("tijana","zgrada"));
        adresar.add(new Korisnik("macka", "rakovacka"));
    }
    
    private ArrayList<Korisnik> adresar;
	@Override
	public String vratiAdresu(String ime) {
		for(Korisnik k : adresar) {
			if(k.ime.equals(ime)){
				return k.adresa;
			}
		}
		return null;
	}

}
