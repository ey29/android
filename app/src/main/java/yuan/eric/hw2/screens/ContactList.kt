package yuan.eric.hw2.screens

import androidx.compose.runtime.Composable
import yuan.eric.hw2.components.SimpleText
import yuan.eric.hw2.repository.ContactDto

@Composable
fun ContactList(
    contacts: List<ContactDto>,
    onContactClick: (String) -> Unit,
) {
    SimpleText(text = "Contacts")
    contacts.forEach {
        SimpleText(text = "${it.firstName} ${it.lastName}") {
            onContactClick(it.id)
        }
    }
}