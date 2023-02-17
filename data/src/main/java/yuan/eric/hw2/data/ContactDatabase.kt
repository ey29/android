package yuan.eric.hw2.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        Contact::class,
        Address::class,
    ],
    exportSchema = false
)
abstract class ContactDatabase: RoomDatabase() {
    abstract val dao: ContactDAO
}  