package LevelAdapter;

import static com.example.mathpuzzles.MainActivity.preferences;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mathpuzzles.LevelActivity;
import com.example.mathpuzzles.R;
import com.example.mathpuzzles.SecondActivity;

public class LevelAdapter extends BaseAdapter {
    LevelActivity levelActivity;
    int[] no;
    int cnt;

    public LevelAdapter(LevelActivity levelActivity, int[] no, int cnt) {
        this.levelActivity = levelActivity;
        this.no = no;
        this.cnt = cnt;
    }

    @Override
    public int getCount() {
        return no.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = LayoutInflater.from(levelActivity).inflate(R.layout.activity_level_item,parent,false);

        String page = preferences.getString("page","pp");
        int levelNo=1;

        if(page.equals("p0")){
            ImageView lock = convertView.findViewById(R.id.lock);
            ImageView tick = convertView.findViewById(R.id.tick);
            TextView textView = convertView.findViewById(R.id.lockno);
            String status = preferences.getString("levelStatus"+(position+1),"pending");
            levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if(status.equals("win"))
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            }
            else if (status.equals("skip") || levelNo==position)
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(levelActivity, SecondActivity.class);
                    intent.putExtra("levelNo",position);
                    levelActivity.startActivity(intent);
                }
            });
        }

        if(page.equals("p1"))
        {
            ImageView lock = convertView.findViewById(R.id.lock);
            ImageView tick = convertView.findViewById(R.id.tick);
            TextView textView = convertView.findViewById(R.id.lockno);
            String status = preferences.getString("levelStatus"+(position+7),"pending");
            levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if(status.equals("win"))
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            }
            else if (status.equals("skip") || levelNo==position+7)
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(levelActivity, SecondActivity.class);
                    intent.putExtra("levelNo",position+6);
                    levelActivity.startActivity(intent);
                }
            });
        }

        if(page.equals("p2"))
        {
            ImageView lock = convertView.findViewById(R.id.lock);
            ImageView tick = convertView.findViewById(R.id.tick);
            TextView textView = convertView.findViewById(R.id.lockno);
            String status = preferences.getString("levelStatus"+(position+13),"pending");
            levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if(status.equals("win"))
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            }
            else if (status.equals("skip") || levelNo==position+13)
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(levelActivity, SecondActivity.class);
                    intent.putExtra("levelNo",position+12);
                    levelActivity.startActivity(intent);
                }
            });
        }

        if(page.equals("p3"))
        {
            ImageView lock = convertView.findViewById(R.id.lock);
            ImageView tick = convertView.findViewById(R.id.tick);
            TextView textView = convertView.findViewById(R.id.lockno);
            String status = preferences.getString("levelStatus"+(position+19),"pending");
            levelNo = preferences.getInt("levelNo",0);
            textView.setText("");

            if(status.equals("win"))
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
                tick.setImageResource(R.drawable.tick);
            }
            else if (status.equals("skip") || levelNo==position+19)
            {
                lock.setVisibility(View.INVISIBLE);
                textView.setText(""+no[position]);
            }

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(levelActivity, SecondActivity.class);
                    intent.putExtra("levelNo",position+18);
                    levelActivity.startActivity(intent);
                }
            });
        }
        return convertView;
    }
}

