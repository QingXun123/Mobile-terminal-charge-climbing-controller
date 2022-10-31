package com.example.android80;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private MyDBOpenHelper MyDBOpenHelper;
    private Context context;

    public StudentService(Context context) {
        this.context = context;
        MyDBOpenHelper = new MyDBOpenHelper(context);

    }

    // 添加
    public void save(Student student) {
        SQLiteDatabase db = MyDBOpenHelper.getWritableDatabase();
        db.execSQL("insert into student(name,age) values(?,?)", new Object[] {
                student.getEmail(), student.getPassword() });

    }

    // 更新操作
    public void update(Student student) {
        SQLiteDatabase db = MyDBOpenHelper.getWritableDatabase();
        db.execSQL("update student set name=?,age=?where studentid=?",
                new Object[] { student.getEmail(), student.getPassword(),
                        student.getId() });

    }

    // 查询操作
    public Student select(Integer id) {
        SQLiteDatabase db = MyDBOpenHelper.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "select studentid,name,age from student where studentid=?",
                new String[] { String.valueOf(id) });

        // 迭代记录集
        if (cursor.moveToNext()) {
            Student student = new Student();
            // 将查询的字段放在student标准
            student.setId(cursor.getInt(0));
            student.setEmail(cursor.getString(1));
            student.setPassword(cursor.getString(2));
            return student;

        }
        cursor.close();
        return null;

    }

    // 删除操作
    public void delete(Integer id) {
        SQLiteDatabase db = MyDBOpenHelper.getWritableDatabase();
        db.execSQL("delete from student where studentid=?", new Object[] { id });

    }

    // //
    // 数据分页操作
    public List<Student> getScrollData(int firstResult, int maxResult) {

        List<Student> students = new ArrayList<Student>();
        SQLiteDatabase db = MyDBOpenHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "select studentid,name,age from student limit ?,?",
                new String[] { String.valueOf(firstResult),
                        String.valueOf(maxResult) });

        while (cursor.moveToNext()) {

            Student student = new Student();
            student.setId(cursor.getInt(0));
            student.setEmail(cursor.getString(1));
            student.setPassword(cursor.getString(2));
            students.add(student);

        }
        cursor.close();

        return students;

    }

    // 获取记录的总数

    public long getCount() {
        SQLiteDatabase db = MyDBOpenHelper.getReadableDatabase();
        // 没有占位符的时候置为空null
        Cursor cursor = db.rawQuery("select count(*)from student", null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();

        return count;

    }

}