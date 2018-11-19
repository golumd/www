package com.example.Dan.a100facts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Favorite extends AppCompatActivity {

    int current=0;
    int position=0;

    List<String> x=new ArrayList<>();
    String[] a=new String[100];
    int count=0;
    List<String> main=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);
       // set();
       // String test = openText();
       // Toast toast = Toast.makeText(getApplicationContext(),
       //         test, Toast.LENGTH_SHORT);
       // toast.show();

        ListView lvMain=findViewById(R.id.lvMain);
        String str=openText();
        //кодировка(aa)
        String buffer="";
        char[] chArray=str.toCharArray();
        for(int i=0;i<str.length();i++){
            if(chArray[i]=='('){
                i++;
                while(chArray[i]!=')'){
                    buffer+=chArray[i];
                    i++;
                }
                main.add(buffer);
                buffer="";
            }
        }
        ArrayAdapter<String> adapter2;
        adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,main);
        lvMain.setAdapter(adapter2);

        lvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                String str=main.get(position);
                String all=openText();
                char[] chArray=all.toCharArray();
                int index=all.indexOf(str);
                index--;
                String buf1="";
                for(int i=0;i<index;i++){
                    buf1+=chArray[i];
                }
                String buf2="";
                while(chArray[index]!=')'){
                    index++;
                }
                index++;
                for(int i=index;i<all.length();i++){
                    buf2+=chArray[i];
                }
                String answer=buf1+buf2;
                saveText(answer);
                Intent intent=new Intent(Favorite.this,Favorite.class);
                startActivity(intent);
                finish();
                return true;
            }
        });
        /*
        String main=openTextAdd();
        char[] chArray=main.toCharArray();
        for(int i=2;i<main.length()-2;i++){
            if(chArray[i]=='1' || chArray[i]=='2' || chArray[i]=='3'){
                current=Character.getNumericValue(chArray[i]);
                if(chArray[i+1]=='0'){ position=Character.getNumericValue(chArray[i+2]);
                }
                else{
                    position=Character.getNumericValue(chArray[i+1])*10+Character.getNumericValue(chArray[i+2]);
                }
                String saved="";
                //position=2;
                if(current==1){
                    saved+=Cs[position];
                }
                if(current==2){
                    saved+=Pubg[position];
                }
                if(current==3){
                    saved+=Dota[position];
                }
                i+=1;
                x.add(saved);
                String str="";
                str+=current;
                str+=" ";
                str+="0";
                str+=position;
                a[count]=str;

            }
        }

        //List

        //x.add(main);
        ListView lvMain = findViewById(R.id.lvMain);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,x );
        lvMain.setAdapter(adapter);
        */
       // ListView lvMain = findViewById(R.id.lvMain);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                String str = main.get(position);
                /*
                if(str.contains("Хэд-шот")){
                    saveText2("1 0 ");
                }
                if(str.contains("Скорострелы")){
                    saveText2("1 1 ");
                }
                */
                for(int i=0;i<18;i++){
                    if(str.contains(Cs2[i])){
                        saveText2("1 "+i+" ");
                    }
                    if(str.contains(Pubg2[i])){
                        saveText2("2 "+i+" ");
                    }
                    if(str.contains(Dota2[i])){
                        saveText2("3 "+i+" ");
                    }
                }
                Intent intent=new Intent(Favorite.this,Otvet.class);
                startActivity(intent);

                 }
            });

    }


    public void DeleteAll(View view){
        String str="";
        saveText(str);
        x.clear();
        ListView lvMain = findViewById(R.id.lvMain);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,x );
        lvMain.setAdapter(adapter);
        count=0;
    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Favorite.this,Navogator.class);
        startActivity(intent);

    }





    private final static String FILE_NAME2 = "contentadd.txt";


    public String openTextAdd() {

        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            return text;
        } catch (IOException ex) {

            String kostil = "Slomalos";
            return kostil;
        } finally {

            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                String kostil = "Slomalos";
                return kostil;
            }
        }
    }



    private final static String FILE_NAME = "content.txt";

    public void saveText2(String obmen){
        FileOutputStream fos = null;
        try {

            String text=obmen;
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
            fos.write(text.getBytes());
        }
        catch(IOException ex) {
            boolean kostil=true;
        }
        finally{
            try{
                if(fos!=null)
                    fos.close();
            }
            catch(IOException ex){
                boolean kostil=true;
            }
        }
    }







    public String[] Dota = {
            "Тандем мечты",
            "Скучающий Земеля",
            "Лансер-рыболов",
            "Рогa Magnus'a",
            "Замок из костей",
            "Герой ритуалов",
            "Бывший часовщик ",
            "Неудержимый",
            "Dota 2 9",
            "Dota 2 10",
            "Dota 2 11",
            "Dota 2 12",
            "Dota 2 13",
            "Dota 2 14",
            "Dota 2 15",
            "Dota 2 16",
            "Dota 2 17",
            "Dota 2 18",

    };
    public String[] Cs = {
            "Хэд-шот",
            "Скорострелы",
            "Недалеко, но мощно",
            "Cs 4",
            "Cs 5",
            "Cs 6",
            "Cs 7",
            "Cs 8",
            "Cs 9",
            "Cs 10",
            "Cs 11",
            "Cs 12",
            "Cs 13",
            "Cs 14",
            "Cs 15",
            "Cs 16",
            "Cs 17",
            "Cs 18",

    };
    public String[] Pubg = {
            "Доча, это в твою честь",
            "Сковородка??",
            "Брутальность - наше всё",
            "PUBG 4",
            "PUBG 5",
            "PUBG 6",
            "PUBG 7",
            "PUBG 8",
            "PUBG 9",
            "PUBG 10",
            "PUBG 11",
            "PUBG 12",
            "PUBG 13",
            "PUBG 14",
            "PUBG 15",
            "PUBG 16",
            "PUBG 17",
            "PUBG 18",

    };

    public Integer[] mThumbIdsCs = {R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo,
            R.drawable.csgo
    };

    public Integer[] mThumbIdsDota = {R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.dota
    };
    public Integer[] mThumbIdsPubg = {R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg,
            R.drawable.pubg
    };
    private final static String FILE_NAMEMAIN = "contentmain.txt";

    public void saveText(String obmen) {
        FileOutputStream fos = null;
        try {
            String text = obmen;
            fos = openFileOutput(FILE_NAMEMAIN, MODE_PRIVATE);
            fos.write(text.getBytes());
        } catch (IOException ex) {
            boolean kostil = true;
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException ex) {
                boolean kostil = true;
            }
        }
    }
    public String openText() {

        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAMEMAIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            return text;
        } catch (IOException ex) {

            String kostil = "Slomalos";
            return kostil;
        } finally {

            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                String kostil = "Slomalos";
                return kostil;
            }
        }
    }
    public void set(){
        ListView lvMain = findViewById(R.id.lvMain);
        String str=openText();
        ArrayList<String> main=new ArrayList<>();
        char[] chArray=str.toCharArray();
        for(int i=1;i<str.length()-2;i++){
            int current = Character.getNumericValue(chArray[i]);
            String buf="";
            i+=2;
            buf+=chArray[i-1];
            buf+=chArray[i];
            int position=Integer.parseInt(buf);
            String push="";
            Toast toast = Toast.makeText(getApplicationContext(),
                    current+" "+position, Toast.LENGTH_SHORT);
            toast.show();
            if(current==1){
                push=Cs[position];
            }
            if(current==2){
                push=Dota[position];
            }
            if(current==3){
                push=Pubg[position];
            }
            main.add(push);

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,main );
        lvMain.setAdapter(adapter);


    }
    public String[] Dota2 = {
            "Тандем мечты",
            "Скучающий Земеля",
            "Лансер-рыболов",
            "Рогa Magnus'a",
            "Кровавая подкормка",
            "История Venomancer'а",
            "Питомец ",
            "Немного о weaver",
            "Потерянная память",
            "Жрец Clasz",
            "Вышибала",
            "Искушенный убийца",
            "Любимец Chaos Night'a",
            "Служивый",
            "Одной расы",
            "Герой ритуалов",
            "Коллеги",
            "7-летний убийца",

    };
    public String[] Cs2 = {
            "Хэд-шот",
            "Скорострелы",
            "Недалеко, но мощно",
            "Арбалет",
            "Огнетушитель",
            "Лакшери скин",
            "Супер-боты",
            "Такого не существует",
            "Плевать на броню",
            "Закроем на это глаза",
            "one-shot в ноги",
            "Хватит скакать",
            "Пиратский язык",
            "Снеговик",
            "Бомба-недотрога",
            "wait",
            "wait",
            "wait",

    };
    public String[] Pubg2 = {
            "Доча, это в твою честь",
            "Сковородка??",
            "Брутальность - наше всё",
            "PРекордсмен",
            "Моддинг под игру ARMA",
            "Реклама не нужна",
            "Сгорели",
            "wait",
            "wait",
            "wait",
            "wait",
            "wait",
            "wait",
            "wait",
            "wait",
            "wait",
            "wait",
            "wait",

    };
}
