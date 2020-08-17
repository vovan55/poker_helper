package com.pokerhelper.thebest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener{
    TextView textCard1, textCard2;
    String[] card1 = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    String[] card2 = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    String[] big_blinds = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    String[] position = {"EP1", "EP2", "EP3", "MP1", "MP2", "HJ", "CO", "BTN", "SB"};
    Spinner spBB, spPosition, spCard1, spCard2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spBB = (Spinner) findViewById(R.id.spBB);
        final TextView textCard1 = findViewById(R.id.textCard1);
        final ImageView tvBB = findViewById(R.id.tvBB);
        init();
        setupMenu();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, big_blinds);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spBB.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String) parent.getItemAtPosition(position);
                textCard1.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spBB.setOnItemSelectedListener(itemSelectedListener);
    }


    private void init()
    {
        TextView textCard1 = findViewById(R.id.textCard1);
        TextView textCard2 = findViewById(R.id.textCard2);
        ImageButton iBtnHearts = findViewById(R.id.iBtnHearts);
        ImageButton iBtnDiamonds = findViewById(R.id.iBtnDiamonds);
        ImageButton iBtnClubs = findViewById(R.id.iBtnClubs);
        ImageButton iBtnSpades = findViewById(R.id.iBtnSpades);
        ImageButton iBtnHearts2 = findViewById(R.id.iBtnHearts2);
        ImageButton iBtnDiamonds2 = findViewById(R.id.iBtnDiamonds2);
        ImageButton iBtnClubs2 = findViewById(R.id.iBtnClubs2);
        ImageButton iBtnSpades2 = findViewById(R.id.iBtnSpades2);
        ImageView tvBB = findViewById(R.id.tvBB);
        ImageView tvPos = findViewById(R.id.tvPos);
        ImageView tvCard1 = findViewById(R.id.tvCard1);
        ImageView tvCard2 = findViewById(R.id.tvCard2);
        Button btnCalc = findViewById(R.id.btnCalc);
        TextView tvResult = findViewById(R.id.tvResult);
        Spinner spBB = (Spinner) findViewById(R.id.spBB);
        Spinner spPosition = findViewById(R.id.spPosition);
        Spinner spCard1 = findViewById(R.id.spCard1);
        Spinner spCard2 = findViewById(R.id.spCard2);
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