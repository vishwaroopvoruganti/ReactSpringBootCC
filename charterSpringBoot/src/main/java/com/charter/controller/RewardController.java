package com.charter.controller;

import com.charter.model.Transaction;
import com.charter.repository.TransactionRepository;
import com.charter.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RewardService rewardService;

    @GetMapping("/customer/{customerId}")
    public Map<String, Integer> calculateRewardPoints(@PathVariable Long customerId,
                                                      @RequestParam(required =  false) LocalDate startDate,
                                                      @RequestParam(required =  false) LocalDate endDate) {
        startDate = startDate != null ? startDate: LocalDate.now().minusMonths(6);
        endDate = endDate != null ? endDate: LocalDate.now();

        List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(
                customerId, startDate, endDate);

        int totalRewardPoints = transactions.stream()
                .mapToInt(transaction -> rewardService.calculateRewardPoints(transaction.getAmount()))
                .sum();

        Map<String, Integer> result = new HashMap<>();
        result.put("totalRewardPoints", totalRewardPoints);

        return result;
    }
}

