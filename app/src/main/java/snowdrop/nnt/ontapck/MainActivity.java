package snowdrop.nnt.ontapck;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnAdd, btnSearch, btnDelete, btnResetData, btnUpdate,btnSend;
    EditText txtname, txtemail, txtage, txtSearch;
    ListView listView;
    List<User> users = new ArrayList<>();
    MyAdapter adapter;
    DataUser dataUser;
    ArrayList<User> listUser;
    ArrayList idList;
    int index;
    String gioiTinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataUser = new DataUser(this, "userdb.sqlite", null, 1);
        idList = new ArrayList();
        listUser = new ArrayList<>();
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnResetData = findViewById(R.id.btnReset);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnSend = findViewById(R.id.btnSend);
        btnSearch = findViewById(R.id.btnSearch);
        txtname = findViewById(R.id.name);
        txtemail = findViewById(R.id.email);
        listView = findViewById(R.id.lv);
        txtage = findViewById(R.id.age);
        txtSearch = findViewById(R.id.search);
        users = dataUser.getAll();
        getNameList();
        adapter = new MyAdapter(this, R.layout.item, users);
        listView.setAdapter(adapter);
        Spinner spinner=findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                gioiTinh=parent.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtname.getText().toString().trim();
                String age = txtage.getText().toString().trim();
                String email = txtemail.getText().toString().trim();
//                User user = new User(name, Integer.parseInt(age), email);
                dataUser.addUser(new User(name, Integer.parseInt(age), email,gioiTinh));
                getNameList();
                adapter.notifyDataSetChanged();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataUser.removeUser((Integer) idList.get(index));
                getNameList();
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtSearch.getText().toString().trim();
                try {
                    users.clear();
                    users.add(dataUser.findUserById(Integer.parseInt(id)));
                    adapter.notifyDataSetChanged();
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Nhap id la so nguyen", Toast.LENGTH_SHORT).show();
                } catch (NullPointerException e){
                    Toast.makeText(MainActivity.this, "khong ton tai user", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnResetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNameList();
                adapter.notifyDataSetChanged();
            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getBaseContext(),MainActivity2.class);
                intent.putExtra("a","bqweqweqwe");
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }
        });
    }
    private List<User> getNameList() {
//        itco
        users.clear();
        idList.clear();
        for (Iterator iterator = dataUser.getAll().iterator(); iterator.hasNext(); ) {
            User user = (User) iterator.next();
            idList.add(user.getId());
            user.getName();
            user.getAge();
            user.getEmail();
            user.getGioiTinh();
            users.add(user);
        }
        return users;
    }
}