package snowdrop.nnt.ontapck;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> users;

    public MyAdapter(Context context, int layout, List<User> users) {
        this.context = context;
        this.layout = layout;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        Button update, close;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtName = convertView.findViewById(R.id.iname);
            viewHolder.txtAge = convertView.findViewById(R.id.iage);
            viewHolder.txtEmail = convertView.findViewById(R.id.iemail);
            viewHolder.txtGioiTinh = convertView.findViewById(R.id.txtGioiTinh);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        User user = users.get(position);
        viewHolder.txtName.setText("Tên: " + user.getName());
        viewHolder.txtAge.setText("Tuổi: " + String.valueOf(user.getAge()));
        viewHolder.txtEmail.setText("Email: " + user.getEmail());
        viewHolder.txtGioiTinh.setText("Giới tính: " + user.getGioiTinh());
        return convertView;
    }
    private class ViewHolder {
        TextView txtName, txtAge, txtEmail, txtGioiTinh;
    }
}
