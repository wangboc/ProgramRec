package com.edu.zjicm.programrec.Beans;

import java.util.UUID;

public class ChoiceItem {
    private UUID mID;
    private String mContent;
    private int mSelected;

    public ChoiceItem(){
        mID = UUID.randomUUID();
        mSelected = 0;
    }

    public UUID getmID() {
        return mID;
    }

    public void setmID(UUID mID) {
        this.mID = mID;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public int getmSelected() {
        return mSelected;
    }

    public void setmSelected(int mSelected) {
        this.mSelected = mSelected;
    }
}
