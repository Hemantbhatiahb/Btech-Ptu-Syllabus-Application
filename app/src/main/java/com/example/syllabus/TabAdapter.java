package com.example.syllabus;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdapter extends FragmentPagerAdapter {

    int tabCount ;

    public TabAdapter(@NonNull FragmentManager fm, int behavior,int tabCount) {
        super(fm, behavior);
        this.tabCount =tabCount ;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 : return new ListOfSubjects();
            case 1 : return  new ListsOfPracticals();
            default: return null ;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}


