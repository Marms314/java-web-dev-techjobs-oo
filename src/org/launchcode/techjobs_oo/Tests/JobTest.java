package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;


public class JobTest {
    Job idTestJob1 = new Job();
    Job idTestJob2 = new Job();
    Job constructorTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job equalsTestJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));

    @Test
    public void testSettingJobId() {
        assertNotEquals(idTestJob1.getId(), idTestJob2.getId());
        assertEquals(idTestJob1.getId() + 1, idTestJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertSame("Product tester", constructorTestJob.getName());
        assertEquals(idTestJob2.getId() + 1, constructorTestJob.getId());
        /*
        TODO: Used the workaround above of having the id be checked to be 1 higher than idTestJob2 to make the test pass.
         Check with Steve if this is the correct way to take care of this or if the ids not being the same as the previous compile is a bug.
         The ids on all the jobs get higher with each compile with new tests, while I thought they would be able to stay the same.
        */
        assertSame("ACME", constructorTestJob.getEmployer().toString());
        assertSame("Desert", constructorTestJob.getLocation().toString());
        assertSame("Quality control", constructorTestJob.getPositionType().toString());
        assertSame("Persistence", constructorTestJob.getCoreCompetency().toString());
        /*
        TODO: int cannot be tested with instanceof because it is a primitive type.
         Discuss workarounds or if it should be disregarded with Steve.
         I was unable to find a good equivalent in java to JavaScript's typeof which would fill this purpose.
         Should the int be cast to an Integer?
         https://education.launchcode.org/java-web-development/assignments/tech-jobs-oo.html#test-the-full-constructor
        */
        assertTrue(constructorTestJob.getName() instanceof String);
        assertTrue(constructorTestJob.getEmployer() instanceof Employer);
        assertTrue(constructorTestJob.getLocation() instanceof Location);
        assertTrue(constructorTestJob.getPositionType() instanceof PositionType);
        assertTrue(constructorTestJob.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(equalsTestJob.equals(constructorTestJob));
    }
}
