package Commons;

import Models.Customer;
import Models.House;
import Models.Services;
import Models.Villa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static Commons.FunctionReadAndWriteCSVVilla.COMMA_DELIMITER;
import static Commons.FunctionReadAndWriteCSVVilla.NEW_LINE_SEPARATOR;

public class FunctionReadAndWriteCsvCustomer {
    private static final String fileCustomer="src/Data/Customer.csv";//đường dẫn đén nơi lưu file
    private static final String FILE_HEADER_CUSTOMER ="nameCustomer,birthdayCustomer,sex,idCustomer,telephoneNumber,email" +
            "typeCustomer,address";
    public static void writeCustomerToFileCsv(ArrayList<Customer> customerArrayList){

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileCustomer);
            fileWriter.append(FILE_HEADER_CUSTOMER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(Customer customer: customerArrayList){
                fileWriter.append(customer.getNameCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getBirthdayCustomer());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getSex());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getIdCustomer()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(customer.getTelephoneNumber()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getEmail());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(customer.getTypeCustomer());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

        }catch (Exception ex){
            System.out.println("Error in CsvFileWriter!!! ");

        }finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception ex){
                System.out.println("Error!!! ");
            }
        }
    }

    public static ArrayList<Customer> readFileCsvToCustomer(){
        ArrayList<Customer> customerArrayList=new ArrayList<Customer>();
        BufferedReader br =null;
        Path path= Paths.get(fileCustomer);
        if(!Files.exists(path)){
            try {
                Writer writer=new FileWriter(fileCustomer);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        try {
            String line;
            br=new BufferedReader(new FileReader(fileCustomer));
            while ((line=br.readLine())!=null){
                String[] splitData=line.split(",");
                if(splitData[0].equals("nameCustomer")){
                    continue;
                }
                Customer customer=new Customer();
                customer.setNameCustomer(splitData[0]);
                customer.setBirthdayCustomer(splitData[1]);
                customer.setSex(splitData[2]);
                customer.setIdCustomer(Integer.parseInt(splitData[3]));
                customer.setTelephoneNumber(Integer.parseInt(splitData[4]));
                customer.setEmail(splitData[5]);
                customer.setTypeCustomer(splitData[6]);
                customer.setAddress(splitData[7]);
                customerArrayList.add(customer);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            try {
                br.close();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        return customerArrayList;
    }
}
