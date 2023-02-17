package yuan.eric.hw2.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import yuan.eric.hw2.*
import yuan.eric.hw2.components.SimpleButton

@Composable
fun TestScreen(
    viewModel: ContactViewModel = viewModel()
) {
    Column {
        Row {
            SimpleButton("Reset") {
                viewModel.resetDatabase()
            }
            SimpleButton("Contacts") {
                viewModel.switchTo(ContactList)
            }
        }
        Row {
            SimpleButton("Addresses") {
                viewModel.switchTo(AddressList)
            }
        }
        val contacts by viewModel.contactsFlow.collectAsState(initial = emptyList())
        val addresses by viewModel.addressesFlow.collectAsState(initial = emptyList())

        when(val screen = viewModel.screen) {
            ContactList -> ContactList(contacts = contacts) { id ->
                viewModel.switchTo(ContactScreen(id))
            }
            AddressList -> AddressList(addresses = addresses)
            is ContactScreen -> ContactDisplay(
                contactId = screen.id,
                fetchContactWithAddresses = { id ->
                    viewModel.getContactWithAddresses(id)
                }
            )
        }
    }
}