package org.example.task_5;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTask {

    //a) Generate 10 random object using class from previous class
    //b) Sort it using any two fields using stream.
    //b) Filter it by any two fields custom filter.
    //c) Collect it to List with *main field(s).

    public static void main(String[] args){
        int n = 10;
        if (args.length > 0) {
            try {
                n = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.out.println("Can`t convert args[0] to integer: " + args[0]);
                e.printStackTrace();
            }
        }

        //a) Generate 10 random object using class from previous class
        List<Event> events = generateEvents(n);
        System.out.println(events);

        //b) Sort it using any two fields using stream.
        System.out.println(events.stream().sorted(Comparator.comparing(Event::getTime)).collect(Collectors.toList()));

        //b) Filter it by any two fields custom filter.
        System.out.println(events.stream().filter(u -> u.getTime().startsWith("15")).collect(Collectors.toList()));

        //c) Collect it to List with *main field(s).
        System.out.println(events.stream().map(Event::getTime).collect(Collectors.toList()));
    }

    public static List<Event> generateEvents(int n){
        List<Event> Events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Random rand = new Random();
            int randomStreetNum = rand.nextInt((200 - 10) + 1) + 10;
            int randomMinute = rand.nextInt((60 - 10) + 1) + 1;
            int randomHour = rand.nextInt((24 - 10) + 1) + 1;

            ArrayList<String> guests = new ArrayList<>();
            guests.add("Bob "+i);
            guests.add("Emily "+i);
            guests.add("David "+i);

            Map<String, String> address = new HashMap<>();
            address.put("street", randomStreetNum + " Elm St");
            address.put("city", "Boston");
            address.put("state", "MA");

            Events.add(new Event("Hello world "+i, randomHour+":"+randomMinute+":00", guests, address));
        }
        return Events;
    }
}
