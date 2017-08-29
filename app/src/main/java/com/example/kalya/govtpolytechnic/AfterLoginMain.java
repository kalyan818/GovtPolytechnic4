package com.example.kalya.govtpolytechnic;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.IdRes;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class AfterLoginMain extends AppCompatActivity implements Communicator{
    BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login_main);
        mBottomBar = BottomBar.attach(this,savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId == R.id.Bottombaritemone)
                {
                    Favourite();
                    HomeFragment homeFragment = new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                }else if(menuItemId == R.id.Bottombaritemtwo)
                {
                    Favourite();
                    ProfileFragment profileFragment = new ProfileFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, profileFragment).commit();
                }else if(menuItemId == R.id.Bottombaritemthree)
                {
                    Favourite();
                    AttendenceFragment attendenceFragment = new AttendenceFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, attendenceFragment).commit();
                }else if(menuItemId == R.id.Bottombaritemfour)
                {
                    Favourite();
                    MarksFragment marksFragment = new MarksFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, marksFragment).commit();
                }
            }
            private void Favourite() {
                FrameLayout view = (FrameLayout)findViewById(R.id.frame);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                        R.anim.fade_in);
                view.startAnimation(animation);
            }


            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });

        View view = this.getWindow().getDecorView().findViewById(android.R.id.content);
        mBottomBar.mapColorForTab(0,"#F44336");
        mBottomBar.mapColorForTab(1,"#9C27B0");
        mBottomBar.mapColorForTab(2,"#03A9F4");
        mBottomBar.mapColorForTab(3,"#FF6F00");
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);
        view.startAnimation(animation);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public void respond(String data) {
        Intent intent = new Intent(getApplicationContext(),RetriveMultipleValues.class);
        intent.putExtra("message",data);
        startActivity(intent);
    }
}
