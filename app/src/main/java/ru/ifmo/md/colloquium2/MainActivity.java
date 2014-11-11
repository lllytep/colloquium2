package ru.ifmo.md.colloquium2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button addButton = (Button) findViewById(R.id.button);
        final Button editButton = (Button) findViewById(R.id.button2);
        final Button goButton = (Button) findViewById(R.id.button3);

        final EditText editText = (EditText)findViewById(R.id.editText);

        final ListView listView = (ListView)findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        listView.setAdapter(adapter);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String candidate = editText.getText().toString();
                if(candidate.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Error! EditText is empty!", Toast.LENGTH_LONG);
                } else{
                    adapter.add(candidate);
                }
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String candidate = editText.getText().toString();
                if(!candidate.isEmpty())
                    textView.setText(candidate);
                else
                    Toast.makeText(getApplicationContext(), "Error! EditText is empty!", Toast.LENGTH_LONG);
            }
        });

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView = (TextView)view;
            }
        });

    }
}
