package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PracticalOfCse extends AppCompatActivity {

    public static  String Extra_Semester="extra message for stream";
    public static String Extra_Subject="extra subject";

    private int  getSemPos ;
    int getSubjPos ;

    TextView description;
    TextView practicalName ;

    private String bofece ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_of_cse);

        getSemPos= (int) getIntent().getExtras().get(PracticalOfCse.Extra_Semester);         // getting the current selected semester positionfrom the list of subject fragment
        Log.d("loka getsemposition",""+getSemPos) ;
        getSubjPos =(int ) getIntent().getExtras().get(PracticalOfCse.Extra_Subject) ;       // getting the current selected subject postion from the list of subjecr fragment
        Log.d("loka getSubposition",""+getSubjPos) ;

        description =(TextView) findViewById(R.id.description1) ;
        practicalName =(TextView) findViewById(R.id.subject1) ;



        switch(getSemPos)
        {
            case 0:
                switch (getSubjPos)
                {
                    case 0: bofece = getResources().getString(R.string.sem1_prac1) ;description.setText(bofece);  practicalName.setText("BASICS OF ELECTRICAL AND ELECTRONICS ENGINEERING");break ;
                    case 1: bofece = getResources().getString(R.string.sem1_prac2);description.setText(bofece); practicalName.setText("COMMUTATIVE ENGLISH");break ;
                    case 2: bofece = getResources().getString(R.string.sem1_prac3);description.setText(bofece); practicalName.setText("PHYSICS");break ;
                 }
                break ;
            case 1:
            {
                switch (getSubjPos)
                {
                    case 0: bofece=getResources().getString(R.string.sem2_prac1);description.setText(bofece);  practicalName.setText("CHEMISTRY");break ;
                    case 1: bofece=getResources().getString(R.string.sem2_prac2);description.setText(bofece);  practicalName.setText("Engineering Graphics and Design");break ;
                    case 2: bofece=getResources().getString(R.string.sem2_prac3);description.setText(bofece);  practicalName.setText("Fundamental of Computer Programming and IT"); break ;
                }
            }   break;

        }
    }
}
