package br.senai.sp.jandira.appPerfil.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.appPerfil.R

@Composable
fun ProfileScreen() {
    val purpleBackground = painterResource(id = R.drawable.split_background) // imagem roxa

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = purpleBackground,
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .align(LineHeightStyle.Alignment.Center)
                    .padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar_placeholder), // ícone do boneco
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                )
                Text("Lucas Cria", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Sr. UX/UI das Quebradas", color = Color.White, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ProfileActionButton("Email")
            ProfileActionButton("Call")
            ProfileActionButton("Whatsapp")
            ProfileActionButton("Favorite")
        }

        Spacer(modifier = Modifier.height(16.dp))

        ProfileInfoSection(title = "Email", details = listOf(
            "Oficial: lucas@exemplo.com",
            "Pessoal: cria.lucas@padoca.com"
        ))

        ProfileInfoSection(title = "Phone Number", details = listOf(
            "Mobile: (11) 99999-9999"
        ))

        ProfileInfoSection(title = "Team", details = listOf(
            "Projeto Fortune Dick"
        ))

        ProfileInfoSection(title = "Leads by", details = listOf(
            "Pantufa, a dog manager"
        ))

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Icon(Icons.Default.PersonAdd, contentDescription = "Add contact")
            Icon(Icons.Default.Share, contentDescription = "Share")
        }
    }
}

@Composable
fun ProfileActionButton(label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.Face, contentDescription = label, tint = Color(0xFF6200EE))
        Text(label, fontSize = 12.sp)
    }
}

@Composable
fun ProfileInfoSection(title: String, details: List<String>) {
    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Text(title, fontWeight = FontWeight.Bold, color = Color.Gray)
        details.forEach {
            Text(it, color = Color.Black, fontSize = 14.sp)
        }
    }
}
