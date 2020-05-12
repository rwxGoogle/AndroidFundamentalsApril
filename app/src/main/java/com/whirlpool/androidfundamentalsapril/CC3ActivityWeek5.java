package com.whirlpool.androidfundamentalsapril;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CC3ActivityWeek5 extends AppCompatActivity {
    public static final String FIRST_MESSAGE = "first_message";
    public static final int REQ_CODE = 900;
    TextView messageInfo;
    TextView messageReceived;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_c3_week5);

        messageInfo = findViewById(R.id.reply_message_info);
        messageReceived = findViewById(R.id.message_received);

        final EditText message = findViewById(R.id.message);
        Button send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageToSend = message.getText().toString();
                Intent intent = new Intent(CC3ActivityWeek5.this, CC3SecondActivityWeek5.class);
                intent.putExtra(FIRST_MESSAGE, messageToSend);
                startActivityForResult(intent, REQ_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                messageInfo.setVisibility(View.VISIBLE);

                if (data != null) {
                    String receivedMessage = data.getStringExtra(CC3SecondActivityWeek5.SECOND_MESSAGE);
                    messageReceived.setText(receivedMessage);
                }
            }
        }
    }
}
