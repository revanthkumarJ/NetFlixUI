package com.example.netflixui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(top = 20.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())

            )
            {
                TopBar()
                TopBelowText()
                TopImage()
                RecentMovies()
                AnimeMovies()
                TeluguMovies()
                Drama()
                Marvel()
                HorrorMovies()
                CartoonMovies()
                ActionMovies()
            }

        }
    }
}

@Composable
@Preview
fun TopBar() {
 Row (modifier= Modifier
     .fillMaxWidth()
     .background(Color.Black),
     horizontalArrangement = Arrangement.SpaceBetween,
     verticalAlignment = Alignment.CenterVertically
 ){
    Image(painter = painterResource(id = R.drawable.netflix), contentDescription ="netflix icon",
        modifier = Modifier.size(80.dp)
    )
     Row (
         
     ){
         Image(painter = painterResource(id = R.drawable.icon_search), contentDescription ="netflix icon",

             modifier = Modifier
                 .size(50.dp)
                 .padding(end = 20.dp)
         )
         Image(painter = painterResource(id = R.drawable.icon_profile), contentDescription ="netflix icon",
             modifier = Modifier
                 .size(50.dp)
                 .padding(end = 20.dp)
             )

     }
 }
}

@Composable
@Preview
fun TopBelowText()
{
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Black)
        .padding(horizontal = 30.dp, vertical = 20.dp)
        , horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
    Text(text = "TV Shows", color = Color.LightGray, fontSize = 19.sp)
        Text(text = "Movies", color = Color.LightGray, fontSize = 19.sp)
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Categories", color = Color.LightGray, fontSize = 19.sp)

            Image(painter = painterResource(id = R.drawable.baseline_arrow_drop_down_24), contentDescription ="drop down" )

        }

       }
}


@Composable
@Preview
fun TopImage() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(top = 25.dp, bottom = 25.dp), verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.top1), contentDescription = "Top Image",
            modifier = Modifier
                .size(width = 400.dp, height = 240.dp)
                .padding(top = 20.dp, bottom = 20.dp, start = 2.dp, end = 2.dp)
        )
        Row(
            modifier = Modifier
                .padding(horizontal = 36.dp, vertical = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(text = "Indian", color = Color.White, fontSize = 17.sp)
            Text(text = "Science", color = Color.White, fontSize = 17.sp)
            Text(text = "Fiction", color = Color.White, fontSize = 17.sp)
            Text(text = "Action", color = Color.White, fontSize = 17.sp)
        }
        Row(
            modifier = Modifier
                .padding(top = 25.dp)
                .fillMaxWidth()
                .padding(horizontal = 36.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_plus),
                    contentDescription = "plus",
                    modifier = Modifier.size(25.dp)
                )
                Text(
                    text = "MyList",
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 7.dp)
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(text = "Play", fontSize = 20.sp, color = Color.Black)
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icon_info),
                    contentDescription = "plus",
                    modifier = Modifier.size(26.dp)
                )
                Text(
                    text = "info",
                    color = Color.LightGray,
                    modifier = Modifier.padding(top = 7.dp)
                )
            }
        }
    }
}

data class imageItem(
    var image:Int,
)


@Composable
@Preview
fun RecentMovies()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.image0))
    listOfMovies.add(imageItem(R.drawable.anime3))
    listOfMovies.add(imageItem(R.drawable.image2))
    listOfMovies.add(imageItem(R.drawable.image1))
    listOfMovies.add(imageItem(R.drawable.image3))
    listOfMovies.add(imageItem(R.drawable.image4))
    listOfMovies.add(imageItem(R.drawable.image5))
    listOfMovies.add(imageItem(R.drawable.image6))

    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Watch It Again",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}

@Composable
@Preview
fun AnimeMovies()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.anime0))
    listOfMovies.add(imageItem(R.drawable.anime1))
    listOfMovies.add(imageItem(R.drawable.anime5))
    listOfMovies.add(imageItem(R.drawable.anime3))
    listOfMovies.add(imageItem(R.drawable.anime2))
    listOfMovies.add(imageItem(R.drawable.anime4))
    listOfMovies.add(imageItem(R.drawable.anime6))

    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Anime",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}


@Composable
@Preview
fun TeluguMovies()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.telugu1))
    listOfMovies.add(imageItem(R.drawable.telugu2))
    listOfMovies.add(imageItem(R.drawable.telugu4))
    listOfMovies.add(imageItem(R.drawable.telugu3))
    listOfMovies.add(imageItem(R.drawable.telugu5))
    listOfMovies.add(imageItem(R.drawable.telugu0))


    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Telugu Movies",
            color = Color.White,
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}

@Composable
@Preview
fun Drama()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.drama1))
    listOfMovies.add(imageItem(R.drawable.drama2))
    listOfMovies.add(imageItem(R.drawable.drama3))
    listOfMovies.add(imageItem(R.drawable.drama4))
    listOfMovies.add(imageItem(R.drawable.drama5))
    listOfMovies.add(imageItem(R.drawable.drama6))


    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Drama",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}

@Composable
@Preview
fun Marvel()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.marvel0))
    listOfMovies.add(imageItem(R.drawable.marvel00))
    listOfMovies.add(imageItem(R.drawable.marvel1))
    listOfMovies.add(imageItem(R.drawable.marvel2))
    listOfMovies.add(imageItem(R.drawable.marvel3))
    listOfMovies.add(imageItem(R.drawable.marvel4))
    listOfMovies.add(imageItem(R.drawable.marvel5))
    listOfMovies.add(imageItem(R.drawable.marvel6))

    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Marvel Movies",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}

@Composable
@Preview
fun HorrorMovies()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.horror1))
    listOfMovies.add(imageItem(R.drawable.horror2))
    listOfMovies.add(imageItem(R.drawable.horror3))
    listOfMovies.add(imageItem(R.drawable.horror4))
    listOfMovies.add(imageItem(R.drawable.horror5))
    listOfMovies.add(imageItem(R.drawable.horror6))


    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Horror Movies",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}


@Composable
@Preview
fun CartoonMovies()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.cartoon0))
    listOfMovies.add(imageItem(R.drawable.cartoon1))
    listOfMovies.add(imageItem(R.drawable.cartoon2))
    listOfMovies.add(imageItem(R.drawable.cartoon3))
    listOfMovies.add(imageItem(R.drawable.cartoon4))
    listOfMovies.add(imageItem(R.drawable.cartoon5))


    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Cartoon Movies",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}

@Composable
@Preview
fun ActionMovies()
{
    val listOfMovies= mutableListOf<imageItem>()
    listOfMovies.add(imageItem(R.drawable.action1))
    listOfMovies.add(imageItem(R.drawable.action2))
    listOfMovies.add(imageItem(R.drawable.action3))
    listOfMovies.add(imageItem(R.drawable.action5))
    listOfMovies.add(imageItem(R.drawable.action6))

    Column(modifier = Modifier.padding(top = 15.dp, bottom = 20.dp)) {
        Text(text ="Action Movies",
            color = Color.White,
            fontSize = 22.sp,
            modifier = Modifier.padding(bottom = 10.dp, start = 10.dp)
        )
        LazyRow(modifier = Modifier.padding(start = 5.dp)) {
            itemsIndexed(listOfMovies){
                    index, item ->
                ImageItemUI(item.image)
            }
        }
    }

}

@Composable
fun ImageItemUI(image:Int)
{

        Image(painter = painterResource(id = image), contentDescription = "Item",
            modifier = Modifier
                .size(135.dp, 190.dp)
                .padding(start = 2.dp, end = 2.dp)
        )

}
