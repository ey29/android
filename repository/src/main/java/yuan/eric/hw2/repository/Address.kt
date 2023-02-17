package yuan.eric.hw2.repository

import yuan.eric.hw2.data.Address

data class AddressDto(
    val id: String,
    val type: String,
    val street: String,
    val city: String,
    val state: String,
    val zip: String,
    val contactId: String,
)

internal fun Address.toDto() =
    AddressDto(id = id, type = type, street = street, city = city, state = state, zip = zip, contactId = contactId)
internal fun AddressDto.toEntity() =
    Address(id = id, type = type, street = street, city = city, state = state, zip = zip, contactId = contactId)