package br.edu.unifacear.jogodavelha_android.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static SQLiteDatabase instance;
    public static SQLiteDatabase getInstance() {
        return instance;
    }
    public Conexao(Context context,
                   String name,
                   SQLiteDatabase.CursorFactory factory,
                   int version) {
        super(context, name, factory, version);
        instance = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table jogada(" +
                " id integer not null primary key autoincrement," +
                " posicao integer not null," +
                " jogada boolean not null)" +
                "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
