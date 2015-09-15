package com.edu.zjicm.programrec.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Choreographer;

import com.edu.zjicm.programrec.R;

import java.util.ArrayList;

public abstract class BaseFragmentActivity extends FragmentActivity {

    protected abstract ArrayList<Fragment> createFragments();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        if(fragment == null)
        {
            ArrayList<Fragment> fragments = createFragments();
            for (int i = 0;i <fragments.size();i++){
                fragment = fragments.get(i);
                fm.beginTransaction().add(R.id.fragmentContainer, fragment).commit();
            }

        }
    }
}
