package com.techelevator.model;

public class UserMealPlan {
    private int userMealPlanId;
    private int createdBy;
    private int mondayBreakfast;
    private int mondayLunch;
    private int mondayDinner;
    private int mondayOther;
    private int tuesdayBreakfast;
    private int tuesdayLunch;
    private int tuesdayDinner;
    private int tuesdayOther;
    private int wednesdayBreakfast;
    private int wednesdayLunch;
    private int wednesdayDinner;
    private int wednesdayOther;
    private int thursdayBreakfast;
    private int thursdayLunch;
    private int thursdayDinner;
    private int thursdayOther;
    private int fridayBreakfast;
    private int fridayLunch;
    private int fridayDinner;
    private int fridayOther;
    private int saturdayBreakfast;
    private int saturdayLunch;
    private int saturdayDinner;
    private int saturdayOther;
    private int sundayBreakfast;
    private int sundayLunch;
    private int sundayDinner;
    private int sundayOther;

    public UserMealPlan(){};

    public UserMealPlan(int userMealPlanId, int createdBy, int mondayBreakfast, int mondayLunch, int mondayDinner, int mondayOther,
                        int tuesdayBreakfast, int tuesdayLunch, int tuesdayDinner, int tuesdayOther,
                        int wednesdayBreakfast, int wednesdayLunch, int wednesdayDinner, int wednesdayOther,
                        int thursdayBreakfast, int thursdayLunch, int thursdayDinner, int thursdayOther,
                        int fridayBreakfast, int fridayLunch, int fridayDinner, int fridayOther,
                        int saturdayBreakfast, int saturdayLunch, int saturdayDinner, int saturdayOther,
                        int sundayBreakfast, int sundayLunch, int sundayDinner, int sundayOther) {

        this.userMealPlanId = userMealPlanId;
        this.createdBy = createdBy;
        this.mondayBreakfast = mondayBreakfast;
        this.mondayLunch = mondayLunch;
        this.mondayDinner = mondayDinner;
        this.mondayOther = mondayOther;
        this.tuesdayBreakfast = tuesdayBreakfast;
        this.tuesdayLunch = tuesdayLunch;
        this.tuesdayDinner = tuesdayDinner;
        this.tuesdayOther = tuesdayOther;
        this.wednesdayBreakfast = wednesdayBreakfast;
        this.wednesdayLunch = wednesdayLunch;
        this.wednesdayDinner = wednesdayDinner;
        this.wednesdayOther = wednesdayOther;
        this.thursdayBreakfast = thursdayBreakfast;
        this.thursdayLunch = thursdayLunch;
        this.thursdayDinner = thursdayDinner;
        this.thursdayOther = thursdayOther;
        this.fridayBreakfast = fridayBreakfast;
        this.fridayLunch = fridayLunch;
        this.fridayDinner = fridayDinner;
        this.fridayOther = fridayOther;
        this.saturdayBreakfast = saturdayBreakfast;
        this.saturdayLunch = saturdayLunch;
        this.saturdayDinner = saturdayDinner;
        this.saturdayOther = saturdayOther;
        this.sundayBreakfast = sundayBreakfast;
        this.sundayLunch = sundayLunch;
        this.sundayDinner = sundayDinner;
        this.sundayOther = sundayOther;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getUserMealPlanId() {
        return userMealPlanId;
    }

    public void setUserMealPlanId(int userMealPlanId) {
        this.userMealPlanId = userMealPlanId;
    }

    public int getMondayBreakfast() {
        return mondayBreakfast;
    }

    public void setMondayBreakfast(int mondayBreakfast) {
        this.mondayBreakfast = mondayBreakfast;
    }

    public int getMondayLunch() {
        return mondayLunch;
    }

    public void setMondayLunch(int mondayLunch) {
        this.mondayLunch = mondayLunch;
    }

    public int getMondayDinner() {
        return mondayDinner;
    }

    public void setMondayDinner(int mondayDinner) {
        this.mondayDinner = mondayDinner;
    }

    public int getMondayOther() {
        return mondayOther;
    }

    public void setMondayOther(int mondayOther) {
        this.mondayOther = mondayOther;
    }

    public int getTuesdayBreakfast() {
        return tuesdayBreakfast;
    }

    public void setTuesdayBreakfast(int tuesdayBreakfast) {
        this.tuesdayBreakfast = tuesdayBreakfast;
    }

    public int getTuesdayLunch() {
        return tuesdayLunch;
    }

    public void setTuesdayLunch(int tuesdayLunch) {
        this.tuesdayLunch = tuesdayLunch;
    }

    public int getTuesdayDinner() {
        return tuesdayDinner;
    }

    public void setTuesdayDinner(int tuesdayDinner) {
        this.tuesdayDinner = tuesdayDinner;
    }

    public int getTuesdayOther() {
        return tuesdayOther;
    }

    public void setTuesdayOther(int tuesdayOther) {
        this.tuesdayOther = tuesdayOther;
    }

    public int getWednesdayBreakfast() {
        return wednesdayBreakfast;
    }

    public void setWednesdayBreakfast(int wednesdayBreakfast) {
        this.wednesdayBreakfast = wednesdayBreakfast;
    }

    public int getWednesdayLunch() {
        return wednesdayLunch;
    }

    public void setWednesdayLunch(int wednesdayLunch) {
        this.wednesdayLunch = wednesdayLunch;
    }

    public int getWednesdayDinner() {
        return wednesdayDinner;
    }

    public void setWednesdayDinner(int wednesdayDinner) {
        this.wednesdayDinner = wednesdayDinner;
    }

    public int getWednesdayOther() {
        return wednesdayOther;
    }

    public void setWednesdayOther(int wednesdayOther) {
        this.wednesdayOther = wednesdayOther;
    }

    public int getThursdayBreakfast() {
        return thursdayBreakfast;
    }

    public void setThursdayBreakfast(int thursdayBreakfast) {
        this.thursdayBreakfast = thursdayBreakfast;
    }

    public int getThursdayLunch() {
        return thursdayLunch;
    }

    public void setThursdayLunch(int thursdayLunch) {
        this.thursdayLunch = thursdayLunch;
    }

    public int getThursdayDinner() {
        return thursdayDinner;
    }

    public void setThursdayDinner(int thursdayDinner) {
        this.thursdayDinner = thursdayDinner;
    }

    public int getThursdayOther() {
        return thursdayOther;
    }

    public void setThursdayOther(int thursdayOther) {
        this.thursdayOther = thursdayOther;
    }

    public int getFridayBreakfast() {
        return fridayBreakfast;
    }

    public void setFridayBreakfast(int fridayBreakfast) {
        this.fridayBreakfast = fridayBreakfast;
    }

    public int getFridayLunch() {
        return fridayLunch;
    }

    public void setFridayLunch(int fridayLunch) {
        this.fridayLunch = fridayLunch;
    }

    public int getFridayDinner() {
        return fridayDinner;
    }

    public void setFridayDinner(int fridayDinner) {
        this.fridayDinner = fridayDinner;
    }

    public int getFridayOther() {
        return fridayOther;
    }

    public void setFridayOther(int fridayOther) {
        this.fridayOther = fridayOther;
    }

    public int getSaturdayBreakfast() {
        return saturdayBreakfast;
    }

    public void setSaturdayBreakfast(int saturdayBreakfast) {
        this.saturdayBreakfast = saturdayBreakfast;
    }

    public int getSaturdayLunch() {
        return saturdayLunch;
    }

    public void setSaturdayLunch(int saturdayLunch) {
        this.saturdayLunch = saturdayLunch;
    }

    public int getSaturdayDinner() {
        return saturdayDinner;
    }

    public void setSaturdayDinner(int saturdayDinner) {
        this.saturdayDinner = saturdayDinner;
    }

    public int getSaturdayOther() {
        return saturdayOther;
    }

    public void setSaturdayOther(int saturdayOther) {
        this.saturdayOther = saturdayOther;
    }

    public int getSundayBreakfast() {
        return sundayBreakfast;
    }

    public void setSundayBreakfast(int sundayBreakfast) {
        this.sundayBreakfast = sundayBreakfast;
    }

    public int getSundayLunch() {
        return sundayLunch;
    }

    public void setSundayLunch(int sundayLunch) {
        this.sundayLunch = sundayLunch;
    }

    public int getSundayDinner() {
        return sundayDinner;
    }

    public void setSundayDinner(int sundayDinner) {
        this.sundayDinner = sundayDinner;
    }

    public int getSundayOther() {
        return sundayOther;
    }

    public void setSundayOther(int sundayOther) {
        this.sundayOther = sundayOther;
    }
}





