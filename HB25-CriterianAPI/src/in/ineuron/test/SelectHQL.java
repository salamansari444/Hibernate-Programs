package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class SelectHQL {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			Criteria criteria = session.createCriteria(Product.class);
			
			
			ProjectionList list = Projections.projectionList();
			list.add(Projections.property("pname"));
			list.add(Projections.property("qty"));

			criteria.setProjection(list);//HQL=> SELECT pname,qty FROM in.ineuron.model.Product


			Criterion cond1 = Restrictions.ge("price", 1500);
			Criterion cond2 = Restrictions.le("price", 3000);

			criteria.add(cond1);
			criteria.add(cond2);
			Order order = Order.asc("pname");
			criteria.addOrder(order);
			System.out.println("PNAME\tQTY");

			List<Object[]> products = criteria.list();
			
			products.forEach(row -> {
				for (Object obj : row) {
					System.out.print(obj + "\t");
				}
				System.out.println();
			});

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}
