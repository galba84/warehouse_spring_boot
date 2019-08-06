package com.warehouse.wh.Entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "StockItem")
public class StockItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Quanity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Article article;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Location location;

    public StockItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Article getArticle() {
        return article;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "StockItem id " + id + " quantity " + quantity + " article " + article.toString() + " location " + location.toString();
    }
}