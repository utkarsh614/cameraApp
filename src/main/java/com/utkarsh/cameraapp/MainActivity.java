package com.utkarsh.cameraapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private final int CAMERA_REQ_CODE=100;
    ImageView imgCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         imgCamera=findViewById(R.id.imgCamera);
        Button button=findViewById(R.id.button);
   button.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent icamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
           startActivityForResult(icamera, CAMERA_REQ_CODE);
       }
   });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
             if (requestCode==CAMERA_REQ_CODE){
                 Bitmap img = (Bitmap)(data.getExtras().get("data"));
        imgCamera.setImageBitmap(img);
             }
        }
    }
}