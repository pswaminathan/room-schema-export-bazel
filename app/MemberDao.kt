package app

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MemberDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(member: Member)

    @Query("SELECT * FROM Members WHERE id = :id")
    suspend fun get(id: Int): Member?
}