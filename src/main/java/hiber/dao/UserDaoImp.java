package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(String model, Integer series) {
      String hql = "FROM Car where model = :paramModel and series = :paramSeries";
      Query query = sessionFactory.getCurrentSession().createQuery(hql);
      query.setParameter("paramModel", model);
      query.setParameter("paramSeries", series);
      List<Car> cars = query.getResultList();
      if (cars.isEmpty()) {
         return null;
      }

      return cars.get(0).getUser();
   }
}
