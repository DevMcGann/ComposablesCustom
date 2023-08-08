package com.example.compropruebas.reusables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.compropruebas.R


@Composable
fun CustomModal(
    content: @Composable () -> Unit,
) {
    ConstraintLayout {
        val (bgImg, modal, closeButton) = createRefs()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(bgImg) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
        ) {
            Image(
                painter = painterResource(id = R.drawable.b),
                contentDescription = "null",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Box (
            modifier = Modifier
                .constrainAs(closeButton){
                    top.linkTo(parent.top, margin = 50.dp)
                }
        ){
            CloseDialogButton(onDismiss = { /*TODO*/ })
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(fraction = 0.92f)
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(top = 20.dp)
                .constrainAs(modal) {
                    bottom.linkTo(parent.bottom)
                }
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun ModalPrev(){
    CustomModal() {
        ExampleContent()
    }
}




