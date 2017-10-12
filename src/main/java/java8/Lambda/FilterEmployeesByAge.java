package java8.Lambda;

public class FilterEmployeesByAge implements MyPredicate<Employee>{
    @Override
    public boolean judge(Employee employee) {
        return employee.getAge() >= 35;
    }
}
