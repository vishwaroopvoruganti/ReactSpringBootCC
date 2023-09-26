package com.charter.service;

import org.springframework.stereotype.Service;

@Service
public class RewardService {
    public int calculateRewardPoints(Double amount) {
        int rewardPoints = 0;
        if (amount > 100) {
            rewardPoints += (int) ((amount - 100) * 2);
            amount = 100.0;
        }
        if (amount > 50) {
            rewardPoints += (int) (amount - 50);
        }
        return rewardPoints;
    }
}

