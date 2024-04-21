package com.example.jetpackcomposesmth


import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Login(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
//        MyButton()
//        MyRadioGroupButton ()
//        MyFloatingActionButton()
//        MyIconButton()
//        MyIconToggleButton()
//        MyOutlinedButton()
//        MyTextButton()

//        MyCard()

//        ProgressIndicatorScreen()

//        MyAlertDialog()

//        MyBox()

    MyScaffold()
    }
}

@Composable
fun MyText(){
    Text(text = stringResource(id = R.string.app_name),
        fontStyle = FontStyle.Italic,
        color = colorResource(id = R.color.purple_500),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(){
    val textValue = remember {
        mutableStateOf("")
    }

    val tealColor = colorResource(id = R.color.teal_700)

    OutlinedTextField(
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },
        label = {Text(text = stringResource(id = R.string.app_name))},
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = tealColor,
            focusedBorderColor = tealColor,
            focusedLabelColor = tealColor,
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun MyButton(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.black)),
        border = BorderStroke(1.dp, color = colorResource(id = R.color.teal_700)),
    ) {
        Text(
            text = "dima",
            color = Color.White,
            fontSize = 20.sp,
        )
    }
}

@Composable
fun MyRadioGroupButton(){
    val radioButtons = listOf(0,1,2,3)
    val selectedButton = remember { mutableStateOf(radioButtons.first()) }

    Row() {
        radioButtons.forEach{index ->
            val isSelected = index == selectedButton.value
            val colors = RadioButtonDefaults.colors(
                selectedColor = colorResource(id = R.color.teal_700),
                unselectedColor = colorResource(id = R.color.black)
            )
            RadioButton(
                selected = isSelected,
                colors = colors,
                onClick = {selectedButton.value = index}
            )
        }
    }
}

@Composable
fun MyFloatingActionButton(){
    FloatingActionButton(
        onClick = { /*TODO*/ },
    ){
        Icon(Icons.Default.Add, "Test Fav")
    }
}

@Composable
fun MyIconButton(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "Информация о приложении",
            modifier = Modifier.size(80.dp),
            tint = Color.Red,
        )
    }
}

@Composable
fun MyIconToggleButton(){
    val checked = remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconToggleButton(
            checked = checked.value,
            onCheckedChange = {checked.value = it}
        ) {
            Icon(
                imageVector = Icons.Filled.Place,
                contentDescription = "Location",
                tint = if (checked.value) colorResource(id = R.color.teal_200) else colorResource(id = R.color.purple_200)
            )
        }
        Text(text = if (checked.value) "Выбранно" else "Не выбранно",
            fontSize = 28.sp
        )
    }
}

fun showToast(context: Context, message: String){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun MyOutlinedButton(){
    val context = LocalContext.current

    OutlinedButton(
        onClick = { showToast(context, "Call Started") },
        border = BorderStroke(1.dp, Color.Blue),
        shape = RoundedCornerShape(corner = CornerSize(1.dp))
    ) {
        Icon(
            imageVector = Icons.Filled.Phone,
            contentDescription = "Phone Icon",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = "Call",
            fontSize = 20.sp,
        )
    }
}

@Composable
fun MyTextButton(){
    val context = LocalContext.current

    TextButton(
        onClick = { showToast(context, "Sharing...") }
    ) {
        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = "ShareIcon",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(
            text = "Share",
            fontSize = 20.sp,
        )
    }
}

@Composable
fun MyCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable { }
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("Card ")
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                    ){
                        append("Jetpack Compose!")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("MyCard() - ")
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W900)
                    ){
                        append("Card")
                    }
                }
            )
        }
    }
}

@Composable
fun ProgressIndicatorScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(
            color = colorResource(id = R.color.teal_200),
            strokeWidth = 5.dp
        )
        LinearProgressIndicator(progress = 0.5f)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAlertDialog(){
    val shouldShowDialog = remember {
        mutableStateOf(true)
    }
    if(shouldShowDialog.value){
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },

        ) {
            Text(text = stringResource(id = R.string.alert_dialog_title))
        }
    }
}

@Composable
fun MyRow(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        val THREE_ELEMENTS_LIST = listOf(R.string.first, R.string.second, R.string.third)

        THREE_ELEMENTS_LIST.forEach{textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 22.sp
            )
        }
    }
}

@Composable
fun MyColumn(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        val THREE_ELEMENTS_LIST = listOf(R.string.first, R.string.second, R.string.third)

        THREE_ELEMENTS_LIST.forEach{textResId ->
            Text(
                text = stringResource(id = textResId),
                fontSize = 22.sp
            )
        }
    }
}

@Composable
fun MyBox(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
){
    Box(modifier = modifier.fillMaxSize()){
        Text(
            text = stringResource(id = R.string.first),
            fontSize = 22.sp,
            modifier = contentModifier.align(Alignment.TopStart)
        )
        Text(
            text = stringResource(id = R.string.second),
            fontSize = 22.sp,
            modifier = contentModifier.align(Alignment.Center)
        )
        Text(
            text = stringResource(id = R.string.third),
            fontSize = 22.sp,
            modifier = contentModifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun SurfaceScreen(modifier: Modifier){
    Box(modifier = Modifier.fillMaxSize()){
        MySurface(modifier = modifier.align(Alignment.Center))
    }
}

@Composable
fun MySurface(modifier: Modifier = Modifier){
    Surface(
        modifier = modifier.size(100.dp),
        color = Color.Gray,
        contentColor = colorResource(id = R.color.black),
        border = BorderStroke(1.dp, Color.Black)
        ){
        MyColumn()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyScaffold(){
    Scaffold(
        contentColor = colorResource(id = R.color.purple_700),
        topBar = { MyTopAppBar()},
        content = { MyRow() },
        floatingActionButton = { MyFloatingActionButton()},
        bottomBar = { MyBottomAppBar() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(){
    TopAppBar(
        title = { Text(text = "My App") },
        colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = colorResource(id = R.color.purple_200))
    )
}

@Composable
fun MyBottomAppBar(){
    BottomAppBar {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Menu, contentDescription = "menu"
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Info, contentDescription = "info"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.Search, contentDescription = "search"
            )
        }
    }
}