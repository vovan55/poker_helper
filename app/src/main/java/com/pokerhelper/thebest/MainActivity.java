package com.pokerhelper.thebest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
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

import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener{
    Button btnCalc;
    TextView tvResult;
    String compareLeft, compareRight;
    String leftCard, rightCard;
    String renameCard;
    String suitLeft, suitRight;
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

        ArrayAdapter<String> adapter_pos;
        adapter_pos = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, position);
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
        tvCard1 = findViewById(R.id.tvCard1);
        tvCard2 = findViewById(R.id.tvCard2);
        btnCalc = findViewById(R.id.btnCalc);
        tvResult = findViewById(R.id.tvResult);

    }

    public void onClickClubs(View view)
    {
        suitLeft = "clubs";
        iBtnClubs.setAlpha(1.0f);
        iBtnDiamonds.setAlpha(0.5f);
        iBtnHearts.setAlpha(0.5f);
        iBtnSpades.setAlpha(0.5f);
        setImageLeft(tvCard1,spCard_1);
    }
    public void onClickHearts(View view)
    {
        suitLeft = "hearts";
        iBtnClubs.setAlpha(0.5f);
        iBtnDiamonds.setAlpha(0.5f);
        iBtnHearts.setAlpha(1.0f);
        iBtnSpades.setAlpha(0.5f);
        setImageLeft(tvCard1,spCard_1);
    }
    public void onClickDiamonds(View view)
    {
        suitLeft = "diamonds";
        iBtnClubs.setAlpha(0.5f);
        iBtnDiamonds.setAlpha(1.0f);
        iBtnHearts.setAlpha(0.5f);
        iBtnSpades.setAlpha(0.5f);
        setImageLeft(tvCard1,spCard_1);
    }
    public void onClickSpades(View view)
    {
        suitLeft = "spades";
        iBtnClubs.setAlpha(0.5f);
        iBtnDiamonds.setAlpha(0.5f);
        iBtnHearts.setAlpha(0.5f);
        iBtnSpades.setAlpha(1.0f);
        setImageLeft(tvCard1,spCard_1);
    }
    public void onClickClubs2(View view)
    {
        suitRight = "clubs";
        iBtnClubs2.setAlpha(1.0f);
        iBtnDiamonds2.setAlpha(0.5f);
        iBtnHearts2.setAlpha(0.5f);
        iBtnSpades2.setAlpha(0.5f);
        setImageRight(tvCard2,spCard_2);
    }
    public void onClickHearts2(View view)
    {
        suitRight = "hearts";
        iBtnClubs2.setAlpha(0.5f);
        iBtnDiamonds2.setAlpha(0.5f);
        iBtnHearts2.setAlpha(1.0f);
        iBtnSpades2.setAlpha(0.5f);
        setImageRight(tvCard2,spCard_2);
    }
    public void onClickDiamonds2(View view)
    {
        suitRight = "diamonds";
        iBtnClubs2.setAlpha(0.5f);
        iBtnDiamonds2.setAlpha(1.0f);
        iBtnHearts2.setAlpha(0.5f);
        iBtnSpades2.setAlpha(0.5f);
        setImageRight(tvCard2,spCard_2);
    }
    public void onClickSpades2(View view)
    {
        suitRight = "spades";
        iBtnClubs2.setAlpha(0.5f);
        iBtnDiamonds2.setAlpha(0.5f);
        iBtnHearts2.setAlpha(0.5f);
        iBtnSpades2.setAlpha(1.0f);
        setImageRight(tvCard2,spCard_2);
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

        //код для получения Bitmap из assets папки
    public Bitmap loadBitmapFromAssets(Context context, String path)
    {
        InputStream stream = null;
        try
        {
            stream = context.getAssets().open(path);
            return BitmapFactory.decodeStream(stream);
        }
        catch (Exception ignored) {} finally
        {
            try
            {
                if(stream != null)
                {
                    stream.close();
                }
            } catch (Exception ignored) {}
        }
        return null;
    }

    private void setImageLeft(ImageView im,Spinner spinner)
    {
        if(!spinner.getSelectedItem().toString().equals("Выберите карту"))
        {
            String imPath = spinner.getSelectedItem().toString() + "_of_" + suitLeft + ".png";
            compareLeft = imPath;
            if(compareRight != null )
            {
                if(compareLeft.equals(compareRight))
                {
                    Toast.makeText(this, "Выберите другую карту", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    im.setImageBitmap(loadBitmapFromAssets(this,imPath));
                }
            }
            else
            {
                im.setImageBitmap(loadBitmapFromAssets(this,imPath));
            }
        }
        else
        {
            Toast.makeText(this, "Карта не выбрана!", Toast.LENGTH_SHORT).show();
        }
    }

    private void setImageRight(ImageView im,Spinner spinner)
    {
        if(!spinner.getSelectedItem().toString().equals("Выберите карту"))
        {
            String imPath = spinner.getSelectedItem().toString() + "_of_" + suitRight + ".png";
            compareRight = imPath;
            if(compareLeft != null )
            {
                if(compareRight.equals(compareLeft))
                {
                    Toast.makeText(this, "Выберите другую карту", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    im.setImageBitmap(loadBitmapFromAssets(this,imPath));
                }
            }
            else
            {
                im.setImageBitmap(loadBitmapFromAssets(this,imPath));
            }
        }
        else
        {
            Toast.makeText(this, "Карта не выбрана!", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickCalc(View view)
    {
        renameCards(leftCard, rightCard);

    }

    public void renameCards(String leftCard, String rightCard)
    {
        if(leftCard != null & rightCard != null)
        {
            if (suitLeft.equals(suitRight))
            {
                leftCard = spCard_1.getSelectedItem().toString();
                rightCard = spCard_2.getSelectedItem().toString();
                String renameCard = leftCard + rightCard;
                if (leftCard.equals(rightCard))
                {

                }
                else
                {
                    renameCard += "s";
                }
            }
            else
            {
                renameCard += "o";
            }
        }
        Log.d("MyLog", "check suit : " + renameCard);

    }



}