package com.example.myapplication.ui.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.DataSource

class OrderScreenViewModel : ViewModel() {
  private val dataSource: DataSource = DataSource
  private val selectedItems: List<Any> = emptyList()
  //TODO("Wystaw odpowiednie dane udostępniane przez dataSource, tak aby UI mógł je wykorzystać")
}