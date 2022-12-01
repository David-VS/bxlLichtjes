package be.ehb.bxllichtjes.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class EventDAOMock {

    private static ArrayList<Event> events;

    public static ArrayList<Event> getEvents() {
        if(events == null){
            new EventDAOMock();
        }
        return events;
    }

    private EventDAOMock(){
        Event e1 = new Event(new LatLng(50.858712, 4.347446),
                "Kaaitheater",
                "Op deze locatie vaart elk uur een boot rond met een geweldige show vol vuurwerk en pyrotechnics",
                EventType.INTERACTIVE);

        Event e2 = new Event(new LatLng(50.860215, 4.350880),
                "Maximiliaan park",
                "De meesters van projectormapping stellen hier tal van interactieve projecties op",
                EventType.INTERACTIVE);

        Event e3 = new Event(new LatLng(50.863994, 4.349828),
                "magasin 4",
                "De dansliefhebbers kunnen hier de genieten van vette beats met bijhorende lasershow",
                EventType.PROJECTION);

        Event e4 = new Event(new LatLng(50.846777, 4.352360),
                "Grote markt",
                "De geschiedenis van Brussel wordt aan de hand van een lichtshow belicht",
                EventType.PROJECTION);

        Event e5 = new Event(new LatLng(50.8555038,4.3499145),
                "Koninklijke Vlaamse Schouwburg",
                "De sportievelingen kunnen zich hier uitleven met een spannende wedstrijd lasertag",
                EventType.INTERACTIVE);
        events = new ArrayList<>();
        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
        events.add(e5);
    }
}
