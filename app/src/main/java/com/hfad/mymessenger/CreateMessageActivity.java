package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();

//        // intent to activity within the app
//        Intent intent = new Intent(this, ReceiveMessageActivity.class);
//        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, messageText);
//        startActivity(intent);

        // intent using action
        Intent intent = new Intent(Intent.ACTION_SEND);
        // MIME type
        intent.setType("text/plain");
        // put the message on the intent
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        // get the chooser title
        String chooserTitle = getString(R.string.chooser);
        // create the chooser
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        // start the selected activity
        startActivity(chosenIntent);
    }
}