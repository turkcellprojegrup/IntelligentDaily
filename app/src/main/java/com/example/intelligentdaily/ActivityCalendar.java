package com.example.intelligentdaily;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;

import java.util.Calendar;

public class ActivityCalendar extends Activity {

    @Override

    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.calendarView);
        simpleCalendarView.setDate(Calendar.getInstance().getTimeInMillis(),false, true);
    }
}
