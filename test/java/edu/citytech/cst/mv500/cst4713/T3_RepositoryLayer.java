package edu.citytech.cst.mv500.cst4713;

import edu.citytech.cst.helper.dao.IQuery;
import edu.citytech.cst.mv500.cst4713.marginaltaxrate.employee.Employee;
import edu.citytech.cst.mv500.cst4713.marginaltaxrate.employee.EmployeeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Repository Layer")
public class T3_RepositoryLayer {

    IQuery<Employee> query = new EmployeeRepository();

    @Test
    @DisplayName("Row Count")
    void t1(){


        List<Employee> list = query.findAll(e -> true);
        var actual = list.size();
        var expected = 400;
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Employees from CT")
    void t2(){

        List<Employee> list = query.findAll(e -> e.getState().equals("CT"));
        var actual = list.size();
        var expected = 44;
        list.forEach(System.out::println);
        System.out.println("Michael, Vanunu " + new Date());
        assertEquals(expected, actual);

    }

}
