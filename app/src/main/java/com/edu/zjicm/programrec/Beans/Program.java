package com.edu.zjicm.programrec.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


public class Program {
    private UUID mId;
    private String mTitle;
    private String mDescription;
    private int mStar;
    private Date mStartTime;
    private Date mEndTime;
    private ArrayList<Comment> mComments;
    private ArrayList<Choice> mChoice;
    private UUID mChannelID;

    public Program(){
        mId = UUID.randomUUID();
        mComments = new ArrayList<>();
        mChoice = new ArrayList<>();

        for(int i = 0; i< 10; i++){
            Comment c = new Comment();
            c.setmDate(new Date());
            c.setmComment("hehe，也就这样吧");
            c.setmTitle("Title");
            c.setmUserName("王博丞");
            mComments.add(c);
        }

        for(int i =  0; i < 3; i++){
            Choice c = new Choice();
            c.setmDate(new Date());
            c.setHeader("你觉得这个节目怎么样?");
            mChoice.add(c);
        }
    }

    public ArrayList<Comment> getComments(){
        return mComments;
    }

    public Comment getSingleComment(UUID id){
        for(Comment c :mComments){
            if(c.getID().equals(id))
                return c;
        }
        return null;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public int getStar() {
        return mStar;
    }

    public void setStar(int mStar) {
        this.mStar = mStar;
    }

    public Date getStartTime() {
        return mStartTime;
    }

    public void setStartTime(Date mStartTime) {
        this.mStartTime = mStartTime;
    }

    public Date getEndTime() {
        return mEndTime;
    }

    public void setEndTime(Date mEndTime) {
        this.mEndTime = mEndTime;
    }

    public UUID getmId() {
        return mId;
    }

    public ArrayList<Choice> getmChoice() {
        return mChoice;
    }

    public void setmChoice(ArrayList<Choice> mChoice) {
        this.mChoice = mChoice;
    }

    public UUID getmChannelID() {
        return mChannelID;
    }

    public void setmChannelID(UUID mChannelID) {
        this.mChannelID = mChannelID;
    }
}
