package com.ymg.compose.constraintset

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.ymg.compose.constraintset.ui.theme.ConstraintSetTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintSetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ConstraintSetEx()
                }
            }
        }
    }
}

@Composable
fun ConstraintSetEx() {
    val constraintSet = ConstraintSet {
        val redBox = createRefFor("redBox")
        val magentaBox = createRefFor("magentaBox")
        val greenBox = createRefFor("greenBox")
        val yellowBox = createRefFor("yellowBox")

        constrain(redBox) {
            bottom.linkTo(parent.bottom, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(magentaBox) {
            start.linkTo(parent.start, 10.dp)
            end.linkTo(parent.end, 30.dp)
        }

        constrain(greenBox) {
            centerTo(parent)
        }

        constrain(yellowBox) {
            start.linkTo(greenBox.end)
            top.linkTo(greenBox.bottom)
        }
    }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize(),
        constraintSet = constraintSet
    ) {
        // val (redBox, magentaBox, greenBox, yellowBox) = createRefs()

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Red)
                .layoutId("redBox")
                /*
                .constrainAs(redBox) {
                    bottom.linkTo(parent.bottom, 10.dp)
                    end.linkTo(parent.end, 30.dp)
                }
                */
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Magenta)
                .layoutId("magentaBox")
                /*
                .constrainAs(magentaBox) {
                    start.linkTo(parent.start, 10.dp)
                    end.linkTo(parent.end, 30.dp)
                }
                */
        )
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Green)
                .layoutId("greenBox")
                /*
                .constrainAs(greenBox) {
                    centerTo(parent)
                }
                */
        )

        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Yellow)
                .layoutId("yellowBox")
                /*
                .constrainAs(yellowBox) {
                    start.linkTo(greenBox.end)
                    top.linkTo(greenBox.bottom)
                }
                */
        )
    }


    /**
     * createRefFor() 로 레퍼런스를 만들고 constrain() 로 제약을 만들 수 있음
     */
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConstraintSetTheme {
        ConstraintSetEx()
    }
}