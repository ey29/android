package yuan.eric.hw2.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

private val DustinHenderson = Contact(id = "c1", firstName = "Dustin", lastName = "Henderson", phone = "1012223333", email = "dh@gmail.com")
private val MikeWheeler = Contact(id = "c2", firstName = "Mike", lastName = "Wheeler", phone = "2022223333", email = "mw@gmail.com")
private val JaneHopper = Contact(id = "c3", firstName = "Jane", lastName = "Hopper", phone = "3032223333", email = "el@gmail.com")

@Dao
abstract class ContactDAO {
    @Query("SELECT * FROM Contact")
    abstract fun getContactsFlow(): Flow<List<Contact>>

    @Query("SELECT * FROM Address")
    abstract fun getAddressesFlow(): Flow<List<Address>>

    @Transaction
    @Query("SELECT * FROM Contact WHERE id = :id")
    abstract suspend fun getContactWithAddresses(id: String): ContactWithAddresses

    @Transaction
    @Query("SELECT * FROM Address WHERE id = :id")
    abstract suspend fun getAddress(id: String): Address

    @Insert
    abstract suspend fun insert(vararg contacts: Contact)
    @Insert
    abstract suspend fun insert(vararg addresses: Address)

    @Update
    abstract suspend fun update(vararg contacts: Contact)
    @Update
    abstract suspend fun update(vararg addresses: Address)

    @Delete
    abstract suspend fun delete(vararg contacts: Contact)
    @Delete
    abstract suspend fun delete(vararg addresses: Address)

    // reset and insert test data
    @Query("DELETE FROM Contact")
    abstract suspend fun clearContacts()
    @Query("DELETE FROM Address")
    abstract suspend fun clearAddresses()

    @Transaction
    open suspend fun resetDatabase() {
        clearContacts()
        clearAddresses()

        // insert sample contacts
        insert(DustinHenderson, MikeWheeler, JaneHopper)

        // insert sample addresses for contact c1
        insert(
            Address("a1", "home", "123 dustin st", "Hawkins", state = "IN", zip = "10101", contactId = "c1"),
            Address("a2", "school", "80 school ave", "Hawkins", state = "IN", zip = "10190", contactId = "c1"),
        )
        // insert sample addresses for contact c2
        insert(
            Address("a3", "home", "907 android st", "Hawkins", state = "IN", zip = "10222", contactId = "c2"),
            Address("a4", "school", "80 school ave", "Hawkins", state = "IN", zip = "10190", contactId = "c2"),
        )
        // insert sample addresses for contact c3
        insert(
            Address("a5", "home", "222 peas st", "Hawkins", state = "IN", zip = "10280", contactId = "c3"),
            Address("a6", "school", "80 school ave", "Hawkins", state = "IN", zip = "10190", contactId = "c3"),
        )

    }
}