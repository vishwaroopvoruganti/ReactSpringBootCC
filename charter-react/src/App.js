import React, { useState } from 'react';
import axios from 'axios';

function RewardCalculator() {
    const [customerId, setCustomerId] = useState('');
    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');
    const [totalRewardPoints, setTotalRewardPoints] = useState(null);

    const calculateRewardPoints = () => {
        axios.get(`/api/rewards/customer/${customerId}`)
            .then((response) => {
                setTotalRewardPoints(response.data.totalRewardPoints);
            })
            .catch((error) => {
                console.error('Error calculating reward points:', error);
            });
    };

    return (
        <div>
            <h2>Reward Points Calculator</h2>
            <div>
                <label>Customer ID: </label>
                <input type="text" value={customerId} onChange={(e) => setCustomerId(e.target.value)} />
            </div>
            <div>
                <label>Start Date: </label>
                <input type="date" value={startDate} onChange={(e) => setStartDate(e.target.value)} />
            </div>
            <div>
                <label>End Date: </label>
                <input type="date" value={endDate} onChange={(e) => setEndDate(e.target.value)} />
            </div>
            <button onClick={calculateRewardPoints}>Calculate Reward Points</button>
            {totalRewardPoints !== null && (
                <p>Total Reward Points: {totalRewardPoints}</p>
            )}
        </div>
    );
}

export default RewardCalculator;
