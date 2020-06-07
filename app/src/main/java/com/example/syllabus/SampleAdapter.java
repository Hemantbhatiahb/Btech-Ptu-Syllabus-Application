package com.example.syllabus;


import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.TimeoutException;

public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder>  {

    String[] captions ;
    int[] images ;
    private Listner listener ;

    public static interface  Listner{
        public void onClick(int position) ;
    }

    public void setListener(Listner listener)
    {
        this.listener =listener ;
    }


    public SampleAdapter(String captions[],int[] images)                   //constructor that sets the value taken from object declared in MaterialActvity
    {
        this.captions = captions ;
        this.images=images ;

    }


    public  static class ViewHolder extends RecyclerView.ViewHolder     // an inner class extends ViewHolder(that holds the card view )  to display the cardView to screen
    {
        CardView mCardView ;
        public ViewHolder(View itemView)
        {
            super(itemView) ;
            mCardView =(CardView ) itemView ;
            Log.d("logkat","inside ViewHolder method ") ;
        }
    }



    @Override                                                           // to create the card view
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        CardView cardView  = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view,parent,false) ;
        Log.d("logkat","inside onCreateViewHolder method ") ;
        return new ViewHolder(cardView);
    }

    @Override                                           // to populate the view with data
    public void onBindViewHolder(ViewHolder holder, final int position)
    {
        CardView cardView = holder.mCardView ;

        TextView cardText= (TextView) cardView.findViewById(R.id.cardTextView ) ;
        cardText.setText(captions[position]);

        ImageView cardImage= (ImageView) cardView.findViewById(R.id.cardImageView) ;
        Drawable drawable =cardView.getResources().getDrawable(images[position]) ;
        cardImage.setImageDrawable(drawable);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null)
                {
                    listener.onClick(position);
                }
            }
        });


        Log.d("logkat","inside Binder class ") ;
    }

    @Override
    public int getItemCount() {                                                     //get the item count
        return captions.length ;
    }
}
