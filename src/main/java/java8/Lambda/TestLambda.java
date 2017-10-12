package java8.Lambda;

import org.junit.Test;

import java.util.*;

public class TestLambda {
    //利用匿名内部类实现
    @Test
    public void test1() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet treeSet = new TreeSet<>(comparator);
    }

    //    利用Lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet treeSet = new TreeSet(comparator);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 5555.55),
            new Employee("李四", 28, 6666.66),
            new Employee("王五", 38, 3333.33),
            new Employee("赵六", 48, 7777.77),
            new Employee("田七", 58, 8888.88)
    );


    //    需求：查询年龄大与35的
    public List<Employee> filterEmployeesAge(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list) {
            if (employee.getAge() >= 35)
                emps.add(employee);
        }

        return emps;
    }

    @Test
    public void testFilterEmployeesAge() {
        List<Employee> emps = filterEmployeesAge(employees);
        for (Employee employee : emps) {
            System.out.println(employee);
        }
    }

    //    需求：查询工资大与5000的
    public List<Employee> filterEmployeeSalary(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();

        for (Employee employee : list) {
            if (employee.getSalary() >= 5000)
                emps.add(employee);
        }

        return emps;
    }

    @Test
    public void testFilterEmployeeSalary() {
        List<Employee> emps = filterEmployeeSalary(employees);

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    //    优化方式一：策略设计模式：不同策略不同的实现
    public List<Employee> filterEmployees(List<Employee> list, MyPredicate<Employee> myPredicate) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (myPredicate.judge(employee))
                emps.add(employee);
        }

        return emps;
    }

    @Test
    public void testFilterEmployees() {
        List<Employee> list1 = filterEmployees(employees, new FilterEmployeesByAge());
        for (Employee employee : list1) {
            System.out.println(employee);
        }
        System.out.println("------------------------------");

        List<Employee> list2 = filterEmployees(employees, new FilterEmployeesBySalary());
        for (Employee employee : list2) {
            System.out.println(employee);
        }
    }

    //    优化方式二：匿名内部类（实现接口），不需要利用继承
    @Test
    public void testFilterEmployeesByAnony() {
        List<Employee> emps = filterEmployees(employees, new MyPredicate<Employee>() {
            @Override
            public boolean judge(Employee employee) {
                return employee.getAge() >= 35;
            }
        });

        for (Employee emp : emps) {
            System.out.println(emp);
        }
    }

    //    优化方式三：Lambda表达式+list方法
    @Test
    public void testLambda() {
        List<Employee> emps = filterEmployees(employees, (e) -> e.getAge() >= 35);
        emps.forEach(System.out::println);
    }
//    优化方式四：流处理方式  Stream API，其余接口什么都不用
    @Test
    public void testStream(){
        employees.stream()
                .filter((e)-> e.getAge() > 35)
                .forEach(System.out::println);

        System.out.println("============================================");

        employees.stream()
                .filter((e)->e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("============================================");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
