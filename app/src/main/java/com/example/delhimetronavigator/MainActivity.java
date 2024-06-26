package com.example.delhimetronavigator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton imageBtn,imageBtn2,imageBtn3,imageBtn4,imageBtn5,imageBtn6,imageBtn7,imageBtn8,imageBtn9,imageBtn10,imageBtn11,imageBtn12;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportFragmentManager().beginTransaction().add(R.id.fm1,new RemoveAdsFragment()).commit();

        imageBtn=findViewById(R.id.imageBtn);
        imageBtn.setOnClickListener(this);
        imageBtn2=findViewById(R.id.imageBtn2);
        imageBtn2.setOnClickListener(this);
        imageBtn3=findViewById(R.id.imageBtn3);
        imageBtn3.setOnClickListener(this);
        imageBtn4=findViewById(R.id.imageBtn4);
        imageBtn4.setOnClickListener(this);
        imageBtn5=findViewById(R.id.imageBtn5);
        imageBtn5.setOnClickListener(this);
        imageBtn6=findViewById(R.id.imageBtn6);
        imageBtn6.setOnClickListener(this);
        imageBtn7=findViewById(R.id.imageBtn7);
        imageBtn7.setOnClickListener(this);
        imageBtn8=findViewById(R.id.imageBtn8);
        imageBtn8.setOnClickListener(this);
        imageBtn9=findViewById(R.id.imageBtn9);
        imageBtn9.setOnClickListener(this);
        imageBtn10=findViewById(R.id.imageBtn10);
        imageBtn10.setOnClickListener(this);
        imageBtn11=findViewById(R.id.imageBtn11);
        imageBtn11.setOnClickListener(this);
        imageBtn12=findViewById(R.id.imageBtn12);
        imageBtn12.setOnClickListener(this);

        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationView);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.removeads){
                    loadFragment(new RemoveAdsFragment());
                }
                else if (id==R.id.home) {
                  startActivity(new Intent(this, MainActivity.class));
                }
                else if (id==R.id.fare) {
                    loadFragment(new FareFragment());
                }
                else if (id==R.id.map) {
                    loadFragment(new MapFragment());
                }
                else if (id==R.id.route) {
                    loadFragment(new RouteFragment());
                }
                else if (id==R.id.firstlastmetro) {
                    loadFragment(new FirstLastMetroFragment());
                }
                else if (id==R.id.upcomingmetro) {
                    loadFragment(new UpcomingMetroFragment());
                }
                else if (id==R.id.parking) {
                    loadFragment(new ParkingFragment());
                }
                else if (id==R.id.gatesanddirections) {
                    loadFragment(new GatesAndDirectionsFragment());
                }
                else if (id==R.id.cardrecharge) {

                    openWebsite();
                }
                else if (id==R.id.likethisapp) {
                    loadFragment(new LikeThisAppFragment());
                }
                else if (id==R.id.feedback) {
                    loadFragment(new FeedbackFragment());
                }
                else {
                    loadFragment(new AboutFragment());
                }
                drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });



    }

    private void openWebsite() {
        String url = "https://www.dmrcsmartcard.com/"; // Replace with your desired URL
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.container,fragment);
        ft.commit();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.imageBtn){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new RemoveAdsFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn2) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new FareFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn3) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new MapFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn4) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new RouteFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn5) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new FirstLastMetroFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn6) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new UpcomingMetroFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn7) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new ParkingFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn8) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new GatesAndDirectionsFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn9) {

            openWebsite();
        }
        else if (view.getId()==R.id.imageBtn10) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new LikeThisAppFragment()).commit();
        }
        else if (view.getId()==R.id.imageBtn11) {

            getSupportFragmentManager().beginTransaction().replace(R.id.container,new FeedbackFragment()).commit();
        }
        else {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new AboutFragment()).commit();
        }

    }
}