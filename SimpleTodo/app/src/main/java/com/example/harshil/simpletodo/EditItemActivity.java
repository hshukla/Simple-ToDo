package com.example.harshil.simpletodo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class EditItemActivity extends ActionBarActivity {
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        String textToEdit = getIntent().getStringExtra("edit_text");
        pos = getIntent().getExtras().getInt("pos");

        EditText mvText = (EditText) findViewById(R.id.etEditItem);
        mvText.setText(textToEdit);
        mvText.setSelection(mvText.getText().length());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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

    public void onSaveItem(View view) {
        EditText editedText = (EditText) findViewById(R.id.etEditItem);
        Intent data = new Intent();

        data.putExtra("edited_text", editedText.getText().toString());
        data.putExtra("pos", pos);
        setResult(RESULT_OK, data);

        finish();
    }
}
