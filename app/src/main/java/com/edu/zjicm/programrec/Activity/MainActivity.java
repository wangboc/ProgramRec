package com.edu.zjicm.programrec.Activity;


import android.support.v4.app.Fragment;

import com.edu.zjicm.programrec.Fragment.ChannelDetailFragment;
import com.edu.zjicm.programrec.Fragment.MainFragment;

import java.util.ArrayList;


public class MainActivity extends BaseFragmentActivity {

    @Override
    protected ArrayList<Fragment> createFragments(){
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new MainFragment());
        return list;
    }



}
