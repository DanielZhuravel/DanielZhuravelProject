package com.example.danielzhuravelproject;

import android.graphics.Bitmap;

public class ScheduleSubject {
    private int hourNum;
    private String name;
    private static String[] times = {
            "1) 08:25-09:10",
            "2) 09:15-10:00",
            "3) 10:15-11:00",
            "4) 11:05-11:50",
            "5) 12:00-12:45",
            "6) 12:50-13:35",
            "7) 13:45-14:30",
            "8) 14:30-15:15",
            "9) 15:15-16:00"
    };

    public String getTime(){
        return times[hourNum-1];
    }

    public ScheduleSubject(int hourNum, String name) {
        this.hourNum = hourNum;
        this.name = name;
    }

    public ScheduleSubject() {
    }

    public int getHourNum() {
        return hourNum;
    }

    public void setHourNum(int hourNum) {
        this.hourNum = hourNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
