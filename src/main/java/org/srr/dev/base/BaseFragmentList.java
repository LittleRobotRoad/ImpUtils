package org.srr.dev.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import org.srr.dev.adapter.RecyclerViewDataAdapter;
import org.srr.dev.view.xrecyclerview.JRecyclerView;
import org.srr.dev.view.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * Created by Cainer on 2016/5/3.
 */
public abstract class BaseFragmentList<DataType,VH extends RecyclerView.ViewHolder> extends BaseFragment implements
        XRecyclerView.LoadingListener, SwipeRefreshLayout.OnRefreshListener {
    private XRecyclerView mRecyclerList;
    private SwipeRefreshLayout srl;
    public JRecyclerView jRecyclerView;

    public MyAdapter adapter=new MyAdapter();
    private ArrayList<DataType> mData;


    @Override
    public abstract int getLayoutId() ;

    @Override
    protected abstract void initView(View contentView);

    @Override
    protected abstract void initData();

    @Override
    public abstract void doAfterReConnectNewWork();

    @Override
    protected void initRec() {
        jRecyclerView=initJrec();
        mRecyclerList=jRecyclerView.getRecyclerView();
        srl=jRecyclerView.getSwipeRefreshLayout();
        initrecs();
        mData=getmDatalist();
        adapter.setData(mData);
        mRecyclerList.setAdapter(adapter);
        mRecyclerList.setLayoutManager(setLayoutManager());

    }

    private void initrecs() {
        mRecyclerList.setLoadingListener(this);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipRefresh();
            }
        });
    }

    protected abstract void swipRefresh();

    @Override
    public void onRefresh() {
    }


    protected abstract RecyclerView.LayoutManager setLayoutManager();

    protected abstract JRecyclerView initJrec();

    /*

     */
    protected abstract ArrayList<DataType> getmDatalist();
    /**
     *
     * @return
     */
    protected abstract int getItemLayout();

    /**
     *
     * @return
     */
    protected abstract VH getViewMyViewHolder(View v);

    /*

     */
    protected abstract void onBindAdapterHolder(VH holder, int i, DataType dataType);
    public void dismiss()
    {
        srl.setRefreshing(false);
    }

    public class MyAdapter extends RecyclerViewDataAdapter<DataType,VH>
    {

        @Override
        public void onBindHolder(VH holder, int i, DataType dataType) {
            onBindAdapterHolder(holder,i,dataType);
        }

        @Override
        public VH getViewHolder(View v) {
            return getViewMyViewHolder(v);
        }

        @Override
        public int getLayoutId(int viewType) {
            return getItemLayout();
        }
    }

}
