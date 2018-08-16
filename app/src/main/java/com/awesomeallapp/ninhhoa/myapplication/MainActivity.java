package com.awesomeallapp.ninhhoa.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    List<Week> dateTim = new ArrayList<>();
    DateTime date = new DateTime();
    private DateTime dateStart = new DateTime();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        Week week = new Week();
        week.setDateTimes(toDay());
        dateTim.add(week);

        for (int i = 0; i < 5; i++) {
            Week weeks = new Week();
            weeks.setDateTimes(getNextDate());

            dateTim.add(weeks);
        }

        viewPager.setAdapter(new PagerAdapter(MainActivity.this, dateTim));
    }

    private List<DateTime> toDay() {

        List<DateTime> dateTimess = new ArrayList<>();
        DateTime midDate = date;
        if (midDate != null) {
            midDate = midDate.withDayOfWeek(DateTimeConstants.THURSDAY);
        }

        for (int i = -3; i <= 3; i++)
            dateTimess.add(midDate != null ? midDate.plusDays(i) : null);

        return dateTimess;
    }

    private List<DateTime> getNextDate() {
        List<DateTime> dateTimes = new ArrayList<>();
        DateTime midDates = NextDate();

        if (midDates != null) {
            midDates = midDates.withDayOfWeek(DateTimeConstants.THURSDAY);
        }

        for (int i = -3; i <= 3; i++) {
            dateTimes.add(midDates != null ? midDates.plusDays(i) : null);
        }

        return dateTimes;
    }

    private DateTime getTodaysDate() {
        dateStart = date;
        return dateStart;
    }

    private DateTime getPerviousDate() {
        return date.plusDays(-7);
    }

    private DateTime NextDate() {
        dateStart = dateStart.plusDays(7);
        return dateStart;
    }

}
