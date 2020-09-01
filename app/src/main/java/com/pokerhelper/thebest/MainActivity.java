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
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener{
    TextView textCard1, textCard2;
    String suit, suit_2;
    String[] card1 = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    String[] card2 = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"};
    String[] big_blinds = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
    String[] position = {"EP1", "EP2", "EP3", "MP1", "MP2", "HJ", "CO", "BTN", "SB"};
    Spinner spPos, spCard_1, spCard_2;
    NumberPicker numberPicker;
    ImageView tvCard1, tvCard2;
    private ImageButton iBtnHearts, iBtnDiamonds, iBtnSpades, iBtnClubs, iBtnHearts2, iBtnDiamonds2, iBtnSpades2, iBtnClubs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setupMenu();

/*        ArrayAdapter<String> adapter_bb = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, big_blinds);
        adapter_bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spBB.setAdapter(adapter_bb);

        AdapterView.OnItemSelectedListener itemSelectedListener_bb = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String) parent.getItemAtPosition(position);
                //tvEnterBB.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spBB.setOnItemSelectedListener(itemSelectedListener_bb);*/

        ArrayAdapter<String> adapter_pos = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, position);
        adapter_pos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPos.setAdapter(adapter_pos);

        AdapterView.OnItemSelectedListener itemSelectedListener_pos = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String) parent.getItemAtPosition(position);
                //tvEnterPos.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        };
        spPos.setOnItemSelectedListener(itemSelectedListener_pos);
    }

    private void init()
    {   numberPicker = (NumberPicker) findViewById(R.id.spBB);
        numberPicker.setMaxValue(20);
        numberPicker.setMinValue(0);
        spPos = (Spinner) findViewById(R.id.spPos);
        //tvEnterBB = findViewById(R.id.tvEnterBB);
        //tvEnterPos = findViewById(R.id.tvEnterPos);
        spCard_1 = findViewById(R.id.spCard_1);
        spCard_2 = findViewById(R.id.spCard_2);
        iBtnHearts = findViewById(R.id.iBtnHearts);
        iBtnDiamonds = findViewById(R.id.iBtnDiamonds);
        iBtnClubs = findViewById(R.id.iBtnClubs);
        iBtnSpades = findViewById(R.id.iBtnSpades);
        iBtnHearts2 = findViewById(R.id.iBtnHearts2);
        iBtnDiamonds2 = findViewById(R.id.iBtnDiamonds2);
        iBtnClubs2 = findViewById(R.id.iBtnClubs2);
        iBtnSpades2 = findViewById(R.id.iBtnSpades2);
        ImageView tvCard1 = findViewById(R.id.tvCard1);
        ImageView tvCard2 = findViewById(R.id.tvCard2);
        Button btnCalc = findViewById(R.id.btnCalc);
        TextView tvResult = findViewById(R.id.tvResult);

    }


    public void onClickClubs(View view)
    {
        suit = "clubs";
        iBtnClubs.setAlpha(1.0f);
        iBtnDiamonds.setAlpha(0.5f);
        iBtnHearts.setAlpha(0.5f);
        iBtnSpades.setAlpha(0.5f);
        //Toast.makeText(this, "Зачем ты это нажал трефи?", Toast.LENGTH_SHORT).show();
    }
    public void onClickHearts(View view)
    {
        suit = "hearts";
        iBtnClubs.setAlpha(0.5f);
        iBtnDiamonds.setAlpha(0.5f);
        iBtnHearts.setAlpha(1.0f);
        iBtnSpades.setAlpha(0.5f);
        //Toast.makeText(this, "Зачем ты это нажал черви?", Toast.LENGTH_SHORT).show();
    }
    public void onClickDiamonds(View view)
    {
        suit = "diamonds";
        iBtnClubs.setAlpha(0.5f);
        iBtnDiamonds.setAlpha(1.0f);
        iBtnHearts.setAlpha(0.5f);
        iBtnSpades.setAlpha(0.5f);
        //Toast.makeText(this, "Зачем ты это нажал бубны?", Toast.LENGTH_SHORT).show();
    }
    public void onClickSpades(View view)
    {
        suit = "spades";
        iBtnClubs.setAlpha(0.5f);
        iBtnDiamonds.setAlpha(0.5f);
        iBtnHearts.setAlpha(0.5f);
        iBtnSpades.setAlpha(1.0f);
        //Toast.makeText(this, "Зачем ты это нажал пики?", Toast.LENGTH_SHORT).show();
    }
    public void onClickClubs2(View view)
    {
        suit_2 = "clubs2";
        iBtnClubs2.setAlpha(1.0f);
        iBtnDiamonds2.setAlpha(0.5f);
        iBtnHearts2.setAlpha(0.5f);
        iBtnSpades2.setAlpha(0.5f);
        //Toast.makeText(this, "Зачем ты это нажал трефи?", Toast.LENGTH_SHORT).show();
    }
    public void onClickHearts2(View view)
    {
        suit_2 = "hearts2";
        iBtnClubs2.setAlpha(0.5f);
        iBtnDiamonds2.setAlpha(0.5f);
        iBtnHearts2.setAlpha(1.0f);
        iBtnSpades2.setAlpha(0.5f);
        //Toast.makeText(this, "Зачем ты это нажал черви?", Toast.LENGTH_SHORT).show();
    }
    public void onClickDiamonds2(View view)
    {
        suit_2 = "diamonds2";
        iBtnClubs2.setAlpha(0.5f);
        iBtnDiamonds2.setAlpha(1.0f);
        iBtnHearts2.setAlpha(0.5f);
        iBtnSpades2.setAlpha(0.5f);
        //Toast.makeText(this, "Зачем ты это нажал бубны?", Toast.LENGTH_SHORT).show();
    }
    public void onClickSpades2(View view)
    {
        suit_2 = "spades2";
        iBtnClubs2.setAlpha(0.5f);
        iBtnDiamonds2.setAlpha(0.5f);
        iBtnHearts2.setAlpha(0.5f);
        iBtnSpades2.setAlpha(1.0f);
        //Toast.makeText(this, "Зачем ты это нажал пики?", Toast.LENGTH_SHORT).show();
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