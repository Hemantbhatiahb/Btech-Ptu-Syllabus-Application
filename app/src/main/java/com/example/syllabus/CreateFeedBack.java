package com.example.syllabus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateFeedBack extends AppCompatActivity {

    EditText feedText ;
    Button sendFeed ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_feed_back);

        feedText = (EditText) findViewById(R.id.feedbackText);
        sendFeed =(Button) findViewById(R.id.sendFeedback) ;

        sendFeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_SEND) ;
                intent.setType("message/html");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"bhatiahemant128@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from user");
                intent.putExtra(Intent.EXTRA_TEXT," "+feedText.getText());
                try {
                    //startActivity(Intent.createChooser(intent, "Send FeedBack.."));
                    startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(CreateFeedBack.this,"Install gmail app for feedback",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
