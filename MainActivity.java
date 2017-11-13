package com.example.ashwin.sqlitearraylist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

    EditText name, phno, age, email;
    MyHelper mh;
    TextView tt1, tt2, tt3, tt4, tt5;
   ArrayList<Pojo> alist = new ArrayList<Pojo>();
    //Context context;

  /*  public MainActivity( ArrayList<Pojo> al){
       // this.context = context;
        this.alist = al;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText)findViewById(R.id.editname);
        phno=(EditText)findViewById(R.id.editphno);
        age=(EditText)findViewById(R.id.editage);
        email=(EditText)findViewById(R.id.editemail);
        mh=new MyHelper(this);
        tt1=(TextView)findViewById(R.id.t1);
        tt2=(TextView)findViewById(R.id.t2);
        tt3=(TextView)findViewById(R.id.t3);
        tt4=(TextView)findViewById(R.id.t4);
        tt5=(TextView)findViewById(R.id.t5);

        RecyclerView rv = (RecyclerView) findViewById(R.id.review);
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(lm);
        alist= mh.getdata();
        int z=alist.size();
        Log.i("SIZE", String.valueOf(z));
        CustomAdapter ca = new CustomAdapter(MainActivity.this, alist);
        rv.setAdapter(ca);
    }

    public void add(View view){
        String n = name.getText().toString();
        String p = phno.getText().toString();
        long pp = Long.parseLong(p);
        String a = age.getText().toString();
        int aa = Integer.parseInt(a);
        String e = email.getText().toString();
        if (n.isEmpty() || p.isEmpty() || a.isEmpty() || e.isEmpty()) {
            Message.message(getApplicationContext(), "Enter both name and password");
        }
        else {
            long id = mh.insertdata(n, pp, aa, e);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
                name.setText("");
                phno.setText("");
                age.setText("");
                email.setText("");
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
                name.setText("");
                phno.setText("");
                age.setText("");
                email.setText("");
            }
        }
    }

    public void view(View view)
    {
        alist= mh.getdata();
        /*Log.e("gethere","okkkkkkkk");
        int xx = alist.size();
        String str1 = " ";
        String str2 = " ";
        String str3 = " ";
        String str4 = " ";
        String str5 = " ";
        for (int i=0; i<xx; i++) {
            Pojo pp = alist.get(i);

            String n = pp.getName();
            long p = pp.getPhno();
            int a = pp.getAge();
            String e = pp.getEmail();
            int c = pp.getCid();

Log.i("ii",n);
            Log.i("ii",e);
            Log.i("ii", String.valueOf(p));
            Log.i("ii", String.valueOf(a));
            Log.i("ii", String.valueOf(c));

            str1 = str1 + n;


            str2 = str2 + p;


            str3 = str3 + a;


            str4 = str4 + e;


            str5 = str5 + c;


           /* tt2.setText(str2);
            tt3.setText(str3);
            tt4.setText(str4);
            tt5.setText(str5);*/

         /*  Log.i("no1",str1);
            Log.i("no2",str2);
            Log.i("no3",str3);
            Log.i("no4",str4);
            Log.i("no5",str5);*/



        }
      //  tt1.setText(str1+"/n"+str2+"/n"+str3+"/n"+str4+"/n"+str5);
      /*  Log.i("no1",str1);
        Log.i("no2",str2);
        Log.i("no3",str3);
        Log.i("no4",str4);
        Log.i("no5",str5);*/




}
