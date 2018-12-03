package application.android.example.com.arrayadaptersqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {
    private static String database="Databossname.db";
    private static String table="Mytableof";
    private static String name="name";
    private static String number="number";
    private static String subject="subject";
    public Database(Context context) {
        super(context, database, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Table="CREATE TABLE "+table+"("+name+" Text,"+number+" Text,"+subject+" Text)";
        db.execSQL(Table);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertdata(String Xname,String Xnumber,String Xsub){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues val=new ContentValues();
        val.put(name,Xname);
        val.put(number,Xnumber);
        val.put(subject,Xsub);
        long as=db.insert(table,null,val);
        db.close();
        return as;
    }
    public Cursor show(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM "+table,null);
        return cursor;
    }
}
