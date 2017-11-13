package com.example.ashwin.sqlitearraylist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ashwin on 11/10/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CusViewHolder> {

    ArrayList<Pojo> aa;
    Context c;

    public CustomAdapter(Context context, ArrayList<Pojo> alist){
        c = context;
        aa = alist;
    }

    @Override
    public CustomAdapter.CusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.second_main, parent, false);
        CusViewHolder viewHolder = new CusViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.CusViewHolder holder, int position) {
        Pojo s = aa.get(position);
        String n = s.getName();
        long p = s.getPhno();
        int a = s.getAge();
        String e = s.getEmail();
        int c = s.getCid();

        String str1 = " ";
        String str2 = " ";
        String str3 = " ";
        String str4 = " ";
        String str5 = " ";

        str1 = str1 + n;
        str2 = str2 + p;
        str3 = str3 + a;
        str4 = str4 + e;
        str5 = str5 + c;

        String f = str1+" "+str2+" "+str3+" "+str4+" "+str5;

        holder.t.setText(f);
    }

    @Override
    public int getItemCount() {
        return aa.size();
    }

    public class CusViewHolder extends RecyclerView.ViewHolder {

        public TextView t;

        public CusViewHolder(View itemView) {
            super(itemView);
            t = (TextView)itemView.findViewById(R.id.txtview);
        }
    }
}
