package com.edu.zjicm.programrec.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.zjicm.programrec.Activity.ChannelDetailActivity;
import com.edu.zjicm.programrec.Activity.MainActivity;
import com.edu.zjicm.programrec.Beans.Channel;
import com.edu.zjicm.programrec.Beans.ChannelManager;

import com.edu.zjicm.programrec.R;

import java.util.ArrayList;



public class MainFragment extends Fragment  {

    private static final String TAG = "MainFragment";

    private GridView mChannelGrid;
    private ArrayList<Channel> mChannels;

    public MainFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.app_name);
        mChannels = ChannelManager.get(getActivity()).getChannels();
    }

    private class ChannelAdapter extends ArrayAdapter<Channel> {
        public ChannelAdapter(ArrayList<Channel> channels) {
            super(getActivity(), 0, mChannels);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.channel_item, null);
            }

            Channel c = getItem(position);

            ImageView image = (ImageView) convertView.findViewById(R.id.Channel_Image);

            TextView tTitle = (TextView) convertView.findViewById(R.id.Channel_Title);
            tTitle.setText(c.getTitle().toString());

            TextView tStar = (TextView) convertView.findViewById(R.id.Channel_ClickTimes);
            tStar.setText("点击量：" + c.getStar());
            return convertView;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_main, container, false);
        final ChannelAdapter adapter = new ChannelAdapter(mChannels);
        TextView appTitle = (TextView)v.findViewById(R.id.ivTitleName);
        appTitle.setText(String.format(getString(R.string.channelTitle), "节目推荐"));
        mChannelGrid = (GridView) v.findViewById(R.id.channelgrid);
        mChannelGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Channel c = adapter.getItem(position);
                Intent i = new Intent(getActivity(), ChannelDetailActivity.class);
                i.putExtra(ChannelDetailFragment.EXTRA_Program_ID, c.getPrograms().get(0).getmId());
                i.putExtra(ChannelDetailFragment.EXTRA_Channel_ID, c.getId());
                startActivity(i);
            }
        });
        mChannelGrid.setAdapter(adapter);



        return v;
    }





}
