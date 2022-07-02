package ZadDom.PostOffice;

public class Address {

    private String street;
    private String houseNumber;
    private String postalCode;

    public Address(String street, String houseNumber, String postalCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address: " + street + " " + houseNumber + " ," + postalCode;
    }
}
