package com.example.namtarn.calapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class AdduserActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }

    public void addClicked(View v) {
        EditText inname = (EditText)findViewById(R.id.inname);
        EditText inage = (EditText)findViewById(R.id.inage);
        EditText inh = (EditText)findViewById(R.id.inh);
        EditText inw= (EditText)findViewById(R.id.inw);
        RadioGroup rg = (RadioGroup)findViewById(R.id.rg);

        String name = inname.getText().toString();
        String age = inage.getText().toString();
        String height = inh.getText().toString();
        String weight = inw.getText().toString();

        //int age =  Integer.parseInt(inage.getText().toString());
        //int height=  Integer.parseInt(inh.getText().toString());
        //int weight =  Integer.parseInt(inw.getText().toString());


        if (name.trim().length() == 0 || age.trim().length() == 0 || height.trim().length() == 0 || weight.trim().length() == 0) {
            Toast t = Toast.makeText(this.getApplicationContext(),
                    "All information are necessary.",
                    Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            Intent result = new Intent();
            result.putExtra("name", name);
            result.putExtra("age", Integer.valueOf(age));
            result.putExtra("height", Integer.valueOf(height));
            result.putExtra("weight", Integer.valueOf(weight));



            int rID = rg.getCheckedRadioButtonId();
            String gender = ((RadioButton)findViewById(rID)).getText().toString();
            result.putExtra("gender", gender);
            this.setResult(RESULT_OK, result);
            this.finish();
        }
    }

    public void buttonClicked1(View v) {
        int id = v.getId();
        Intent i;

        switch(id) {
            case R.id.button:
                i = new Intent(this, AddcalActivity.class);
                //startActivityForResult(i, 88);
                startActivity(i);
                break;

            case R.id.button2:
                i = new Intent(this, ListuserActivity.class);
                startActivity(i);
                break;



        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
