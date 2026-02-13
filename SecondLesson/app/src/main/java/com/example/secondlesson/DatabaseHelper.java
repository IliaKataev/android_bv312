//package com.example.secondlesson;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//import com.example.secondlesson.models.HistoryItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseHelper extends SQLiteOpenHelper {
//
//    private static final String DATABASE_NAME = "my_database.db";
//    private static final int DATABASE_VERSION = 2;
//
//    private static final String TABLE_HISTORY = "history";
//    private static final String COLUMN_ID = "id";
//    private static final String COLUMN_EXPRESSION = "expression";
//    private static final String COLUMN_RESULT = "result";
//
//    public DatabaseHelper(@Nullable Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        String createTableQuery = "CREATE TABLE " + TABLE_HISTORY + " (" +
//                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                COLUMN_EXPRESSION + " TEXT, " +
//                COLUMN_RESULT + " TEXT, " +
//                "category_id INTEGER, " +
//                "FOREIGN KEY(category_id) REFERENCES categories(id)" +
//                ")";
//        db.execSQL(createTableQuery);
//
//        db.execSQL("CREATE TABLE categories (" +
//                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "name TEXT NOT NULL" +
//                ")");
//
//        db.execSQL("INSERT INTO categories (name) VALUES ('Обычные')");
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY);
//        db.execSQL("DROP TABLE IF EXISTS categories");
//        onCreate(db);
//    }
//
//    public void insertHistory(String expression, String result) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_EXPRESSION, expression);
//        values.put(COLUMN_RESULT, result);
//
//        db.insert(TABLE_HISTORY, null, values);
//        db.close();
//
//    }
//
//    public List<HistoryItem> getHistoryWithCategory(){
//        SQLiteDatabase db = this.getReadableDatabase();
//        List<HistoryItem> list = new ArrayList<>();
//
//        Cursor cursor = db.rawQuery(
//                "SELECT history.id, history.expression, history.result, categories.name " +
//                "FROM history" +
//                " LEFT JOIN categories ON history.category_id = categories.id", null);
//
//        if(cursor.moveToFirst()){
//            do{
//                int id = cursor.getInt(0);
//                String expression = cursor.getString(1);
//                String result = cursor.getString(2);
//                String category = cursor.getString(3);
//                list.add(new HistoryItem(id, expression + " = " + result + " (" + category + ")"));
//            }while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return list;
//    }
//
//    public List<HistoryItem> getHistory(){
//        List<HistoryItem> historyList = new ArrayList<>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_HISTORY, null);
//        if(cursor.moveToFirst()) {
//            do {
//                String expression = cursor.getString(1);
//                int id = cursor.getInt(0);
//                historyList.add(new HistoryItem(id, expression));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return historyList;
//    }
//
//    public void deleteItem(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TABLE_HISTORY, COLUMN_EXPRESSION + " = ?", new String[]{String.valueOf(id)});
//        db.close();
//    }
//}
