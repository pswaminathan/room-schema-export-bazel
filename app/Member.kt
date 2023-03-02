package app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Members")
data class Member(
    @PrimaryKey val id: Int,
    val name: String,
)