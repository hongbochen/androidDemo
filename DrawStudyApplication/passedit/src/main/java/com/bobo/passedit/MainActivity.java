package com.bobo.passedit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et_p1;
    private EditText et_p2;
    private EditText et_p3;
    private EditText et_p4;
    private EditText et_p5;
    private EditText et_p6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        et_p1 = (EditText)findViewById(R.id.et_p1);
        et_p2 = (EditText)findViewById(R.id.et_p2);
        et_p3 = (EditText)findViewById(R.id.et_p3);
        et_p4 = (EditText)findViewById(R.id.et_p4);
        et_p5 = (EditText)findViewById(R.id.et_p5);
        et_p6 = (EditText)findViewById(R.id.et_p6);

        et_p1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_p1.getText().toString().length() == 1){
                    et_p2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_p2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_p2.getText().toString().length() == 1){
                    et_p3.requestFocus();
                }else  if(et_p2.getText().toString().length() == 0){
                    et_p1.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_p3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_p3.getText().toString().length() == 1){
                    et_p4.requestFocus();
                }else  if(et_p3.getText().toString().length() == 0){
                    et_p2.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_p4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_p4.getText().toString().length() == 1){
                    et_p5.requestFocus();
                }else if(et_p4.getText().toString().length() == 0){
                    et_p3.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_p5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_p5.getText().toString().length() == 1){
                    et_p6.requestFocus();
                }else  if(et_p5.getText().toString().length() == 0){
                    et_p4.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_p6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_p6.getText().toString().length() == 0){
                    et_p5.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
