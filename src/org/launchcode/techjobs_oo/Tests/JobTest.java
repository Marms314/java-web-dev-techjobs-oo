package org.launchcode.techjobs_oo.Tests;

import org.junit.Test;
import org.launchcode.techjobs_oo.*;
import static org.junit.Assert.*;


public class JobTest {
    Job idOnlyJob1 = new Job();
    Job idOnlyJob2 = new Job();
    Job filledConstructorJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job filledConstructorJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job nullConstructorJob = new Job(null, null, null,null, null);
    Job missingNameJob = new Job(null, new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job missingEmployerJob = new Job("Product tester", null, new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job missingLocationJob = new Job("Product tester", new Employer("ACME"), null, new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job missingPositionTypeJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), null, new CoreCompetency("Persistence"));
    Job missingCoreCompetencyJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), null);

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
        assertEquals(0, nullConstructorJob.toString().indexOf("\n"));
        assertEquals(nullConstructorJob.toString().length() - 1, nullConstructorJob.toString().lastIndexOf("\n"));
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
    public void testToStringMissingName() {
        assertEquals("\nID:  " + (nullConstructorJob.getId() + 1) + "\n" +
                        "Name: Data not available\n" +
                        "Employer: ACME\n" +
                        "Location: Desert\n" +
                        "Position Type: Quality control\n" +
                        "Core Competency: Persistence\n",
                missingNameJob.toString()
        );
    }

    @Test
    public void testToStringMissingEmployer() {
        assertEquals("\nID:  " + (missingNameJob.getId() + 1) + "\n" +
                        "Name: Product tester\n" +
                        "Employer: Data not available\n" +
                        "Location: Desert\n" +
                        "Position Type: Quality control\n" +
                        "Core Competency: Persistence\n",
                missingEmployerJob.toString()
        );
    }

    @Test
    public void testToStringMissingLocation() {
        assertEquals("\nID:  " + (missingEmployerJob.getId() + 1) + "\n" +
                        "Name: Product tester\n" +
                        "Employer: ACME\n" +
                        "Location: Data not available\n" +
                        "Position Type: Quality control\n" +
                        "Core Competency: Persistence\n",
                missingLocationJob.toString()
        );
    }

    @Test
    public void testToStringMissingPositionType() {
        assertEquals("\nID:  " + (missingLocationJob.getId() + 1) + "\n" +
                        "Name: Product tester\n" +
                        "Employer: ACME\n" +
                        "Location: Desert\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Persistence\n",
                missingPositionTypeJob.toString()
        );
    }

    @Test
    public void testToStringMissingCoreCompetency() {
        assertEquals("\nID:  " + (missingPositionTypeJob.getId() + 1) + "\n" +
                        "Name: Product tester\n" +
                        "Employer: ACME\n" +
                        "Location: Desert\n" +
                        "Position Type: Quality control\n" +
                        "Core Competency: Data not available\n",
                missingCoreCompetencyJob.toString()
        );
    }

    @Test
    public void testToStringMissingAllFields() {
        assertEquals("\nOOPS! This job does not seem to exist.\n",
                nullConstructorJob.toString()
        );
        assertEquals("\nOOPS! This job does not seem to exist.\n",
                idOnlyJob2.toString()
        );
    }
}
