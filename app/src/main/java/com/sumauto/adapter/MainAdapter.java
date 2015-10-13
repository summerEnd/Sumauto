package com.sumauto.adapter;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.sumauto.bean.MainItemBean;
import com.sumauto.demo.R;
import com.sumauto.demo.databinding.MainAdapterItemBinding;
import com.sumauto.support.utils.NavigationUtil;
import com.sumauto.support.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lincoln on 2015/10/13.
 */
public class MainAdapter extends RecyclerView.Adapter
{
    public static final int TYPE_HEAD = 1;
    public static final int TYPE_ITEM = 2;
    LayoutInflater inflater;
    private ArrayList<MainItemBean> itemBeans = new ArrayList<>();

    public MainAdapter(Context context, List<MainItemBean> itemBeans)
    {
        inflater = LayoutInflater.from(context);
        this.itemBeans.addAll(itemBeans);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        switch (viewType)
        {
            case TYPE_HEAD:
            {
                View itemView = inflater.inflate(R.layout.main_adapter_header, parent, false);
                return new HeadHolder(itemView);
            }
            case TYPE_ITEM:
            {
                View itemView = inflater.inflate(R.layout.main_adapter_item, parent, false);
                DataBindingUtil.bind(itemView);
                return new ItemHolder(itemView);
            }
            default:return null;
        }
    }

    @Override
    public int getItemViewType(int position)
    {
        return position == 0 ? TYPE_HEAD : TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_ITEM)
        {
            MainAdapterItemBinding binding = DataBindingUtil.findBinding(holder.itemView);
            binding.setData(itemBeans.get(position));
        }
        else if (itemViewType == TYPE_HEAD)
        {

        }

    }

    @Override
    public int getItemCount()
    {
        return itemBeans.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ItemHolder(View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v)
        {

            Class<? extends Activity> activity = itemBeans.get(getAdapterPosition()).activity;
            ToastUtils.toast(v.getContext(), activity.getName());
            NavigationUtil.goTo(v.getContext(), activity);
        }
    }

    private class HeadHolder extends RecyclerView.ViewHolder
    {
        public HeadHolder(View itemView)
        {
            super(itemView);
        }
    }
}
