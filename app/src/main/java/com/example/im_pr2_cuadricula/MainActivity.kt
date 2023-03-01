package com.example.im_pr2_cuadricula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.im_pr2_cuadricula.ui.theme.DataSource
import com.example.im_pr2_cuadricula.ui.theme.IM_pr2_cuadriculaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IM_pr2_cuadriculaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    cuadriculaApp()
                }
            }
        }
    }
}


@Composable
@Preview
fun cuadriculaApp() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(DataSource.topics) { card ->
            TopicCard(topic = card)
        }
    }
}

@Preview
@Composable
fun previewCard() {
    TopicCard(topic = Topic(R.string.architecture, 58, R.drawable.architecture))
}

@Composable
fun TopicCard(topic: Topic) {
    Card {
        Row {
            Box() {
                Image(
                    painter = painterResource(id = topic.imageResouceID),
                    contentDescription = stringResource(
                        id = topic.stringResourceId
                    ),
                    modifier = Modifier
                        .height(68.dp)
                        .width(68.dp)
                        .aspectRatio(1f)
                )
            }

            Column {
                Text(
                    stringResource(id = topic.stringResourceId),
                    modifier = Modifier.padding(
                        bottom = 8.dp,
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
                )
                Row {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 16.dp, end = 8.dp)
                    )
                    Text(topic.numCursos.toString())
                }
            }
        }
    }
}

