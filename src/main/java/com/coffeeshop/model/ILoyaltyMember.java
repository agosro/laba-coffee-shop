package com.coffeeshop.model;

import com.coffeeshop.exception.InvalidPointsException;

public interface ILoyaltyMember {
    void earnPoints(int points) throws InvalidPointsException;
    int getPoints();
}
