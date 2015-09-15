package com.edu.zjicm.programrec.Beans;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

public class ChannelManager {

    private static ChannelManager sChannelManager;
    private Context mAppContext;

    private ArrayList<Channel> mChannels;

    private ChannelManager(Context AppContext){
        this.mAppContext = AppContext;
        mChannels = new ArrayList<>();

        for(int i = 0; i< 10;i++){
            Channel c = new Channel();
            c.setTitle("浙江电视台，频道" + i);
            c.setDescription("内容描述:");
            c.setStar(5);
            mChannels.add(c);
        }
    }

    public static ChannelManager get(Context c){
        if(sChannelManager == null){
            sChannelManager = new ChannelManager(c.getApplicationContext());
        }
        return sChannelManager;
    }

    public ArrayList<Channel> getChannels() {
        return mChannels;
    }

    public Channel getChannel(UUID id){
        for(Channel c:mChannels)
        {
            if(c.getId().equals(id))
                return c;
        }
        return null;
    }
}
