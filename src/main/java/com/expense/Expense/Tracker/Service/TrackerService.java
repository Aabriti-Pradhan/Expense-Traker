package com.expense.Expense.Tracker.Service;

import com.expense.Expense.Tracker.Model.TrackerModel;
import com.expense.Expense.Tracker.Repository.TrackerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrackerService {

    @Autowired
    private TrackerRepository trackerRepository;

    public List<TrackerModel> extractExpenses() {
        return trackerRepository.findAll();
    }

    public String createExpense(TrackerModel trackerModel) {
        trackerRepository.save(trackerModel);
        return "Created Successfully";
    }

    /*the update model takes the existing data from the database and updates on it
    through repository rather than deleting and inserting a whole new row*/

    public String updateExpense(TrackerModel trackerModel) { //deserializes the JSON format input and keeps in memory as TrackerModel object
        TrackerModel exists;
        try{
            exists = trackerRepository.findById(trackerModel.getId()).orElseThrow(); //fetches the row with that ID from the database
        }catch (Exception e){
            return "Enter the correct ID";
        }

        /*
        if statements below to not override the existing value with null
        */

        if(trackerModel.getProductName() != null){
            exists.setProductName(trackerModel.getProductName()); //updating the product name
        }
        if(trackerModel.getAmount() != 0){
            exists.setAmount(trackerModel.getAmount()); //updating the amount
        }
        if(trackerModel.getCategory() != null){
            exists.setCategory(trackerModel.getCategory()); //updating the category
        }
        if(trackerModel.getDate() != null){
            exists.setDate(trackerModel.getDate()); //updating the date
        }

        trackerRepository.save(exists); //saving the already existing database row with new value
        return "Updated Successfully";
    }

    public String deleteExpense(int id) {
        TrackerModel exists;
        try{
            exists = trackerRepository.findById(id).orElseThrow();
        }
        catch (Exception e){
            return "Enter the correct ID";
        }

        trackerRepository.delete(exists);
        return "Deleted Successfully";
    }

    public List<TrackerModel> findExpense(TrackerModel trackerModel) {
        List<TrackerModel> fetchedProduct = new ArrayList<>();
        if(trackerModel.getId() != 0 ){
            try{
                TrackerModel exists = trackerRepository.findById(trackerModel.getId()).orElseThrow();
                fetchedProduct.add(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting id from findExpense");
                return null;
            }
        }
        if (trackerModel.getProductName() != null) {
            try {
                List<TrackerModel> exists = trackerRepository.findByProductName(trackerModel.getProductName());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting product name from findExpense");
                return null;
            }
        }

        if (trackerModel.getCategory() != null) {
            try {
                List<TrackerModel> exists = trackerRepository.findByCategory(trackerModel.getCategory());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting category from findExpense");
                return null;
            }
        }

        if (trackerModel.getDate() != null) {
            try {
                List<TrackerModel> exists = trackerRepository.findByDate(trackerModel.getDate());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting date from findExpense");
                return null;
            }
        }

        if (trackerModel.getAmount() != 0) {
            try {
                List<TrackerModel> exists = trackerRepository.findByAmount(trackerModel.getAmount());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting amount from findExpense");
                return null;
            }
        }

        if (trackerModel.productName != null && trackerModel.getAmount() !=0) {
            try {
                List<TrackerModel> exists = trackerRepository.findByProductNameAndAmount(trackerModel.getProductName(),trackerModel.getAmount());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting product name and amount from findExpense");
                return null;
            }
        }

        if (trackerModel.productName != null && trackerModel.getCategory() != null) {
            try {
                List<TrackerModel> exists = trackerRepository.findByProductNameAndCategory(trackerModel.getProductName(),trackerModel.getCategory());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting product name and category from findExpense");
                return null;
            }
        }

        if (trackerModel.productName != null && trackerModel.getDate() != null) {
            try {
                List<TrackerModel> exists = trackerRepository.findByProductNameAndDate(trackerModel.getProductName(),trackerModel.getDate());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting product name and date from findExpense");
                return null;
            }
        }

        if (trackerModel.amount != 0 && trackerModel.getDate() != null) {
            try {
                List<TrackerModel> exists = trackerRepository.findByAmountAndDate(trackerModel.getAmount(),trackerModel.getDate());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting amount and date from findExpense");
                return null;
            }
        }

        if (trackerModel.category != null && trackerModel.getDate() != null) {
            try {
                List<TrackerModel> exists = trackerRepository.findByCategoryAndDate(trackerModel.getCategory(),trackerModel.getDate());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting category and date from findExpense");
                return null;
            }
        }

        if (trackerModel.category != null && trackerModel.getAmount() != 0) {
            try {
                List<TrackerModel> exists = trackerRepository.findByCategoryAndAmount(trackerModel.getCategory(),trackerModel.getAmount());
                fetchedProduct.addAll(exists);
            }
            catch (Exception e){
                System.out.println("problem in getting category and amount from findExpense");
                return null;
            }
        }

        return fetchedProduct;
    }
}
