package com.example.dksub.fifafixtures;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    public class listItems
    {
        int image_1;
        int image_2;
        String name_1;
        String name_2;
        String venue_s;
        String date_time_s;

         listItems (int im1, int im2, String a, String b, String c, String d )
        {
            this.image_1=im1;
            this.image_2=im2;
            this.name_1=a;
            this.name_2=b;
            this.venue_s=c;
            this.date_time_s=d;
        }


    }


    listItems newItem=new listItems(R.drawable.ic_launcher_foreground,R.drawable.telph,"Spain","Germany","Moscow","day 2");
    ArrayList<listItems> arr= new ArrayList<listItems>(Arrays.asList(newItem,newItem));
    ArrayAdapter<listItems> arrAdapt= new ArrayAdapter<listItems>(this, R.layout.custom_row, arr);






    int lenTot=arr.size();

  /*  public void addClick(View view)
    {
        EditText newName1 = (EditText)findViewById(R.id.editTeam1);
        EditText newName2 = (EditText)findViewById(R.id.editTeam2);
        EditText newVenue = (EditText)findViewById(R.id.editVenue);
        EditText newDate = (EditText)findViewById(R.id.editDate);

        listItems newItem= new listItems(R.drawable.ic_launcher_foreground,R.drawable.telph,newName1.getText().toString(),newName2.getText().toString(),newVenue.getText().toString(),newDate.getText().toString());
        arr.add(newItem);
        arrAdapt.notifyDataSetChanged();

    }*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listV = (ListView) findViewById(R.id.my_list);

        CustomAdapter ca= new CustomAdapter(this,arr);
        listV.setAdapter(ca);



}


class CustomAdapter extends ArrayAdapter<listItems>
{
    public CustomAdapter(Context context, ArrayList<listItems> users) {
        super(context, 0, users);
    }

    @Override
    public int getCount() {

        return lenTot;
    }


    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewgroup) {


        view= getLayoutInflater().inflate(R.layout.custom_row,null);


        ImageView img1= (ImageView)view.findViewById(R.id.image_1);
        ImageView img2= (ImageView)view.findViewById(R.id.image_2);
        TextView venue= (TextView)view.findViewById(R.id.venue);
        TextView name1= (TextView)view.findViewById(R.id.name_1);
        TextView name2= (TextView)view.findViewById(R.id.name_2);
        TextView date_time= (TextView)view.findViewById(R.id.date_time);

        listItems gaga= arr.get(position);
        img1.setImageResource(gaga.image_1);
        img2.setImageResource(gaga.image_2);
        venue.setText(gaga.venue_s);
        name1.setText(gaga.name_1);
        name2.setText(gaga.name_2);
        date_time.setText(gaga.date_time_s);

        return view;
    }

}

}
