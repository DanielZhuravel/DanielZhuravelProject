package com.example.danielzhuravelproject;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SummarieAdapter extends ArrayAdapter<Summarie> {
    private Context ctx;
    private int SummarieResourceId;
    private List<Summarie> data;

    public SummarieAdapter(@NonNull Context context, int resource, @NonNull List<Summarie> objects) {
        super(context, resource, objects);
        this.ctx = (ActivitySummaries) context;
        this.SummarieResourceId = resource;
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
        View v = li.inflate(this.SummarieResourceId,null);

        Summarie s = this.data.get(position);
        TextView tvsubject = v.findViewById(R.id.tvSubjectname);
        tvsubject.setText(s.getSubject());
        TextView tvgrade = v.findViewById(R.id.tvWhatAbout);
        tvgrade.setText(s.getWhatAbout());
        ImageView imgV = v.findViewById(R.id.imageSubject);
        imgV.setImageBitmap(BitmapFactory.decodeByteArray(s.getImg(),0,s.getImg().length));
        TextView fromwho = v.findViewById(R.id.fromWho);
        fromwho.setText(s.getFromWho());
        return v;

    }
}
