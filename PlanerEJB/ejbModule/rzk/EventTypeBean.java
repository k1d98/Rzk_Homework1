package rzk;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.EventType;

/**
 * Session Bean implementation class EventTypeBean
 */
@Singleton
@LocalBean
public class EventTypeBean implements EventTypeBeanLocal {
	private List<EventType> types;
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public EventTypeBean() {
        // TODO Auto-generated constructor stub
    }
    

	@Override
	public List<EventType> getTypes() {
		return types;
	}
	@PostConstruct
	public void fillTypes() {
		Query q = em.createQuery("SELECT e FROM EventType e");
		types= q.getResultList();
		
	}

}
