//Renton Malseed-Smith:c3349143 and Robert Duggan: c3374593
package com.company;
import java.util.*;
public class Clinic
{
    private Doctor doctor1 = null, doctor2 = null;
    private Pet pet1 = null , pet2 = null, pet3 = null, pet4 = null;
    //sets the objects to null

    private void run() //the beginning flow of the program, gives options then runes methods
    {
        int option = 0;

        while (option != -1)
        {
            option = chooseOption();
            switch (option)
            {
                case 1: addDoctor(); //break allows the switch to move on to another method
                    break;
                case 2: addPet();
                    break;
                case 3: deleteDoctor();
                    break;
                case 4: deletePet();
                    break;
                case 5: docList();
                    break;
                case 6: petList();
                    break;
                //case 7: petToDoct  List();
                //break;
                case 8: assignDoc();
                    //break;
                    //case 9: petAnalysis();
                    //break;
                case 10: System.exit(1);
                default:
                    System.out.print("Please pick a valid number \r\n");

            }
        }
    }

    public static void main(String[] args)
    {
        Clinic clinic = new Clinic();
        clinic.run();
        //declared run() allows the ability to return to the run() method
    }
    public static int chooseOption(){
        Scanner console = new Scanner(System.in);
        int optNum = 0;
        while (optNum < 1){
            System.out.print("Type number for options...\r\n1: New Doctor \r\n2: New Pet \r\n3: Delete Doctor \r\n4: Delete Pet \r\n5: Doctor List \r\n6: Pet List \r\n7: Which doctor has which pets? \r\n8: Assign a doctor a new pet \r\n9: Pet Information/Analysis \r\n10: Exit \r\n");
            optNum = console.nextInt();
        }
        return optNum; //allows a user to choose an option and naviagte through the screens
    }

    public void addDoctor(){//adds a doctor
        Scanner console = new Scanner(System.in);
        if (doctor1==null || doctor2==null)
        {
            Doctor doctor = new Doctor();
            String name;
            String specialisation;
            System.out.print("Doctors name? ");
            name = console.nextLine();
            if (name.contains(" "))
            {
                System.out.print("Name cannot contain spaces or already exist \r\n");
                run();
            }
            else{
                doctor.setName(name);
                System.out.println("Name = "+doctor.getName());
            }
            //Gives inputs for names and spcialisation of a doctor
            System.out.println("Doctors Specialisation? ");
            specialisation = console.nextLine();
            if (specialisation.contains("cat") || specialisation.contains("dog")){
                doctor.setSpecialisation(specialisation);
                System.out.println("Dr "+doctor.getName() + " with Specialisation "+doctor.getSpecialisation() + " has been entered.");
            }
            else{
                System.out.println("Specialisation must be either dog or cat \r\n");
                run();
            }
            if (doctor1 == null){
                doctor1 = doctor;
            }
            //allows for there to be two different doctors with diffrent fields and pets
            else{
                doctor2 = doctor;
            }
        }
        else{
            System.out.println("No space for a new doctor");
        }

    }
    public void addPet(){
        Scanner console = new Scanner(System.in);
        if (pet1 == null || pet2 == null || pet3 == null || pet4 == null )
        {
            Pet p = new Pet();
            String type;
            String size;
            String name;
            double weight;
            int age;
            System.out.print("Pet type? ");
            type=console.nextLine();
            if (type.contains("cat")|| type.contains( "dog")){
                p.setPetType(type);
                System.out.println("Pet's type = "+p.getPetType());
            }
            else{
                System.out.println("Value can only be dog or cat \r\n");
                run();
            }
            System.out.print("Pet size? ");
            size=console.nextLine();
            if (size.contains("large") || size.contains("medium") || size.contains("small")){
                p.setPetSize(size);
                System.out.println("Pet's size = "+p.getPetSize());
            }
            else{
                System.out.println("Value can only be small, large or medium \r\n");
                run();
            }
            System.out.print("Pet name? ");
            name=console.nextLine();
            if (name.contains(" ") || name.contains(p.getPetName())){
                p.setPetName(name);
                System.out.println("Pet's Name = "+p.getPetName());
            }
            else{
                System.out.print("Name must have no spaces and cannot already exist");
            }
            System.out.print("Pet weight? ");
            //try and catch block lets you catch certain input mismatches and other obscure errors
            try {
                weight=console.nextDouble();
                p.setPetWeight(weight);
                System.out.println("Pets weight = "+p.getPetWeight());
            }
            catch(InputMismatchException e){
                System.out.println("Not a valid weight, please enter an integer");
                run();
            }
            System.out.print("Pet age? ");
            try{
                age=console.nextInt();
                p.setPetAge(age);
                System.out.println("Pets age = "+p.getPetAge());
            }
            catch(InputMismatchException e){
                System.out.println("Not a valid age, please enter an integer");
                run();
            }
            //moves throught the different pet fields
            if (pet1 == null){
                pet1 = p;
                System.out.println("Pet "+ name + " has been added");
            }
            else if (pet1 != null && pet2 == null){
                pet2 = p;
                System.out.println("Pet "+ name + " has been added");
            }
            else if (pet2 != null && pet3 == null){
                pet3 = p;
                System.out.println("Pet "+ name + " has been added");
            }
            else if (pet3 != null && pet4 == null){
                pet4 = p;
                System.out.println("Pet "+ name + " has been added");
            }
            //else if (pet1.getPetName().contains(pet2.getPetName()) || pet1.getPetName().contains(pet3.getPetName()) ){
            //== pet2.getPetName() || pet1.getPetName() == pet3.getPetName() ||pet1.getPetName() == pet4.getPetName() ||pet2.getPetName() == pet3.getPetName() || pet2.getPetName() == pet4.getPetName() || pet3.getPetName() == pet4.getPetName()) {
            //System.out.print("Name already taken please try again.....\r\n");
            else{
                System.out.println("No more space for pets");
            }
        }
    }
    public void deleteDoctor(){
        Scanner console = new Scanner(System.in);
        Doctor d = new Doctor();
        String name;
        System.out.print("Doctors name? ");
        name = console.nextLine();
        //deletes a doctor returning it to null
        if (name == doctor1.getName() || doctor1.getName() != null){
            doctor1 = null;
            System.out.print("Doctor " + name + " has been deleted..... \r\n");
        }
        else if (name == doctor2.getName() || doctor2.getName() != null){
            doctor2 = null;
            System.out.print("Doctor " + name + " has been deleted..... \r\n");
        }
        else
            System.out.print("That doctor doesn't exist \r\n");
    }

    public void deletePet(){
        Scanner console = new Scanner(System.in);
        Pet p = new Pet();
        String name;
        System.out.print("Pets name? ");
        name = console.nextLine();
        //deletes a pet returning it to null
        if (name == pet1.getPetName() && pet1.getPetName() != null){
            pet1 = null;
            System.out.print("Doctor " + name + " has been deleted..... \r\n");
        }
        else if (name == pet2.getPetName() && pet2.getPetName() != null){
            pet2 = null;
            System.out.print("Doctor " + name + " has been deleted..... \r\n");
        }
        else if (name == pet3.getPetName() && pet3.getPetName() != null){
            pet3 = null;
            System.out.print("Doctor " + name + " has been deleted..... \r\n");
        }
        else if (name == pet4.getPetName() && pet4.getPetName() != null){
            pet4 = null;
            System.out.print("Doctor " + name + " has been deleted..... \r\n");
        }
        else
            System.out.print("That doctor doesn't exist \r\n");

    }
    public void docList(){
        Doctor d = new Doctor();
        //shows all doctors if there are any
        if (doctor1 == null && doctor2 == null)
            System.out.print("No Doctors \r\n");
        else if (doctor1 != null && doctor2 == null)
            System.out.print("Name: " + doctor1.getName() + "\r\n Specialisation" + doctor1.getSpecialisation() + "\r\n");
        else if (doctor2 != null && doctor1 == null)
            System.out.print("Name: " + doctor2.getName() + "\r\n Specialisation" + doctor2.getSpecialisation());
        else
            System.out.print("Names: " + doctor1.getName()  + ", " + doctor2.getName() + "\r\n Specialisations" + doctor1.getSpecialisation() + ", " + doctor2.getSpecialisation() + "\r\n");
    }
    public void petList(){
        Pet p = new Pet();
        //shows all pets if there are any
        if (pet1 == null && pet2 == null && pet3 == null && pet4 == null)
        {
            System.out.println("No Pets");
        }
        else if (pet1 != null)
        {
            System.out.println("Pet 1 " + pet1.getPetName() + ": " + pet1.getPetSize() + ", " + pet1.getPetType() + " weighing " + pet1.getPetWeight() + " kg at " + pet1.getPetAge() + " years old ");
        }
        else if (pet1 != null && pet2 != null)
        {
            System.out.println("Pet 1 " + pet1.getPetName() + ": " + pet1.getPetSize() + ", " + pet1.getPetType() + " weighing " + pet1.getPetWeight() + " kg at " + pet1.getPetAge() + " years old ");
            System.out.println("Pet 2 " + pet2.getPetName() + ": " + pet2.getPetSize() + ", " + pet2.getPetType() + " weighing " + pet2.getPetWeight() + " kg at " + pet2.getPetAge() + " years old ");
        }
        else if (pet1 != null && pet2 != null && pet3 != null)
        {
            System.out.println("Pet 1 " + pet1.getPetName() + ": " + pet1.getPetSize() + ", " + pet1.getPetType() + " weighing " + pet1.getPetWeight() + " kg at " + pet1.getPetAge() + " years old ");
            System.out.println("Pet 2 " + pet2.getPetName() + ": " + pet2.getPetSize() + ", " + pet2.getPetType() + " weighing " + pet2.getPetWeight() + " kg at " + pet2.getPetAge() + " years old ");
            System.out.println("Pet 3 " + pet3.getPetName() + ": " + pet3.getPetSize() + ", " + pet3.getPetType() + " weighing " + pet3.getPetWeight() + " kg at " + pet3.getPetAge() + " years old ");
        }
        else{
            System.out.println("Pet 1 " + pet1.getPetName() + ": " + pet1.getPetSize() + ", " + pet1.getPetType() + " weighing " + pet1.getPetWeight() + " kg at " + pet1.getPetAge() + " years old ");
            System.out.println("Pet 2 " + pet2.getPetName() + ": " + pet2.getPetSize() + ", " + pet2.getPetType() + " weighing " + pet2.getPetWeight() + " kg at " + pet2.getPetAge() + " years old ");
            System.out.println("Pet 3 " + pet3.getPetName() + ": " + pet3.getPetSize() + ", " + pet3.getPetType() + " weighing " + pet3.getPetWeight() + " kg at " + pet3.getPetAge() + " years old ");
            System.out.println("Pet 4 " + pet4.getPetName() + ": " + pet4.getPetSize() + ", " + pet4.getPetType() + " weighing " + pet4.getPetWeight() + " kg at " + pet4.getPetAge() + " years old ");

        }
    }

    // public void docPetList(){} - didnt have time to figure out
    public void assignDoc(){
        //unfinished part - didnt have time, couldnt figure out to get rid of InputMismatchException
        Scanner console = new Scanner(System.in);
        Pet p = new Pet();
        Doctor d = new Doctor();
        String namePet;
        String doctor;
        System.out.print("Pets name? ");
        namePet = console.nextLine();
        System.out.print("Doctors name? ");
        doctor = console.nextLine();
        if (pet1.getPetName() != null || pet2.getPetName() != null || pet3.getPetName() != null || pet4.getPetName() != null ||namePet == pet1.getPetName() || namePet == pet2.getPetName() || namePet == pet3.getPetName() || namePet == pet4.getPetName()){
            if (doctor1.getName() != null || doctor2.getName() != null || doctor == doctor1.getName() || doctor == doctor2.getName()){

                p.setDoctor(doctor);
                System.out.println("Doctor: " + doctor );

            }
            else if (namePet != p.getPetName()){
                System.out.print("Pet does not exist \r\n");
            }
            else if (doctor != d.getName()){
                System.out.print("Doctor does not exist \r\n");
            }
        }
    }

    // Didnt have time to complete this part
    // public void petAnalysis()
    // {
    // Scanner console = new Scanner(System.in);
    // String petName;
    // System.out.println("Enter pet's name");
    // petName = console.nextLine();
    // if (pet1.getPetName() != null || pet2.getPetName() != null || pet3.getPetName() != null || pet4.getPetName() != null || petName == pet1.getPetName() || petName == pet2.getPetName() || petName == pet3.getPetName() || petName == pet4.getPetName())
    // {
    // //if the pet is pet1
    // if (petName == pet1.getPetName())
    // {
    // if (pet1.getPetType().contains("cat"))
    // {
    // if (pet1.getPetSize().contains("small") && pet1.getPetWeight() > 4)
    // System.out.println(petName + " is overweight");
    // else if (pet1.getPetSize().contains("medium") && pet1.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet1.getPetSize().contains("large") && pet1.getPetWeight() > 8)
    // System.out.println(petName + " is overweight");
    // else if (pet1.getPetSize().contains("small") && pet1.getPetWeight() <= 4)
    // System.out.println(petName + " is healthy");
    // else if (pet1.getPetSize().contains("medium") && pet1.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet1.getPetSize().contains("large") && pet1.getPetWeight() <= 8)
    // System.out.println(petName + " is healthy");
    // }
    // else if (pet1.getPetType().contains("dog"))
    // {
    // if (pet1.getPetSize().contains("small") && pet1.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet1.getPetSize().contains("medium") && pet1.getPetWeight() > 9)
    // System.out.println(petName + " is overweight");
    // else if (pet1.getPetSize().contains("large") && pet1.getPetWeight() > 12)
    // System.out.println(petName + " is overweight");
    // else if (pet1.getPetSize().contains("small") && pet1.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet1.getPetSize().contains("medium") && pet1.getPetWeight() <= 9)
    // System.out.println(petName + " is healthy");
    // else if (pet1.getPetSize().contains("large") && pet1.getPetWeight() <= 12)
    // System.out.println(petName + " is healthy");
    // }
    // }else if (pet2.getPetName() != null && petName == pet2.getPetName())
    // {
    // if (pet2.getPetType().contains("cat"))
    // {
    // if (pet2.getPetSize().contains("small") && pet2.getPetWeight() > 4)
    // System.out.println(petName + " is overweight");
    // else if (pet2.getPetSize().contains("medium") && pet2.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet2.getPetSize().contains("large") && pet2.getPetWeight() > 8)
    // System.out.println(petName + " is overweight");
    // else if (pet2.getPetSize().contains("small") && pet2.getPetWeight() <= 4)
    // System.out.println(petName + " is healthy");
    // else if (pet2.getPetSize().contains("medium") && pet2.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet2.getPetSize().contains("large") && pet2.getPetWeight() <= 8)
    // System.out.println(petName + " is healthy");
    // }
    // else if (pet2.getPetType().contains("dog"))
    // {
    // if (pet2.getPetSize().contains("small") && pet2.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet2.getPetSize().contains("medium") && pet2.getPetWeight() > 9)
    // System.out.println(petName + " is overweight");
    // else if (pet2.getPetSize().contains("large") && pet2.getPetWeight() > 12)
    // System.out.println(petName + " is overweight");
    // else if (pet2.getPetSize().contains("small") && pet2.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet2.getPetSize().contains("medium") && pet2.getPetWeight() <= 9)
    // System.out.println(petName + " is healthy");
    // else if (pet2.getPetSize().contains("large") && pet2.getPetWeight() <= 12)
    // System.out.println(petName + " is healthy");
    // }
    // }else if (pet3.getPetName() != null && petName == pet3.getPetName())
    // {
    // if (pet3.getPetType().contains("cat"))
    // {
    // if (pet3.getPetSize().contains("small") && pet3.getPetWeight() > 4)
    // System.out.println(petName + " is overweight");
    // else if (pet3.getPetSize().contains("medium") && pet3.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet3.getPetSize().contains("large") && pet3.getPetWeight() > 8)
    // System.out.println(petName + " is overweight");
    // else if (pet3.getPetSize().contains("small") && pet3.getPetWeight() <= 4)
    // System.out.println(petName + " is healthy");
    // else if (pet3.getPetSize().contains("medium") && pet3.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet3.getPetSize().contains("large") && pet3.getPetWeight() <= 8)
    // System.out.println(petName + " is healthy");
    // }
    // else if (pet3.getPetType().contains("dog"))
    // {
    // if (pet3.getPetSize().contains("small") && pet3.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet3.getPetSize().contains("medium") && pet3.getPetWeight() > 9)
    // System.out.println(petName + " is overweight");
    // else if (pet3.getPetSize().contains("large") && pet3.getPetWeight() > 12)
    // System.out.println(petName + " is overweight");
    // else if (pet3.getPetSize().contains("small") && pet3.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet3.getPetSize().contains("medium") && pet3.getPetWeight() <= 9)
    // System.out.println(petName + " is healthy");
    // else if (pet3.getPetSize().contains("large") && pet3.getPetWeight() <= 12)
    // System.out.println(petName + " is healthy");
    // }
    // }
    // //if pet is pet4
    // else if (pet4.getPetName() != null && petName == pet4.getPetName())
    // {
    // if (pet4.getPetType().contains("cat"))
    // {
    // if (pet4.getPetSize().contains("small") && pet4.getPetWeight() > 4)
    // System.out.println(petName + " is overweight");
    // else if (pet4.getPetSize().contains("medium") && pet4.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet4.getPetSize().contains("large") && pet4.getPetWeight() > 8)
    // System.out.println(petName + " is overweight");
    // else if (pet4.getPetSize().contains("small") && pet4.getPetWeight() <= 4)
    // System.out.println(petName + " is healthy");
    // else if (pet4.getPetSize().contains("medium") && pet4.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet4.getPetSize().contains("large") && pet4.getPetWeight() <= 8)
    // System.out.println(petName + " is healthy");
    // }
    // else if (pet4.getPetType().contains("dog"))
    // {
    // if (pet4.getPetSize().contains("small") && pet4.getPetWeight() > 6)
    // System.out.println(petName + " is overweight");
    // else if (pet4.getPetSize().contains("medium") && pet4.getPetWeight() > 9)
    // System.out.println(petName + " is overweight");
    // else if (pet4.getPetSize().contains("large") && pet4.getPetWeight() > 12)
    // System.out.println(petName + " is overweight");
    // else if (pet4.getPetSize().contains("small") && pet4.getPetWeight() <= 6)
    // System.out.println(petName + " is healthy");
    // else if (pet4.getPetSize().contains("medium") && pet4.getPetWeight() <= 9)
    // System.out.println(petName + " is healthy");
    // else if (pet4.getPetSize().contains("large") && pet4.getPetWeight() <= 12)
    // System.out.println(petName + " is healthy");
    // }
    // }
    // }
    // else
    // System.out.println("This pet does not exist");
    // }


}
