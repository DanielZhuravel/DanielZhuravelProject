package com.example.danielzhuravelproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ScheduleSubjectAdapter extends ArrayAdapter<ScheduleSubject> {

    private Context ctx;
    private int ScheduleSubjectResourceId;
    private List<ScheduleSubject> data;

    public ScheduleSubjectAdapter(@NonNull Context context, int resource, @NonNull List<ScheduleSubject> objects) {
        super(context, resource, objects);
        this.ctx = (ActivitySchedule) context;
        this.ScheduleSubjectResourceId = resource;
        this.data = objects;

    }
    @Override
    public int getCount(){
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = li.inflate(this.ScheduleSubjectResourceId,null);

        ScheduleSubject sb = this.data.get(position);
        TextView tvsubject = v.findViewById(R.id.tvsubjectName);
        tvsubject.setText(sb.getName());
        TextView tvtime = v.findViewById(R.id.tvsubjectNum);
        tvtime.setText(sb.getTime()+"");
        TextView tvdate = v.findViewById(R.id.tvfromwho);
        return v;

    }

}
