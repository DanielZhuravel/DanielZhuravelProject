package com.example.danielzhuravelproject;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class GradeAdapter extends ArrayAdapter<Grade> {

    private Context ctx;
    private int GradeResourceId;
    private List<Grade> data;

    public GradeAdapter(@NonNull Context context, int resource, @NonNull List<Grade> objects) {
        super(context, resource, objects);
        this.ctx = (ActivityGrades) context;
        this.GradeResourceId = resource;
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
        View v = li.inflate(this.GradeResourceId,null);

        Grade g = this.data.get(position);
        TextView tvsubject = v.findViewById(R.id.tvSubjectname);
        tvsubject.setText(g.getSubject());
        TextView tvgrade = v.findViewById(R.id.tvGradeNum);
        tvgrade.setText(g.getGrade()+"");
        TextView tvdate = v.findViewById(R.id.tvDate);
        tvdate.setText(g.getDate());
        ImageView imgSub = v.findViewById(R.id.imageSubject);
        imgSub.setImageBitmap(g.getImg());
        return v;

    }


}
