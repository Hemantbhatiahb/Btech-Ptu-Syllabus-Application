package com.example.syllabus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle ;
    Toolbar toolbar ;
    NavigationView navigationView ;
    String shareApp  ;         // a string to share the app

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

       RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycleView); // TO set the various stream lists

        Log.d("logkat","inside display activity") ;

        String stream[]= new String[ItemsContainer.itemsContainer.length];

        for(int i=0;i<stream.length ;i++)
        {
            stream[i]= ItemsContainer.itemsContainer[i].getStream();
        }

        int icon[]= new int[ItemsContainer.itemsContainer.length] ;

        for(int i=0;i<icon.length;i++)
        {
            icon[i]= ItemsContainer.itemsContainer[i].getStreamId();
        }

        SampleAdapter sampleAdapter= new SampleAdapter(stream,icon);
        recyclerView.setAdapter(sampleAdapter);                             //adding the adapter with the recycleView

        sampleAdapter.setListener(new SampleAdapter.Listner() {
            @Override
            public void onClick(int position)
            {

                switch (position)
                {
                    case 0 :Intent intent = new Intent(MainActivity.this,SemesterActivtiy.class);
                            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,position) ;
                            startActivity(intent);
                            break ;
                    case 1: Intent intent1 = new Intent(MainActivity.this, SemesterActivityMechanical.class);
                            intent1.putExtra(SemesterActivityMechanical.EXTRA_INTENT,position) ;
                            startActivity(intent1);
                            break ;
                    case 2: Intent intent2 = new Intent(MainActivity.this,SemesterActivityIT.class);
                            intent2.putExtra(SemesterActivityIT.EXTRA_INTENT,position) ;
                            startActivity(intent2);
                            break ;
                    case 3: Intent intent3 = new Intent(MainActivity.this,SemesterActivityECE.class);
                            intent3.putExtra(SemesterActivityECE.EXTRA_INTENT,position) ;
                            startActivity(intent3);
                            break ;

               }
            }
        });


        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
       recyclerView.setLayoutManager(linearLayoutManager);                                      // using the linearLayout can also grid Layout

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
                Intent intent1=new Intent(this,AboutActivity.class) ;
                startActivity(intent1);
                return  true ;
            case R.id.feedbackItem :
                 Intent intent=new Intent(this,CreateFeedBack.class);
                 startActivity(intent);
        }
        return true ;


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
         drawerLayout.closeDrawer(GravityCompat.START);

        Intent intent = new Intent(MainActivity.this,SemesterActivtiy.class);

        if(item.getItemId() == R.id.itemCse)
        {
         intent.putExtra(SemesterActivtiy.EXTRA_INTENT,0) ;startActivity(intent);
        }
        if(item.getItemId() == R.id.itemMechanical)
        {
            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,1);startActivity(intent);
        }
        if(item.getItemId() == R.id.itemIt)
        {
            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,2) ;startActivity(intent);
        }
        if(item.getItemId() == R.id.itemEce )
        {
            intent.putExtra(SemesterActivtiy.EXTRA_INTENT,3) ;startActivity(intent);
        }if(item.getItemId()==R.id.ptuResult)
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

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog= new AlertDialog.Builder(MainActivity.this,R.style.AlertDialog);

        dialog.setTitle("EXIT").
                setIcon(R.drawable.exit_white).
                setMessage("Are you sure you want to exit?").
                setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No",null).
                setCancelable(false)
                ;
        AlertDialog alert=dialog.create() ;

        alert.show();
        alert.getWindow().setLayout(900,500);


    }
}