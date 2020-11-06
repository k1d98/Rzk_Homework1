package rzk;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import model.Event;
import model.EventType;

@Remote
public interface PlannerBeanRemote {
	public String login(String user, String pass);
	public boolean createEvent(String descripion, Date fromDate, Date toDate, int eventTypeID);
	public List<Event> searchEvents(Date date);
	public void destroy();
	public List<EventType> getTypes();
}
