package thinking_java.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet stus = new TreeSet();
//        TreeSet stus = new TreeSet(new MyCompare());

        stus.add(new Student("lisi01",12));
        stus.add(new Student("lisi02",10));
        stus.add(new Student("lisi03",11));
        stus.add(new Student("lisi04",8));

        Iterator iterator = stus.iterator();

        while (iterator.hasNext()){
            Student s = (Student) iterator.next();
            System.out.println(s.getName()+"...."+s.getAge());
        }
    }
}

class Student implements Comparable{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student))
            throw new RuntimeException("不是学生");
        Student student = (Student) o;

        System.out.println(this.age+" .compareTo. "+student.age);

        if (this.age > student.age)
            return 1;
        if (this.age == student.age )
        {
//            排序次要条件
            return this.name.compareTo(student.name);
        }
        else return -1;
    }
}

//自定义比较器，覆盖Comparator的compare方法

class MyCompare implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
/*
lisi01 .compareTo. lisi01
lisi02 .compareTo. lisi01
lisi03 .compareTo. lisi01
lisi03 .compareTo. lisi02
lisi04 .compareTo. lisi03
lisi04 .compareTo. lisi02
lisi01....10
lisi03....11
lisi02....12
lisi04....13
 */