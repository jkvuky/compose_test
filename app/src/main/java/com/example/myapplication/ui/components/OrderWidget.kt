package com.example.myapplication.ui.components

import androidx.compose.runtime.Composable
import com.example.myapplication.data.OrderData
import com.example.myapplication.ui.components.BigOrderWidget
import com.example.myapplication.ui.components.MediumOrderWidget
import com.example.myapplication.ui.components.SmallOrderWidget
import com.example.myapplication.utils.FormFactors
import com.example.myapplication.utils.LocalFormFactor

@Composable
fun OrderWidget(model: OrderData, onPress: () -> Unit) {

  when (LocalFormFactor.current) {
    FormFactors.BIG -> {
      BigOrderWidget(model, onPress)
    }
    FormFactors.MEDIUM -> {
      MediumOrderWidget(model, onPress)
    }
    FormFactors.SMALL -> {
      SmallOrderWidget(model, onPress)
    }
  }
}