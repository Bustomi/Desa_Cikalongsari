package com.kempaka.desa_cikalongsari;

import android.content.Intent;
import android.os.Bundle;

import com.kempaka.desa_cikalongsari.footer.CopyReg;
import com.kempaka.desa_cikalongsari.footer.Dasar_Hukum;
import com.kempaka.desa_cikalongsari.footer.zzzzz;
import com.kempaka.desa_cikalongsari.menu_utama.kesekertariatan;
import com.kempaka.desa_cikalongsari.menu_utama.pokja_i;
import com.kempaka.desa_cikalongsari.menu_utama.pokja_ii;
import com.kempaka.desa_cikalongsari.menu_utama.pokja_iii;
import com.kempaka.desa_cikalongsari.menu_utama.pokja_iv;
import com.kempaka.desa_cikalongsari.menu_utama.profil;
import com.kempaka.desa_cikalongsari.navig.nav1;
import com.kempaka.desa_cikalongsari.navig.nav2;
import com.kempaka.desa_cikalongsari.navig.nav3;

import android.os.Handler;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;
import com.viewpagerindicator.CirclePageIndicator;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public RelativeLayout das,das1;
    public RelativeLayout das2;
    public CardView wahh1,wahh2,wahh3,wahh4,wahh5,wahh6;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.abcd4,R.drawable.abcd5,R.drawable.abcd3};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initSlider();

        wahh1 = (CardView) findViewById(R.id.menu1);
        wahh2 = (CardView) findViewById(R.id.menu2);
        wahh3 = (CardView) findViewById(R.id.menu3);
        wahh4 = (CardView) findViewById(R.id.menu4);
        wahh5 = (CardView) findViewById(R.id.menu5);
        wahh6 = (CardView) findViewById(R.id.menu6);

        das = (RelativeLayout) findViewById(R.id.Daskum);
        das1 = (RelativeLayout) findViewById(R.id.Daskum1);
        das2 = (RelativeLayout) findViewById(R.id.Daskum2);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Bagian Daskum
        das.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Dasar_Hukum.class);
                startActivity(intent);
            }
        });
        das1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, zzzzz.class);
                startActivity(intent);
            }
        });
        das2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CopyReg.class);
                startActivity(intent);
            }
        });
        //Bagian CardView
        wahh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, profil.class);
//                    Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
                startActivity(intent);

            }
        });
        wahh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, kesekertariatan.class);
                startActivity(intent);
            }
        });
        wahh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pokja_i.class);
                startActivity(intent);
            }
        });
        wahh4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pokja_ii.class);
                startActivity(intent);
            }
        });
        wahh5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pokja_iii.class);
                startActivity(intent);
            }
        });
        wahh6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, pokja_iv.class);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    private void initSlider() {
        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImageAdapter(MainActivity.this, ImagesArray));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);
        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent i = new Intent( MainActivity.this, nav1.class );
            startActivity( i );
        }else if (id == R.id.message) {
            Intent i = new Intent( MainActivity.this, nav2.class );
            startActivity( i );
        } else if (id == R.id.nav_gallery) {
            Intent i = new Intent( MainActivity.this, nav3.class );
            startActivity( i );
        }
        else if (id == R.id.nav_slideshow) {
            Intent i = new Intent( MainActivity.this, nav3.class );
            startActivity( i );
        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
