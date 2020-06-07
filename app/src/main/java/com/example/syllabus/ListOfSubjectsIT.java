package com.example.syllabus;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class ListOfSubjectsIT extends Fragment {


    ListView lv ;
    private static int semesterId ;             // to get the position of which semester is clicked


    // string arrrays to store the syllabus of different semesters
    String sem1[] ={"Basic of Electrical and Electronics Engineering","Commutative English","Human Values and Professional Ethics","Mathematics-1","Physics"};
    String sem2[] = {"Chemistry","Engineering Graphics and Design","Environmental Studies","Elements of Mechanical Engineering","Fundamentals of Computer Programming and IT","Mathematics-2"} ;
    String sem3[] ={"Computer Architecture","Data Structure","Digital Circuits and Logic Design","Mathematics-3","Object Oriented Programming using C++"} ;
    String sem4[] ={"Computer Networks-1","Discrete Structure","Microprocessor and Assembly Language Programming","Operating System","System Programming "} ;
    String sem5[]={"Computer Networks-2","Cyber Laws and IPR","Database Management System" ,"Programming in JAVA","System Analysis and Design"};
    String sem6[]={"Elective-1","Information Security and Risk Management","Network Programming","Software Engineering","Web Technologies"};
    String sem7[]={"Building Enterprise Application","Elective-2","Elective-3","Software Project Management"} ;
    String  sem8[]={"Semester 8 is training period for 6 months"} ;

    //array Lists that will store all those string arrays
    ArrayList l1,l2,l3,l4,l5,l6,l7 ,l8;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_of_subjects_it, container, false);

        //passing the values of string array to lists
        l1 = new ArrayList(Arrays.asList(sem1)) ;
        l2= new ArrayList(Arrays.asList(sem2));
        l3 = new ArrayList(Arrays.asList(sem3)) ;
        l4= new ArrayList(Arrays.asList(sem4));
        l5 = new ArrayList(Arrays.asList(sem5)) ;
        l6= new ArrayList(Arrays.asList(sem6));
        l7 = new ArrayList(Arrays.asList(sem7)) ;
        l8= new ArrayList(Arrays.asList(sem8));

        Log.d("loka",""+semesterId) ;
 return view ;
    }

    @Override
    public void onStart() {
        super.onStart();
// creating the Arraylist containing lists that contain stringArray
        ArrayList subjectLists[]={l1,l2,l3,l4,l5,l6,l7,l8};


        lv =(ListView) getView().findViewById(R.id.subjectList1) ;       // to get the referece to listView


        ArrayAdapter<ArrayList> arrayAdapter = new ArrayAdapter<ArrayList>(getActivity(),
                android.R.layout.simple_list_item_1,subjectLists[semesterId])
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 19);           // increasing the listItem size
                return textView;
            }
        };

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(getActivity(),DataOfCse.class) ;
                intent.putExtra(DataOfCse.Extra_Subject,position);
                intent.putExtra(DataOfCse.Extra_Semester,semesterId);
                startActivity(intent);

            }
        });

    }

    // setting the semid Position
    public static  void setsemesterId(int semesterId) {
        ListOfSubjectsIT.semesterId =semesterId;

    }

}
