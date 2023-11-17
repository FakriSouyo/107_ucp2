import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.KeyboardType
import androidx.compose.material3.*
import androidx.compose.material3.icons.Icons
import androidx.compose.material3.icons.filled.MailOutline
import androidx.compose.material3.icons.filled.PersonOutline
import androidx.compose.material3.icons.filled.Title
import androidx.compose.material3.icons.filled.WorkOutline
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.formulirskripsi.ui.theme.FormulirSkripsiTheme

@Composable
fun HalamanHome(
    onNextButtonClicked: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var jurusan by remember { mutableStateOf("") }
    var judulSkripsi by remember { mutableStateOf("") }

    val image = painterResource(id = R.drawable.umylogo)

    var selectedRadioIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .padding(vertical = 50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(vertical = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))


                InputField("Nama", Icons.Default.PersonOutline, nama) { nama = it }
                InputField("NIM", Icons.Default.MailOutline, nim) { nim = it }
                InputField("Jurusan", Icons.Default.WorkOutline, jurusan) { jurusan = it }
                InputField("Judul Skripsi", Icons.Default.Title, judulSkripsi) { judulSkripsi = it }

                Spacer(modifier = Modifier.height(16.dp))


                RadioGroup(
                    options = listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5", "Option 6"),
                    selectedOption = selectedRadioIndex,
                    onOptionSelected = { selectedRadioIndex = it }
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.medium))
                .weight(1f, false),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = onNextButtonClicked
            ) {
                Text(stringResource(R.string.lanjut))
            }
        }
    }
}

@Composable
fun InputField(label: String, icon: ImageVector, value: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanged,
        label = { Text(label) },
        leadingIcon = { Icon(icon, contentDescription = null) },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    )
}

@Composable
fun RadioGroup(options: List<String>, selectedOption: Int, onOptionSelected: (Int) -> Unit) {
    var selectedOption by remember { mutableStateOf(selectedOption) }

    Column {
        options.forEachIndexed { index, option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                RadioButton(
                    selected = index == selectedOption,
                    onClick = {
                        selectedOption = index
                        onOptionSelected(index)
                    }
                )
                Text(text = option)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HalamanHomePreview() {
    FormulirSkripsiTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HalamanHome(
                onNextButtonClicked = {}
            )
        }
    }
}
