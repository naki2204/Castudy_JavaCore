package Models;

public abstract class Services {
    private String id;
    private String nameService;
    private double AreaUse;
    private double rentalCost;
    private int maxNumberOfPeople;
    private String typeRent;

    public Services() {
    }

    public Services(String id, String nameService, double areaUse, double rentalCost, int maxNumberOfPeople, String typeRent) {
        this.id = id;
        this.nameService = nameService;
        AreaUse = areaUse;
        this.rentalCost = rentalCost;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.typeRent = typeRent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUse() {
        return AreaUse;
    }

    public void setAreaUse(double areaUse) {
        AreaUse = areaUse;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }
    public abstract String showInfor();

}
