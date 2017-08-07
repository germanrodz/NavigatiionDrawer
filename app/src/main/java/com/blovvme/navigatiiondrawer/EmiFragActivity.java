package com.blovvme.navigatiiondrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Blovvme on 8/6/17.
 */

public class EmiFragActivity extends Fragment {

    TextView tv5;
    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    Button btn;
    Button clear;
    SeekBar seekBar,seekBar2,seekBar3;
    double amount;//car cost
    double rate;//interest rate of the loan
    double year;//year of the loan
    double emi;//total payment of the loan

    @Nullable
    @Override
    //Borrar @Nullable que esta dentro de la funcion onCreateView
    //OnCreate if different on Fragments its gotta be writen like this
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.emifrag,container,false);

        btn = (Button) view.findViewById(R.id.btn);
        clear = (Button) view.findViewById(R.id.clear);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar2 = (SeekBar) view.findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) view.findViewById(R.id.seekBar3);
        tv1 = (TextView) view.findViewById(R.id.tv1);
        tv2 = (TextView) view.findViewById(R.id.tv2);
        tv3 = (TextView) view.findViewById(R.id.tv3);
        tv4 = (TextView) view.findViewById(R.id.tv4);
        tv5 = (TextView) view.findViewById(R.id.tv5);
        //Amount
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv1.setText(String.valueOf(progress));
                amount = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Rate
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv2.setText(String.valueOf(progress));
                rate = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //Years
        seekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv3.setText(String.valueOf(progress));
                year = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (amount ==0 || rate == 0 || year == 0){
                    tv5.setText("0");
                }else {
                    rate = rate / (12 * 100);
                    year = year * 12 ;
                    emi = (amount * rate * Math.pow(1 + rate, year)) / (Math.pow(1 + rate, year) - 1);
                    //converts to string it was a double
                    tv5.setText(emi + "");

                    //Total amount to pay
                    //emi = (emi * 12) * year;
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear the seekbar or scrollbar
                tv1.setText("");
                tv2.setText("");
                tv3.setText("");
                tv5.setText("");
                seekBar.setProgress(0);
                seekBar2.setProgress(0);
                seekBar3.setProgress(0);
            }
        });


        return view;
    }
}
