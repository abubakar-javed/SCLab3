/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package rules;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * JUnit tests for RulesOf6005.
 */
public class RulesOf6005Test {
    
    /**
     * Tests the mayUseCodeInAssignment method.
     */
    @Test
    public void testMayUseCodeInAssignment() {
        assertFalse("Expected false: un-cited publicly-available code",
                RulesOf6005.mayUseCodeInAssignment(false, true, false, false, false));
        assertTrue("Expected true: self-written required code",
                RulesOf6005.mayUseCodeInAssignment(true, false, true, true, true));
    }

    /**
     * Tests the mayUseCodeInAssignment method with publicly available cited code.
     * In this case, the code is publicly available, but it's properly cited,
     * so it should be allowed.
     */
    @Test
    public void testMayUseCitedPublicCode() {
        assertTrue("Expected true: publicly available code properly cited",
                RulesOf6005.mayUseCodeInAssignment(false, true, true, true, false));
    }

    /**
     * Tests the mayUseCodeInAssignment method with required implementation.
     * In this case, the code is not written by the student, but it's required for
     * the assignment, so it should be allowed if properly cited.
     */
    @Test
    public void testMayUseRequiredImplementation() {
        assertTrue("Expected true: required code properly cited",
                RulesOf6005.mayUseCodeInAssignment(false, false, false, true, true));
    }
}
