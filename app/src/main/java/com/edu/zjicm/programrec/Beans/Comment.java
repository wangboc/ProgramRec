package com.edu.zjicm.programrec.Beans;

import android.media.Image;

import java.util.Date;
import java.util.UUID;

public class Comment {
    private UUID mID;
    private int mProgramID;
    private int mChannelID;
    private String mTitle;
    private String mComment;
    private Date mDate;
    private Image mHeadImage;
    private String mUserName;

    public Comment(){
        mID = UUID.randomUUID();
        mDate = new Date();
    }
    public UUID getID() {
        return mID;
    }

    public int getmProgramID() {
        return mProgramID;
    }

    public void setmProgramID(int mProgramID) {
        this.mProgramID = mProgramID;
    }

    public int getmChannelID() {
        return mChannelID;
    }

    public void setmChannelID(int mChannelID) {
        this.mChannelID = mChannelID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmComment() {
        return mComment;
    }

    public void setmComment(String mComment) {
        this.mComment = mComment;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public Image getmHeadImage() {
        return mHeadImage;
    }

    public void setmHeadImage(Image mHeadImage) {
        this.mHeadImage = mHeadImage;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }
}
