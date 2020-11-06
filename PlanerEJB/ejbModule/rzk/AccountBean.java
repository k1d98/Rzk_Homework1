package rzk;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.User;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@LocalBean
public class AccountBean implements AccountBeanRemote {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public AccountBean() {
        // TODO Auto-generated constructor stub
    }
    public boolean createAccount(String email, String password, String firstNam, String lastName) {
    	Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :user");
		q.setParameter("user", email);
		List<User> users = q.getResultList();
		System.out.println(users.size());
		if(users.size() == 0) {
			//nemamo takvog korisnika, napravi novog
			User u = new User();
			u.setEmail(email);
			u.setPassword(password);
			u.setFirstName(firstNam);
			u.setLastName(lastName);
			
			em.persist(u);

			
			return true;
			
		}
		return false;
    }

}
