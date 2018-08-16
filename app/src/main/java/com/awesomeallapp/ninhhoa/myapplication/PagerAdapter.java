package com.awesomeallapp.ninhhoa.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends android.support.v4.view.PagerAdapter {

    private Context context;
    private List<Week> dateTimes = new ArrayList<>();
//    private DateTime date = new DateTime();
//    private DateTime midDate = new DateTime();

    public PagerAdapter(Context context, List<Week> weeks) {
        this.context = context;
        dateTimes = weeks;
//        initData();
    }

//
//    public void initData() {
//        if (midDate != null) {
//            midDate = midDate.withDayOfWeek(DateTimeConstants.THURSDAY);
//        }
//
//        for (int i = -3; i <= 3; i++)
//            dateTimes.add(midDate != null ? midDate.plusDays(i) : null);
//    }

//    private void setData(DateTime date) {
//
//    }
//
//    private DateTime getTodaysDate() {
//        return date;
//    }
//
//    private DateTime getPerviousDate() {
//        return date.plusDays(-7);
//    }
//
//    private DateTime getNextDate() {
//        return date.plusDays(7);
//    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.layout_item_viewpager, container, false);

        RecyclerView recyclerView = layout.findViewById(R.id.rcvItemWeek);
        Week w = dateTimes.get(position);

        recyclerView.setAdapter(new AdapterWeek(w.getDateTimes(), context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));

        container.addView(layout);
        return layout;

    }

    @Override
    public int getCount() {
        return dateTimes.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
