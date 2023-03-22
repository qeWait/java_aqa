package org.example.task_5;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XMLSerDes {

    //Serialization-Deserialization:
    //a) Make some complex models using your variant.
    //b) Make it serializable.
    //c) Read json from “input.xml”
    //d) and deserialize it to POJO.
    //e) Then change a few fields and save it to “output.xml”.

    public static void main(String[] args) throws IOException {
        Event event = new Event();
        ArrayList<String> guests = new ArrayList<>();
        guests.add("Bob");
        guests.add("Emily");
        guests.add("David");

        event.setName("Birthday party 2");
        event.setTime("22:55:00");
        event.setGuests(guests);

        Map<String, String> address = new HashMap<>();
        address.put("street", "234 Elm St");
        address.put("city", "Boston");
        address.put("state", "MA");

        System.out.println(event);

        XmlMapper xmlMapper = new XmlMapper();

        Event event1 = xmlMapper.readValue(new File("input.xml"), Event.class);
        System.out.println(event1);

        event1.setAddress(address);
        System.out.println(event1);
        xmlMapper.writeValue(new File("output.xml"), event1);
    }
}
