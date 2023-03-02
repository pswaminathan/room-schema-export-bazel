package app

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        Member::class,
    ],
    exportSchema = true,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun memberDao(): MemberDao
}
