package yuan.eric.hw2.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import yuan.eric.hw2.components.SimpleText
import yuan.eric.hw2.repository.AddressDto

@Composable
fun AddressDisplay(
    addressId: String,
    fetchAddress: suspend (String) -> AddressDto,
) {
    var addressDto by remember { mutableStateOf<AddressDto?>(null) }

    LaunchedEffect(key1 = addressId) {
        addressDto = fetchAddress(addressId)
    }

    SimpleText(text = "Address")
    addressDto?.let { address ->
        SimpleText(text = """
            Address Type: ${address.type} 
            
            ${address.city}
            
            ${address.state}
            
            ${address.street}
        """.trimIndent())
//        contactWithAddresses.addresses.forEach { address ->
//            SimpleText(text = "Address: ${address.type}")
//        }
    }
}