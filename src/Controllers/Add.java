package Controllers;

import Commons.FunctionReadAndWriteCSVVilla;
import Commons.FunctionReadAndWriteCsvHouse;
import Commons.FunctionReadAndWriteCsvRoom;
import Commons.FunctionValidate;
import Controllers.MainController;
import Models.House;
import Models.Room;
import Models.Services;
import Models.Villa;

import java.util.ArrayList;
import java.util.Scanner;

public class Add {
    MainController mainController=new MainController();
    static Scanner scanner=new Scanner(System.in);
    private Services addNewService(Services services){
        System.out.println("Enter Service's name your choice:");
        String regaxNameService="^[A-Z][a-z]+";
        services.setNameService(FunctionValidate.checkString("Name Service fail",regaxNameService));
        System.out.println("Enter area used: ");
        services.setAreaUse(FunctionValidate.checkAreaUse("Area use fail"));
        System.out.println("Enter rental costs:");
        services.setRentalCost(FunctionValidate.checkRentalCost("Rental Cost fail"));
        System.out.println("Enter maximum number of people for service");
        services.setMaxNumberOfPeople(FunctionValidate.checkMaxNumberOfPeople("maximum number of people for service fail"));
        System.out.println("Type rent: (year or month or day or hour)");
        String regexTypeRent="^(year|month|day|hour)$";
        services.setTypeRent(FunctionValidate.checkString("Type rent fail",regexTypeRent));
        return services;
    }


    public void addVilla(){
        ArrayList<Villa> villaArrayList=new ArrayList<>();
        villaArrayList=FunctionReadAndWriteCSVVilla.readFileCsvToVilla();
        Services villa = new Villa();
        System.out.println("Enter the Id Service: ");
        villa.setId(FunctionValidate.checkIdService(villa,"Id Service fail"));
        villa=addNewService(villa);
        System.out.println("Enter Standard of Room: (Vip or Business or Normal)");
        String regexStandardOfRoom="^(Vip|Business|Normal)$";
        ((Villa)villa).setStandardOfRoom(FunctionValidate.checkString("Standard of room fail",regexStandardOfRoom));
        System.out.println("Enter Convenient Description:");
        ((Villa)villa).setConvenientDescription(scanner.nextLine());
        System.out.println("Enter Area Pool:");
        ((Villa)villa).setAreaPool(FunctionValidate.checkAreaUse("Area 's Pool Fail"));
        System.out.println("Enter Number of Floor:");
        ((Villa)villa).setNumberFloor(FunctionValidate.inputInteger("Number of floor"));
        villaArrayList.add((Villa)villa);
        FunctionReadAndWriteCSVVilla.writeVillaToFileCsv(villaArrayList);
        System.out.println(villa.showInfor());
        mainController.backToMainMenu();
    }

    public void addHouse(){
        ArrayList<House> houseArrayList=new ArrayList<>();
        houseArrayList= FunctionReadAndWriteCsvHouse.readFileCsvToHouse();
        Services house=new House();
        System.out.println("Enter the Id Service: ");
        house.setId(FunctionValidate.checkIdService(house,"Id Service fail"));
        house=addNewService(house);
        System.out.println("Enter Standard of Room:");
        String regexStandardOfRoom="^(Vip|Business|Normal)$";
        ((House)house).setStandardOfRoom(FunctionValidate.checkString("Standard of room fail",regexStandardOfRoom));
        System.out.println("Enter Convenient Description:");
        ((House)house).setConvenientDescription(scanner.nextLine());
        System.out.println("Enter Number of Floor:");
        ((House)house).setNumberFloor(FunctionValidate.inputInteger("Number of floor"));
        FunctionReadAndWriteCsvHouse.writeHouseToFileCsv(houseArrayList);
        System.out.println(house.showInfor());
        mainController.backToMainMenu();
    }

    public void addRoom(){
        ArrayList<Room>roomArrayList=new ArrayList<>();
        roomArrayList=FunctionReadAndWriteCsvRoom.readFileCsvToRoom();
        Services room = new Room();
        System.out.println("Enter the Id Service: ");
        room.setId(FunctionValidate.checkIdService(room,"Id Service fail"));
        room=addNewService(room);
        System.out.println("Free service included: ");
        ((Room)room).setFreeService(scanner.nextLine());
        FunctionReadAndWriteCsvRoom.writeRoomToFileCsv(roomArrayList);
        System.out.println(room.showInfor());
        mainController.backToMainMenu();
    }
}
