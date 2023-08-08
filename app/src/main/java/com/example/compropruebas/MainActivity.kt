package com.example.compropruebas

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compropruebas.reusables.CustomBox
import com.example.compropruebas.reusables.CustomModal
import com.example.compropruebas.reusables.ExampleContent
import com.example.compropruebas.ui.theme.ComproPruebasTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnrememberedMutableState")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val vm: MainViewModel = viewModel()
            ComproPruebasTheme {
                MyContent({ vm.showFullScreen() }, { vm.hideFullScreen() }, vm)
            }
        }
    }
}

@Composable
fun MyContent(
    showFullScreenDialog: () -> Unit,
    hideFullScreenDialog: () -> Unit,
    viewModel: MainViewModel? = null
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Box() {

            Image(
                painter = painterResource(id = R.drawable.b),
                contentDescription = "Modal Background Image",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            viewModel?.showFullScreenModal?.value?.let {
                CustomBox(
                    color = Color.White,
                    modalVisible = it,
                    onCloseModal = { hideFullScreenDialog() }) {
                    ExampleContent(viewModel = viewModel)
                }
            }

            if(!viewModel?.showFullScreenModal?.value!!){
                Box {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Example Content")
                        Button(onClick = { showFullScreenDialog() }) {
                            Text(text = "Show Modal")
                        }

                    }
                }
            }

        }//main box
    }
}



