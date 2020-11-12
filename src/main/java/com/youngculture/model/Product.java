package com.youngculture.model;

public class Product {

    private String name;
    private Category category;
    private String description;
    private Double price;

    public Product(String name, Category category, String description, Double price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public static class Builder {

        private String name;
        private Category category;
        private String description;
        private Double price;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCategory(Category category) {
            this.category = category;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(name, category, description, price);
        }
    }
}
