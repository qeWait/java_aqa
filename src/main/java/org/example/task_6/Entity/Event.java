package org.example.task_6.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Event implements Serializable {

    @JsonProperty("event")
    @JacksonXmlProperty()
    private String name;
    private String time;
    private ArrayList<String> guests;
    private Map address;

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", guests=" + guests +
                ", address=" + address +
                '}';
    }

    public Event() {}

    public Event(String name, String time, ArrayList<String> guests, Map address) {
        this.name = name;
        this.time = time;
        this.guests = guests;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<String> getGuests() {
        return guests;
    }

    public void setGuests(ArrayList<String> guests) {
        this.guests = guests;
    }

    public Map getAddress() {
        return address;
    }

    public void setAddress(Map address) {
        this.address = address;
    }
}
