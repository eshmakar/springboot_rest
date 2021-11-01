package ru.eshmakar.springboot_rest.dao;

//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.eshmakar.springboot_rest.entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager; //автоматический создается за кулисами

    @Override
    public List<Employee> getAllEmployees() {
        /*//БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ HIBERNATE (import org.hibernate.*)
        Session session = entityManager.unwrap(Session.class);//используем entityManager вместо SessionFactory, чтобы можно было использовать в jpa. не только в hibernate
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> allEmployees = query.getResultList();
       */

        //БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ JPA (import javax.persistence.*)
        Query query = entityManager.createQuery("from Employee");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;

    }

    @Override
    public void saveEmployee(Employee employee) {
        /*//БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ HIBERNATE
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);//сохраняем или обновляем объект работника в базу
        */

        //БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ JPA
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());//устанавливаем id на то, что получили при сохранении
    }

    @Override
    public Employee getEmployee(int id) {
        /*//БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ HIBERNATE
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);//получаем работника из базы по id*/

        //БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ JPA
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        /*//БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ HIBERNATE
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
        */

        //БИЗНЕС-ЛОГИКА С ПОМОЩЬЮ JPA
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
