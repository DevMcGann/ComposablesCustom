package com.example.compropruebas.reusables


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compropruebas.R


@Composable
fun CustomBox(
    color: Color = Color.White,
    bgImage : Int = R.drawable.b,
    modalHeightFloat : Float = .95f,
    onCloseModal : ()-> Unit,
    modalVisible : Boolean,
    content: @Composable () -> Unit
    //we can add N parameters to customize the modal behavior
) {
    AnimatedVisibility(
        visible = modalVisible,
        enter = slideInVertically(
            initialOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 650, easing = LinearOutSlowInEasing)
        ),
        exit = slideOutVertically(
            targetOffsetY = { fullHeight -> fullHeight },
            animationSpec = tween(durationMillis = 650, easing = FastOutLinearInEasing)
        ),

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = bgImage),
                contentDescription = "Modal Background Image",
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            Box(modifier = Modifier.clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(fraction = modalHeightFloat)
                        .fillMaxWidth()
                        .background(color),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    //Should the modal include his close button, or every dev implementing it will handle that on his content?
                    CloseDialogButton(onDismiss = { onCloseModal() })
                    //content should be responsible for managing business logic and scroll behavior
                    content()
                }
            }
        }
    }
}


@Preview
@Composable
fun CustomPrev(){
    CustomBox(color = Color.White, bgImage = R.drawable.b, onCloseModal = {}, modalVisible = true) {
        ExampleContent()
    }
}