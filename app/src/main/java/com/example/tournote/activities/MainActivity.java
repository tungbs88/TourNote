package com.example.tournote.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tournote.fragments.FirstFragment;
import com.example.tournote.R;
import com.example.tournote.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFirstFragmentListener {
    private static final String TAG = "TourNote_MainActivity";
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle; // Điều khiển đóng|mở Drawer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.activity_main_drawer);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        // Hiện icon menu Drawer (menu back) trên ActionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        FirstFragment firstFragment = new FirstFragment();
        if(findViewById(R.id.contentFrame) != null){
            // Found the ID of only one Fragment ==> Portrait mode
            // Remove the existing fragment before add new one
            if(savedInstanceState != null){
                getSupportFragmentManager().executePendingTransactions();
                Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.contentFrame);
                if(fragmentById != null){
                    getSupportFragmentManager().beginTransaction().remove(fragmentById).commit();
                }
            }
            // Add new one
            getSupportFragmentManager().beginTransaction().add(R.id.contentFrame, firstFragment).commit();
        } else {
            // Landscape mode
            // Remove the existing fragments before add new one
            if (savedInstanceState != null){
                getSupportFragmentManager().executePendingTransactions();
                Fragment firstFragmentById = getSupportFragmentManager().findFragmentById(R.id.firstFrame);
                if(firstFragmentById != null){
                    getSupportFragmentManager().beginTransaction().remove(firstFragment);
                }
                Fragment secondFragmentById = getSupportFragmentManager().findFragmentById(R.id.secondFrame);
                if(secondFragmentById != null){
                    getSupportFragmentManager().beginTransaction().remove(secondFragmentById);
                }
                // Add new one
                getSupportFragmentManager().beginTransaction().add(R.id.firstFrame, firstFragment).commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Đồng bộ ActionBarDrawerToggle với Activity
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch (item.getItemId()){
            case R.id.menu_item_search:
                Toast.makeText(this, "Search button selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_item_about:
                Intent intent = new Intent(this, ContactActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(ContactActivity.KEY_SHOW_WHAT, ContactActivity.VALUE_SHOW_ABOUT);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
            case R.id.menu_item_help:
                intent = new Intent(this, ContactActivity.class);
                bundle = new Bundle();
                bundle.putString(ContactActivity.KEY_SHOW_WHAT, ContactActivity.VALUE_SHOW_HELP);
                intent.putExtras(bundle);
                startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Đồng bộ ActionBarDrawerToggle với Activity
    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        // Sync the toggle state after onRestoreInstanceState has occurred
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onItemPressed(String content) {
        SecondFragment secondFragment = SecondFragment.newInstance(content); // Khởi tạo SecondFragment với ths content truyền vào
        if(findViewById(R.id.contentFrame) != null){
            // Found the ID of only one Fragment ==> Portrait mode
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.contentFrame, secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            // Landscape mode
            getSupportFragmentManager().beginTransaction().replace(R.id.secondFrame, secondFragment).commit();
        }
    }
}
