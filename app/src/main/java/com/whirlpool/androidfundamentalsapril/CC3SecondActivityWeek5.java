package com.whirlpool.androidfundamentalsapril;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CC3SecondActivityWeek5 extends AppCompatActivity {
    public static final String SECOND_MESSAGE = "second_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_c3_second_week5);

        TextView messageInfo = findViewById(R.id.reply_message_info);
        TextView messageReceived = findViewById(R.id.message_received);

        final EditText message = findViewById(R.id.message);
        Button send = findViewById(R.id.send);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String receivedMessage = bundle.getString(CC3ActivityWeek5.FIRST_MESSAGE);
            messageReceived.setText(receivedMessage);
        }


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m = message.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(SECOND_MESSAGE, m);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
