package com.bmicalculator;

public class BMICategory {

    public String getCategory (double result) {
        String category;
        if (result < 15) {
            category = "very severely underweight";
        } else if (result >=15 && result <= 16) {
            category = "severely underweight";
        } else if (result >16 && result <= 18.5) {
            category = "underweight";
        } else if (result >18.5 && result <= 25) {
            category = "normal ";
        } else if (result >25 && result <= 30) {
            category = "overweight";
        } else if (result >30 && result <= 35) {
            category = "moderately obese";
        } else if (result >35 && result <= 40) {
            category = "severely obese";
        } else {
            category ="very severely obese";
        }
        return category;
    }
    public String getSuggestions (double result) {
        String category;

        if (result < 15) {
            category = " ->In take of rich protein & carbohydrated food.\n ->Avoid foods that are high in sugar & salt. ";
        } else if (result >=15 && result <= 16) {
            category = " ->Eat more frequently. \n ->Choose nutrient rich foods. \n ->Try smoothies anf shakes. ";
        } else if (result >16 && result <= 18.5) {
            category = " ->Eat right \n ->Having an occasional treat \n ->Make every bite count";
        } else if (result >18.5 && result <= 25) {
            category = " ->Continue with your daily exercise";
        } else if (result >25 && result <= 30) {
            category = " -> Focus on eating low. \n ->Eat plenty of dietary fiber.\n ->Consume less sugar foods.";
        } else if (result >30 && result <= 35) {
            category = " ->Engage in regular physical activity. \n ->Avoid eating oil foods.\n ->Maintain food & weight diary.";
        } else if (result >35 && result <= 40) {
            category = " ->Must change you diet plan.\n ->Reduce high calories intake. \n ->Engage in regular physical activity.";
        } else {
            category =" ->Plenty intake of fruits & vegetables.\n ->Intake of low calorie diets.\n ->Engage in regular exercise.";
        }
        return category;
    }
}
