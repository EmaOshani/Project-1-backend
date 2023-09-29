package com.example.resturent.modal;

import jakarta.persistence.*;

@Entity
@Table(name ="pizza")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "largeprice")
    private Double largeprice;

    @Column(name = "mediumprice")
    private Double mediumprice;

    @Column(name = "smallprice")
    private Double smallprice;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "details")
    private String details;

    @Column(name="quantity")
    private Integer quantity= 1;

    @Column(name ="size" )
    private String size = " Medium,Large,small " ;

    public Pizza() {

    }

    public Pizza(String name, Double price, String imageURL, String details) {
        this.name = name;
        this.largeprice = largeprice;
        this.mediumprice = mediumprice;
        this.smallprice = smallprice;
        this.imageURL = imageURL;
        this.details = details;
        this.quantity = quantity;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLargeprice() {
        return largeprice;
    }

    public void setLargeprice(Double largeprice) {
        this.largeprice = largeprice;
    }

    public Double getMediumprice() {
        return mediumprice;
    }

    public void setMediumprice(Double mediumprice) {
        this.mediumprice = mediumprice;
    }

    public Double getSmallprice() {
        return smallprice;
    }

    public void setSmallprice(Double smallprice) {
        this.smallprice = smallprice;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getQuantity() { return quantity; }
    
    public void setQuantity (Integer quantity) { this.quantity = quantity; }

    public String getSize() { return size; }

    public void setSize (String size )  {this.size = size; }
}
