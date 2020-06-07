package com.example.syllabus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Random extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle ;
    Toolbar toolbar ;
    NavigationView navigationView ;
    String shareApp  ;         // a string to share the app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        toolbar =(Toolbar) findViewById(R.id.Toolbar);
        setSupportActionBar(toolbar);                               // setting the actionBar to use toolbar it will help in getting menu items
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout) ;
        navigationView =(NavigationView) findViewById(R.id.nav_view) ;




        // to set the Navigation view Visible and list to actionBarDrawerToggle
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close) ;

        drawerLayout.addDrawerListener(toggle);    //setting the drawerLayout to listen to toggle
        toggle.setDrawerIndicatorEnabled(true);      // enable the toggle to get visible as hamburger sign
        toggle.syncState();                             //sync between open and closse state

        navigationView.setNavigationItemSelectedListener(this);   // for calling the navigation selected  listener and handling the clicks


        shareApp= getString(R.string.sendData) ;




    }


    // SETTING THE MENU BAR ON TOOLBAR AND HANDLING ITEM CLICK
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater() ;

        menuInflater.inflate(R.menu.menu_main,menu);
        // toolbar.inflateMenu(R.menu.menu_main);
        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.shareItem :
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain") ;
                sendIntent.putExtra(Intent.EXTRA_TEXT,shareApp) ;
                Intent shareIntent = Intent.createChooser(sendIntent,"PtU Syllabus App") ;        // createChooser method to create a dialog box everytime when the button is clicked and if there is not any app that will take the message return a error message
                startActivity(shareIntent);
                return true ;
            case R.id.aboutItem :
                Toast.makeText(this,"This app is created by Hemant Bhatia",Toast.LENGTH_LONG).show();
                return  true ;
            case R.id.feedbackItem :
                Intent intent=new Intent(this,CreateFeedBack.class);
                startActivity(intent); case R.id.ptuResult :
        }
        return true ;


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        Intent intent = new Intent(Random.this,SemesterActivtiy.class);

        if(item.getItemId() == R.id.itemCse)
        {
            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,0) ;   startActivity(intent);
        }
        if(item.getItemId() == R.id.itemMechanical)
        {
            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,1);   startActivity(intent);
        }
        if(item.getItemId() == R.id.itemIt)
        {
            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,2) ;   startActivity(intent);
        }
        if(item.getItemId() == R.id.itemEce )
        {
            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,3) ;   startActivity(intent);
        }
        if(item.getItemId()==R.id.ptuResult)
        {
            Uri uri1 = Uri.parse("http://www.m.ptuexam.com/LoginMe.aspx"); // creating the url for result webpage
            Intent intent1=new Intent(Intent.ACTION_VIEW,uri1) ;             // creating the intent and passing the url
            startActivity(intent1) ;
        }
        if(item.getItemId()==R.id.ptuOfficialwebsite)
        {
            Uri uri2 = Uri.parse("http://www.ptu.ac.in/") ;
            Intent intent2 =new Intent(Intent.ACTION_VIEW,uri2) ;
            startActivity(intent2);
        }
        return false;
    }
}
