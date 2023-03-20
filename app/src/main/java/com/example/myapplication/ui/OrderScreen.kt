package com.example.myapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.vm.OrderScreenViewModel
import com.example.myapplication.utils.Previewer

@Composable
fun OrderScreen(viewModel: OrderScreenViewModel = viewModel()) {
//  val dataList = ???
//  val selected = ???
  StatelessOrderScreen(orders = emptyList())
}

@Composable
fun StatelessOrderScreen(
  orders: List<Any>, //TODO change me
) {
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    Previewer {
      Column {
        Row(
          modifier = Modifier.fillMaxWidth()
        ) {
          Text("Remove me")
//          OrderWidget(orders[0]) //TODO Uncomment me
//          Spacer(Modifier.width(20.dp)) //TODO Uncomment me
//          OrderWidget(orders[1]) //TODO Uncomment me
        }
        Spacer(Modifier.height(20.dp))
        Text(text = "Ilosc zaznaczonych elementow to: ???")
        Button(onClick = { }) { //TODO odczytaj ilosc zaznaczonych itemow, dane maja przyjsc z viewmodelu
          Text("Kliknij by odczytac ilosc zaznaczonych")
        }
      }
    }
  }
}
