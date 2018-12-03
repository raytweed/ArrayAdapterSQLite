package application.android.example.com.arrayadaptersqlite;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<ReturnClass> {
    public Adapter(Activity context, ArrayList<ReturnClass> listof) {
        super(context,0,listof);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listofcontent=convertView;
        if(listofcontent==null){
            listofcontent= LayoutInflater.from(getContext()).inflate(R.layout.layout,parent,false);
        }
        ReturnClass returnClass=getItem(position);
        TextView name=listofcontent.findViewById(R.id.name);
        name.setText(returnClass.getName());
        TextView num=listofcontent.findViewById(R.id.number);
        num.setText(returnClass.getNumber());
        TextView subject=listofcontent.findViewById(R.id.subject);
        subject.setText(returnClass.getSubject());
        ImageView img=listofcontent.findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Yasss!!",Toast.LENGTH_SHORT).show();
            }
        });
        return listofcontent;
    }

}
