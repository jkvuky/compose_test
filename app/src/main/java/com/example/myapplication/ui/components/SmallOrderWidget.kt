package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.OrderData
import com.example.myapplication.utils.component.advancedShadow
import java.math.BigDecimal

@Preview
@Composable
fun SmallOrderWidget(
    model: OrderData = OrderData(
        waiter = "Waiter",
        tableNumber = 1,
        area = "Area 1",
        value = BigDecimal(100.0),
        hasInformation = true, orderName = "aaa", isHighlighted = false,),
    onPress: () -> Unit = { }
) {

    val infoIcon = if (model.hasInformation) Icons.Filled.Info else Icons.Outlined.Info

    Row(
        modifier = Modifier
            .width(393.dp)
            .height(59.dp)
            .padding(8.dp)
            .border(
                width = if (model.isHighlighted) 2.dp else 0.dp,
                color = if (model.isHighlighted) Color.Black else Color.Gray.copy(alpha = 0.5f),
                shape = RoundedCornerShape(8.dp)
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        onPress()
                    }
                )
            }
            .shadow(8.dp, shape = RoundedCornerShape(8.dp))

            .background(
                if (model.isHighlighted) Color.White
                else Color.Yellow, shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .weight(.4f)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = model.orderName, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(text = model.waiter, fontSize = 12.sp)
        }

        Row(
            modifier = Modifier
                .weight(.6f)
                .fillMaxHeight(1f)
                .advancedShadow(
                    cornersRadius = 10.dp,
                    shadowBlurRadius = 6.dp,
                )
                .background(Color.White, shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                Modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "${model.value} PLN", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Row {
                    Text(text = model.area, fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Table #${model.tableNumber}", fontSize = 12.sp)
                }
            }
            Icon(
                imageVector = infoIcon,
                contentDescription = "Info",
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
            )
        }
    }
}