package Controllers;

import Commons.FunctionReadAndWriteCsvCustomer;
import Commons.FunctionValidate;
import Models.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    static Scanner input = new Scanner(System.in);
    public void displayMainMenu(){
        String choice="";
        System.out.println("Main menu: " +
                "\n1.Add New Services." +
                "\n2.Show Services." +
                "\n3.Add New Customer." +
                "\n4.Show Information of Customer." +
                "\n5.Add New Booking." +
                "\n6.Show Information of Employee." +
                "\n7.Exit.");
        switch (choice=input.nextLine()){
            case "1":
                addNewServices();
                break;
            case "2":
                showServices();
                break;
            case "3":
                addNewCustomer();
                break;
            case "4":
                showInformationCustomer();
                break;
            case "5":
                addNewBooking();
                break;
            case "6":
                showInformationEmployee();
                break;
            case "7":
                System.exit(7);
                break;
            default:
                System.out.println("Your choice is not correct.Please enter again...");
               backToMainMenu();
        }
    }

    protected void backToMainMenu(){
        System.out.println("Enter to continue...Back to Main Menu");
        input.nextLine();
        System.out.println("\n---------------------------------------------------------");
        displayMainMenu();
    }

    private void addNewServices() {
        Add add=new Add();
        String choiceService="";
        System.out.println("Main menu add new Service : " +
                "\n1.Add New Villa." +
                "\n2.Add New House." +
                "\n3.Add New Room." +
                "\n4.Back to menu." +
                "\n5.Exit.");
        switch (choiceService=input.nextLine()){
            case "1":
                add.addVilla();
                break;
            case "2":
                add.addHouse();
                break;
            case "3":
                add.addRoom();
                break;
            case "4":
                backToMainMenu();
                break;
            case "5":
                System.exit(5);
                break;
            default:
                System.out.println("Your choice is not correct.Please enter again...");
                System.out.println("Enter to continue...Back to Main Menu");
                input.nextLine();
                System.out.println("\n---------------------------------------------------------");
                addNewServices();
        }
    }

    private void addNewCustomer() {
        ArrayList<Customer> customerArrayList =new ArrayList<>();
        Customer customer=new Customer();
        customerArrayList=FunctionReadAndWriteCsvCustomer.readFileCsvToCustomer();
        System.out.println("Enter information's Customer: ");
        System.out.println("Enter Name Customer: ");
        customer.setNameCustomer(input.nextLine());
        System.out.println("Enter Birthday's Customer: ");
        customer.setBirthdayCustomer(FunctionValidate.checkBirthdayCustomer());
        System.out.println("Enter sex's Customer: ");
        customer.setSex(input.nextLine());
        System.out.println("Enter Id Customer: ");
        String regexIdCustomer="^[0-9]{9}$";
        customer.setIdCustomer(FunctionValidate.checkInteger("Id Customer fail",regexIdCustomer));
        input.nextLine();
        System.out.println("Enter Telephone Number:");
        customer.setTelephoneNumber(input.nextInt());
        input.nextLine();
        System.out.println("Enter Email's Customer: ");
        customer.setEmail(input.nextLine());
        System.out.println("Enter Type Customer: ");
        customer.setTypeCustomer(input.nextLine());
        System.out.println("Enter Address's Customer: ");
        customer.setAddress(input.nextLine());
        customerArrayList.add(customer);
        FunctionReadAndWriteCsvCustomer.writeCustomerToFileCsv(customerArrayList);
        backToMainMenu();
    }

    private void showServices() {
        ShowingService showingService=new ShowingService();
        String choiceShow="";
        System.out.println("Show Information of Service: " +
                "\n1.Show all Villa." +
                "\n2.Show all House." +
                "\n3.Show all Room." +
                "\n4.Show All Name Villa Not Duplicate." +
                "\n5.Show All Name House Not Duplicate." +
                "\n6.Show All Name Room Not Duplicate." +
                "\n7.Back to Menu." +
                "\n8.Exit.");
        switch (choiceShow=input.nextLine()){
            case "1":
                showingService.showAllVilla();
                break;
            case "2":
                showingService.showAllHouse();
                break;
            case "3":
                showingService.showAllRoom();
                break;
            case "4":
                break;
            case "5":
                break;
            case "6":
                break;
            case "7":
                backToMainMenu();
                break;
            case "8":
                System.exit(8);
                break;
            default:
                System.out.println("Your choice is not correct.Please enter again...");
                System.out.println("Enter to continue...Back to Main Menu");
                input.nextLine();
                System.out.println("\n---------------------------------------------------------");
                showServices();
        }

    }

    private void showInformationCustomer() {
        ArrayList<Customer> customerArrayList= new ArrayList<>();
        customerArrayList=FunctionReadAndWriteCsvCustomer.readFileCsvToCustomer();
        for (Customer customer:customerArrayList){
            System.out.println(customer.showInfor());
        }
    }

    private void addNewBooking() {
    }

    private void showInformationEmployee() {
    }

}
