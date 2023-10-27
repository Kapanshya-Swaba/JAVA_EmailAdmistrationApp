package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String alternateEmail;
    private String email;
    private String CompanySurfix = "";
    private int mailBoxCapcity = 500;
    private int defaultPasswordLength = 10;

    // Constructo to receive the firstname andlast name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // System.out.println("Email Created " + this.firstName + " " + this.lastName);
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);

        // Call a method that returns a random passoword
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + " " + lastName.toLowerCase() + "@" + department + "." + CompanySurfix;
        // System.out.println("Your email is: " + email);
    }
    // Ask for department

    private String setDepartment() {
        System.out.print(
                "New Worker: " + firstName
                        + "\nDepartment Codes\n1 for Sales\n2 for Development\n3 for Accounting\n4 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    // Generate a random passowrd
    private String randomPassword(int length) {
        String passwordSet = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890?!@#$%^&*()_+=";
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int random = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(random);
        }
        return new String(password);
    }

    // Set mailbox capacity
    public void setMailBoxCapacity(int capacity) {
        this.mailBoxCapcity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // Change password
    public void changePassword(String password) {
        this.password = password;

    }

    // get Password
    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL" + email + "\nMAILBOX CAPACITY: " + mailBoxCapcity + "mb";

    }

}