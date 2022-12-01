package be.ehb.bxllichtjes.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Event implements Serializable {

    private LatLng position;
    private String name;
    private String description;
    private EventType type;

    public Event() {
    }

    public Event(LatLng position, String name, String description, EventType type) {
        this.position = position;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}
