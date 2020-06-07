package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class SyllabusActivityCSE extends AppCompatActivity {

    public static String EXTRASEM = "getExtra" ;
    TextView semName ;
    ViewPager mViewPager;
    TabLayout mTabLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus_cse);



        semName = (TextView) findViewById(R.id.semesterName) ;
        mViewPager = (ViewPager) findViewById(R.id.viewPager) ;
        mTabLayout =(TabLayout) findViewById(R.id.tabLayout) ;

        SemesterActivtiy obj1=new SemesterActivtiy();       // reference to obj to call the semesterNO array

        int position= (int)getIntent().getExtras().get(SyllabusActivityCSE.EXTRASEM);   // getting th position of clicked item
        semName.setText(obj1.semesterNo[position]);      // setting the name of semester whose item is clicked

        // reference to fragment to set the semesterId postion

//        ListOfSubjects fragment = (ListOfSubjects)
//                getSupportFragmentManager().findFragmentById(R.id.listFragment);
//        fragment.setsemesterId(position);


        Log.d("loka positon",""+position) ;



        //get refernce to fragment adapter
        TabAdapter adapter  = new TabAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,mTabLayout.getTabCount());

        // attach the viewPager with the view Pager
        mViewPager.setAdapter(adapter);

        //set the listener to tablayout
        //noinspection deprecation
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());    // setting the current tab
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        ListOfSubjects fragment1 = (ListOfSubjects) getSupportFragmentManager().getFragments().get(0);
        fragment1.setsemesterId(position);

        ListsOfPracticals fragment = (ListsOfPracticals) getSupportFragmentManager().getFragments().get(1);
        fragment.setPracticalID(position);

    }

}
