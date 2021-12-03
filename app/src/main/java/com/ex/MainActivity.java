package com.ex;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;

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





















    @Override
    public void onClick(View v) {

    }
}