package org.example.task_5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JSONSerDes {
    //Serialization-Deserialization:
    //a) Make some complex models using your variant.
    //b) Make it serializable.
    //c) Read json from “input.json”
    //d) and deserialize it to POJO.
    //e) Then change a few fields and save it to “output.json”.

    public static void main(String[] args) throws IOException {
        Event event = new Event();
        ArrayList<String> guests = new ArrayList<>();
        guests.add("Alice");
        guests.add("Bob");
        guests.add("David");
        guests.add("Emily");

        event.setName("Birthday party");
        event.setTime("19:45:00");
        event.setGuests(guests);

        Map<String, String> address = new HashMap<>();
        address.put("street", "234 Elm St");
        address.put("city", "Boston");
        address.put("state", "MA");

        System.out.println(event);

        ObjectMapper objectMapper = new ObjectMapper();

        Event event1 = objectMapper.readValue(new File("input.json"), Event.class);
        System.out.println(event1);

        event1.setAddress(address);
        System.out.println(event1);
        objectMapper.writeValue(new File("output.json"), event1);
    }

}
