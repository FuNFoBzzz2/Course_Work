package com.example.myapplication.BD

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.BD.Dao.RecipeDao

@Database(
    entities = [Recipe::class, Components::class, Binding::class],
    version = 1,
    exportSchema = false
)
abstract class DataBase: RoomDatabase() {
    abstract fun RecipeDao(): RecipeDao

    companion object {
        // Переменная для хранения единственного экземпляра базы данных
        @Volatile
        private var INSTANCE: DataBase? = null

        // Функция для получения экземпляра базы данных
        fun getDatabase(context: Context): DataBase {
            // Проверяем, существует ли уже экземпляр базы данных
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            // Синхронизируем доступ к созданию экземпляра базы данных, чтобы избежать возможных проблем с многопоточностью
            synchronized(this) {
                // Создаем экземпляр базы данных
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "Clothes_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}