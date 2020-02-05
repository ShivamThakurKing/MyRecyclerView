package com.example.recyclerview;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ayalma.ir.expandablerecyclerview.ExpandableRecyclerView;

public class ItemRecyclerViewAdapter extends ExpandableRecyclerView.Adapter<ItemRecyclerViewAdapter.ChildViewHolder, ExpandableRecyclerView.SimpleGroupViewHolder,String,String> {
    String[] s1 = {"New","Top","Featured"};
    String[] s = {"one","two","three"};
    String[] s2 = {"one","two"};
    String[] s3 = {"one","two","three","four"};



    @Override
    public int getGroupItemCount() {
        return 2;

    }

    @Override
    public int getChildItemCount(int group) {

        if (group ==1){
            return 2;
        }else if (group == 2){
            return s.length;
        }else if (group ==0){
            return s3.length;
        }else {
            return 0;
        }

    }

    @Override
    public String getGroupItem(int position) {
        return s1[position];
    }

    @Override
    public String getChildItem(int group, int position) {
       // return "group :"+ group + " item :"+ position;

        if (group == 1){

            return s2[position].toString();
        }else if (group ==2){
            return s[position].toString();
        }else if (group ==0){
            return s3[position].toString();
        }
        else {
            return "";
        }

    }
    @Override
    protected ChildViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subitem_row,parent,false);
        TextView textView = rootView.findViewById(R.id.item_name);

        return new ChildViewHolder(rootView);
    }

    @Override
    protected ExpandableRecyclerView.SimpleGroupViewHolder onCreateGroupViewHolder(ViewGroup parent) {
        ExpandableRecyclerView.SimpleGroupViewHolder ch = new ExpandableRecyclerView.SimpleGroupViewHolder(parent.getContext());
        //ch.expand();

        return  ch;

    }



    @Override
    public void onBindGroupViewHolder(ExpandableRecyclerView.SimpleGroupViewHolder holder, int group) {
        super.onBindGroupViewHolder(holder, group);

//        for(int i = 0;i<s1.length;i++){
//            holder.setText(s1[i]);
//        }
       holder.setText(getGroupItem(group));



    }




    @Override
    public void onBindChildViewHolder(ChildViewHolder holder, int group, int position) {
        super.onBindChildViewHolder(holder, group, position);
        expand(group);
       // holder.name.setText(s[position]);
        if (group ==1){

            holder.name.setText(getChildItem(group,position));
            expand(group);


        }
        if (group ==2){
            holder.name.setText(getChildItem(group,position));
            expand(group);
        }
        if (group ==0){
            holder.name.setText(getChildItem(group,position));
            expand(group);
        }
    }

    @Override
    public int getChildItemViewType(int group, int position) {
        return 1;
    }

    public class ChildViewHolder extends RecyclerView.ViewHolder
    {
        private TextView name;
        public ChildViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
