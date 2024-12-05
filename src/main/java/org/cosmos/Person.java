package org.cosmos;

import java.util.Random;

public class Person {
    Random rand= new Random();
    private final int id;
    private final String name;
    private String Address;
    private int contact;

    public Person(int id, String name, String address, int contact) {
        this.id = id;
        this.name = name;
        this.Address = address;
        this.contact = contact;
    }

    public String getInfos(){
        return "Id: "+id+"/n   Name: "+name+"/n  Address: "+Address+"/n    Contact: "+contact;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getContact() {
        return contact;
    }
}
