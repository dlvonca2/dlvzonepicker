package com.example.dlvzonepicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dlvzonepicker.ui.theme.DLVZonePickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DLVZonePickerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ZonePickerLayout()
                }
            }
        }
    }
}

@Composable
fun ZonePickerLayout() {

    var z1Input by remember { mutableStateOf("11") }
    var z2Input by remember { mutableStateOf("11") }
    var z3Input by remember { mutableStateOf("11") }
    var z4Input by remember { mutableStateOf("11") }
    var z5Input by remember { mutableStateOf("11") }
    var z6Input by remember { mutableStateOf("11") }
    var z7Input by remember { mutableStateOf("11") }
    var z8Input by remember { mutableStateOf("11") }
    var z9Input by remember { mutableStateOf("11") }
    var rollCount by remember { mutableIntStateOf(0) }

    val z1 = z1Input.toDoubleOrNull() ?: 11.0
    val z2 = z2Input.toDoubleOrNull() ?: 11.0
    val z3 = z3Input.toDoubleOrNull() ?: 11.0
    val z4 = z4Input.toDoubleOrNull() ?: 11.0
    val z5 = z5Input.toDoubleOrNull() ?: 11.0
    val z6 = z6Input.toDoubleOrNull() ?: 11.0
    val z7 = z7Input.toDoubleOrNull() ?: 11.0
    val z8 = z8Input.toDoubleOrNull() ?: 11.0
    val z9 = z9Input.toDoubleOrNull() ?: 11.0
    var result by remember { mutableIntStateOf(1) }
    val imageResource = when(result) {
        1 -> R.drawable.zone1
        2 -> R.drawable.zone2
        3 -> R.drawable.zone3
        4 -> R.drawable.zone4
        5 -> R.drawable.zone5
        6 -> R.drawable.zone6
        7 -> R.drawable.zone7
        8 -> R.drawable.zone8
        else -> R.drawable.zone9
    }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(imageResource), contentDescription = result.toString())

        Button(
            onClick = { result = calculateZone(z1, z2, z3, z4, z5, z6, z7, z8, z9);rollCount+=1},
        ) {
            Text(text = (stringResource(R.string.roll) + ":" + rollCount.toString()), fontSize = 24.sp)
        }
        EditNumberField(
            label = stringResource(R.string.zone1percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z1Input,
            onValueChanged = { z1Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone2percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z2Input,
            onValueChanged = { z2Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone3percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z3Input,
            onValueChanged = { z3Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone4percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z4Input,
            onValueChanged = { z4Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone5percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z5Input,
            onValueChanged = { z5Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone6percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z6Input,
            onValueChanged = { z6Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone7percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z7Input,
            onValueChanged = { z7Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone8percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z8Input,
            onValueChanged = { z8Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        EditNumberField(
            label = stringResource(R.string.zone9percent),
            leadingIcon = R.drawable.percent,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = z9Input,
            onValueChanged = { z9Input = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(
    label: String,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        singleLine = true,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        modifier = modifier,
        onValueChange = onValueChanged,
        label = { Text(label) },
        keyboardOptions = keyboardOptions
    )
}

/**
 * Calculates the tip based on the user input and format the tip amount
 * according to the local currency.
 * Example would be "$10.00".
 */
private fun calculateZone(z1: Double = 11.0, z2: Double = 11.0, z3: Double = 11.0, z4: Double = 11.0, z5: Double = 11.0, z6: Double = 11.0, z7: Double = 11.0, z8: Double = 11.0, z9: Double = 11.0): Int {
    var adjustedZ1 = z1 * 10000
    var adjustedZ2 = z2 * 10000
    var adjustedZ3 = z3 * 10000
    var adjustedZ4 = z4 * 10000
    var adjustedZ5 = z5 * 10000
    var adjustedZ6 = z6 * 10000
    var adjustedZ7 = z7 * 10000
    var adjustedZ8 = z8 * 10000
    var adjustedZ9 = z9 * 10000
    var totalZonePercent = adjustedZ1 +adjustedZ2 + adjustedZ3 +
            adjustedZ4 + adjustedZ5 +adjustedZ6 +
            adjustedZ7 + adjustedZ8 +adjustedZ9
    adjustedZ2 += adjustedZ1
    adjustedZ3 += adjustedZ2
    adjustedZ4 += adjustedZ3
    adjustedZ5 += adjustedZ4
    adjustedZ6 += adjustedZ5
    adjustedZ7 += adjustedZ6
    adjustedZ8 += adjustedZ7
    adjustedZ9 += adjustedZ8
    if ( totalZonePercent < 2.0 ) {
        totalZonePercent = 2.0
        adjustedZ1 = 2.0
    }
    val randomResult = (1..totalZonePercent.toInt()).random()
    if (randomResult <= adjustedZ1.toInt()) {
        return 1
    }
    if (randomResult <= adjustedZ2.toInt()) {
        return 2
    }
    if (randomResult <= adjustedZ3.toInt()) {
        return 3
    }
    if (randomResult <= adjustedZ4.toInt()) {
        return 4
    }
    if (randomResult <= adjustedZ5.toInt()) {
        return 5
    }
    if (randomResult <= adjustedZ6.toInt()) {
        return 6
    }
    if (randomResult <= adjustedZ7.toInt()) {
        return 7
    }
    if (randomResult <= adjustedZ8.toInt()) {
        return 8
    }
    return 9
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DLVZonePickerTheme {
        ZonePickerLayout()
    }
}