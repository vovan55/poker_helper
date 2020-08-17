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
        ImageButton iBtnHearts2 = findViewById(R.id.iBtnHearts2);
        ImageButton iBtnDiamonds2 = findViewById(R.id.iBtnDiamonds2);
        ImageButton iBtnClubs2 = findViewById(R.id.iBtnClubs2);
        ImageButton iBtnSpades2 = findViewById(R.id.iBtnSpades2);
    }
    public void onClickClubs(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал трефи?", Toast.LENGTH_SHORT).show();

    }
    public void onClickHearts(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал черви?", Toast.LENGTH_SHORT).show();
    }
    public void onClickDiamonds(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал бубны?", Toast.LENGTH_SHORT).show();
    }
    public void onClickSpades(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал пики?", Toast.LENGTH_SHORT).show();
    }
    public void onClickClubs2(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал трефи?", Toast.LENGTH_SHORT).show();
    }
    public void onClickHearts2(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал черви?", Toast.LENGTH_SHORT).show();
    }
    public void onClickDiamonds2(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал бубны?", Toast.LENGTH_SHORT).show();
    }
    public void onClickSpades2(View view)
    {
        Toast.makeText(this, "Зачем ты это нажал пики?", Toast.LENGTH_SHORT).show();
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