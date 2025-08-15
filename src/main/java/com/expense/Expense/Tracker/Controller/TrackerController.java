package com.expense.Expense.Tracker.Controller;

import com.expense.Expense.Tracker.Model.TrackerModel;
import com.expense.Expense.Tracker.Service.TrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackerController {

    @Autowired
    private TrackerService trackerService;

    @GetMapping("/")
    public String showIndex(){
        return "Welcome to Expense Tracker \n" +
                "1. Type /showAll in the URL to show all expenses listed in the app \n" +
                "2. Type /create in the URL to add a new expense to the list \n" +
                "3. Type /update in the URL to update any listed expense \n" +
                "4. Type /delete in the URL to delete any listed expense \n" +
                "5. Type /custom in the URL to view expense on basis of the chosen date or category or product name";
    }

    @GetMapping("/showAll")
    public List<TrackerModel> showExpenses(){
        return trackerService.extractExpenses();
    }

    @PostMapping("/create")
    public String createExpense(@RequestBody TrackerModel trackerModel){
        return trackerService.createExpense(trackerModel);
    }

    @PostMapping("/update")
    public String updateExpense(@RequestBody TrackerModel trackerModel){
        return trackerService.updateExpense(trackerModel);
    }

    @DeleteMapping("/delete")
    public String deleteExpense(@RequestBody int id){
        return trackerService.deleteExpense(id);
    }

    @GetMapping("/custom")
    public List<TrackerModel> findExpense(TrackerModel trackerModel){
        return trackerService.findExpense(trackerModel);
    }
}
