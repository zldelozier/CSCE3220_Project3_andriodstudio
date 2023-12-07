package com.example.project3

import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.project3.ui.theme.Project3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project3Theme {
                var pageNum = 1; //zero = base number/front of the book

                setContentView(R.layout.activity_main)

                val  nextButton = findViewById<Button>(R.id.nextButton)
                val previousButton = findViewById<Button>(R.id.backButton)
                val resetButton = findViewById<Button>(R.id.resetButton)

                val pageView = findViewById<ImageView>(R.id.pageImage)
                val pageBackground = findViewById<ImageView>(R.id.imageBackground)

                nextButton.setOnClickListener(){
                    //Toast.makeText(this, "next", Toast.LENGTH_SHORT).show()
                   displayImage(pageNum, pageView)
                    pageNum += 1
                    if(pageNum > 17){
                        pageNum = 0
                    }

                }
                previousButton.setOnClickListener(){
                    //Toast.makeText(this, "previous", Toast.LENGTH_SHORT).show()
                    displayImage(pageNum, pageView);
                    pageNum -= 1
                    if(pageNum > 17){
                        pageNum = 0
                    }

                }
                resetButton.setOnClickListener(){
                    //Toast.makeText(this, "Reset", Toast.LENGTH_SHORT).show()
                    pageNum = 0
                }
            }
        }
    }
}


fun displayImage(pageNum: Int, pageView: ImageView) {
    var pageName = ""

    if(pageNum == 0){
        pageView.SetImageResource(R.drawable.bookfront)
    }
    else if(pageNum == 17){
        pageView.SetImageResource(R.drawable.bookback)
    }
    else{
        pageName = "page".plus(pageNum)
        pageView.SetImageResource(R.drawable.pageName)//idk if I can do vars here
    }
}

