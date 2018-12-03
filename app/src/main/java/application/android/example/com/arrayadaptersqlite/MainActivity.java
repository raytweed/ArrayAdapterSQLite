package application.android.example.com.arrayadaptersqlite;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,number,subject;
    Button save,show;
    Database mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new Database(this);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        save=findViewById(R.id.save);
        show=findViewById(R.id.show);
        subject=findViewById(R.id.subject);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long inser=mydb.insertdata(name.getText().toString(),number.getText().toString(),subject.getText().toString());
                if(inser==-1){
                    Toast.makeText(getApplicationContext(),"No Record Added!",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Record Added!",Toast.LENGTH_SHORT).show();
                    }
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Second_Activity.class);
                startActivity(i);
            }
        });

    }
}
