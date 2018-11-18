package com.example.Dan.a100facts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {



    public static final String APP_PREFERENCES = "musettings";
    public static final String True="1";
    public static final String False="0";
    public static final String Key="key";
    SharedPreferences mSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this,Navogator.class);
        startActivity(intent);

        //pref
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

        //grid
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this,1));

        gridview.setOnItemClickListener(gridviewOnItemClickListener);
    }


    GridView.OnItemClickListener gridviewOnItemClickListener = new GridView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position,
                                long id) {
            String buf="";

            buf+=position;
            saveTextBuffer(buf);
            Intent intent=new Intent (MainActivity.this,Otvet.class);
            startActivity(intent);
        }
    };


    public void saveTextBuffer(String obmen){
        FileOutputStream fos = null;
        try {

            String text=obmen;
            fos = openFileOutput(FILE_NAMEBUFFER, MODE_PRIVATE);
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


    private final static String FILE_NAMEBUFFER = "contentbuffer.txt";

    private final static String FILE_NAME = "content.txt";

    public String openTextBuffer(){

        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAMEBUFFER);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            return text;
        }
        catch(IOException ex) {

            String kostil="Slomalos";
            return kostil;
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
                String kostil="Slomalos";
                return kostil;
            }
        }
    }





    public void saveText(String obmen){
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



    public String openText(){

        FileInputStream fin = null;
        try {
            fin = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String (bytes);
            return text;
        }
        catch(IOException ex) {

            String kostil="Slomalos";
            return kostil;
        }
        finally{

            try{
                if(fin!=null)
                    fin.close();
            }
            catch(IOException ex){
                String kostil="Slomalos";
                return kostil;
            }
        }
    }

}
