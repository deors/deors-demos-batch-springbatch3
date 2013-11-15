package deors.demos.batch.springbatch2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The Employee DAO. Employees are stored in-memory on a map
 * indexed by employee id.
 *
 * @author jorge.hidalgo
 * @version 1.0
 */
public class EmployeeDao {

    /**
     * Employee data store - this pattern is not to be used in real apps
     * but is useful to reduce complexity from the demo code.
     */
    public static final Map<String, Employee> EMPLOYEES =
        new HashMap<String, Employee>();

    /**
     * Initializes initial data.
     */
    static {
        EMPLOYEES.put("1", new Employee("1", "Jorge", "Hidalgo", "PTA",
            "952044000", "jorge.hidalgo@goodmail.com"));
        EMPLOYEES.put("2", new Employee("2", "Antonio", "Hidalgo", "Malaga",
            "951020000", "antonio.hidalgo@goodmail.com"));
    }

    /**
     * DAO constructor.
     */
    public EmployeeDao() {
        super();
    }

    /**
     * Returns all employees in the datastore.
     *
     * @return a collection with all employees
     */
    public Collection<Employee> selectAll() {
        // in real code this will be a query to the database
        return EmployeeDao.EMPLOYEES.values();
    }

    /**
     * Returns whether the given employee exists in the datastore.
     *
     * @param employee the employee to be searched for
     * @return whether the given employee exists in the datastore
     */
    public boolean exist(Employee employee) {
        return EmployeeDao.EMPLOYEES.get(employee.getId()) != null;
    }

    /**
     * Adds a new employee to the datastore.
     *
     * @param employee the employee to be added
     * @throws EmployeeException the employee already exists in the datastore
     */
    public void insert(Employee employee) throws EmployeeException {
        Employee existing = EmployeeDao.EMPLOYEES.get(employee.getId());
        if (existing == null) {
            EmployeeDao.EMPLOYEES.put(employee.getId(), employee);
        } else {
            throw new EmployeeException("unable to add - already exists employee: " + existing.getId());
        }
    }

    /**
     * Deletes an existing employee from the datastore.
     *
     * @param employee the employee to be deleted
     * @throws EmployeeException the employee does not exist in the datastore
     */
    public void delete(Employee employee) throws EmployeeException {
        Employee existing = EmployeeDao.EMPLOYEES.get(employee.getId());
        if (existing == null) {
            throw new EmployeeException("unable to delete - employee does not exist: " + employee.getId());
        } else {
            EmployeeDao.EMPLOYEES.remove(employee.getId());
        }
    }

    /**
     * Updates an existing employee in the datastore.
     *
     * @param employee the employee to be updated
     * @throws EmployeeException the employee does not exist in the datastore
     */
    public void update(Employee employee) throws EmployeeException {
        Employee existing = EmployeeDao.EMPLOYEES.get(employee.getId());
        if (existing == null) {
            throw new EmployeeException("unable to update - employee does not exist: " + employee.getId());
        } else {
            EmployeeDao.EMPLOYEES.put(employee.getId(), employee);
        }
    }
}
