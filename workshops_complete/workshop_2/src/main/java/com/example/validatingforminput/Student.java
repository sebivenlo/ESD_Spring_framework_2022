package com.example.validatingforminput;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {

    //INITIALISE VARIABLES
    @NotNull
    private final Integer id;
    @NotNull
    private final Integer PCN;
    @NotNull
    @Size(min=2, max=30)
    private String firstName;
    @NotNull
    @Size(min=2, max=30)
    private String lastName;
    private Specialisation specialisation;

    //CONSTRUCTOR
    public Student (final int id, final int PCN, String firstName, String lastName) {
        this.id = id;
        this.PCN = PCN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialisation = Specialisation.SOFTWAREENGINEERING;
    }
    //HELPER FUNCTIONS
    /**
     * This method is used to change specialisation from software engineering. If the user is currently software
     * engineering, it'll switch and return "Business informatics", and vice versa.
     *
     * @return The new specialisation
     */
    public Specialisation changeSpecialisation(){
        if(this.specialisation == Specialisation.SOFTWAREENGINEERING){
            this.specialisation = Specialisation.BUSINESSINFORMATICS;
        }
        else if(this.specialisation == Specialisation.BUSINESSINFORMATICS){
            this.specialisation = Specialisation.SOFTWAREENGINEERING;
        }
        return this.specialisation;
    }
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", PCN=" + PCN +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialisation=" + specialisation +
                '}';
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPCN() {
        return PCN;
    }


}
