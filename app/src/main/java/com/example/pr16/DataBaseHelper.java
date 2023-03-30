package com.example.pr16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "character.db";
    private static final int SCHEMA = 1;

    static final String TABLE_NAME = "Character";
    public static final String COLUMN_ID = "ID_Char";
    public static final String COLUMN_NAME = "Name_Char";
    public static final String COLUMN_CLASS = "Class_Char";

    public DataBaseHelper(@NotNull Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + " ( " +COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_CLASS + " TEXT); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addCharacter(Character character) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, character.getName_Char());
        contentValues.put(COLUMN_CLASS, character.getClass_Char());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public void UpgradeCharacter(int id, String Name, String Class) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, Name);
        contentValues.put(COLUMN_CLASS, Class);
        db.update(TABLE_NAME,contentValues, COLUMN_ID +" = "+id,null);
    }

    public  void DeleteCharacter(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,COLUMN_ID+" = " +id,null);
    }

    public ArrayList<Character> getCharacterList() {
        ArrayList<Character> listChar = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if(result.moveToFirst()) {
            while(result.moveToNext()) {
                int id = result.getInt(0);
                String charName = result.getString(1);
                String charClass = result.getString(2);
                Character character = new Character(id, charName, charClass);
                listChar.add(character);
            }
        }
        result.close();
        return listChar;
    }
}
