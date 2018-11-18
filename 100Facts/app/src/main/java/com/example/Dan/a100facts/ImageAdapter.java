package com.example.Dan.a100facts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageAdapter extends BaseAdapter {



    int index=0;

    private Context mContext;

    public ImageAdapter(Context c,int buf) {
        mContext = c;
        index=buf;
    }

    public int getCount() {
        if(index==1){
            return mThumbIdsPubg.length;
        }
        else if(index==2){
            return mThumbIdsDota.length;
        }
        else return mThumbIdsCs.length;


    }

    public Object getItem(int position) {
        if(index==1){
            return mThumbIdsPubg[position];
        }
        else if(index==2){
            return mThumbIdsDota[position];
        }
        else return mThumbIdsCs[position];
    }

    public long getItemId(int position) {
        return position;
    }

    // create a new ImageView for each item referenced by the Adapter
    // public View getView(int position, View convertView, ViewGroup parent) {
    // ImageView imageView;
    // if (convertView == null) {
    // // if it's not recycled, initialize some attributes
    // imageView = new ImageView(mContext);
    // imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
    // imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    // imageView.setPadding(8, 8, 8, 8);
    // } else {
    // imageView = (ImageView) convertView;
    // }
    //
    // imageView.setImageResource(mThumbIds[position]);
    // return imageView;
    // }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View grid;

        if (convertView == null) {
            grid = new View(mContext);
            //LayoutInflater inflater = getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            grid = inflater.inflate(R.layout.adapter, parent, false);
        } else {
            grid = (View) convertView;
        }

        ImageView imageView = (ImageView) grid.findViewById(R.id.imagepart);
        TextView textView = (TextView) grid.findViewById(R.id.textpart);
        if(index==1){
            imageView.setImageResource(mThumbIdsCs[position]);
            textView.setText(Cs[position]);
        }
        if(index==2){
            imageView.setImageResource(mThumbIdsPubg[position]);
            textView.setText(Pubg[position]);
        }
        if(index==3){
            imageView.setImageResource(mThumbIdsDota[position]);
            textView.setText(Dota[position]);
        }
        //imageView.setImageResource(mThumbIds[0]);
//Если нужно во всех элементах текст разный просто заполни массив all
       // textView.setText(All[position]);


        return grid;
    }





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
    public Integer[] mThumbIdsPubg = {R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2
    };




    public String[] Dota = {
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
    public String[] Cs = {
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
    public String[] Pubg = {
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