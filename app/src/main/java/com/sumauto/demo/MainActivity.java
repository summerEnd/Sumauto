package com.sumauto.demo;

import android.databinding.tool.reflection.SdkUtil;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sumauto.adapter.MainAdapter;
import com.sumauto.bean.MainItemBean;
import com.sumauto.support.android.recyclerview.PaddingItemDecoration;
import com.sumauto.support.utils.SDKUtils;
import com.sumauto.support.utils.SLog;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{

    int titleBackground;
    int dark;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        titleBackground = SDKUtils.getColor(this, R.color.blue_A);
        dark = SDKUtils.getColor(this, R.color.dark_A);

        setContentView(R.layout.content_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new MainAdapter(this, getData()));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration()
        {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
            {
                int childAdapterPosition = parent.getChildAdapterPosition(view);
                if (0 != childAdapterPosition)
                {
                    outRect.set(16, 22, 16, 22);
                }
            }
        });
        recyclerView.setSystemUiVisibility(
                //View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                //| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        );
        //        getWindow().setStatusBarColor(Color.parseColor("#00000000"));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                if (firstVisibleItemPosition == 0)
                {

                    View header = recyclerView.getChildAt(0);
                    SLog.debug("", "top:%d dx=%d dy=%d", header.getTop(), dx, dy);

                    ActionBar actionBar = getSupportActionBar();
                    if (null != actionBar)
                    {
                        int alpha = Math.abs((int) ((-header.getTop() / (float) header.getMeasuredHeight()) * 0xff));

                        recyclerView.setBackgroundColor(ColorUtils.setAlphaComponent(dark,Math.max(0x55,0xff-alpha) ));

                        alpha = Math.max(0, Math.min(alpha, 0xaa));

                        int color = ColorUtils.setAlphaComponent(titleBackground, alpha);
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(color));
                        SDKUtils.setStatusBarColor(getWindow(), color);
                    }
                }
                else
                {

                }
            }
        });
    }

    private List<MainItemBean> getData()
    {
        ArrayList<MainItemBean> itemBeans = new ArrayList<>();
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        itemBeans.add(new MainItemBean(FullscreenActivity.class));
        return itemBeans;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
