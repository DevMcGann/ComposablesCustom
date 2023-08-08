package com.example.compropruebas.reusables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CloseDialogButton(
    onDismiss: () -> Unit,
    closeButtonColor : Color = Color.Black,
    buttonSize : Dp = 40.dp
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.End
    ) {
        IconButton(onClick = { onDismiss() }) {
            Icon(
                imageVector = Icons.Default.Close ,
                contentDescription = "Close Modal",
                tint = closeButtonColor,
                modifier = Modifier.size(buttonSize) )
        }
    }
}