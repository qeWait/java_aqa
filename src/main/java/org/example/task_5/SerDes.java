package org.example.task_5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SerDes {

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

        event.setAddress(address);

        System.out.println(event);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("output.json"), event);


    }

}
