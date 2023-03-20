package com.example.myapplication.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.myapplication.utils.FormFactors
import com.example.myapplication.utils.LocalFormFactor

@Composable
fun OrderWidget(model: Any) { //TODO ustaw odpowiedni model, który spełni wszystkie wymagania
  val formFactor: FormFactors = LocalFormFactor.current // Definicja rozmiaru widgetu
  Text("Replace me")
}
