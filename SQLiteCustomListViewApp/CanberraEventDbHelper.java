package au.edu.canberra.listviewactionbarmenuapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Tashvi G on 13/03/2017.
 */

public class CanberraEventDbHelper extends SQLiteOpenHelper {
    public CanberraEventDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(" +
                COLUMN_ID + " integer primary key, " +
                COLUMN_TITLE + " text, " +
                COLUMN_IMAGE_RESOURCE + " integer, " +
                COLUMN_DATE + " text)" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_NAME);
        onCreate(db);


    }
    public static final String TABLE_NAME = "events";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_IMAGE_RESOURCE = "image_resource";
    public static final String COLUMN_DATE = "date";

    public ArrayList<CanberraEvent> getAllEvents() {
        ArrayList<CanberraEvent> eventList = new ArrayList<CanberraEvent>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            CanberraEvent event = new CanberraEvent(
                    res.getString(res.getColumnIndex(COLUMN_TITLE)),
                    res.getInt(res.getColumnIndex(COLUMN_IMAGE_RESOURCE)),
                    new Date(res.getString(res.getColumnIndex(COLUMN_DATE)) ));
            eventList.add(event);
            res.moveToNext();
        }
        return eventList;
    }

    public boolean insertEvent(CanberraEvent event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, event.getTitle());
        contentValues.put(COLUMN_IMAGE_RESOURCE, event.getImageResource());
        contentValues.put(COLUMN_DATE, event.getDateString());
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public Integer deleteEvent(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "id = ? ", new String[]{id});
    }

    public boolean updateEvent(String id, CanberraEvent event) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, event.getTitle());
        contentValues.put(COLUMN_IMAGE_RESOURCE, event.getImageResource());
        contentValues.put(COLUMN_DATE, event.getDateString());
        db.update(TABLE_NAME, contentValues, "id = ? ", new String[]{id});
        return true;
    }


}
