package com.androidfragments.activities;


import android.app.Fragment;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.androidfragments.R;
import com.androidfragments.fragments.ItemFragment;
import com.androidfragments.fragments.MyDialogFragment;
import com.androidfragments.fragments.WebFragment;

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private TextView txt_notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        createViews();

    }

    /**
     * create instances of views used in activity
     */
    private void createViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt_notification=(TextView)findViewById(R.id.txt_notification);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fragmentManager = getSupportFragmentManager();

    }


    /**
     * Back button pressed
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     *
     * @param menu
     * @return true if menu is created otherwise false
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_screen, menu);
        return true;
    }

    /**
     *
     * @param item of the menu and perform appropriate action
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * perform actions on diferent items of navigation drawer
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        txt_notification.setVisibility(View.GONE);
        int id = item.getItemId();

      switch (id){
          case R.id.web_fragment:
              fragmentTransaction=fragmentManager.beginTransaction();
              WebFragment webFragment=new WebFragment();
              fragmentTransaction.add(R.id.content_home_screen,webFragment,getString(R.string.web_fragment));

              break;
          case R.id.list_fragment:
              fragmentTransaction=fragmentManager.beginTransaction();
              ItemFragment itemFragment=new ItemFragment();
              fragmentTransaction.add(R.id.content_home_screen,itemFragment,getString(R.string.list_fragment));
              break;
          case R.id.dialog_fragment:
              fragmentTransaction=fragmentManager.beginTransaction();
              MyDialogFragment dialogFragment=new MyDialogFragment();
              fragmentTransaction.add(R.id.content_home_screen,dialogFragment,getString(R.string.dialog_fragment));
              break;
          case R.id.pref_fragment:
              fragmentTransaction=fragmentManager.beginTransaction();
              break;
      }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
