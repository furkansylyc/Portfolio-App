package com.example.portfolio.ui.theme.Components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.portfolio.Data.Model.Project
import com.example.portfolio.R

@Preview
@Composable
 fun PortfolioCard(modifier: Modifier = Modifier) {
    val portfolioShowState = remember { mutableStateOf(false) }

    Surface (
        modifier = modifier.fillMaxSize()
    ){
        Card(
            modifier = modifier
                .width(200.dp)
                .height(400.dp)
                .padding(20.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.Cyan)
        ){
            Column(
                 modifier = Modifier.fillMaxSize(),
                 verticalArrangement = Arrangement.Top,
                 horizontalAlignment = Alignment.CenterHorizontally
            ){
                /*TODO*/
                PortfolioProfileImage()
                Divider(
                    modifier = modifier
                        .padding(20.dp)
                        .width(250.dp),
                    color = Color.Black,
                    thickness = 1.dp

                )
                PortfolioPersonalInfo()
                Button(onClick = {
                    portfolioShowState.value = !portfolioShowState.value
                }) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black,
                        textAlign = TextAlign.Center
                    )
                }
                PortfolioProject(isShown = portfolioShowState.value)
            }
        }
    }
}


@Preview
@Composable
private fun PortfolioProfileImage(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(10.dp),
        shape = CircleShape,
        border = BorderStroke(1.dp,Color.Black),
        shadowElevation = 10.dp

    ){
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun PortfolioPersonalInfo() {
    Column(
        modifier = Modifier.padding(5.dp)
    ){
        Text(
            text="Furkan Söyleyici",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.Black
        )
        Text(
            text="Android Engineer",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.padding(start = 35.dp)
        )
        Text(
            text="@furkansylyc",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black,
            modifier = Modifier.padding(start = 45.dp)
        )

    }
    
}

@Composable
fun PortfolioProject(modifier: Modifier = Modifier, isShown: Boolean= false) {
    if(isShown == true){
        Box(modifier = modifier
            .fillMaxSize()
            .padding(5.dp)
        ){
            Surface(
                modifier= modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(corner = CornerSize(10.dp)),
                border = BorderStroke(1.dp, Color.Black),
                color = Color.Gray
            ) {
                PortfolioProjectItem( // Pass the modifier for LazyColumn here if needed
                    data = listOf(
                        Project(
                            projectName = "EasyNote",
                            projectDescription = "Modern not alma uygulaması. REST API backend, alarm, etiketler, favoriler, renkli notlar ve kullanıcı dostu arayüz ile Play Store’da yayında."
                        ),
                        Project(
                            projectName ="Çizgi İzleyen Akıllı Araç",
                            projectDescription = "Arduino tabanlı, Bluetooth ile manuel/otonom kontrol yapılabilen çizgi izleyen robot. HC-05 modülü, motor sürücü ve mesafe sensörleri ile geliştirildi."
                        ),
                        Project(
                            projectName = "Stone Age",
                            projectDescription = "Unity ile geliştirilmiş 2D mobil oyun. Karakter kontrolü, can sistemi ve efektlerle taş devri atmosferinde eğlenceli bir deneyim."
                        ),
                        Project(
                            projectName = "Portfolio App",
                            projectDescription = "Jetpack Compose ile yapılmış kişisel portfolyo uygulaması. Minimal tasarım ve modern Android UI elementleri kullanıldı."
                        ),
                        Project(
                            projectName = "Şiir Web Sitesi",
                            projectDescription = "Babamın şiirlerini paylaştığı kişisel web sitesi. Modern tasarım, sade arayüz ve edebi içerikle kişisel yaratıcılığını yansıtıyor."
                        )
                    )
                )

            }
        }
    }
}

@Composable
fun PortfolioProjectItem(modifier: Modifier = Modifier,data:List<Project>) {
    LazyColumn(modifier = modifier) { // Apply the passed modifier to LazyColumn
        items(data) { item ->
            Card(
                modifier = Modifier.padding(10.dp) // Card uses its own Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(20.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ){
                Row(
                    modifier = Modifier // Row uses its own Modifier
                        .padding(10.dp) // Removed .background()
                ){
                    ProjectIcon(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier // Column uses its own Modifier
                            .padding(start = 10.dp) // Adjusted padding
                            .align(Alignment.CenterVertically)
                    ){
                        Text(text = item.projectName.toString(),
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black)

                        Text(text = item.projectDescription.toString(),
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Black)

                    }

                }

            }
        }
    }
}

@Composable
fun ProjectIcon(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Filled.Android,
        contentDescription = "Project Icon",
        modifier = modifier
            .size(60.dp)
            .padding(8.dp),
        tint = Color.Black
    )
}
