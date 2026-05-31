package ua.opnu.labwork4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String city;
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "building")
    private List<Hall> halls;

    @JsonIgnore
    @OneToMany(mappedBy = "building")
    private List<Event> events;

    public Building() {}

    public Building(Long id, String name, String city, String address) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public List<Hall> getHalls() { return halls; }
    public List<Event> getEvents() { return events; }
}