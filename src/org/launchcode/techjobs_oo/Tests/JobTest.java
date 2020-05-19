package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;


public class JobTest {
    Job idOnlyJob1 = new Job();
    Job idOnlyJob2 = new Job();
    Job filledConstructorJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job filledConstructorJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
            new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job nullConstructorJob = new Job(null, null, null,null, null);

    @Test
    public void testSettingJobId() {
        assertNotEquals(idOnlyJob1.getId(), idOnlyJob2.getId());
        assertEquals(idOnlyJob1.getId() + 1, idOnlyJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertSame("Product tester", filledConstructorJob1.getName());
        assertEquals(idOnlyJob2.getId() + 1, filledConstructorJob1.getId());
        assertSame("ACME", filledConstructorJob1.getEmployer().toString());
        assertSame("Desert", filledConstructorJob1.getLocation().toString());
        assertSame("Quality control", filledConstructorJob1.getPositionType().toString());
        assertSame("Persistence", filledConstructorJob1.getCoreCompetency().toString());
        assertTrue(filledConstructorJob1.getName() instanceof String);
        assertTrue(filledConstructorJob1.getEmployer() instanceof Employer);
        assertTrue(filledConstructorJob1.getLocation() instanceof Location);
        assertTrue(filledConstructorJob1.getPositionType() instanceof PositionType);
        assertTrue(filledConstructorJob1.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(filledConstructorJob2.equals(filledConstructorJob1));
    }

    @Test
    public void testToStringBeginsAndEndsWithNewLine() {
        assertEquals(0, filledConstructorJob1.toString().indexOf("\n"));
        assertEquals(filledConstructorJob1.toString().length() - 1, filledConstructorJob1.toString().lastIndexOf("\n"));
    }

    @Test
    public void testToStringWithAllFieldsFilled() {
        assertEquals("\nID:  " + (idOnlyJob2.getId() + 1) + "\n" +
                "Name: Product tester\n" +
                "Employer: ACME\n" +
                "Location: Desert\n" +
                "Position Type: Quality control\n" +
                "Core Competency: Persistence\n",
                filledConstructorJob1.toString()
        );
    }

    @Test
    public void testToStringMissingAllFields() {
        assertEquals("\nID:  " + (filledConstructorJob2.getId() + 1) + "\n" +
                        "Name: Data not available\n" +
                        "Employer: Data not available\n" +
                        "Location: Data not available\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Data not available\n",
                nullConstructorJob.toString()
        );
        assertEquals("\nID:  " + (idOnlyJob1.getId() + 1) + "\n" +
                        "Name: Data not available\n" +
                        "Employer: Data not available\n" +
                        "Location: Data not available\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Data not available\n",
                idOnlyJob2.toString()
        );
    }
}
