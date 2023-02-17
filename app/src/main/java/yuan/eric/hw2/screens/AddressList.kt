package yuan.eric.hw2.screens

import androidx.compose.runtime.Composable
import yuan.eric.hw2.components.SimpleText
import yuan.eric.hw2.repository.AddressDto


@Composable
fun AddressList(
    addresses: List<AddressDto>
) {
    SimpleText(text = "Addresses")
    addresses.forEach {
        SimpleText(text = "${it.type} ${it.street}")
    }
}