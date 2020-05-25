package Models;

public class Villa extends Services {
    private String standardOfRoom;
    private String convenientDescription;
    private double AreaPool;
    private int numberFloor;

    public Villa() {
    }

    public Villa(String id, String nameService, double areaUse, double rentalCost, int maxNumberOfPeople,
                 String typeRent, String standardOfRoom, String convenientDescription, double areaPool, int numberFloor) {
        super(id, nameService, areaUse, rentalCost, maxNumberOfPeople, typeRent);
        this.standardOfRoom = standardOfRoom;
        this.convenientDescription = convenientDescription;
        AreaPool = areaPool;
        this.numberFloor = numberFloor;
    }

    public String getStandardOfRoom() {
        return standardOfRoom;
    }

    public void setStandardOfRoom(String standardOfRoom) {
        this.standardOfRoom = standardOfRoom;
    }

    public String getConvenientDescription() {
        return convenientDescription;
    }

    public void setConvenientDescription(String convenientDescription) {
        this.convenientDescription = convenientDescription;
    }

    public double getAreaPool() {
        return AreaPool;
    }

    public void setAreaPool(double areaPool) {
        AreaPool = areaPool;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String showInfor() {
        return "Information of Villa: " +
                "\nId service: "+getId()+
                "\nName's service: "+getNameService()+
                "\nArea used of service: "+getAreaUse()+
                "\nRental costs of service: "+getRentalCost()+
                "\nMaximum number of people for service: "+getMaxNumberOfPeople()+
                "\nType rent: "+getTypeRent()+
                "\nStandard of room for service: "+getStandardOfRoom()+
                "\nConvenient description of service: "+getConvenientDescription()+
                "\nArea pool: "+getAreaPool()+
                "\nNumber Floor of villa service: "+getNumberFloor();
    }
}
