package deors.demos.batch.springbatch2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

public class EmployeeDaoTest {

    @Test
    public void testSelectAll() {

        assertEquals(EmployeeDao.EMPLOYEES.values(), new EmployeeDao().selectAll());
    }

    @Test
    public void addAndDelete() throws EmployeeException {

    	Collection<Employee> initData = Collections.unmodifiableCollection(EmployeeDao.EMPLOYEES.values());
    	int initSize = initData.size();

    	new EmployeeDao().insert(new Employee("T", "T", "T", "T", "T", "T"));
    	new EmployeeDao().delete(new Employee("T", "T", "T", "T", "T", "T"));

    	Collection<Employee> finalData = EmployeeDao.EMPLOYEES.values();
    	int finalSize = finalData.size();

    	assertEquals(initSize, finalSize);
    	for (Employee e : finalData) {
    		assertTrue(initData.contains(e));
    	}
    }

    @Test(expected = EmployeeException.class)
    public void testUnableToInsert() throws EmployeeException {

    	new EmployeeDao().insert(new Employee("1", "Jorge", "Hidalgo", "PTA",
            "952044000", "jorge.hidalgo@goodmail.com"));
    }

    @Test(expected = EmployeeException.class)
    public void testUnableToDelete() throws EmployeeException {

    	new EmployeeDao().delete(new Employee("x", "", "", "", "", ""));
    }

    @Test(expected = EmployeeException.class)
    public void testUnableToUpdate() throws EmployeeException {

    	new EmployeeDao().update(new Employee("x", "", "", "", "", ""));
    }
}
