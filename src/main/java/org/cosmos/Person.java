package org.cosmos;

import java.util.Random;

public class Person {
    Random rand= new Random();
    private int id;
    private String name;
    private String Address;
    private int contact;



    public String getInfos(){
        return "Id: "+id+"   Name: "+name+"  Address: "+Address+"    Contact: "+contact;
    }
}
