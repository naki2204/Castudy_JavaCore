package Models;

public class Room extends Services {
    private String freeService;

    public Room() {
    }

    public Room(String id, String nameService, double areaUse, double rentalCost, int maxNumberOfPeople,
                String typeRent, String freeService) {
        super(id, nameService, areaUse, rentalCost, maxNumberOfPeople, typeRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
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
                "\nFree service included: "+getFreeService();
    }
}
