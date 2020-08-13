package com.pokerhelper.thebest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setupMenu();
    }
    private void init()
    {
        ImageButton iBtnHearts = findViewById(R.id.iBtnHearts);
        ImageButton iBtnDiamonds = findViewById(R.id.iBtnDiamonds);
        ImageButton iBtnClubs = findViewById(R.id.iBtnClubs);
        ImageButton iBtnSpades = findViewById(R.id.iBtnSpades);
    }
    public void onClickClubs(View view)
    {
        
    }
    public void onClickHearts(View view)
    {

    }
    public void onClickDiamonds(View view)
    {

    }
    public void onClickSpades(View view)
    {

    }


    private void setupMenu() {
        FragmentManager fm = getSupportFragmentManager();
        MenuFragmentList mMenuFragment = (MenuFragmentList) fm.findFragmentById(R.id.id_container_menu);
        if (mMenuFragment == null) {
            mMenuFragment = new MenuFragmentList();
            mMenuFragment.setNavItemSelectedListener(this);
            fm.beginTransaction().add(R.id.id_container_menu, mMenuFragment).commit();
        }
    }

    @Override
    public void onNavItemSelctedListener(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
    }
}