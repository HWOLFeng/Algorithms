package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class Junit4Test {
    @Test
    public void testAdd(){
        int z = new Demo().getZ(1,2);
        assertEquals(3,z);
    }
}
