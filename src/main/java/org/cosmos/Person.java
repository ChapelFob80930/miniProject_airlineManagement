package org.cosmos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Person {
    Random rand= new Random();
    @JsonProperty("id")
    private final int id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("Address")
    private String Address;
    @JsonProperty("contact")
    private String contact;


    public Person(@JsonProperty("id") int id,@JsonProperty("name") String name,@JsonProperty("address") String address,@JsonProperty("contact") String contact) {
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

    public String getContact() {
        return contact;
    }
}
