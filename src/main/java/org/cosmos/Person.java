package org.cosmos;

public class Person {
    private final int id;
    private final String name;
    private String address;
    private int contact;

    public Person(int id, String name, String address, int contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getContact() {
        return contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getInfos() {
        return "ID: " + id +
                "\nName: " + name +
                "\nAddress: " + address +
                "\nContact: " + contact;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + id +
                ", Name='" + name + '\'' +
                ", Address='" + address + '\'' +
                ", Contact=" + contact +
                '}';
    }
}
