package snowdrop.nnt.ontapck;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataUser extends SQLiteOpenHelper {
    public DataUser(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE user ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "age INTEGER NOT NULL," +
                "email INTEGER NOT NULL," +
                "gioiTinh TEXT NOT NULL)";
        db.execSQL(sql);
    }
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("age", user.getAge());
        values.put("email", user.getEmail());
        values.put("gioiTinh", user.getGioiTinh());
        db.insert("user", null, values);
    }
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setAge(cursor.getInt(2));
                user.setEmail(cursor.getString(3));
                user.setGioiTinh(cursor.getString(4));
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return userList;
    }
    public int removeUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("user", "id=?", new String[]{String.valueOf(id)});
    }
    public User findUserById(int id) {
        String sql="select * from user where id="+id;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor !=null){
            if (cursor.moveToFirst()) {
                    User user = new User();
                    user.setId(cursor.getInt(0));
                    user.setName(cursor.getString(1));
                    user.setAge(cursor.getInt(2));
                    user.setEmail(cursor.getString(3));
                    user.setGioiTinh(cursor.getString(4));
                    return user;
            }
        }
        return null;
    }
    public void updateUser(int id,String name,int age,String email) {
        String sql="update user set name="+name+",age="+age+",email="+email+" where id="+id;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        values.put("email", email);
        db.update("user", values,null, null);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }
}
