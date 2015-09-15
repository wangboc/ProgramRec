package com.edu.zjicm.programrec.Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by hoh on 2015/9/9.
 */
public class Channel {

    private UUID mId;
    private String mTitle;
    private String mDescription;
    private int mStar;

    private ArrayList<Program> mPrograms;

    public ArrayList<Program> getPrograms(){
        return mPrograms;
    }

    public Program getProgram(UUID id){
        for(Program p :mPrograms){
            if(p.getmId().equals(id))
                return p;
        }
        return null;
    }

    public Channel(){
        mId = UUID.randomUUID();
        mPrograms = new ArrayList<>();

        for(int i = 0; i<10; i++){
            Program p = new Program();
            p.setStar(5);
            p.setTitle("中国好声音" + i);
            p.setDescription("内容描述");
            p.setStartTime(new Date());
            p.setEndTime(new Date());
            p.setmChannelID(mId);
            mPrograms.add(p);
        }
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

    public UUID getId() {
        return mId;
    }
}
