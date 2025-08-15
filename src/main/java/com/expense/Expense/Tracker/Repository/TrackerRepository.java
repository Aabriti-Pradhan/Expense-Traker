package com.expense.Expense.Tracker.Repository;

import com.expense.Expense.Tracker.Model.TrackerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TrackerRepository extends JpaRepository<TrackerModel, Integer> {
    List<TrackerModel> findByCategory(String category);
    List<TrackerModel> findByProductName(String productName);
    List<TrackerModel> findByDate(LocalDate date);
    List<TrackerModel> findByAmount(float amount);
    List<TrackerModel> findByProductNameAndAmount(String productName, float amount);
    List<TrackerModel> findByProductNameAndCategory(String productName, String category);
    List<TrackerModel> findByProductNameAndDate(String productName, LocalDate date);
    List<TrackerModel> findByAmountAndDate(float amount, LocalDate date);
    List<TrackerModel> findByCategoryAndAmount(String category, float amount);
    List<TrackerModel> findByCategoryAndDate(String category, LocalDate date);
}
