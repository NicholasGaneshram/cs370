package edu.qc.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuggyClassTestSC2 {

    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After
    public void tearDown() {
        myBuggyClass = null;
    }

    //test achieves 100% statement coverage of BuggyMethod2 and does not show the fault therein
    @Test
    public void testBuggyClassMethod2a1() {
        assertEquals(16, myBuggyClass.buggyMethod2(3, 4));
    }

    @Test
    public void testBuggyClassMethod2a2() {
        assertEquals(0, myBuggyClass.buggyMethod2(20, 6));
    }

}