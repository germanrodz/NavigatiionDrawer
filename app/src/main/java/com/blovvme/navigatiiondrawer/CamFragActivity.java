package com.blovvme.navigatiiondrawer;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;//Needed to compability
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Blovvme on 8/5/17.
 */

public class CamFragActivity extends Fragment {


    private static final int CAMERA_REQUEST = 2;
    ImageView img;
    Button btnC;
    Bitmap p;

    @Nullable
    @Override
    //Borrar @Nullable que esta dentro de la funcion onCreateView
    //OnCreate if different on Fragments its gotta be writen like this
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragcam,container,false);

        img = (ImageView) view.findViewById(R.id.img);
        btnC = (Button) view.findViewById(R.id.btnC);

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });



        return view;
    }
    //onActivityResul va afuera del return view
//En fragments hay que usar onClickListeners
//    public void goToCamera(View view) {
//        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//        startActivityForResult(cameraIntent, CAMERA_REQUEST);
//  }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            img.setImageBitmap(photo);
        }
   }
}//last key
