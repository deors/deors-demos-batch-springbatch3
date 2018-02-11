package deors.demos.batch.springbatch3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import deors.demos.batch.springbatch3.Employee;
import deors.demos.batch.springbatch3.EmployeeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:spring-batch-test.xml"
})
public class EmployeeTest {

    @Autowired
    private SimpleJobLauncher launcher;

    @Autowired
    private Job job;

    @Test
    public void testJob() throws Exception {
        try {
        System.out.println("this is the initial employee list " + EmployeeDao.EMPLOYEES);

        JobParametersBuilder builder = new JobParametersBuilder();
        JobParameters parameters = builder.toJobParameters();
        JobExecution execution = launcher.run(job, parameters);
        BatchStatus status = execution.getStatus();

        for (Throwable t : execution.getAllFailureExceptions()) {
            t.printStackTrace();
        }

        assertEquals(BatchStatus.COMPLETED, status);

        System.out.println("this is the final employee list " + EmployeeDao.EMPLOYEES);

        assertEquals(3, EmployeeDao.EMPLOYEES.size());

        assertEquals(new Employee("1", "Jorge", "Hidalgo", "PTA", "952044000", "jorge.hidalgo@goodmail.com"), EmployeeDao.EMPLOYEES.get("1"));
        assertEquals(new Employee("2", "Antonio", "Hidalgo", "Unknown", "958404080", "antonio.hidalgo@goodmail.com"), EmployeeDao.EMPLOYEES.get("2"));
        assertEquals(new Employee("4", "Angela", "Rodriguez", "PTA Malaga", "676909080", "angie90@gmail.com"), EmployeeDao.EMPLOYEES.get("4"));
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
