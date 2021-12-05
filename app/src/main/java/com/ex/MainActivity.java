package com.ex;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static final String FILENAME="namaFile.txt";
    Button buatFile,bacaFile,ubahFile,hapusFile;
    TextView textView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buatFile=findViewById(R.id.btn_create);
        bacaFile=findViewById(R.id.btn_baca);
        ubahFile=findViewById(R.id.btn_ubah);
        hapusFile=findViewById(R.id.btn_hapus);
        textView=findViewById(R.id.ini_textView);


        buatFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        hapusFile.setOnClickListener(this);















    }


    void buatFile(){
        String isiFile="coba isi data file txt";
        File file = new File(getFilesDir(),FILENAME);

        FileOutputStream fileOutputStream=null;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,true);
            fileOutputStream.write(isiFile.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }


    }


        void ubahFile(){

        String ubah="update isi data file text";



        File file=new File(getFilesDir(),FILENAME);
        FileOutputStream fileOutputStream=null;

        try{
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file,false);
            fileOutputStream.write(ubah.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }



        }

        void bacaFile(){
        File sdCard=getFilesDir();
        File file=new File(sdCard,FILENAME);

        if(file.exists());{

            StringBuilder stringBuilder=new StringBuilder();

            try{
                BufferedReader bufferedReader= new BufferedReader(new FileReader(file));

                String line= bufferedReader.readLine();

                    while (line != null){
                        textView.append(line);
                        line=bufferedReader.readLine();
                    }

                    bufferedReader.close();

            } catch (IOException e){
                System.out.println("Error"+ e.getMessage());
            }
            textView.setText(textView.toString());
            }

        }

            void setHapusFile(){
            File file=new File(getFilesDir(),FILENAME);

            if(file.exists()){
                file.delete();
            }


            }














    @Override
    public void onClick(View v) {


        jalankanPerintah(v.getId());





    }


    void jalankanPerintah(int id){

        switch (id){


            case R.id.btn_create:
                bacaFile();
                break;
            case R.id.btn_baca:
                bacaFile();
                break;
            case R.id.btn_ubah:
                ubahFile();
                break;
            case R.id.btn_hapus:
                setHapusFile();
                break;
        }


    }





}