package br.senai.sp.jandira.appPerfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.appPerfil.ui.theme.AppPerfilTheme

@Composable
fun ProfileScreen() {
    val purpleBackground = painterResource(id = R.drawable.fundo)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .height(380.dp) // AUMENTOU A ALTURA DA IMAGEM
                .fillMaxWidth()
        ) {
            Image(
                painter = purpleBackground,
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)) // BORDA ARREDONDADA SÓ EMBAIXO
            )

            // SETA "PARA SAIR"
            IconButton(
                onClick = { /* Aqui tu bota a lógica pra voltar ou sair */ },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 60.dp), // AJUSTADO PRA CABER A SETA
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Details",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.image_placeholder),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
                Text("Lucas Cria", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Sr. UX/UI das Quebradas", color = Color.White, fontSize = 14.sp)
            }

            // BOTÕES DENTRO DA IMAGEM
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ProfileActionButton("Email", Icons.Default.Email)
                ProfileActionButton("Call", Icons.Default.Phone)
                ProfileActionButton("Whatsapp", Icons.Default.Call)
                ProfileActionButton("Favorite", Icons.Default.Favorite)
            }
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
            Icon(Icons.Default.Person, contentDescription = "Add contact")
            Icon(Icons.Default.Share, contentDescription = "Share")
        }
    }
}

@Composable
fun ProfileActionButton(label: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = label, tint = Color.White)
        Text(label, fontSize = 12.sp, color = Color.White)
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

@Preview(showBackground = true)
@Composable
fun AppPerfilScreenPreview() {
    AppPerfilTheme {
        ProfileScreen()
    }
}

