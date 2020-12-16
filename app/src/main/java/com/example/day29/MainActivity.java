package com.example.day29;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    /**
     * 主界面
     */
    private TextView mTvMain;
    private ConstraintLayout mC1Main;
    private NavigationView mNvMain;
    private DrawerLayout mD1Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//找控件设置监听
        initListener();

    }

    private void initListener() {
        //设置头部监听
        View headerView = mNvMain.getHeaderView(0);
            //找到header里面的属性
        headerView.findViewById(R.id.img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击图片吐司内容

                Toast.makeText(MainActivity.this, "别摸我", Toast.LENGTH_SHORT).show();
            }
        });
        headerView.findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击图片是
                Toast.makeText(MainActivity.this, "想干啥干啥", Toast.LENGTH_SHORT).show();
            }
        });

        //设置导航条目监听
        mNvMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){
                   case  R.id.imem1:
                       Toast.makeText(MainActivity.this,item.getTitle(), Toast.LENGTH_SHORT).show();
                     break;
                   case R.id.imem2:
                       Toast.makeText(MainActivity.this,item.getTitle(), Toast.LENGTH_SHORT).show();
                       break;
                   case  R.id.imem3:

                       mD1Main.closeDrawer(Gravity.LEFT);
                       break;
               }
                return false;
            }
        });
////设置抽屉监听
        mD1Main.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                Log.e("TAG","抽屉在动");
                int right = drawerView.getRight();
                mC1Main.setX(right);
            }


            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                Log.e("TAG", "抽屉打开");
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                Log.e("TAG", "抽屉关闭");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.e("TAG", "抽屉状态发生改变");
            }
        });
        mTvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //手动打开抽屉
                mD1Main.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTvMain = (TextView) findViewById(R.id.tv_main);
        mNvMain = (NavigationView) findViewById(R.id.nv_main);
        mC1Main = (ConstraintLayout) findViewById(R.id.c1_main);
        mD1Main = (DrawerLayout) findViewById(R.id.d1_main);
        //设置条目图标
        mToolbar.setLogo(R.drawable.ic_pan_tool_black_24dp);
        //各自标题
        mToolbar.setTitle("陈豪杰的好爸爸");
        // mToolbar.setTitleTextColor(#fff);
        mToolbar.setSubtitle("楠楠鸭");
        //设置条目条目正常显示
         mNvMain.setItemIconTintList(null);
//         mToolbar.setNavigationIcon(R.drawable.ic_dialer_sip_black_24dp);
         setSupportActionBar(mToolbar);
         //在toolbar添加开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mD1Main, mToolbar, R.string.app_name, R.string.app_name);
          mD1Main.addDrawerListener(toggle);
      //实线抽屉和toolbar同步
        toggle.syncState();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.imem1:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.imem2:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.imem3:
                Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
