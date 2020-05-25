package Commons;

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

public class FunctionReadAndWriteCsvHouse {
//    private static final String COMMA_DELIMITER=",";
//    private static final String NEW_LINE_SEPARATOR="\n";
    private static final String fileHouse="src/Data/House.csv";//đường dẫn đén nơi lưu file
    private static final String FILE_HEADER_ROOM ="id,nameService,areaUsed,rentalCosts,maxNumberOfPeople,typeRent," +
            "standardOfRoom,convenientDescription,numberFloor";
    public static void writeHouseToFileCsv(ArrayList<House>houseArrayList){

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileHouse);
            fileWriter.append(FILE_HEADER_ROOM);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(House house: houseArrayList){
                fileWriter.append(String.valueOf(house.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getNameService());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getRentalCost()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getMaxNumberOfPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getTypeRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getStandardOfRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(house.getConvenientDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(house.getNumberFloor()));
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

    public static ArrayList<House> readFileCsvToHouse(){
        ArrayList<House> houseArrayList=new ArrayList<House>();
        BufferedReader br =null;
        Path path= Paths.get(fileHouse);
        if(!Files.exists(path)){
            try {
                Writer writer=new FileWriter(fileHouse);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        try {
            String line;
            br=new BufferedReader(new FileReader(fileHouse));
            while ((line=br.readLine())!=null){
                String[] splitData=line.split(",");
                if(splitData[0].equals("id")){
                    continue;
                }
                Services house=new House();
                house.setId((splitData[0]));
                house.setNameService(splitData[1]);
                house.setAreaUse(Double.parseDouble(splitData[2]));
                house.setRentalCost(Double.parseDouble(splitData[3]));
                house.setMaxNumberOfPeople(Integer.parseInt(splitData[4]));
                house.setTypeRent(splitData[5]);
                ((House)house).setStandardOfRoom(splitData[6]);
                ((House)house).setConvenientDescription(splitData[7]);
                ((House)house).setNumberFloor(Integer.parseInt(splitData[8]));
                houseArrayList.add((House) house);
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
        return houseArrayList;
    }
}
