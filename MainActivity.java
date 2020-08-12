package com.yasarerkan.sendmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText adress;
    EditText subject;
    EditText content;
    String addressv,subjectv,contentv;
    Button sendbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        definition();
        sendemail();
    }
    public void definition(){

        adress=findViewById(R.id.mail1);
        subject=findViewById(R.id.subject1);
        content=findViewById(R.id.content1);
        sendbtn=findViewById(R.id.sndbtn);
    }
    public void getvalues(){
        addressv=adress.getText().toString();
        subjectv=subject.getText().toString();
        contentv=content.getText().toString();
    }

    public void sendemail(){
        getvalues();
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL,addressv);
                intent.putExtra(Intent.EXTRA_SUBJECT,subjectv);
                intent.putExtra(Intent.EXTRA_TEXT,contentv);
                startActivity(Intent.createChooser(intent,"Send Emaill"));

            }
        });


    }

}
