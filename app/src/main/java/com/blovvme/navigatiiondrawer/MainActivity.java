package com.blovvme.navigatiiondrawer;

import android.support.v7.app.ActionBarActivity;//trying it out
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
//import android.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //To call the CamFragActivity
        //Para que uno de los fragmentos trabaje como Main Activity

        WebFragActivity w = new WebFragActivity();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.mainXml,w).addToBackStack(null).commit();
        //fm.beginTransaction().replace(R.id.mainXml,w).addToBackStack(null).commit();
//
//        CamFragActivity cfa = new CamFragActivity();
//        FragmentManager fm = getSupportFragmentManager();
//        fm.beginTransaction().replace(R.id.mainXml,cfa).commit();


    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //OverFlow Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //OverFlow Menu Continuation
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.overflow_home) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainXml,new WebFragActivity()).addToBackStack(null).commit();
            Toast.makeText(this,"Home OverFlow",Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Camera Fragment", Toast.LENGTH_LONG).show();

        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.overflow_camera) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.mainXml,new CamFragActivity()).addToBackStack(null).commit();
                Toast.makeText(this,"Camera OverFlow",Toast.LENGTH_SHORT).show();
                //Toast.makeText(this,"Camera Fragment", Toast.LENGTH_LONG).show();

        } else if (id == R.id.overflow_emi){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainXml,new EmiFragActivity()).addToBackStack(null).commit();
            Toast.makeText(this,"EMI Fragment",Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Camera Fragment", Toast.LENGTH_LONG).show();
            return true;//overflow camera
        } else if (id == R.id.overflow_web){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainXml,new WebFragActivity()).addToBackStack(null).commit();
            Toast.makeText(this,"WebView Fragment", Toast.LENGTH_SHORT).show();
            //Toast.makeText(this,"Camera Fragment", Toast.LENGTH_LONG).show();
        };


        return super.onOptionsItemSelected(item);
    }


    //Navigator Drawer Menu
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            //Call from drawer to CamFracActiviy
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainXml, new CamFragActivity()).addToBackStack(null).commit();
            Toast.makeText(this, "Camera Fragment", Toast.LENGTH_SHORT).show();
        }
      else if (id == R.id.nav_emi){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainXml,new EmiFragActivity()).addToBackStack(null).commit();
            Toast.makeText(this,"EMI Fragment", Toast.LENGTH_SHORT).show();
        }
       else if (id == R.id.nav_web){
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.mainXml,new WebFragActivity()).addToBackStack(null).commit();
            Toast.makeText(this,"WebView Fragment", Toast.LENGTH_SHORT).show();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
