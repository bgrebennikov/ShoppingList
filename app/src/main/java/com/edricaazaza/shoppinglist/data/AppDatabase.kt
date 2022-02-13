package com.edricaazaza.shoppinglist.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.edricaazaza.shoppinglist.data.entity.ShopItemDbModel


@Database(
    entities = [ShopItemDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getShopListDao() : ShopListDao

    companion object {

        private const val DATABASE_NAME = "shop_list.db"

        private var instance: AppDatabase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): AppDatabase {
            instance?.let { return it }

            synchronized(LOCK) {
                instance?.let {
                    return it
                }

                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DATABASE_NAME
                )
                    .allowMainThreadQueries()
                    .build()
                instance = db
                return db

            }

        }
    }

}