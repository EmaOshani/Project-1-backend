package com.example.resturent.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "burger")

    public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "price")
        private Double price;

        @Column(name = "imageURL")
        private String imageURL;

        @Column(name = "details")
        private String details;

        @Column(name = "quantity")
        private Integer quantity = 1;

        public Burger() {

        }


        public Burger(String name, Double price, String imageURL, String details) {
            this.name = name;
            this.price = price;
            this.imageURL = imageURL;
            this.details = details;
            this.quantity = quantity;
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

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
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
    }



