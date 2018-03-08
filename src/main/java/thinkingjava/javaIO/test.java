package thinkingjava.javaIO;

import java.util.concurrent.atomic.AtomicInteger;

public class test {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        Person person = new Person(atomicInteger, 100);
        System.out.println(person.changeAtomicInteger() instanceof AtomicInteger);
        if (person.getAtomicInteger() instanceof AtomicInteger)
            System.out.println("true");
    }
}

class Person {
    private final AtomicInteger atomicInteger;

    private final int m;

    Person(AtomicInteger atomicInteger, int m) {
        this.atomicInteger = atomicInteger;
        this.m = m;
    }


    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public AtomicInteger changeAtomicInteger() {

//        System.out.println(this.atomicInteger);

        this.atomicInteger.addAndGet(-1);

//        System.out.println(this.atomicInteger);
//
//        System.out.println("...");
//        System.out.println("...");
//        System.out.println("...");
//
//        System.out.println(this.atomicInteger.addAndGet(-2) instanceof AtomicInteger);

        return this.atomicInteger;
    }

    public final int changeInt(int m) {
        AtomicInteger atomicInteger1 = new AtomicInteger(this.m);



        return atomicInteger1.addAndGet(-1);
    }

}