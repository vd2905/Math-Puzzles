package LevelAdapter;

import static com.example.mathpuzzles.MainActivity.preferences;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mathpuzzles.LevelActivity;
import com.example.mathpuzzles.R;

public class LevelAdapter extends BaseAdapter {
    LevelActivity levelActivity;
    int[] no;

    public LevelAdapter(LevelActivity levelActivity, int[] no) {
        this.levelActivity = levelActivity;
        this.no = no;
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

        ImageView imageView = convertView.findViewById(R.id.lockimg);
        TextView textView = convertView.findViewById(R.id.lockno);
        String status=preferences.getString("levelstatus"+position,"pending");
        int levelNo=preferences.getInt("levelNo",0);

        if(status.equals("win"))
        {
            imageView.setImageResource(R.drawable.tick);
            textView.setText(""+(position+1));
            textView.setVisibility(View.VISIBLE);
        }
        else if (status.equals("skip") || position==levelNo+1)
        {
            textView.setText(""+(position+1));
            textView.setVisibility(View.VISIBLE);
        }
        Log.d("TTT", "getView: Status="+status);

        return convertView;
    }
}

