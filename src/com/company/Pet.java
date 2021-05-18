package com.company;

//Renton Malseed-Smith:c3349143 and Robert Duggan: c3374593
public class Pet
{
    private String type;     // the type of the pet.
    private String size;     // the size of the pet.
    private String name;     // the name of the pet.
    private double weight;     //the weight of the pet.
    private int age;         //the age of the pet.
    private String doctor;  // the doctor of the pet.

    // add comments
    public void setPetType(String type) //all set methods for the pets
    {
        this.type = type;
    }
    public void setPetSize(String size)
    {
        this.size = size;
    }
    public void setPetName(String name)
    {
        this.name = name;
    }
    public void setPetWeight(double weight)
    {
        this.weight = weight;
    }
    public void setPetAge(int age)
    {
        this.age = age;
    }
    public void setDoctor(String doctor)
    {
        this.doctor = doctor;
    }
    // add comments
    public String getPetType() // and the return methods when we need them
    {
        return type;
    }
    public String getPetSize()
    {
        return size;
    }
    public String getPetName()
    {
        return name;
    }
    public double getPetWeight()
    {
        return weight;
    }
    public int getPetAge()
    {
        return age;
    }
    public String getPetDoctor()
    {
        return doctor;
    }
    //complete all other methods from here.
}
