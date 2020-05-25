package Commons;

import Models.Room;
import Models.Services;

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

public class FunctionReadAndWriteCsvRoom {
    ArrayList<Room> roomArrayList=new ArrayList<Room>();
    private static final String fileRoom="src/Data/Room.csv";//đường dẫn đén nơi lưu file
    private static final String FILE_HEADER_ROOM ="id,nameService,areaUsed,rentalCosts,maxNumberOfPeople,typeRent," +
            "freeService";
    public static void writeRoomToFileCsv(ArrayList<Room> roomArrayList){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileRoom);
            fileWriter.append(FILE_HEADER_ROOM);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for(Room room: roomArrayList){
                fileWriter.append(String.valueOf(room.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getNameService());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getAreaUse()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getRentalCost()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(room.getMaxNumberOfPeople()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getTypeRent());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(room.getFreeService());
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


    public static ArrayList<Room> readFileCsvToRoom() {
        ArrayList<Room> roomArrayList=new ArrayList<Room>();
        BufferedReader br = null;
        Path path = Paths.get(fileRoom);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(fileRoom);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        try {
            String line;
            br = new BufferedReader(new FileReader(fileRoom));
            while ((line = br.readLine()) != null) {
                String[] splitData = line.split(",");
                if (splitData[0].equals("id")) {
                    continue;
                }
                Services room = new Room();
                room.setId((splitData[0]));
                room.setNameService(splitData[1]);
                room.setAreaUse(Double.parseDouble(splitData[2]));
                room.setRentalCost(Double.parseDouble(splitData[3]));
                room.setMaxNumberOfPeople(Integer.parseInt(splitData[4]));
                room.setTypeRent(splitData[5]);
                ((Room) room).setFreeService(splitData[6]);
                roomArrayList.add((Room) room);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        return roomArrayList;
    }
}
