package database

import androidx.room.Entity

@Entity(tableName = "films_name")
data class filmEntity(
@primarykey
    val id:Long=0,
    val fName:String,
    val description:String,
    val pic:Int


) {
    annotation class primarykey
}
