package com.example.syllabus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class DataOfCse extends AppCompatActivity  {

    public static  String Extra_Semester="extra message for stream";
    public static String Extra_Subject="extra subject";

    private int  getSemPos ;
    int getSubjPos ;

    TextView description;
    TextView subjectName ;

    String bofece ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_of_cse);

      getSemPos= (int) getIntent().getExtras().get(DataOfCse.Extra_Semester);         // getting the current selected semester positionfrom the list of subject fragment
        Log.d("loka getsemposition",""+getSemPos) ;
        getSubjPos =(int ) getIntent().getExtras().get(DataOfCse.Extra_Subject) ;       // getting the current selected subject postion from the list of subjecr fragment
        Log.d("loka getSubposition",""+getSubjPos) ;

        description =(TextView) findViewById(R.id.description) ;
        subjectName =(TextView) findViewById(R.id.subject) ;



        switch(getSemPos)
        {
            case 0:
                switch (getSubjPos)
                {
                    case 0: bofece = getResources().getString(R.string.sem1_sub1) ;description.setText(bofece);  subjectName.setText("BASICS OF ELECTRICAL AND ELECTRONICS ENGINEERING");break ;
                    case 1: bofece = getResources().getString(R.string.sem1_sub2);description.setText(bofece); subjectName.setText("COMMUTATIVE ENGLISH");break ;
                    case 2: bofece = getResources().getString(R.string.sem1_sub3);description.setText(bofece); subjectName.setText("HUMAN VALUES AND PROFESSIONAL ETHICS");break ;
                    case 3: bofece = getResources().getString(R.string.sem1_sub4);description.setText(bofece); subjectName.setText("MATHEMATICS-1");break ;
                    case 4: bofece = getResources().getString(R.string.sem1_sub5);description.setText(bofece); subjectName.setText("PHYSICS");break ;

                }
                break ;
            case 1:
                switch (getSubjPos)
                {
                    case 0: bofece = getResources().getString(R.string.sem2_sub1) ;description.setText(bofece);  subjectName.setText("CHEMISTRY");break ;
                    case 1: bofece = getResources().getString(R.string.sem2_sub2);description.setText(bofece); subjectName.setText("ENGINEERING GRAPHICS AND DESIGN");break ;
                    case 2: bofece = getResources().getString(R.string.sem2_sub3);description.setText(bofece); subjectName.setText("Environmetal Studies");break ;
                    case 3: bofece = getResources().getString(R.string.sem2_sub4);description.setText(bofece); subjectName.setText("ELEMENTS OF MECHANICAL ENGINEERING");break ;
                    case 4: bofece = getResources().getString(R.string.sem2_sub5);description.setText(bofece); subjectName.setText("FUNDAMENTALS OF COMPUTER ENGINEERING AND IT");break ;
                    case 5: bofece = getResources().getString(R.string.sem2_sub6);description.setText(bofece); subjectName.setText("MATHEMATICS-2");
                }

        }





    }




}
