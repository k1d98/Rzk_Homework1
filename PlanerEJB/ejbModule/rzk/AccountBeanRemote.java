package rzk;

import javax.ejb.Remote;

@Remote
public interface AccountBeanRemote {
	public boolean createAccount(String email, String passoword, String firstNam, String lastName);
}
