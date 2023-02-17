package yuan.eric.hw2

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import yuan.eric.hw2.repository.ContactDatabaseRepository
import yuan.eric.hw2.repository.ContactRepository

sealed interface Screen
object ContactList: Screen
object AddressList: Screen
data class ContactScreen(
    val id: String
): Screen

class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository = ContactDatabaseRepository(application)

    var screen by mutableStateOf<Screen>(ContactList)
        private set

    val contactsFlow = repository.contactsFlow
    val addressesFlow = repository.addressesFlow

    suspend fun getContactWithAddresses(id: String) =
        repository.getContactWithAddresses(id)

    fun switchTo(screen: Screen) {
        this.screen = screen
    }

    fun resetDatabase() {
        viewModelScope.launch {
            repository.resetDatabase()
        }
    }
}