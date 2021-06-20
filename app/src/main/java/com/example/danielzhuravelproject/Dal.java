package com.example.danielzhuravelproject;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.widget.ArrayAdapter;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class Dal extends SQLiteAssetHelper {
    public Dal(Context context) {
        super(context, "my_db.db", null, 1);
    }

    public void addUser(String name, String email, String password){ //מוסיפה משתמש לטבלה
        SQLiteDatabase db = getWritableDatabase();
        String sql_INSERT = "INSERT INTO users (name ,email ,password) values(?,?,?)";
        SQLiteStatement statment = db.compileStatement(sql_INSERT);

        statment.bindString(1, name);
        statment.bindString(2,email);
        statment.bindString(3,password);

        statment.execute();
    }

    public ArrayList<User> getAllUsers(){  //מחזירה מערך של כל המשתמשים
        ArrayList<User> ary = new ArrayList<>();
        String st = "SELECT * FROM users";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while(cursor.moveToNext()){
            User s = new User();
            s.setUsername(cursor.getString(cursor.getColumnIndex("name")));
            s.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            s.setPassword(cursor.getString(cursor.getColumnIndex("password")));

            ary.add(s);
        }
        return ary;
    }

    public ArrayList<Grade> getAllGradesByID(int userid){  //מחזירה מערך של כל הציונים
        ArrayList<Grade> ary = new ArrayList<>();
        String st = "SELECT * FROM grades WHERE userid = "+userid;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while(cursor.moveToNext()){
            Grade g = new Grade();
            g.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
            g.setGrade(cursor.getInt(cursor.getColumnIndex("grade")));
            g.setDate(cursor.getString(cursor.getColumnIndex("date")));
            g.setImg(cursor.getBlob(cursor.getColumnIndex("img")));

            ary.add(g);
        }
        return ary;
    }

    public ArrayList<ScheduleSubject> getAllSchedule(int userid, int dayNum){  //מחזירה מערך של כל המערכות שעות
        ArrayList<ScheduleSubject> ary = new ArrayList<>();
        String st = "SELECT hourNum, subject FROM schedule WHERE userid = '"+userid+"' AND dayNum = '"+dayNum+"'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while(cursor.moveToNext()){
            ScheduleSubject  s = new ScheduleSubject();
            s.setHourNum(cursor.getInt(cursor.getColumnIndex("hourNum")));
            s.setName(cursor.getString(cursor.getColumnIndex("subject")));

            ary.add(s);
        }
        return ary;
    }

   public ArrayList<Task> getAllTasks(){  //מחזירה מערך של כל המשימות
        ArrayList<Task> ary = new ArrayList<>();
        String st = "SELECT * FROM tasks";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while(cursor.moveToNext()){
            Task t = new Task();
            t.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
            t.setTaskTodo(cursor.getString(cursor.getColumnIndex("context")));
            if(cursor.getInt(cursor.getColumnIndex("isDone"))==1)
                t.setCheckBox(true);
            else t.setCheckBox(false);
            t.setDueDate(cursor.getString(cursor.getColumnIndex("dueDate")));
            t.setSubjectimg(cursor.getBlob(cursor.getColumnIndex("subImg")));

            ary.add(t);
        }
        return ary;
    }

    public ArrayList<Task> getAllTasksByid(int userid){  //מחזירה מערך של כל המשימות
        ArrayList<Task> ary = new ArrayList<>();
        String st = "SELECT * FROM tasks WHERE userid = "+userid+"";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while(cursor.moveToNext()){
            Task t = new Task();
            t.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
            t.setTaskTodo(cursor.getString(cursor.getColumnIndex("context")));
                t.setCheckBox(true);
            t.setDueDate(cursor.getString(cursor.getColumnIndex("dueDate")));
            t.setSubjectimg(cursor.getBlob(cursor.getColumnIndex("img")));
            t.setTaskID(cursor.getInt(cursor.getColumnIndex("taskid")));
            ary.add(t);
        }
        return ary;
    }

    public ArrayList<Test> getAllTests(int userid){  //מחזירה מערך של כל המבחנים
        ArrayList<Test> ary = new ArrayList<>();
        String st = "SELECT * FROM Task WHERE userid = '"+userid+"'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while(cursor.moveToNext()){
            Test t = new Test();
            t.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
            t.setDate(cursor.getString(cursor.getColumnIndex("date")));

            ary.add(t);
        }
        return ary;
    }

    public boolean userIsExists(String name, String password){
        String st = "SELECT * FROM users WHERE name = '"+name+"' AND password = '"+password+"'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        return cursor.getCount() == 1;
    }

    public User getUserByName(String name){
        String st = "SELECT * FROM users WHERE name = '"+name+"'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        cursor.moveToNext();
        User u = new User();
        u.setId(cursor.getInt(cursor.getColumnIndex("id")));
        u.setUsername(cursor.getString(cursor.getColumnIndex("name")));
        u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        u.setPassword(cursor.getString(cursor.getColumnIndex("password")));

        return u;
    }

    public void addSchedule(int dayNum, int hourNum, String subject){
        User u = new User();
        String st = "INSERT INTO users (dayName ,hourNum ,subject) values(?,?,?) WHERE userid = "+u.getId()+"'";
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statment = db.compileStatement(st);

        statment.bindDouble(1, dayNum);
        statment.bindDouble(2, hourNum);
        statment.bindString(3, subject);

        statment.execute();
    }

    public ArrayList<ScheduleSubject> getDayschedule(int dayNum, int userid){
        String st = "SELECT * FROM schedule WHERE dayNum = "+dayNum+" AND userid = "+userid+" ORDER BY hourNum ASC";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        ScheduleSubject s = new ScheduleSubject();
        ArrayList<ScheduleSubject> arr = new ArrayList<>();
        while(cursor.moveToNext()){
            s.setHourNum(cursor.getInt(cursor.getColumnIndex("hourNum")));
            s.setName(cursor.getString(cursor.getColumnIndex("subject")));

            arr.add(s);
        }
        return arr;

    }

    public ArrayList<String> getDaySubjects(int dayNum, int userid){
        String st = "SELECT subject FROM schedule WHERE dayNum = "+dayNum+" AND userid = "+userid+" ORDER BY hourNum ASC";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);

        ArrayList<String> arr = new ArrayList<>();
        while(cursor.moveToNext()){
            arr.add(cursor.getString(cursor.getColumnIndex("subject")));
        }
        return arr;

    }
    public void addDeafultSchedule(int userid){
        String st = "INSERT INTO schedule (dayNum, hourNum, subject, userid) values (?,?,?,?)";
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(st);

        statement.bindString(3,"");
        statement.bindDouble(4, userid);
        for(int i=1; i<7; i++)
        {
            for(int h = 1; h<10; h++)
            {

                statement.bindDouble(1, i);
                statement.bindDouble(2,h);
                statement.execute();
            }
        }
    }

    public void updateScheduleSubject(int dayNum, int hourNum, int userid, String subject){
        String st = "UPDATE schedule SET subject = '"+subject+"' WHERE userid = '"+userid+"' AND dayNum = '"+dayNum+"' AND hourNum = '"+hourNum+"'";
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(st);

        statement.execute();
    }

    public void addTask(Task task , int userid/*String subject, String context, int isDone, String dueDate, byte[] img*/){
        String st = "INSERT INTO tasks (subject, context, dueDate, img, userid) values(?,?,?,?,?)";
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(st);

        statement.bindString(1, task.getSubject());
        statement.bindString(2, task.getTaskTodo());
        statement.bindString(3, task.getDueDate());
        statement.bindBlob(4, task.getSubjectimg());
        statement.bindDouble(5, userid);

        statement.execute();
    }

    public void deleteDoneTasks(int taskid){
        String st = "DELETE FROM tasks WHERE taskID = "+taskid;
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(st);
        statement.execute();
    }

    public void addGrade(String subject, int grade, String date, byte[] img,int userid){
        String st = "INSERT INTO grades (subject ,grade, date, img, userid) values(?,?,?,?,?)";
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(st);

        statement.bindString(1, subject);
        statement.bindDouble(2, grade);
        statement.bindString(3,date);
        statement.bindBlob(4,img);
        statement.bindDouble(5,userid);

        statement.execute();
    }

    public void addSummary(String subject, String whatAbout, String fromwho, byte[] img){
        String st = "INSERT INTO summaries (subject ,whatabout, fromwho, img) values(?,?,?,?)";
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(st);

        statement.bindString(1,subject);
        statement.bindString(2, whatAbout);
        statement.bindString(3, fromwho);
        statement.bindBlob(4, img);

        statement.execute();
    }

    public ArrayList<Summarie> getAllSummaries(){  //מחזירה מערך של כל הציונים
        ArrayList<Summarie> ary = new ArrayList<>();
        String st = "SELECT * FROM summaries";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        while(cursor.moveToNext()){
            Summarie s = new Summarie();
            s.setSubject(cursor.getString(cursor.getColumnIndex("subject")));
            s.setWhatAbout(cursor.getString(cursor.getColumnIndex("whatabout")));
            s.setFromWho(cursor.getString(cursor.getColumnIndex("fromwho")));
            s.setImg(cursor.getBlob(cursor.getColumnIndex("img")));

            ary.add(s);
        }
        return ary;
    }

    public String getUserNameByID(int userid){
        String st = "SELECT name FROM users WHERE id = "+userid;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        cursor.moveToNext();
        return  cursor.getString(cursor.getColumnIndex("name"));
    }

    public String getTestByDateandID(String date, int userid){
        String st = "SELECT subject FROM tests WHERE userid = "+userid+" AND date = '"+date+"'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);
        cursor.moveToNext();
        return cursor.getString(cursor.getColumnIndex("subject"));

    }

    public boolean checkTest(String date, int userid){
        String st = "SELECT subject FROM tests WHERE userid = "+userid+" AND date = '"+date+"'";
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(st, null);

        return cursor.getCount()!=0;
    }

    public void addTest(String date,String subject, int userid){
        String st = "INSERT INTO tests (subject, date, userid) values (?,?,?)";
        SQLiteDatabase db = getWritableDatabase();
        SQLiteStatement statement = db.compileStatement(st);

        statement.bindString(1, subject);
        statement.bindString(2, date);
        statement.bindDouble(3, userid);

        statement.execute();
    }
}

