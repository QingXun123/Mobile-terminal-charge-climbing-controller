package com.example.android80;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Master extends AppCompatActivity implements View.OnClickListener {
    private Button loginBtn;
    private EditText editTextTextEmailAddress;
    private EditText editTextTextPassword;
    private Connection conn;
    private String text;
    private MyDBOpenHelper myDBOpenHelper;
    private SQLiteDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);

        loginBtn = findViewById(R.id.loginBtn);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editTextTextPassword = findViewById(R.id.editTextTextPassword);
        myDBOpenHelper = new MyDBOpenHelper(this);
        db = myDBOpenHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from student", null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                System.out.println(cursor.getString(0));
                System.out.println(cursor.getString(1));
                editTextTextEmailAddress.setText(cursor.getString(0));
                editTextTextPassword.setText(cursor.getString(1));
                break;
            }
        }
        db.close();
        cursor.close();

        loginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                new Thread(select).start();
        }
    }

    final Runnable select = new Runnable() {
        @Override
        public void run() {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://47.112.115.77:3306/test?characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC", "root", "SzSz2003..");
                Statement s = conn.createStatement();
                // 准备sql语句
                // 注意： 字符串要用单引号'
                //在statement中使用字符串拼接的方式，这种方式存在诸多问题
                String sql = "select * from student where email =\'" + editTextTextEmailAddress.getText() + "\';";
                ResultSet rs = s.executeQuery(sql);
                Boolean flag = true;
                while (rs.next()) {
                    flag = false;
                    if (rs.getString("email").equals(String.valueOf(editTextTextEmailAddress.getText()))) {
                        if (rs.getString("password").equals(String.valueOf(editTextTextPassword.getText()))) {
                            db = myDBOpenHelper.getWritableDatabase();
                            db.execSQL("delete from student;");
                            db.execSQL("INSERT INTO student(email, password) values (?, ?)", new Object[]{editTextTextEmailAddress.getText(), editTextTextPassword.getText()});
                            db.close();
                            Intent intent = new Intent();
                            intent.setClass(Master.this, Console.class);
                            startActivity(intent);
                            text = "登录成功";
                            Toast.makeText(getApplicationContext(), "登录成功！", Toast.LENGTH_SHORT).show();
                        } else {
                            text = "密码错误！";
                            Toast.makeText(getApplicationContext(), "密码错误！", Toast.LENGTH_SHORT).show();
                        }
                    }
                    System.out.println(rs.getString("email"));
                    System.out.println(rs.getString("password"));
                }
                if (flag) {
                    text = "账号不存在！";
                    Toast.makeText(getApplicationContext(), "账号不存在！", Toast.LENGTH_SHORT).show();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                Looper.prepare();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                Looper.loop();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}