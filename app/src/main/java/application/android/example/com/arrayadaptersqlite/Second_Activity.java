package application.android.example.com.arrayadaptersqlite;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Second_Activity extends AppCompatActivity {
    Database db;
    Cursor cur;
    int i,j,k;
    int l[][]=new int[i][j];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        db=new Database(this);
        ArrayList<ReturnClass> content=new ArrayList<>();
        cur=db.show();
        /*Here i'm using cur.moveToFirst because if you don't do it will directly jump to row 2nd of SQlite table and
        * result is that it won't show the data at row index 1*/
        cur.moveToFirst();
            if(cur.moveToFirst()){
                do {
                    /* From here as soon as cursor move to next position it get that row content as in my case at row 1..
                    * it will fetch 0th column index  that's name(Ansh), 1st column index it will show number(123),
                    * 2nd column it will show subject(Bio)...and you can continue to fetch data from a specified column
                    * by just inserting index of that column.*/
                    content.add(new ReturnClass(cur.getString(0), cur.getString(1),
                            cur.getString(2)));

                    }while(cur.moveToNext());
            }
        Adapter adapter=new Adapter(this,content);
        ListView listView=findViewById(R.id.listofcontent);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    menu.setHeaderTitle("Select Option");
    menu.add(0,v.getId(),0,"Update Contact");
    menu.add(0,v.getId(),0,"Delete Contact");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
       if(item.getTitle().equals("Delete Contact")){
           Toast.makeText(getApplicationContext(),"Deleted Contact",Toast.LENGTH_SHORT).show();
       }else  if(item.getTitle().equals("Update Contact")){
           Toast.makeText(getApplicationContext(),"Updated Contact",Toast.LENGTH_SHORT).show();
       }
       return true;
    }
}