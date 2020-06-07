package com.example.syllabus;

public class ItemsContainer {

    private int streamId;
    private String stream ;

    public static void setItemsContainer(ItemsContainer[] itemsContainer) {
        ItemsContainer.itemsContainer = itemsContainer;
    }

    static ItemsContainer itemsContainer[]={
            new ItemsContainer("CSE",R.drawable.cse) ,
            new ItemsContainer("Mechanical",R.drawable.mechanical),
            new ItemsContainer("IT",R.drawable.it),
            new ItemsContainer("ECE",R.drawable.ece)
    };

    public ItemsContainer(String stream,int streamId) {
        this.streamId = streamId;
        this.stream = stream;
    }

    public int getStreamId() {
        return streamId;
    }

    public String getStream() {
        return stream;
    }

}
