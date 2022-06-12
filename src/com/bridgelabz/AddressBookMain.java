package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
    ArrayList<Contacts> Book = new ArrayList<Contacts>();
    static Scanner scanner = new Scanner(System.in);

    static HashMap<String, ArrayList<Contacts>> hashmap = new HashMap<>();
    static AddressBookMain Details = new AddressBookMain();


    public void addDetails() {

        Scanner scanner = new Scanner(System.in);
        Contacts details = new Contacts();
        System.out.println("Enter the First Name ");
        details.setFirstName(scanner.nextLine());
        System.out.println("Enter the Last Name ");
        details.setLastName(scanner.nextLine());
        System.out.println("Enter the Address ");
        details.setAddress(scanner.nextLine());
        System.out.println("Enter the City");
        details.setCity(scanner.nextLine());
        System.out.println("Enter the State");
        details.setState(scanner.nextLine());
        System.out.println("Enter the Email ");
        details.setEmail(scanner.nextLine());
        System.out.println("Enter the Zip code");
        details.setZipCode(scanner.nextInt());
        System.out.println("Enter the Phone number");
        details.setPhoneNumber(scanner.nextInt());

        Book.add(details);
        viewAllBooks();
    }

    public void editDetails() {

        System.out.println("Confirm your first name to edit details: ");
        String name = scanner.next();

        for (int i = 0; i < Book.size(); i++) {
            if (Book.get(i).getFirstName().equals(name)) {
                System.out.println("Select form below to change: ");
                System.out.println(
                        "\n1.First Name\n2.Last Name\n3.Address\n4.city\n5.State\n6.Email\n7.Zip\n8.Phone number");
                int check = scanner.nextInt();

                switch (check) {
                    case 1:
                        System.out.println("Enter first name");
                        Book.get(i).setFirstName(scanner.next());
                        break;
                    case 2:
                        System.out.println("Enter Last name");
                        Book.get(i).setLastName(scanner.next());
                        break;
                    case 3:
                        System.out.println("Enter address");
                        Book.get(i).setAddress(scanner.next());
                        break;
                    case 4:
                        System.out.println("Enter city");
                        Book.get(i).setCity(scanner.next());
                        break;
                    case 5:
                        System.out.println("Enter state");
                        Book.get(i).setState(scanner.next());
                        break;
                    case 6:
                        System.out.println("Enter email");
                        Book.get(i).setEmail(scanner.next());
                        break;
                    case 7:
                        System.out.println("Enter Zip");
                        Book.get(i).setZipCode(scanner.nextInt());
                        break;
                    case 8:
                        System.out.println("Enter phone number");
                        Book.get(i).setPhoneNumber(scanner.nextInt());
                        break;
                }

                System.out.println(Book);

            } else
                System.out.println("Enter valid First name");
        }

    }
    public void output() {

        System.out.println(Book);
    }

    public void deleteDetails() {

        System.out.println("Confirm your first name to delete details: ");
        String name = scanner.next();

        for (int i = 0; i < Book.size(); i++) {
            if (Book.get(i).getFirstName().equals(name)) {
                System.out.println("Select form below to change: ");
                //Book.remove(i);
                Book.get(i).setFirstName("");
                Book.get(i).setLastName("");
            }
        }
        System.out.println(Book);
    }

    public void createAddressBook() {

        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println(
                    "1.Create new address book.\n2.Edit existing address book.\n3.Display all address books.\n4.exit");
            int choose = scanner.nextInt();

            if (choose == 4) {
                System.out.println("Exited");
                break;
            }

            switch (choose) {
                case 1:
                    System.out.println("Enter the name of address book: ");
                    String address_name = scanner.next();

                    // condition to check for uniqueness of address book.
                    if (hashmap.containsKey(address_name)) {
                        System.out.println("Address book name exits, enter different name");
                        break;
                    }

                    ArrayList<Contacts> new_address_book = new ArrayList<>();
                    Book = new_address_book;
                    while (true) {
                        int choose1;
                        System.out.println("Choose what you want to do: ");
                        System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                        choose1 = scanner.nextInt();
                        if (choose1 == 4) {
                            System.out.println("Exited");
                            break;
                        }
                        switch (choose1) {
                            case 1:
                                Details.addDetails();
                                break;
                            case 2:
                                Details.editDetails();
                                break;
                            case 3:
                                Details.deleteDetails();
                                break;
                            default:
                                System.out.println("Choose valid option");
                                break;
                        }
                        hashmap.put(address_name, Book);
                        viewMap();
                    }
                    break;

                case 2:
                    System.out.println("Enter the name of address book: ");
                    String address_name_old = scanner.next();

                    // condition to check whether address book exists or no.
                    if (hashmap.containsKey(address_name_old)) {

                        ArrayList<Contacts> old_address_book = new ArrayList<>();
                        Book = old_address_book;
                        Book = hashmap.get(address_name_old);
                        while (true) {
                            System.out.println("Choose what you want to do: ");
                            System.out.println("1.Add details.\n2.Edit details.\n3.Delete contact.\n4.Exit");
                            int choose2 = scanner.nextInt();
                            if (choose2 == 4) {
                                System.out.println("Exited");
                                break;
                            }
                            switch (choose2) {
                                case 1:
                                    Details.addDetails();
                                    addDetails();
                                    break;
                                case 2:
                                    Details.editDetails();
                                    break;
                                case 3:
                                    Details.deleteDetails();
                                    break;
                                default:
                                    System.out.println("Choose valid option");
                                    break;
                            }
                            hashmap.put(address_name_old, Book);
                            viewMap();

                        }
                    } else {
                        System.out.println("Enter valid address book name");
                    }
                    break;

                case 3:
                    viewMap();
                    break;

                default:
                    System.out.println("Enter valid option");

            }
        }
    }
    public void viewAllBooks () {
        for (Contacts book : Book) {
            System.out.println(book);
        }
    }
    public void viewMap(){
        for (String name: hashmap.keySet()) { String key = name;
            String value = hashmap.get(name).toString(); System.out.println(key + " " + value); }
    }

    public static void main(String[] args) {
        Details.createAddressBook();
    }
}