/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailapplication;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int passwordLength = 10;
    private String department;
    int mailboxCapacity = 500;
    private String alternateEmail;
    private String email;
    private String companySuffix = "fpt.vn";
    
    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email created! First name: " + this.firstName + ". Last name: " + this.lastName);
        
        // Call a method asking for the department, return the department
        this.department = setDepartment();
        System.out.println("Set department successfull! \nDepartment: " + department);
        
        // Call a method that return the ramdom password
        this.password = randomPassword(passwordLength);
        System.out.println("Default password: " + password);
        
        //Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email: " + email);
    }
    
    // Ask for department
    private String setDepartment(){
        System.out.println("Department code: \n0.For none \n1.For Sale \n2.For Development \n3.For Accounting");
        Scanner scanner = new Scanner(System.in);
        int departmentCode = scanner.nextInt();
        while(departmentCode > 3 || departmentCode < 0){
            System.out.println("Incorrect Code!!! Try Again: ");
            departmentCode = scanner.nextInt();
        }
        switch(departmentCode){
            case 0: return "";
            case 1: return "sale";
            case 2: return "development";
            case 3: return "counting";
        }
        return department;
    }
    
    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890!@#$%^&*";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String (password);
    }
    
    // Set the mail box capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    
    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    
    //Change a password
    public void changePassword(String password){
        this.password = password;
    }
    
    public int getMailboxCapacity(){return mailboxCapacity; }
    public String getAlternateEmail(){ return alternateEmail; }
    public String getPassword(){ return password; }
    
    public String showInfor(){
        return "DISPLAY NAME: " + firstName + " " + lastName + 
                "\nCompany email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "Mb";
    }
}
