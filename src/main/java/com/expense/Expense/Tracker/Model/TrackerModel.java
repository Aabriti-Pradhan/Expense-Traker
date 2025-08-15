package com.expense.Expense.Tracker.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class TrackerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //to auto increment id
    public int id;
    public String productName;
    public float amount;
    public String category;
    public LocalDate date;

    public TrackerModel(int id, String productName, float amount, String category, LocalDate date) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public TrackerModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
