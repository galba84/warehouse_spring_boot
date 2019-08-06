package com.warehouse.wh.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "RowNumber", nullable = false)
    private int rowNumber;
    @Column(name = "PlaceNumber", nullable = false)
    private int placeNumber;

    public Location() {
    }

    public Location(int rowNumber, int placeNumber) {
        this.rowNumber = rowNumber;
        this.placeNumber = placeNumber;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    @Override
    public String toString() {
        return "id " + id + " row number " + rowNumber + " placeNumber " + placeNumber;
    }
}