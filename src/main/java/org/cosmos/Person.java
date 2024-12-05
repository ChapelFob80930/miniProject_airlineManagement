package org.cosmos;

import java.util.Random;

public class Person {
    Random rand= new Random();
    private int id;
    private String name;
    private String address;
    private int contact;

    public Person(String name, int id, int contact, String address) {
        this.contact = contact;
        this.name = name;
        this.address = address;
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Random getRand() {
        return rand;
    }

    public int getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getInfos(){
        return "Id: "+id+"/n   Name: "+name+"/n  Address: "+address+"/n    Contact: "+contact;
    }
}
