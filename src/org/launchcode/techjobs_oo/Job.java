package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString(){
        boolean nameIsNull = this.name == null;
        boolean employerIsNull = this.employer == null;
        boolean locationIsNull = this.location == null;
        boolean positionTypeIsNull = this.positionType == null;
        boolean coreCompetencyIsNull = this.coreCompetency == null;
        boolean allAreNull = nameIsNull && employerIsNull && locationIsNull && positionTypeIsNull && coreCompetencyIsNull;

        if(allAreNull) {
            return "\nOOPS! This job does not seem to exist.\n";
        } else {
            return "\nID:  " + this.id + "\n" +
                    "Name: " + (nameIsNull ? "Data not available" : this.name) + "\n" +
                    "Employer: " + (employerIsNull ? "Data not available" : this.employer.toString()) + "\n" +
                    "Location: " + (locationIsNull ? "Data not available" : this.location.toString()) + "\n" +
                    "Position Type: " + (positionTypeIsNull ? "Data not available" : this.positionType.toString()) + "\n" +
                    "Core Competency: " + (coreCompetencyIsNull ? "Data not available" : this.coreCompetency.toString()) + "\n";
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }
}
