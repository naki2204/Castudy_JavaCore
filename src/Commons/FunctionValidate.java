package Commons;

import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FunctionValidate {
    public static String checkIdService(Services services, String error){
        Scanner scanner=new Scanner(System.in);
        String idService;
        String regexVilla = "^SVVL([0-9]{4})$";
        String regexHouse = "^SVHO([0-9]{4})$";
        String regexRoom = "^SVRO([0-9]{4})$";
        while (true){
            idService=scanner.nextLine();

                if(services instanceof Villa){
                    if(idService.matches(regexVilla)){
                        return idService;
                    }else {
                        System.out.println(error+". Please enter again...");
                    }
                }else if(services instanceof House){
                    if(idService.matches(regexHouse)){
                        return idService;
                    }else {
                        System.out.println(error+". Please enter again...");
                    }
                }else if(services instanceof Room){
                    if(idService.matches(regexRoom)){
                        return idService;
                    }else {
                        System.out.println(error+". Please enter again...");
                    }
                }
        }
    }
    public static int checkInteger(String error,String regex){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String integer=scanner.nextLine();
                if(integer.matches(regex)){
                    return Integer.parseInt(integer);
                }
            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }
    public static double checkDouble(String error,String regex){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String integer=scanner.nextLine();
                if(integer.matches(regex)){
                    return Double.parseDouble(integer);
                }

            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }
    public static String checkString(String error,String regex){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String integer=scanner.nextLine();
                if(integer.matches(regex)){
                    return integer;
                }else {
                    System.out.println(error+".Please enter again..");
                }

            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }
    public static int inputInteger(String error){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String integer=scanner.nextLine();
                return Integer.parseInt(integer);
            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }
    public static double inputDouble(String error){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String integer=scanner.nextLine();
                return Double.parseDouble(integer);
            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }
    public static double checkAreaUse(String error){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String AreaUse=scanner.nextLine();
                if(Double.parseDouble(AreaUse)>=30){
                    return Double.parseDouble(AreaUse);
                }else {
                    System.out.println(error+".Please enter again..");
                }
            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }
    public static double checkRentalCost(String error){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String rentalCost=scanner.nextLine();
                if(Double.parseDouble(rentalCost)>=0){
                    return Double.parseDouble(rentalCost);
                }else {
                    System.out.println(error+".Please enter again..");
                }
            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }
    public static int checkMaxNumberOfPeople(String error){
        while (true){
            try {
                Scanner scanner=new Scanner(System.in);
                String integer=scanner.nextLine();
                if(Integer.parseInt(integer)<20 && Integer.parseInt(integer)>0){
                    return Integer.parseInt(integer);
                }else {
                    System.out.println(error+".Please enter again..");
                }

            }catch (Exception e){
                System.out.println(error+".Please enter again..");
            }
        }
    }

    public static String checkNameCustomer(String error){
        String nameCustomer="";
        Scanner scanner=new Scanner(System.in);
        nameCustomer=scanner.nextLine();
        String[] str=new String[nameCustomer.length()];
        for (int i=0;i<str.length;i++){
            str[i]= String.valueOf(nameCustomer.charAt(i));
        }
        return nameCustomer;
    }
    public static String checkBirthdayCustomer(){
        while (true){
            Scanner scanner=new Scanner(System.in);
            String regexTime="^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$";
            String birthday=scanner.nextLine();
            if(birthday.matches(regexTime)){
                int day=Integer.parseInt(birthday.substring(0,2));
                int month=Integer.parseInt(birthday.substring(3,5));
                int year=Integer.parseInt(birthday.substring(6,10));
                if(month==4|month==6|month==9|month==11){
                    if(day<31){
                        return birthday;
                    }
                }
                if (month == 2) {
                    if(year%4==0){
                        if(year%100==0){
                            if(year%400==0){
                                if (day<30){
                                    return birthday;
                                }
                            }else {
                                if(day<29){
                                    return birthday;
                                }
                            }
                        }else {
                            if(day<30){
                                return birthday;
                            }
                        }
                    }else {
                        if(day<29){
                            return birthday;
                        }
                    }

                }

            }else {
                System.out.println("Birthday's Customer fail. Please enter again");
            }
        }
    }

}
