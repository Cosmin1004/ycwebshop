package com.youngculture.utils;

import com.youngculture.model.Category;

public class CategoryUtil {

    private final static String[] automotive = {"AUTOMOTIVE", "cars", "car", "drive"};
    private final static String[] clothingAndShoes = {"CLOTHING_AND_SHOES", "clothingAndShoes", "clothes", "shoes", "fashion"};
    private final static String[] computers = {"COMPUTERS", "pc", "mouse", "laptop"};
    private final static String[] phones = {"PHONES", "phone", "smartphone", "mobile"};
    private final static String[] electronics = {"ELECTRONICS", "tv", "smart-tv"};
    private final static String[] food = {"FOOD", "pizza", "burger"};
    private final static String[] healtyAndBeauty = {"HEALTH_AND_BEAUTY", "healtyAndBeauty", "cream", "parfume", "healty", "beauty"};
    private final static String[] homeAndGarden = {"HOME_AND_GARDEN", "homeAndGarden", "table", "flowers", "furniture", "home", "garden"};

    public static Category processCategory(String categoryFromFile) {
        Category category;

        if (containsWords(categoryFromFile, automotive)) {
            category = Category.AUTOMOTIVE;
        } else if (containsWords(categoryFromFile.
                replaceAll("_", " "), clothingAndShoes)) {
            category = Category.CLOTHING_AND_SHOES;
        } else if (containsWords(categoryFromFile, computers)) {
            category = Category.COMPUTERS;
        } else if (containsWords(categoryFromFile, electronics)) {
            category = Category.ELECTRONICS;
        } else if (containsWords(categoryFromFile, phones)) {
            category = Category.PHONES;
        } else if (containsWords(categoryFromFile.
                replaceAll("_", " "), healtyAndBeauty)) {
            category = Category.HEALTH_AND_BEAUTY;
        } else if (containsWords(categoryFromFile, food)) {
            category = Category.FOOD;
        } else if (containsWords(categoryFromFile.
                replaceAll("_", " "), homeAndGarden)) {
            category = Category.HOME_AND_GARDEN;
        } else {
            category = Category.UNKNOWN;
        }
        return category;
    }

    public static boolean containsWords(String inputString, String[] items) {
        boolean found = false;
        for (String item : items) {
            if (inputString.toLowerCase()
                    .contains(item.toLowerCase())) {
                found = true;
                break;
            }
        }
        return found;
    }


}
