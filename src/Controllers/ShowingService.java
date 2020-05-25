package Controllers;

import Commons.FunctionReadAndWriteCSVVilla;
import Commons.FunctionReadAndWriteCsvHouse;
import Commons.FunctionReadAndWriteCsvRoom;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.util.ArrayList;

public class ShowingService {
    MainController mainController=new MainController();
    public void showAllVilla(){
        ArrayList<Villa> villaArrayList=new ArrayList<>();
        Services villa=new Villa();
        villaArrayList= FunctionReadAndWriteCSVVilla.readFileCsvToVilla();
        for (int i=0;i<villaArrayList.size();i++){
            System.out.println(villaArrayList.get(i).showInfor());
        }
        mainController.backToMainMenu();
    }

    public void showAllHouse(){
        ArrayList<House> houseArrayList= new ArrayList<>();
        houseArrayList= FunctionReadAndWriteCsvHouse.readFileCsvToHouse();
        for (Services villa:houseArrayList){
            System.out.println(villa.showInfor());
        }
        mainController.backToMainMenu();
    }

    public void showAllRoom(){
        ArrayList<Room>roomArrayList=new ArrayList<>();
        roomArrayList= FunctionReadAndWriteCsvRoom.readFileCsvToRoom();
        for(Services room:roomArrayList){
            System.out.println(room.showInfor());
        }
        mainController.backToMainMenu();
    }
}
