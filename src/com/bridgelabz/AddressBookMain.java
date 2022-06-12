package com.bridgelabz.addressbook;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookMain {

    ArrayList<Contacts> Book = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void AddDetails() {

        Scanner scanner = new Scanner(System.in);
        Contacts details = new Contacts();
        System.out.println("Enter the First Name of person");
        details.setFirstName(scanner.nextLine());
        System.out.println("Enter the Last Name of person");
        details.setLastName(scanner.nextLine());
        System.out.println("Enter the Address Name of person");
        details.setAddress(scanner.nextLine());
        System.out.println("Enter the City Name of person");
        details.setCity(scanner.nextLine());
        System.out.println("Enter the State Name of person");
        details.setState(scanner.nextLine());
        System.out.println("Enter the Email of person");
        details.setEmail(scanner.nextLine());
        System.out.println("Enter the Zip code of person");
        details.setZipCode(scanner.nextInt());
        System.out.println("Enter the Phone number of person");
        details.setPhoneNumber(scanner.nextInt());

        Book.add(details);

        System.out.println(Book);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Management System");
        AddressBookMain details = new AddressBookMain();
    }
}