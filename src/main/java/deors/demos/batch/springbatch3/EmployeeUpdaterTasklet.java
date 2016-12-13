package deors.demos.batch.springbatch3;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

/**
 * Batch tasklet to write Employee information to the datastore.
 *
 * @author jorge.hidalgo
 * @version 1.0
 */
public class EmployeeUpdaterTasklet
    implements ItemWriter<Employee> {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeUpdaterTasklet.class);

    /**
     * The Employee DAO.
     */
    private EmployeeDao employeeDao;

    /**
     * Tasklet constructor.
     */
    public EmployeeUpdaterTasklet() {
        super();
    }

    /**
     * Sets the Employee DAO instance.
     *
     * @param employeeDao the DAO instance
     */
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    /**
     * Writes the given list of employees either inserting or
     * updating the record to the datastore.
     *
     * @param list the list of employees
     * @throws EmployeeException an exception writing the list to the datastore
     */
    public void write(List<? extends Employee> list) throws EmployeeException {
        for (Employee employee : list) {
            if (employeeDao.exist(employee)) {
                LOG.info("updating " + employee);
                employeeDao.update(employee);
            } else {
                LOG.info("adding " + employee);
                employeeDao.insert(employee);
            }
        }
    }
}
