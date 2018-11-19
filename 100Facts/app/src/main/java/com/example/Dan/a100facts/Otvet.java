package com.example.Dan.a100facts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Otvet extends AppCompatActivity {

    public static final String APP_PREFERENCES = "musettings";
    public static final String True = "1";
    public static final String False = "0";
    public static final String Key = "key";
    SharedPreferences mSettings;

    int position=0;
    int current=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otvet);
        ConstraintLayout layout =findViewById(R.id.background);
        String str = openText();
        char[] chArray = str.toCharArray();
        int buf = Character.getNumericValue(chArray[0]);
        ImageView imageView = findViewById(R.id.ImageMain);
        TextView textView = findViewById(R.id.TextMain);
        int pos = 0;
        if (chArray[3] == ' ') {
            pos = Character.getNumericValue(chArray[2]);
        } else {
            pos = Character.getNumericValue(chArray[2]) * 10 + Character.getNumericValue(chArray[3]);
        }
        if (buf == 1) {
            imageView.setImageResource(mThumbIdsCs[pos]);
            textView.setText(Cs[pos]);
            layout.setBackgroundResource(R.drawable.cs);
        } else if (buf == 2) {
            imageView.setImageResource(mThumbIdsPubg[pos]);
            textView.setText(Pubg[pos]);

        } else {
            imageView.setImageResource(mThumbIdsDota[pos]);
            textView.setText(Dota[pos]);
            layout.setBackgroundResource(R.drawable.dotka);
        }
        //textView.setText(str);
        current=buf;
        position=pos;

    }
    @Override
    public void onBackPressed() {
        Intent intent=new Intent(Otvet.this,Navogator.class);
        startActivity(intent);

    }

    public String[] Dota = {
            "Razor и Visage – коллеги по работе в чистилище. Visage охраняет вход, а Razor патрулирует внутренние помещения",
            "Earth Spirit – это дух, которому стало скучно, и он вселился в статую генерала армии",
            "Phantom Lancer был рыбаком, пока война не пришла в его деревню и ему не пришлось убить злого волшебника. С последним вздохом мага Phantom Lancer получил свои невероятные силы.",
            "Многие охотились за бесценными рогами Magnus. Он пронзил и растоптал бесчисленное количество таких охотников.",
            "Bloodseeker проливает кровь везде, чтобы кормить своих хозяев",
            "Venomancer был простым травником. Его укусила ядовитая рептилия в джунглях Джиди, тогда он попробовал использовать противоядие, которое приготовил благодаря своим знаниям. Однако он впал в кому на 17 лет и очнулся таким, каким мы его знаем",
            "Viper был питомцем Pugna. Но однажды он плюнул ядом в глаза хозяина и сумел сбежать.",
            "Weaver – представитель расы, которая восстанавливает ткань вселенной. Он решил, что хочет создать свой мир, но был отрезан от основной вселенной.",
            "Morphling теряет память после каждой смены формы",
            "Faceless Void является жрецом Clasz, бога удачи",
            "Bristleback работал вышибалой в одной забегаловке. Одному клиенту он сломал пять ног.",
            "Magnus любит пронзать людей своим рогом, потому что таким образом он может вблизи смотреть, как они умирают",
            "Любимый скакун Chaos Knight – Армаггедон.",
            "Undying раньше служил в армии. Как-то раз его с сослуживцами бросили в яму. В итоге солдаты начали есть друг друга есть.",
            "Clockwerk, Tinker, Sniper, Gyrocopter, Alchemist и Timbersaw принадлежат к одной расе. Techies, вероятно, тоже.",
            "Sand King – главное действующее лицо многих ритуалов. Например, в одном из них он пронзает семь служителей церемониальным жалом",
            "Slardar и Naga Siren были элитными стражами – коллегами. Однако Naga была изгнана после того, как левиафаны-мародеры похитили священную чашу.",
            "Когда Beastmaster было 7 лет, он убил короля с помощью животных из зверинца.",

    };
    public String[] Cs = {
            "Как и P250, пистолетам Five SeveN и Tec9 для убийства достаточно одного попадания в голову оппонента экипированного в броню, но эти пистолеты имеют большую убойную дальность, чем P250",
            "MP9 настолько же скорострельный, как и Р90. Игроки жалуются на Р90, но МР9 такой же беспощадный против противников без брони",
            "Дробь Sawedoff дробовика не летит дальше 750 единиц (длина парапета на dust2)",
            "В игре можно превратить оружие в арбалеты. За этот режим в ответе консольная команда sv_showbullethits 1, которая позволяет показывать, куда именно попала ваша или чужая пуля." ,
            "Дымовая граната тушит огненную",
            "Скин на AWP с автографом игрока Тайлера Латэма, играющего под ником Skadoodle, был продан на сайте OPSkins за $61052.",
            "Скучно разминаться с обычными ботами? Наберите в консоли главного меню команду bot_quota 20.",
            "m4a4 - выдуманное оружее",
            "sg553 - единственное оружее, полностью игнорирующее броню",
            "Смерть от бомбы C4 не учитывается в таблице результатов",
            "MAC7 & ZEUS - оружия, убивающие с 1 выстрела даже в ноги",
            "От пропрыгиваения коктейля молотова кол-во получаемого урона не уменьшается",
            "В настройках игры есть пиратский язык",
            "Снеговику на карте Guardian можно прострелить 'ноги' ",
            "Спецназ не способен взаимодействовать с выброшенной бомбой С4",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",

    };
    public String[] Pubg = {
            "Оригинальная карта в PUBG названа в честь дочери Брендана Грина",
            "Сковородка в игре появилась из-за невнимательности разработчика",
            "Сеттинг Восточной Европы был выбран из-за брутальной архитектуры",
            "Именно PUBG на данный момент принадлежит рекорд в Steam по одновременному количеству игроков — 3 106 358. По этому показателю игра опередила многолетнего лидера — Dota 2.",
            "Брендан Грин под ником «PlayerUnknown» изначально занялся всего лишь моддингом под игру ARMA. Но придуманный им режим «Королевской битвы» стал настолько популярным, что перерос в отдельную игру, популярность которой растет изо дня в день.",
            "Игра достигла своего успеха без рекламы и до основного релиза",
            "Огненный след за самолетом - люди, сгорающие еще до старта игры (печально, но факт)",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",
            "Ожидаем интересных фактов",

    };

    public Integer[] mThumbIdsCs = {
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
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait
    };

    public Integer[] mThumbIdsDota = {
            R.drawable.dota,
            R.drawable.dota,
            R.drawable.lancer,
            R.drawable.magnus,
            R.drawable.blood,
            R.drawable.venom,
            R.drawable.viper,
            R.drawable.weav,
            R.drawable.morph,
            R.drawable.voiid,
            R.drawable.brist,
            R.drawable.magn,
            R.drawable.chaooos,
            R.drawable.und,
            R.drawable.her5,
            R.drawable.sand,
            R.drawable.slard,
            R.drawable.beast
    };
    public Integer[] mThumbIdsPubg = {
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.pubg2,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
            R.drawable.wait,
    };


    private final static String FILE_NAME = "content.txt";

    public String openText() {

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


    public void AddFavorite(View view) {
        /*String str=openText();
        str+=" ";
        str+=current;
        if(position<=9){
            str+="0";
        }
        str+=position;
        saveText(str);

        Toast toast = Toast.makeText(getApplicationContext(),
                str, Toast.LENGTH_SHORT);
        toast.show();
        */
        form();

    }


    private final static String FILE_NAME2 = "contentadd.txt";


    public String openTextAdd() {

        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME2);
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

    public void saveText(String obmen) {
        FileOutputStream fos = null;
        try {
            String text = obmen;
            fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
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

    private final static String FILE_NAMEMAIN = "contentmain.txt";
    public void saveTextMAIN(String obmen) {
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
    public String openTextMAIN() {

        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAMEMAIN);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
            return text;
        } catch (IOException ex) {

            String kostil = "";
            return kostil;
        } finally {

            try {
                if (fin != null)
                    fin.close();
            } catch (IOException ex) {
                String kostil = "";
                return kostil;
            }
        }
    }

    public void form(){
        String str=openTextMAIN();
        str+="(";
        if(current==1){
            str+=Cs2[position];
        }
        if(current==2){
            str+=Pubg2[position];
        }
        if(current==3){
            str+=Dota2[position];
        }
        str+=")";
        saveTextMAIN(str);
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