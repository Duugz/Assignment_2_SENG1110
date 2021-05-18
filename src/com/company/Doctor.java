package com.company;

//Renton Malseed-Smith:c3349143
//and Robert Duggan: c3374593
public class Doctor
{
    private String name;     // the name of the doctor
    private String specialisation;     // the specialisation of the doctor

    // setting the fields values and then calling them using non void methods
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setSpecialisation(String specialisation)
    {
        this.specialisation = specialisation;

    }
    public String getSpecialisation()
    {
        return specialisation;
    }
    // complete all other methods from here.
}