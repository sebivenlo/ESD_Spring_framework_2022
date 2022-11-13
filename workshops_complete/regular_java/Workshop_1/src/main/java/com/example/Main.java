package com.example;


public class Main {
    public static void main(String[] args) {
        StudentController controller = new StudentController();
        int id;
        int PCN;
        String firstName;
        String lastName;
        if(args.length >= 4){
            try {
                id = Integer.parseInt(args[0]);
                PCN = Integer.parseInt(args[1]);
                firstName = args[2];
                lastName = args[3];
            }
            catch(NumberFormatException ex){
                id = 1;
                PCN = 123;
                firstName = "Jason";
                lastName = "Tavernier";
            }
        }
        else{
            id = 1;
            PCN = 123;
            firstName = "Jason";
            lastName = "Tavernier";
        }
        System.out.println(controller.createStudent(id, PCN, firstName, lastName));
    }
}