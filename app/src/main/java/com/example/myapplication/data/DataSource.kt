package com.example.myapplication.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.math.BigDecimal

object DataSource {

  private val ids = listOf("11223344", "9977553311")
  private val data = ids.mapIndexed { index, name ->
    OrderData(
      tableNumber = index,
      orderName = name,
      area = "Main area",
      waiter = "Waiter",
      value = BigDecimal("99.24"),
      hasInformation = index == 0,
      isHighlighted = index > 0,
    )
  }.groupBy { it.orderName }
    .mapValues { it.value.first() }

  fun getAllOrders(): Flow<Map<String, OrderData>> = flow {
    while (true) {
      emit(data.mapValues {
        it.value.copy(hasInformation = it.value.hasInformation.not())
      })
      delay(10_000L)
    }
  }

  suspend fun getOrderData(orderId: String): OrderData? = data[orderId]
}

data class OrderData(
  val tableNumber: Int,
  val orderName: String,
  val area: String,
  val waiter: String,
  val value: BigDecimal,
  val hasInformation: Boolean,
  val isHighlighted: Boolean
)