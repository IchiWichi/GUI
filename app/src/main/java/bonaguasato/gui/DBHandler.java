package bonaguasato.gui;

/**
 * Created by kouichisato on 1/30/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "UBAS";
    //  table name
    private static final String TABLE_UBAS = "ubas" ;
    //  Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASSWORD = "password";
    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_UBAS + "("
        + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
        + KEY_PASSWORD + " TEXT " + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UBAS);
// Creating tables again
        onCreate(db);
    }
    public boolean validateUser(String name, String password){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_UBAS + " WHERE "
                        + KEY_NAME + "='" +name+"'AND "+KEY_PASSWORD+"='"+password+"'" ,  null);
        if (c.getCount() > 0) {
            return true;
        }
        else{return false;}

    }

    public void addUsers(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, username); //  Name
        values.put(KEY_PASSWORD, password); //  Password
// Inserting Row
        db.insert(TABLE_UBAS, null, values);
        db.close(); // Closing database connection
    }

    public UBAS getUsers(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_UBAS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PASSWORD }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        UBAS users = new UBAS(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
// return USERS
        return users;
    }

    // Getting All
    public List<UBAS> getAllUsers() {
        List<UBAS> usersList = new ArrayList<UBAS>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_UBAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                UBAS ubas = new UBAS();
                ubas.setId(Integer.parseInt(cursor.getString(0)));
                ubas.setName(cursor.getString(1));
                ubas.setPassword(cursor.getString(2));
// Adding contact to list
                usersList.add(ubas);
            } while (cursor.moveToNext());
        }
// return contact list
        return usersList;
    }

    // Getting shops Count
    public int getUsersCount() {
        String countQuery = "SELECT * FROM " + TABLE_UBAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
// return count
        return cursor.getCount();
    }

    // Updating a shop
    public int updateUsers(UBAS users) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, users.getName());
        values.put(KEY_PASSWORD, users.getPassword());
// updating row
        return db.update(TABLE_UBAS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(users.getId())});
    }

    // Deleting a shop
    public void deleteUsers(UBAS users) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_UBAS, KEY_ID + " = ?",
                new String[] { String.valueOf(users.getId()) });
        db.close();
    }
    public boolean sameUser(String username){
        Cursor c = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_UBAS + " WHERE "
                        + KEY_NAME + "='" + username  + "'" ,  null);
        if (c.getCount() > 0) {
            return true;
        }
        else{return false;}
    }



}
