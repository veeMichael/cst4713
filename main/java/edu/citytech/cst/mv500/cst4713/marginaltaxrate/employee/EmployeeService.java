package edu.citytech.cst.mv500.cst4713.marginaltaxrate.employee;


import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Service
//business logic
// service feeds the controller which will point to a webpage where you can display the data
public class EmployeeService {

    private EmployeeRepository repository = new EmployeeRepository();

    private static Predicate<Employee> allEmployees = e -> true;
    private static Predicate<Employee> maleEmployees = e -> e.getGender().equals("M");
    private static Predicate<Employee> femaleEmployees = e -> e.getGender().equals("F");
    private static Predicate<Employee> employeesGT100k = e -> e.getSalary() >100_000;
    private static Predicate<Employee> employeesGT200k = e -> e.getSalary() >200_000;
    private static Predicate<Employee> employeesGT300k = e -> e.getSalary() >300_000;
    private static Predicate<Employee> employeesGT600k = e -> e.getSalary() >600_000;
    private static Predicate<Employee> employeesTriState = e -> e.getState().equals("NY") || e.getState().equals("NJ") || e.getState().equals("CT");

    public List<Employee> getAllEmployees(){
        return repository.findAll(allEmployees);
    }

    public List<Employee> getAllMales(){
        return repository.findAll(maleEmployees);
    }

    public List<Employee> getAllFemales(){
        return repository.findAll(femaleEmployees);
    }

    public List<Employee> getEmployeesGT100k(){
        return repository.findAll(employeesGT100k);
    }

    public List<Employee> getEmployeesGT200k(){
        return repository.findAll(employeesGT200k);
    }
    public List<Employee> getEmployeesGT300k(){
        return repository.findAll(employeesGT300k);
    }
    public List<Employee> getEmployeesGT600k(){
        return repository.findAll(employeesGT600k);
    }

    public List<Employee> getEmployeesTriState(){
        return repository.findAll(employeesTriState);
    }

    public static void main(String[] args) {
        new EmployeeService().getEmployeesGT100k()
                .forEach(System.out::println);

        System.out.println("Vanunu, Michael " + new Date());
    }

}
