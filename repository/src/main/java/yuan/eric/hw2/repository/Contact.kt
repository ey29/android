package yuan.eric.hw2.repository

import yuan.eric.hw2.data.Contact
import yuan.eric.hw2.data.ContactWithAddresses

data class ContactDto(
    val id: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
)

internal fun Contact.toDto() =
    ContactDto(id = id, firstName = firstName, lastName = lastName, phone = phone, email = email)
internal fun ContactDto.toEntity() =
    Contact(id = id, firstName = firstName, lastName = lastName, phone = phone, email = email)

data class ContactWithAddressesDto(
    val contact: ContactDto,
    val addresses: List<AddressDto>,
)

internal fun ContactWithAddresses.toDto() = ContactWithAddressesDto (
        contact = contact.toDto(),
        addresses = addresses.map{it.toDto()}
)