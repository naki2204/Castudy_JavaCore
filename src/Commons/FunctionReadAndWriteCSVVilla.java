package Commons;

import Models.Services;
import Models.Villa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FunctionReadAndWriteCSVVilla {

    protected static final String COMMA_DELIMITER=",";
    protected static final String NEW_LINE_SEPARATOR="\n";
    private static final String fileVilla="src/Data/Villa.csv";//đường dẫn đén nơi lưu file
    private static final String FILE_HEADER_VILLA ="id,nameService,areaUsed,rentalCosts,maxNumberOfPeople,typeRent," +
            "standardOfRoom,convenientDescription,areaPool,numberFloor";
    public static void writeVillaToFileCsv(ArrayList<Villa> villaArrayList){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileVilla);
            fileWriter.append(FILE_HEADER_VILLA);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(Villa villa: villaArrayList){
                fileWriter.append(String.valueOf(villa.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getNameService());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getRentalCost()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getMaxNumberOfPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getTypeRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getStandardOfRoom());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(villa.getConvenientDescription());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getAreaPool()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(villa.getNumberFloor()));
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


    public static ArrayList<Villa> readFileCsvToVilla(){
        ArrayList<Villa> villaArrayList=new ArrayList<Villa>();
        BufferedReader br =null;
        Path path= Paths.get(fileVilla);
        if(!Files.exists(path)){
            try {
                Writer writer=new FileWriter(fileVilla);
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
        try {
            String line;
            br=new BufferedReader(new FileReader(fileVilla));
            while ((line=br.readLine())!=null){
                String[] splitData=line.split(",");
                if(splitData[0].equals("id")){
                    continue;
                }
                Services villa=new Villa();
                villa.setId((splitData[0]));
                villa.setNameService(splitData[1]);
                villa.setAreaUse(Double.parseDouble(splitData[2]));
                villa.setRentalCost(Double.parseDouble(splitData[3]));
                villa.setMaxNumberOfPeople(Integer.parseInt(splitData[4]));
                villa.setTypeRent(splitData[5]);
                ((Villa)villa).setStandardOfRoom(splitData[6]);
                ((Villa)villa).setConvenientDescription(splitData[7]);
                ((Villa)villa).setAreaPool(Double.parseDouble(splitData[8]));
                ((Villa)villa).setNumberFloor(Integer.parseInt(splitData[9]));
                villaArrayList.add((Villa)villa);
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
        return villaArrayList;
    }


}
