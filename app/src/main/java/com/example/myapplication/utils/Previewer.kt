package com.example.myapplication.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Previewer(content: @Composable () -> Unit) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .verticalScroll(state = rememberScrollState())
  ) {
    Spacer(Modifier.height(20.dp))
    withFormFactor(formFactor = FormFactors.BIG) {
      content()
    }
    Spacer(Modifier.height(20.dp))
    withFormFactor(formFactor = FormFactors.MEDIUM) {
      content()
    }
    Spacer(Modifier.height(20.dp))
    withFormFactor(formFactor = FormFactors.SMALL) {

    }
    Spacer(Modifier.height(20.dp))
  }
}