package com.example.syllabus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SemesterActivityECE extends AppCompatActivity {

    public static  String EXTRA_INTENT ="items" ;
    TextView StreamName ;
    public String semesterNo []={"Semester 1","Semester 2",
            "Semester 3","Semester 4",
            "Semester 5","Semester 6",
            "Semester 7","Semester 8"};

    ListView  mListView ;
    int itemNo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester_ece);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);          //enable the back button to get to parent activity

        itemNo  = (Integer) getIntent().getExtras().get(SemesterActivtiy.EXTRA_INTENT);

        StreamName = (TextView) findViewById(R.id.streamName);
        StreamName.setText(ItemsContainer.itemsContainer[itemNo].getStream());

        List<String> listofname = new ArrayList<>(Arrays.asList(semesterNo));                  // passing the string array to string

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(SemesterActivityECE.this,
                android.R.layout.simple_list_item_1, listofname) {

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                TextView textView = (TextView) super.getView(position, convertView, parent);

                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22);           // increasing the listItem size
//                // Set the list view item's text color
//                textView.setTextColor(Color.parseColor("#FF3E80F1"));
//
//                // Set the item text style to bold
//                textView.setTypeface(textView.getTypeface(), Typeface.BOLD);

                return textView;
            }
        };

        mListView = (ListView) findViewById(R.id.lists);                 // getting reference to list View
        mListView.setAdapter(arrayAdapter);                            // settig the adapter with the listView


        // set the onItemClickListener
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
//                Intent intent = new Intent(SemesterActivityECE.this, SyllabusActivityCSE.class);
//                intent.putExtra(SyllabusActivityCSE.EXTRASEM, position);
//                startActivity(intent);
            }
        });

    }
}
