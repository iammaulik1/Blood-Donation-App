package com.stepup.blooddonationapp2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.stepup.blooddonationapp2.R;

import java.util.HashMap;
import java.util.List;

public class FaqAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> groupList;
    private HashMap<String, List<String>> childList;

    public FaqAdapter(Context context, List<String> groupList, HashMap<String, List<String>> childList) {
        this.context = context;
        this.groupList = groupList;
        this.childList = childList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String groupKey = groupList.get(groupPosition);
        List<String> childData = childList.get(groupKey);
        return childData != null ? childData.size() : 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String groupKey = groupList.get(groupPosition);
        return childList.get(groupKey).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_group_header, null);
        }
        TextView groupHeaderTextView = convertView.findViewById(R.id.groupHeaderTextView);
        groupHeaderTextView.setText(groupTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_child_item, null);
        }
        TextView childItemTextView = convertView.findViewById(R.id.childItemTextView);
        childItemTextView.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
