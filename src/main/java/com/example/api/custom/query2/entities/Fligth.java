package com.example.api.custom.query2.entities;

import javax.persistence.*;

@Table
@Entity
public class Fligth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String fromAirport;
    private String toAirport;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Fligth(){}

    public Fligth(String description, String fromAirport, String toAirport, Status status) {
        this.description=description;
        this.fromAirport=fromAirport;
        this.toAirport=toAirport;
        this.status=status;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public void setToAirport(String toAirport) {
        this.toAirport = toAirport;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
