package com.example.myapplication.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.OrderData
import com.example.myapplication.ui.components.OrderWidget
import com.example.myapplication.ui.vm.OrderScreenViewModel
import com.example.myapplication.utils.FormFactors
import com.example.myapplication.utils.withFormFactor

@Composable
fun OrderScreen(viewModel: OrderScreenViewModel = viewModel()) {
  val orders by viewModel.orders.collectAsState()
  val orderList = orders.values.toList()
  val selectedItems by viewModel.selectedItems.collectAsState()

  StatelessOrderScreen(orders = orderList, selectedItems = selectedItems, onOrderPress = viewModel::toggleSelection)
}

@Composable
fun StatelessOrderScreen(
  orders: List<OrderData>,
  selectedItems: List<OrderData> = emptyList(),
  onOrderPress: (String) -> Unit
) {

  Surface(
    modifier = Modifier
      .fillMaxSize()
      .padding(10.dp), color = Color.White
  ) {
    Column {
      LazyColumn(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        item {
          Text(text = "Big", fontSize = 20.sp)
          Spacer(Modifier.padding(top = 20.dp))
          withFormFactor(formFactor = FormFactors.BIG) {
            OrderWidget(orders[0]) { onOrderPress(orders[0].orderName) }
            Spacer(Modifier.padding(top = 20.dp))
            OrderWidget(orders[1]) { onOrderPress(orders[1].orderName) }
          }
        }
        item {
          Text(text = "Medium", fontSize = 20.sp)
          Spacer(Modifier.padding(top = 20.dp))
          withFormFactor(formFactor = FormFactors.MEDIUM) {
            OrderWidget(orders[0]) { onOrderPress(orders[0].orderName) }
            Spacer(Modifier.padding(top = 20.dp))
            OrderWidget(orders[1]) { onOrderPress(orders[1].orderName) }
          }
        }
        item {
          Text(text = "Small", fontSize = 20.sp)
          Spacer(Modifier.padding(top = 20.dp))
          withFormFactor(formFactor = FormFactors.SMALL) {
            OrderWidget(orders[0]) { onOrderPress(orders[0].orderName) }
            Spacer(Modifier.padding(top = 20.dp))
            OrderWidget(orders[1]) { onOrderPress(orders[1].orderName) }
          }
        }
      }
      Box(
        modifier = Modifier
          .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
      ) {
        Column(modifier = Modifier
          .fillMaxWidth(),
          horizontalAlignment = Alignment.CenterHorizontally) {
          Divider()
          Spacer(Modifier.height(20.dp))
          Text(text = "Ilosc zaznaczonych elementow to: ${selectedItems.size}")
          Spacer(Modifier.height(20.dp))
        }
      }
    }
  }
}