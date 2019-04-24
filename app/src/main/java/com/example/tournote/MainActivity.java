package com.example.tournote;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFirstFragmentListener{
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

        Log.d("MainActivity Lifecycle", "===== onCreate =====");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MainActivity Lifecycle", "===== onStart =====");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("MainActivity Lifecycle", "===== onRestart =====");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MainActivity Lifecycle", "===== onResume =====");

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("MainActivity Lifecycle", "===== onPause =====");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MainActivity Lifecycle", "===== onStop =====");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("MainActivity Lifecycle", "===== onDestroy =====");

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

    }
}
