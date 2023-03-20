package com.example.myapplication.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf

@Composable
fun withFormFactor(formFactor: FormFactors, content: @Composable () -> Unit) {
  CompositionLocalProvider(LocalFormFactor provides formFactor) {
    content()
  }
}

enum class FormFactors {
  BIG,
  MEDIUM,
  SMALL,
}

val LocalFormFactor = compositionLocalOf { FormFactors.BIG }