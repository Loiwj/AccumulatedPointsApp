package com.example.tinhdiemtichluy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinhdiemtichluy.ui.theme.TinhDiemTichLuyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TinhDiemTichLuyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AccumulatedPointsApp()
                }
            }
        }
    }
}

@Composable
fun AccumulatedPointsApp() {
    val TongSoTinChi = remember {
        mutableStateOf("")
    }
    val TongSoTinChiDaTichLuy = remember {
        mutableStateOf("")
    }
    val DiemTrungBinhTichLuy = remember {
        mutableStateOf("")
    }
    val DiemTrungBinhTichLuyMongMuon = remember {
        mutableStateOf("")
    }
    val KetQua = remember {
        mutableStateOf("")
    }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OutlinedTextField(
            value = TongSoTinChi.value,
            onValueChange = { TongSoTinChi.value = it },
            label = { Text("Tổng số tính chỉ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = TongSoTinChiDaTichLuy.value,
            onValueChange = { TongSoTinChiDaTichLuy.value = it },
            label = { Text("Tổng số tính chỉ đã tích luỹ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = DiemTrungBinhTichLuy.value,
            onValueChange = { DiemTrungBinhTichLuy.value = it },
            label = { Text("Điễm trung bình tích luỹ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = DiemTrungBinhTichLuyMongMuon.value,
            onValueChange = { DiemTrungBinhTichLuyMongMuon.value = it },
            label = { Text("Điểm TBTL mong muốn") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            if (TongSoTinChi.value != "" ||
                TongSoTinChiDaTichLuy.value != "" ||
                DiemTrungBinhTichLuy.value != "" ||
                DiemTrungBinhTichLuyMongMuon.value != ""
            ) {
                if (TongSoTinChi.value.toDouble() < TongSoTinChiDaTichLuy.value.toDouble()) {
                    Toast.makeText(
                        context,
                        "Tổng số tính chỉ đã tích luỹ không được lớn hơn tổng số tính chỉ",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (DiemTrungBinhTichLuy.value.toDouble() > 4) {
                        Toast.makeText(
                            context,
                            "Điểm trung bình tích luỹ không được lớn hơn 4",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        if (DiemTrungBinhTichLuyMongMuon.value.toDouble() > 4) {
                            Toast.makeText(
                                context,
                                "Điểm trung bình tích luỹ mong muốn không được lớn hơn 4",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            if (DiemTrungBinhTichLuy.value.toDouble() < 0) {
                                Toast.makeText(
                                    context,
                                    "Điểm trung bình tích luỹ không được nhỏ hơn 0",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                if (DiemTrungBinhTichLuyMongMuon.value.toDouble() < 0) {
                                    Toast.makeText(
                                        context,
                                        "Điểm trung bình tích luỹ mong muốn không được nhỏ hơn 0",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                } else {
                                    if (TongSoTinChi.value.toDouble() < 0) {
                                        Toast.makeText(
                                            context,
                                            "Tổng số tính chỉ không được nhỏ hơn 0",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    } else {
                                        if (TongSoTinChiDaTichLuy.value.toDouble() < 0) {
                                            Toast.makeText(
                                                context,
                                                "Tổng số tính chỉ đã tích luỹ không được nhỏ hơn 0",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        } else {
                                            if (TongSoTinChi.value.toDouble() == 0.0) {
                                                Toast.makeText(
                                                    context,
                                                    "Tổng số tính chỉ không được bằng 0",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            } else {
                                                if (TongSoTinChiDaTichLuy.value.toDouble() == 0.0) {
                                                    Toast.makeText(
                                                        context,
                                                        "Tổng số tính chỉ đã tích luỹ không được bằng 0",
                                                        Toast.LENGTH_SHORT
                                                    ).show()
                                                } else {

                                                    KetQua.value =
                                                        (((TongSoTinChi.value.toDouble() * DiemTrungBinhTichLuyMongMuon.value.toDouble())
                                                                - (TongSoTinChiDaTichLuy.value.toDouble() * DiemTrungBinhTichLuy.value.toDouble()))
                                                            / (TongSoTinChi.value.toDouble() - TongSoTinChiDaTichLuy.value.toDouble())).toString()

                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {

                Toast.makeText(
                    context,
                    "Vui lòng nhập đầy đủ thông tin",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text("Tính điểm")

        }
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Kết quả: ${KetQua.value}",
            color = Color.Red,
            fontSize = 24.sp, fontWeight = FontWeight.Bold
        )
    }
}
