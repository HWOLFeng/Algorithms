package java8.Lambda;

public class FilterEmployeesBySalary implements MyPredicate<Employee>{
    @Override
    public boolean judge(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
