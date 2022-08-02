package com.vishnevskiypro.splitcostcompose

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vishnevskiypro.splitcostcompose.navigation.SplitCostNavHost
import com.vishnevskiypro.splitcostcompose.ui.theme.SplitCostComposeTheme
import com.vishnevskiypro.splitcostcompose.viewmodel.MainViewModel
import com.vishnevskiypro.splitcostcompose.viewmodel.MainViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplitCostComposeTheme {
                val context = LocalContext.current
                val mViewModel : MainViewModel =
                    viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
                mViewModel.initDatabase()

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Notes App")
                            },
                            backgroundColor = Color.Blue,
                            contentColor = Color.White,
                            elevation = 12.dp
                        )
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colors.background
                        ) {
                            SplitCostNavHost(mViewModel)
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SplitCostComposeTheme {
        
    }
}