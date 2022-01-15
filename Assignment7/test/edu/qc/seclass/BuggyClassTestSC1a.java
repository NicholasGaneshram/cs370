package edu.qc.seclass;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuggyClassTestSC1a {
    BuggyClass myBuggyClass;

    @Before
    public void setUp() {
        myBuggyClass= new BuggyClass();
    }

    @After
    public void tearDown() {
        myBuggyClass = null;
    }

    //these tests achieves a 100% statement coverage of buggyMethod1 and does not show the fault
    @Test
    public void testBuggyClassMethod1a1() {
        assertEquals(1, myBuggyClass.buggyMethod1(1, 1));
    }

    @Test
    public void testBuggyClassMethod1a2() {
        assertEquals(6, myBuggyClass.buggyMethod1(8, 7));
    }

}