package yuan.eric.hw2.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import yuan.eric.hw2.components.SimpleText
import yuan.eric.hw2.repository.AddressDto
import yuan.eric.hw2.repository.ContactWithAddressesDto

@Composable
fun ContactDisplay(
    contactId: String,
    fetchContactWithAddresses: suspend (String) -> ContactWithAddressesDto,
) {
    var contactWithAddressesDto by remember { mutableStateOf<ContactWithAddressesDto?>(null) }

    LaunchedEffect(key1 = contactId) {
        contactWithAddressesDto = fetchContactWithAddresses(contactId)
    }

    SimpleText(text = "Contact")
    contactWithAddressesDto?.let { contactWithAddresses ->
        // SimpleText(text = "${contactWithAddresses.contact.lastName} ${contactWithAddresses.contact.firstName}")
        SimpleText(text = """
            Name: ${contactWithAddresses.contact.firstName} ${contactWithAddresses.contact.lastName}
            
            Phone number: ${contactWithAddresses.contact.phone}
            
            Email Address: ${contactWithAddresses.contact.email}
        """.trimIndent())

        contactWithAddresses.addresses.forEach { address ->
            SimpleText(text = "Address: ${address.type}")
        }
    }
}