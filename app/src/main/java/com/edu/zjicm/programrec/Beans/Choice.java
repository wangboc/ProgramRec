package com.edu.zjicm.programrec.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Choice {
    private UUID mID;
    private String Header;
    private Date mDate;
    private int mDefaultIndex;
    private ArrayList<ChoiceItem> ChoiceItems;

    public Choice() {
        mID = UUID.randomUUID();
        mDate = new Date();
        ChoiceItems = new ArrayList<>();
        mDefaultIndex = 0;

        for (int i = 0; i < 4; i++) {
            ChoiceItem c = new ChoiceItem();
            c.setmContent("这个节目很有趣，我不太喜欢！");
            c.setmSelected(100);
            ChoiceItems.add(c);
        }
    }

    public UUID getmID() {
        return mID;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public ArrayList<ChoiceItem> getChoiceItems() {
        return ChoiceItems;
    }

    public void setChoiceItems(ArrayList<ChoiceItem> choiceItems) {
        ChoiceItems = choiceItems;
    }

    public int getmDefaultIndex() {
        return mDefaultIndex;
    }

    public void setmDefaultIndex(int mDefaultIndex) {
        this.mDefaultIndex = mDefaultIndex;
    }
}
