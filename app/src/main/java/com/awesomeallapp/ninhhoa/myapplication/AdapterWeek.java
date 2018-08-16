package com.awesomeallapp.ninhhoa.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdapterWeek extends RecyclerView.Adapter<AdapterWeek.ViewHolder> {
    List<DateTime> dateTimes;
    List<String> names = new ArrayList<>();
    private Context context;

    public AdapterWeek(List<DateTime> dateTimes, Context context) {
        this.context = context;
        this.dateTimes = dateTimes;
        names.add("T2");
        names.add("T3");
        names.add("T4");
        names.add("T5");
        names.add("T6");
        names.add("T7");
        names.add("cn");
    }

    public void setWeek(List<DateTime> dateWeek) {
        dateTimes.addAll(dateWeek);
        notifyDataSetChanged();
    }

    @Override
    public AdapterWeek.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_week, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterWeek.ViewHolder viewHolder, int i) {
        viewHolder.tvNameDay.setText(names.get(i));
        viewHolder.tvDay.setText(dateTimes.get(i).getDayOfMonth() + "");
        if (dateTimes.get(i).getDayOfMonth() == getDayOfMonth() && dateTimes.get(i).getMonthOfYear() == getfMonth()) {
            viewHolder.tvDay.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }

        if (dateTimes.get(i).getDayOfMonth() > getDayOfMonth() && dateTimes.get(i).getMonthOfYear() != getfMonth()) {
            viewHolder.tvDay.setTextColor(context.getResources().getColor(R.color.cologray));
        }
    }

    public static int getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth;
    }

    public static int getfMonth() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.MONTH);
        return dayOfMonth + 1;
    }

    @Override
    public int getItemCount() {
        return dateTimes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNameDay;
        TextView tvDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tvDay);
            tvNameDay = itemView.findViewById(R.id.tvNameDay);
        }
    }
}
