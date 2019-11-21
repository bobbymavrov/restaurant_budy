package com.group.project.restaurantbuddy;

import java.util.ArrayList;
import java.util.List;

public class CardData {

    private static List<String[]> cardData = new ArrayList<>();

    public static void addToCard(String[] newData){
        cardData.add(newData);
    }

    public static List<String[]> getCardData(){
        return cardData;
    }

    public static boolean emptyCard(){
        cardData.clear();
        if (cardData.isEmpty())
            return true;
        return false;
    }

}
