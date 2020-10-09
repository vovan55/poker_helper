package com.pokerhelper.thebest;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.icu.text.RelativeDateTimeFormatter;
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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity implements NavItemSelectedListener{
    // todo если хешмапа нужна в виде поля как здесь, ее нужно типизировать
    // todo HashMap<String, Integer> hashMap;
    HashMap hashMap;
    private static final String TAG = "MyApp";
    // todo все поля которые не нужны извне нужно сделать минимально возможным модификатором доступа (private, protected)
    Button btnCalc;
    TextView tvResult;
    String compareLeft, compareRight;
    String leftCard, rightCard;
    String renameCard;
    String resultFromTable;
    // Объявляем переменную второго спиннера
    // todo названия(особенно полей) нужно давать читаемые и понятные, потом очень быстро забывается
    String pos;
    String suitLeft, suitRight;
    // todo в поле нужно выносить переменные, которые используются в разных местах. position используется в 1 методе, поэтому убираем туда
    String[] position = {"EP1", "EP2", "MP1", "MP2", "HJ", "CO", "BTN", "SB"};
    //int position [] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    Spinner spPos, spCard_1, spCard_2;
    int bb;
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
                //String item = (String) parent.getItemAtPosition(position);
                //tvEnterPos.setText(item);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spPos.setOnItemSelectedListener(itemSelectedListener_pos);
    }

    // todo фигурная скобка в java практике идет в той же строчке, где и название метода
    // todo так же в Idea или Android Studio есть автоформатирование кода по ctrl-alt-L
    private void init()
    {   numberPicker = (NumberPicker) findViewById(R.id.spBB);
        numberPicker.setMaxValue(20);
        numberPicker.setMinValue(1);
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

    // todo дальше идут однотипные методы, которые нужно объединить в один
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
        // todo нечитаемое форматирование, нужно привыкать к общепринятому стандарту
        InputStream stream = null;
        // todo в Java есть try with resources, советую изучить как это работает
        try
        {
            stream = context.getAssets().open(path);
            return BitmapFactory.decodeStream(stream);
        }
        // todo рекомендуется не игнорировать исключения
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

    // todo setImageLeft & setImageRight так похожи, что лучше объединить
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
    // Переименуем карты в текст
    public void renameCards(String leftCard, String rightCard)
    {
        leftCard = spCard_1.getSelectedItem().toString();
        rightCard = spCard_2.getSelectedItem().toString();
        renameCard = leftCard + rightCard;
        if (suitLeft.equals(suitRight))
        {
            renameCard += "s";
        }
        else
        {
            renameCard += "o";
        }
        if (leftCard.equals(rightCard))
        {
           renameCard = leftCard + rightCard;
        }
        //Log.d("MyLog", "check suit : " + renameCard);
    }
    public void compareCards()
    {   // Записываем позицию из спиннера выбора позиции
        pos = spPos.getSelectedItem().toString();
        //Log.d("MyLog", "check result position : " + pos);

        // Переводим текстовое значение спиннера позиции в число
        //int posInt = Integer.parseInt(pos);

        // Записываем данные из NumberPicker
        bb = numberPicker.getValue();

        // todo 1) вроде бы данные не меняются, их не нужно собирать при каждом нажатии, можно один раз на старте
        // todo 2) это стоит вынести в другой класс, в Activity все-таки работа с вьюхами, а дату убрать в другое место
        // todo 3) вообще вот эти данные это хороший повод познакомиться с БД, можно начать с SQL и работать с локальной базой
        // Присваиваем каждой позиции её числовое значение
        hashMap = new HashMap<String, Integer>();
        hashMap.put("1_EP1", R.array.ct01_EP1);
        hashMap.put("1_EP2", R.array.ct01_EP2);
        hashMap.put("1_MP1", R.array.ct01_MP1);
        hashMap.put("1_MP2", R.array.ct01_MP2);
        hashMap.put("1_HJ", R.array.ct01_HJ);
        hashMap.put("1_CO", R.array.ct01_CO);
        hashMap.put("1_BTN", R.array.ct01_BTN);
        hashMap.put("1_SB", R.array.ct01_SB);

        hashMap.put("2_EP1", R.array.ct02_EP1);
        hashMap.put("2_EP2", R.array.ct02_EP2);
        hashMap.put("2_MP1", R.array.ct02_MP1);
        hashMap.put("2_MP2", R.array.ct02_MP2);
        hashMap.put("2_HJ", R.array.ct02_HJ);
        hashMap.put("2_CO", R.array.ct02_CO);
        hashMap.put("2_BTN", R.array.ct02_BTN);
        hashMap.put("2_SB", R.array.ct02_SB);

        hashMap.put("3_EP1", R.array.ct03_EP1);
        hashMap.put("3_EP2", R.array.ct03_EP2);
        hashMap.put("3_MP1", R.array.ct03_MP1);
        hashMap.put("3_MP2", R.array.ct03_MP2);
        hashMap.put("3_HJ", R.array.ct03_HJ);
        hashMap.put("3_CO", R.array.ct03_CO);
        hashMap.put("3_BTN", R.array.ct03_BTN);
        hashMap.put("3_SB", R.array.ct03_SB);

        hashMap.put("4_EP1", R.array.ct04_EP1);
        hashMap.put("4_EP2", R.array.ct04_EP2);
        hashMap.put("4_MP1", R.array.ct04_MP1);
        hashMap.put("4_MP2", R.array.ct04_MP2);
        hashMap.put("4_HJ", R.array.ct04_HJ);
        hashMap.put("4_CO", R.array.ct04_CO);
        hashMap.put("4_BTN", R.array.ct04_BTN);
        hashMap.put("4_SB", R.array.ct04_SB);

        hashMap.put("5_EP1", R.array.ct05_EP1);
        hashMap.put("5_EP2", R.array.ct05_EP2);
        hashMap.put("5_MP1", R.array.ct05_MP1);
        hashMap.put("5_MP2", R.array.ct05_MP2);
        hashMap.put("5_HJ", R.array.ct05_HJ);
        hashMap.put("5_CO", R.array.ct05_CO);
        hashMap.put("5_BTN", R.array.ct05_BTN);
        hashMap.put("5_SB", R.array.ct05_SB);

        hashMap.put("6_EP1", R.array.ct06_EP1);
        hashMap.put("6_EP2", R.array.ct06_EP2);
        hashMap.put("6_MP1", R.array.ct06_MP1);
        hashMap.put("6_MP2", R.array.ct06_MP2);
        hashMap.put("6_HJ", R.array.ct06_HJ);
        hashMap.put("6_CO", R.array.ct06_CO);
        hashMap.put("6_BTN", R.array.ct06_BTN);
        hashMap.put("6_SB", R.array.ct06_SB);

        hashMap.put("7_EP1", R.array.ct07_EP1);
        hashMap.put("7_EP2", R.array.ct07_EP2);
        hashMap.put("7_MP1", R.array.ct07_MP1);
        hashMap.put("7_MP2", R.array.ct07_MP2);
        hashMap.put("7_HJ", R.array.ct07_HJ);
        hashMap.put("7_CO", R.array.ct07_CO);
        hashMap.put("7_BTN", R.array.ct07_BTN);
        hashMap.put("7_SB", R.array.ct07_SB);

        hashMap.put("8_EP1", R.array.ct08_EP1);
        hashMap.put("8_EP2", R.array.ct08_EP2);
        hashMap.put("8_MP1", R.array.ct08_MP1);
        hashMap.put("8_MP2", R.array.ct08_MP2);
        hashMap.put("8_HJ", R.array.ct08_HJ);
        hashMap.put("8_CO", R.array.ct08_CO);
        hashMap.put("8_BTN", R.array.ct08_BTN);
        hashMap.put("8_SB", R.array.ct08_SB);

        hashMap.put("9_EP1", R.array.ct09_EP1);
        hashMap.put("9_EP2", R.array.ct09_EP2);
        hashMap.put("9_MP1", R.array.ct09_MP1);
        hashMap.put("9_MP2", R.array.ct09_MP2);
        hashMap.put("9_HJ", R.array.ct09_HJ);
        hashMap.put("9_CO", R.array.ct09_CO);
        hashMap.put("9_BTN", R.array.ct09_BTN);
        hashMap.put("9_SB", R.array.ct09_SB);

        hashMap.put("10_EP1", R.array.ct10_EP1);
        hashMap.put("10_EP2", R.array.ct10_EP2);
        hashMap.put("10_MP1", R.array.ct10_MP1);
        hashMap.put("10_MP2", R.array.ct10_MP2);
        hashMap.put("10_HJ", R.array.ct10_HJ);
        hashMap.put("10_CO", R.array.ct10_CO);
        hashMap.put("10_BTN", R.array.ct10_BTN);
        hashMap.put("10_SB", R.array.ct10_SB);

        hashMap.put("11_EP1", R.array.ct11_EP1);
        hashMap.put("11_EP2", R.array.ct11_EP2);
        hashMap.put("11_MP1", R.array.ct11_MP1);
        hashMap.put("11_MP2", R.array.ct11_MP2);
        hashMap.put("11_HJ", R.array.ct11_HJ);
        hashMap.put("11_CO", R.array.ct11_CO);
        hashMap.put("11_BTN", R.array.ct11_BTN);
        hashMap.put("11_SB", R.array.ct11_SB);

        hashMap.put("12_EP1", R.array.ct12_EP1);
        hashMap.put("12_EP2", R.array.ct12_EP2);
        hashMap.put("12_MP1", R.array.ct12_MP1);
        hashMap.put("12_MP2", R.array.ct12_MP2);
        hashMap.put("12_HJ", R.array.ct12_HJ);
        hashMap.put("12_CO", R.array.ct12_CO);
        hashMap.put("12_BTN", R.array.ct12_BTN);
        hashMap.put("12_SB", R.array.ct12_SB);

        hashMap.put("13_EP1", R.array.ct13_EP1);
        hashMap.put("13_EP2", R.array.ct13_EP2);
        hashMap.put("13_MP1", R.array.ct13_MP1);
        hashMap.put("13_MP2", R.array.ct13_MP2);
        hashMap.put("13_HJ", R.array.ct13_HJ);
        hashMap.put("13_CO", R.array.ct13_CO);
        hashMap.put("13_BTN", R.array.ct13_BTN);
        hashMap.put("13_SB", R.array.ct13_SB);

        hashMap.put("14_EP1", R.array.ct14_EP1);
        hashMap.put("14_EP2", R.array.ct14_EP2);
        hashMap.put("14_MP1", R.array.ct14_MP1);
        hashMap.put("14_MP2", R.array.ct14_MP2);
        hashMap.put("14_HJ", R.array.ct14_HJ);
        hashMap.put("14_CO", R.array.ct14_CO);
        hashMap.put("14_BTN", R.array.ct14_BTN);
        hashMap.put("14_SB", R.array.ct14_SB);

        hashMap.put("15_EP1", R.array.ct15_EP1);
        hashMap.put("15_EP2", R.array.ct15_EP2);
        hashMap.put("15_MP1", R.array.ct15_MP1);
        hashMap.put("15_MP2", R.array.ct15_MP2);
        hashMap.put("15_HJ", R.array.ct15_HJ);
        hashMap.put("15_CO", R.array.ct15_CO);
        hashMap.put("15_BTN", R.array.ct15_BTN);
        hashMap.put("15_SB", R.array.ct15_SB);

        hashMap.put("16_EP1", R.array.ct16_EP1);
        hashMap.put("16_EP2", R.array.ct16_EP2);
        hashMap.put("16_MP1", R.array.ct16_MP1);
        hashMap.put("16_MP2", R.array.ct16_MP2);
        hashMap.put("16_HJ", R.array.ct16_HJ);
        hashMap.put("16_CO", R.array.ct16_CO);
        hashMap.put("16_BTN", R.array.ct16_BTN);
        hashMap.put("16_SB", R.array.ct16_SB);

        hashMap.put("17_EP1", R.array.ct17_EP1);
        hashMap.put("17_EP2", R.array.ct17_EP2);
        hashMap.put("17_MP1", R.array.ct17_MP1);
        hashMap.put("17_MP2", R.array.ct17_MP2);
        hashMap.put("17_HJ", R.array.ct17_HJ);
        hashMap.put("17_CO", R.array.ct17_CO);
        hashMap.put("17_BTN", R.array.ct17_BTN);
        hashMap.put("17_SB", R.array.ct17_SB);

        hashMap.put("18_EP1", R.array.ct18_EP1);
        hashMap.put("18_EP2", R.array.ct18_EP2);
        hashMap.put("18_MP1", R.array.ct18_MP1);
        hashMap.put("18_MP2", R.array.ct18_MP2);
        hashMap.put("18_HJ", R.array.ct18_HJ);
        hashMap.put("18_CO", R.array.ct18_CO);
        hashMap.put("18_BTN", R.array.ct18_BTN);
        hashMap.put("18_SB", R.array.ct18_SB);

        hashMap.put("19_EP1", R.array.ct19_EP1);
        hashMap.put("19_EP2", R.array.ct19_EP2);
        hashMap.put("19_MP1", R.array.ct19_MP1);
        hashMap.put("19_MP2", R.array.ct19_MP2);
        hashMap.put("19_HJ", R.array.ct19_HJ);
        hashMap.put("19_CO", R.array.ct19_CO);
        hashMap.put("19_BTN", R.array.ct19_BTN);
        hashMap.put("19_SB", R.array.ct19_SB);

        hashMap.put("20_EP1", R.array.ct20_EP1);
        hashMap.put("20_EP2", R.array.ct20_EP2);
        hashMap.put("20_MP1", R.array.ct20_MP1);
        hashMap.put("20_MP2", R.array.ct20_MP2);
        hashMap.put("20_HJ", R.array.ct20_HJ);
        hashMap.put("20_CO", R.array.ct20_CO);
        hashMap.put("20_BTN", R.array.ct20_BTN);
        hashMap.put("20_SB", R.array.ct20_SB);

    }

   public void onClickCalc(View view){

       renameCards(leftCard, rightCard);
       compareCards();

       String resultPosition = bb  + "_" +  pos;
       //Log.d("MyLog", "check result position : " + resultPosition);

       String[] resultCardArray = getResources().getStringArray((int) hashMap.get(resultPosition));
       boolean isPush = false;

       for(String resultFromArray : resultCardArray){
           if(resultFromArray.equals(renameCard))
           {
               isPush = true;
               break;
           }
       }
       if(isPush){
           // todo стоит читать и гуглить подсказки студии, например тексты как здесь стоит выносить в ресурсы
           tvResult.setText("PUSH");
           tvResult.setTextColor(Color.GREEN);
           tvResult.setTextSize(20);
       } else{
           tvResult.setText("FOLD");
           tvResult.setTextColor(Color.RED);
       }
   }
}