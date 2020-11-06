package rzk;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.jboss.resteasy.util.DateUtil;

import model.Event;
import model.EventType;
import model.User;

/**
 * Session Bean implementation class PlannerBean
 */
@Stateful
@LocalBean
public class PlannerBean implements PlannerBeanRemote {

	@PersistenceContext
	EntityManager em;
	@EJB
	EventTypeBeanLocal etb;
	
	private int userID;
	
    /**
     * Default constructor. 
     */
    public PlannerBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String login(String user, String pass) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :user AND u.password LIKE :pass");
		q.setParameter("user", user);
		q.setParameter("pass", pass);
		List<User> users = q.getResultList();
		System.out.println(users.size());
		try {
			userID = users.get(0).getId();
			return  users.get(0).getEmail();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "";
	}
	private User getUser() {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.id LIKE :user");
		q.setParameter("user", userID);
		return (User) q.getResultList().get(0);
	}

	@Override
	public boolean createEvent(String description, Date fromDate, Date toDate, int eventTypeID) {
		Event e = new Event();
		e.setDescription(description);
		e.setFromDate(fromDate);
		e.setToDate(toDate);
		User u = getUser();
		
		EventType et = etb.getTypes().get(eventTypeID);
		
		e.setEventType(et);
		e.setUser(u);
		u.addEvent(e);
		
		try {
			em.persist(e);
			em.persist(u);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}

	@Override
	public List<Event> searchEvents(Date date) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 1);
		Date morning=calendar.getTime();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		Date night=calendar.getTime();
		Query q = em.createQuery("SELECT e FROM Event e WHERE e.user.id LIKE :user AND e.fromDate BETWEEN :dateA AND :dateB");
		q.setParameter("dateA", morning);
		q.setParameter("dateB", night);
		q.setParameter("user", userID);
		return q.getResultList();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EventType> getTypes() {		
		return etb.getTypes();
	}

}
