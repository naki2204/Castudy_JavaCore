package Models;

public class Customer {

    private String nameCustomer;
    private String birthdayCustomer;
    private String sex;
    private int idCustomer;
    private int telephoneNumber;
    private String email;
    private String typeCustomer;
    private String address;
    private Services services;

    public Customer() {
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getBirthdayCustomer() {
        return birthdayCustomer;
    }

    public void setBirthdayCustomer(String birthdayCustomer) {
        this.birthdayCustomer = birthdayCustomer;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(int telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String showInfor(){
        return "----Information Customer----" +
                "1.Name Customer: "+getNameCustomer()+
                "2.Birthday's Customer: " +getBirthdayCustomer()+
                "3.Sex: " +getSex()+
                "4.Id Customer: " +getIdCustomer()+
                "5.Telephone Number: " +getTelephoneNumber()+
                "6.Email: " +getEmail()+
                "7.Type Customer: " +getTypeCustomer()+
                "8.Address's Customer: "+getAddress();
    }
}
