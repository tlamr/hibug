package hibug;

import org.hibernate.Session;
import org.hibernate.engine.spi.SelfDirtinessTracker;

import java.util.List;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Hentity hentity = new Hentity();
		HotherEntity hotherEntity = new HotherEntity();
		hentity.setLineItems(List.of(hotherEntity));
		hentity.setNextRevUNs(List.of("something"));
		session.saveOrUpdate(hentity);
		session.evict(hentity);
		session.getTransaction().commit();

		session.beginTransaction();
		hentity.bumpNumber();
		session.saveOrUpdate(hentity);
		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}
}
