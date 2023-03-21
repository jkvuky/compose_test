package com.example.myapplication.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.DataSource
import com.example.myapplication.data.OrderData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class OrderScreenViewModel : ViewModel() {
  private val dataSource: DataSource = DataSource

  private val _orders = MutableStateFlow<Map<String, OrderData>>(emptyMap())
  val orders: StateFlow<Map<String, OrderData>> = _orders

  private val _selectedItems = MutableStateFlow<List<OrderData>>(emptyList())
  val selectedItems: StateFlow<List<OrderData>> = _selectedItems

  init {
    viewModelScope.launch {
      dataSource.getAllOrders().collect { data ->
        _orders.value = data
        updateSelectedItems()
      }
    }
  }

  fun toggleSelection(orderId: String) {
    val currentOrder = _orders.value[orderId]
    currentOrder?.let {
      val updatedOrder = it.copy(isSelected = !it.isSelected)
      _orders.value = _orders.value.toMutableMap().apply { put(orderId, updatedOrder) }
      updateSelectedItems()
    }
  }

  private fun updateSelectedItems() {
    _selectedItems.value = _orders.value.values.filter { it.isSelected }
  }
}