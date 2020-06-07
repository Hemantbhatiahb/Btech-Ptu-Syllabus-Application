package com.example.syllabus;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
import java.util.List;

public class ListsOfPracticals extends Fragment {

    String sem1[] ={"Basics of Electrical and Electronics Engineering","Commutative English","Physics"};
    String sem2[] = {"Chemistry","Engineering Graphics and Design","Fundamentals of Computer Programming and IT"} ;
    String sem3[] ={"Data Structure","Digital Circuits and Logic Design","Object Oriented Programming using C++"} ;
    String sem4[] ={"Computer Networks-1","Microprocessor and Assembly Language Programming","Operating System","System Programming "} ;
    String sem5[]={"Computer Graphics","Computer Networks-2","Design and Analysis of Algorithm","Relational Database and Management System"};
    String sem6[]={"Web Technologies","Simulation and Modeling Lab","Software Engineering","Relational Database and Management System-2"};
    String sem7[]={"Artificial Intelligence"} ;
    String  sem8[]={"Semester 8 is training period for 6 months"} ;

    ArrayList l1,l2,l3,l4,l5,l6,l7,l8 ;
    ListView lv ;
    private static int practicalID ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_lists_of_practicals, container, false);

        //passing the values of string array to lists
        l1 = new ArrayList(Arrays.asList(sem1)) ;
        l2= new ArrayList(Arrays.asList(sem2));
        l3 = new ArrayList(Arrays.asList(sem3)) ;
        l4= new ArrayList(Arrays.asList(sem4));
        l5 = new ArrayList(Arrays.asList(sem5)) ;
        l6= new ArrayList(Arrays.asList(sem6));
        l7 = new ArrayList(Arrays.asList(sem7)) ;
        l8= new ArrayList(Arrays.asList(sem8));


        return view ;
    }

    @Override
    public void onStart() {
        super.onStart();
        // creating the Arraylist containing lists that contain stringArray
        ArrayList praticallists[]={l1,l2,l3,l4,l5,l6,l7,l8};


        lv =(ListView) getView().findViewById(R.id.practicalsList) ;       // to get the referece to listView


        ArrayAdapter<ArrayList> mArrayAdapter = new ArrayAdapter<ArrayList>(getActivity(),
                android.R.layout.simple_list_item_1,praticallists[practicalID])
            {
                @NonNull
                @Override
                public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                TextView textView = (TextView) super.getView(position, convertView, parent);
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 19);           // increasing the listItem size
                return textView;
            }
            };


        lv.setAdapter(mArrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(getActivity(),PracticalOfCse.class) ;
                intent.putExtra(PracticalOfCse.Extra_Subject,position);
                intent.putExtra(PracticalOfCse.Extra_Semester,practicalID);
                startActivity(intent);

            }
        });

    }

    public static void setPracticalID(int practicalID)
    {
        ListsOfPracticals.practicalID=practicalID;
    }

}
