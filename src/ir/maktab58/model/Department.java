package ir.maktab58.model;

/**
 * @author Mahsa Alikhani m-58 - pset05 - jdbc Q#1
 */
public class Department {

    private int id;
    private String name;
    private int phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
