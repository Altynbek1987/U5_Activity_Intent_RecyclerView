package com.example.u5_activity_intent_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity{
    public static String TEXT_KEY = "text_key";

    EditText editText;
    SomeClass someClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView textView = findViewById(R.id.main_2_text);
        editText = findViewById(R.id.main_2_edit);

        Button save = findViewById(R.id.main_2_save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View v) {
                Intent intent = new Intent();
                someClass.text = editText.getText().toString();
                Log.d("ololo", someClass.text);
                intent.putExtra(MainActivity.RESULT_KEY,someClass);
                setResult(RESULT_OK, intent);
                finish();
           }
        });

        if (getIntent() != null) {
            someClass = (SomeClass) getIntent().getSerializableExtra(TEXT_KEY);
            textView.setText(someClass.text);
        } else {
            textView.setText("Nothing to show");
        }
    }
}
