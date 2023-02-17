package yuan.eric.hw2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import yuan.eric.hw2.screens.TestScreen
import yuan.eric.hw2.ui.theme.HW2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HW2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TestScreen()
                }
            }
        }
    }
}

/*
@Composable
fun AddressDisplay(
    address: AddressDto
) {
    SimpleText(text = "Address")
    Row {
        SimpleText(text = "Type")
        SimpleText(text = address.type)
    }
    Row {
        SimpleText(text = "Street")
        SimpleText(text = address.street)
    }
    Row {
        SimpleText(text = "City")
        SimpleText(text = address.city)
    }
    Row {
        SimpleText(text = "State")
        SimpleText(text = address.state)
    }
    Row {
        SimpleText(text = "Zip")
        SimpleText(text = address.zip)
    }
}
 */


