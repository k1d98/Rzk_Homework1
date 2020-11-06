package rzk;

import javax.ejb.Remote;

@Remote
public interface AdresarRemote {
	public String vratiAdresu(String ime);
}
