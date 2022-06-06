package xany.models;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {

    public Event() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "event_attendees_cnt")
    private Integer eventAttendsCnt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Event(String eventName, String eventLocation, Integer eventAttendsCnt) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventAttendsCnt = eventAttendsCnt;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Integer getEventAttendsCnt() {
        return eventAttendsCnt;
    }

    public void setEventAttendsCnt(Integer eventAttendsCnt) {
        this.eventAttendsCnt = eventAttendsCnt;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", eventName='" + eventName + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventAttendsCnt='" + eventAttendsCnt + '\'' +
                '}';
    }
}
