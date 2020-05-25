package Models;

public class House extends Services {
    private String standardOfRoom;
    private String convenientDescription;
    private int numberFloor;

    public House() {
    }

    public House(String id, String nameService, double areaUse, double rentalCost, int maxNumberOfPeople, String typeRent,
                 String standardOfRoom, String convenientDescription, int numberFloor) {
        super(id, nameService, areaUse, rentalCost, maxNumberOfPeople, typeRent);
        this.standardOfRoom = standardOfRoom;
        this.convenientDescription = convenientDescription;
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

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String showInfor() {
        return "Information of House: " +
                "\nId service: "+getId()+
                "\nName's service: "+getNameService()+
                "\nArea used of service: "+getAreaUse()+
                "\nRental costs of service: "+getRentalCost()+
                "\nMaximum number of people for service: "+getMaxNumberOfPeople()+
                "\nType rent: "+getTypeRent()+
                "\nStandard of room for service: "+getStandardOfRoom()+
                "\nConvenient description of service: "+getConvenientDescription()+
                "\nNumber Floor of house service: "+getNumberFloor();
    }
}
