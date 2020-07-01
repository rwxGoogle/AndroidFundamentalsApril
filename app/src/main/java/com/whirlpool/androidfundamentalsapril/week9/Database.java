package com.whirlpool.androidfundamentalsapril.week9;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Created by roxanan on 9,June,2020
 */
@androidx.room.Database(entities = {PersonEntity.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract PersonDao personDao();

    private static Database DATABASE;

//    static final Migration MIGRATION1_2 = new Migration(1, 2) {
//
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            // TODO add what you what to change
//        }
//    };

    public static Database getDatabase(Context context) {
        if (DATABASE == null) {
            DATABASE = Room.databaseBuilder(context,
                    Database.class,
                    "my_database")
                    // .addMigrations(MIGRATION1_2)
                    .build();
        }
        return DATABASE;
    }

}