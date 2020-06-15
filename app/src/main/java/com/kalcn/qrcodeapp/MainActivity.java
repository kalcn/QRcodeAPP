package com.kalcn.qrcodeapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private ImageView imgQRcode;
    private Button btnQRcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        imgQRcode = findViewById(R.id.imgQRcode);
        btnQRcode = findViewById(R.id.btnQRcode);
        btnQRcode.setOnClickListener(btn_qrcode);
    }

    public void btnOK(View view) {
        BarcodeEncoder encoder = new BarcodeEncoder();
        try{
            Bitmap bit = encoder.encodeBitmap(editText.getText().toString(), BarcodeFormat.QR_CODE,250,250);
            imgQRcode.setImageBitmap(bit);
        }catch (WriterException e){
            e.printStackTrace();
        }
    }
}
