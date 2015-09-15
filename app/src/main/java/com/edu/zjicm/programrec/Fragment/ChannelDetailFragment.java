package com.edu.zjicm.programrec.Fragment;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.edu.zjicm.programrec.Beans.Channel;
import com.edu.zjicm.programrec.Beans.ChannelManager;
import com.edu.zjicm.programrec.Beans.Comment;
import com.edu.zjicm.programrec.Beans.Program;
import com.edu.zjicm.programrec.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.UUID;


public class ChannelDetailFragment extends Fragment {

    private static final String TAG = "ChannelDetailFragment";
    public static final String EXTRA_Program_ID = "com.edu.zcjicm.programrec.EXTRA_Program_ID";
    public static final String EXTRA_Channel_ID = "com.edu.zcjicm.programrec.EXTRA_Channel_ID";
    private Channel mChannel;
    private Program mProgram;

    public ChannelDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UUID programID = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_Program_ID);
        UUID channelID = (UUID) getActivity().getIntent().getSerializableExtra(EXTRA_Channel_ID);
        mChannel = ChannelManager.get(getActivity()).getChannel(channelID);
        mProgram = mChannel.getProgram(programID);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_channeldetail, container, false);
        String channelTitleStr = getString(R.string.channelTitle);
        String programTitleStr = getString(R.string.programTitle);
        TextView channelTitle = (TextView) v.findViewById(R.id.ivTitleName);
        TextView Program_Title = (TextView) v.findViewById(R.id.ChannelDetail_ProgramTitle);
        TextView Program_Star = (TextView) v.findViewById(R.id.Program_Star);
        Program_Star.setText(String.format(getString(R.string.Program_Star), mProgram.getStar()));
        Program_Title.setText(String.format(programTitleStr, mProgram.getTitle()));
        channelTitle.setText(String.format(channelTitleStr, mChannel.getTitle()));

        final ChoiceViewAdapter adapter = new ChoiceViewAdapter(getActivity());
        ExpandableListView choiceView = (ExpandableListView) v.findViewById(R.id.ChannelDetail_ChoiceGroupListView);
        ListView commentView = (ListView) v.findViewById(R.id.ChannelDetail_CommentGroupListView);
        choiceView.setGroupIndicator(null);
        choiceView.setDividerHeight(0);
        choiceView.setAdapter(adapter);
        final CommentViewAdapter commentAdapter =new CommentViewAdapter(mProgram.getComments());
        commentView.setAdapter(commentAdapter);
        return v;
    }

    private class CommentViewAdapter extends ArrayAdapter<Comment> {
        public CommentViewAdapter(ArrayList<Comment> comments) {
            super(getActivity(), 0, comments);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView==null)
                convertView = getActivity().getLayoutInflater().inflate(R.layout.comment_item, null);
            Comment c = getItem(position);
            TextView commentUserName = (TextView) convertView.findViewById(R.id.Comment_UserName);
            commentUserName.setText(c.getmUserName());
            TextView commentContent = (TextView) convertView.findViewById(R.id.Comment_Content);
            commentContent.setText(c.getmComment());
            TextView commentDate = (TextView) convertView.findViewById(R.id.Comment_Date);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            commentDate.setText(dateFormat.format(c.getmDate()));
            return convertView;
        }
    }


    private class ChoiceViewAdapter extends BaseExpandableListAdapter {
        Activity activity;

        public ChoiceViewAdapter(Activity a) {
            activity = a;
        }


        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            if (convertView == null)
                convertView = getActivity().getLayoutInflater().inflate(R.layout.choice_item, null);

            RadioButton mchoice = (RadioButton) convertView.findViewById(R.id.ChoiceItem);
            mchoice.setText(mProgram.getmChoice().get(groupPosition).getChoiceItems().get(childPosition).getmContent());
            mchoice.setTextColor(Color.BLACK);

            return convertView;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return mProgram.getmChoice().get(groupPosition);
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            int childnum = mProgram.getmChoice().get(groupPosition).getChoiceItems().size();
            return childnum;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return mProgram.getmChoice().get(groupPosition).getChoiceItems().get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public int getGroupCount() {
            int groupCount = mProgram.getmChoice().size();
            return groupCount;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.choice_header, null);
            }
            TextView header = (TextView) convertView.findViewById(R.id.ChoiceItem_Header);
            header.setText(mProgram.getmChoice().get(groupPosition).getHeader());


            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
