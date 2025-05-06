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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.appPerfil.ui.theme.AppPerfilTheme

@Composable

fun ProfileScreen() {
    val purpleBackground = painterResource(id = R.drawable.fundor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .height(380.dp)
                .fillMaxWidth()
        ) {
            Image(
                painter = purpleBackground,
                contentDescription = "Background",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp))
                    .shadow(30.dp, RoundedCornerShape(bottomStart = 40.dp, bottomEnd = 40.dp)) // Adicionando sombra
            )


            IconButton(
                onClick = {  },
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
                    .padding(top = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Detalhes",
                    color = Color.White,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.offset(y = (-31).dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.image_placeholder),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.height(30.dp)) // Adicionando espaçamento entre o avatar e as informações

                Text("Cachorrada", color = Color.White, fontSize = 27.sp, fontWeight = FontWeight.Bold)
                Text("De pente de 30!", color = Color.White, fontSize = 17.sp)
            }


            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                ProfileActionButton("Email", Icons.Default.Email)
                ProfileActionButton("Ligar", Icons.Default.Phone)
                ProfileActionButton(
                    label = "Whatsapp",
                    imageResId = R.drawable.zapzap
                )

                ProfileActionButton("Favoritar", Icons.Default.Favorite)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Atualizando a seção de informações para incluir ícones
        ProfileInfoSectionWithIcon(
            title = "Email",
            titleIcon = Icons.Default.Email,
            details = listOf(
                "Oficial: lucas@exemplo.com" to Icons.Default.Email,
                "Pessoal: cria.lucas@padoca.com" to Icons.Default.Email
            )
        )

        ProfileInfoSectionWithIcon(
            title = "Phone Number",
            titleIcon = Icons.Default.Phone,
            details = listOf(
                "Mobile: (11) 99999-9999" to Icons.Default.Phone
            )
        )

        ProfileInfoSectionWithIcon(
            title = "Team",
            titleIcon = Icons.Default.AccountBox,
            details = listOf(
                "Projeto Fortune Dick" to Icons.Default.AccountBox
            )
        )

        ProfileInfoSectionWithIcon(
            title = "Leads by",
            titleIcon = Icons.Default.Person,
            details = listOf(
                "Pantufa, a dog manager" to Icons.Default.Person
            )
        )


        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Person, contentDescription = "Add contact", tint = colorResource(id = R.color.roxo))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Add contact", color = Color.Black)
            }
            Icon(Icons.Default.Share, contentDescription = "Share", tint = colorResource(id = R.color.roxo))
        }
    }
}
@Composable
fun ProfileActionButton(label: String, icon: ImageVector? = null, imageResId: Int? = null) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        if (icon != null) {
            Icon(icon, contentDescription = label, tint = Color.White)
        } else if (imageResId != null) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = label,
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )
        }
        Text(label, fontSize = 12.sp, color = Color.White)
    }
}




@Composable
fun ProfileInfoSectionWithIcon(
    title: String,
    titleIcon: ImageVector,
    details: List<Pair<String, ImageVector>>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 4.dp)
        ) {
            Icon(
                imageVector = titleIcon,
                contentDescription = title,
                tint = colorResource(id = R.color.roxo),
                modifier = Modifier
                    .size(27.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color.Gray,
                fontSize = 15.sp
            )
        }

        details.forEach { detail ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {

                Spacer(modifier = Modifier.width(8.dp))
                Text(detail.first, color = Color.Black, fontSize = 14.sp)
            }
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

