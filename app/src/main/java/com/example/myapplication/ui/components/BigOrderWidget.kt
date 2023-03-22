package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.data.OrderData
import java.math.BigDecimal

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun BigOrderWidget(
    model: OrderData = OrderData(
        waiter = "Waiter",
        tableNumber = 1,
        area = "Area 1",
        value = BigDecimal(100.0),
        hasInformation = true, orderName = "aaa", isHighlighted = false,
    ),
    onPress: () -> Unit = { }
) {
    val infoIcon = if (model.hasInformation) Icons.Filled.Info else Icons.Outlined.Info

    Card(
        modifier = Modifier
            .width(327.dp)
            .height(202.dp)
            .border(
                width = if (model.isHighlighted) 2.dp else 0.dp,
                color = if (model.isHighlighted) Color.Black else Color.Gray.copy(alpha = 0.5f),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = false),
                onClick = { }
            )
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        onPress()
                    }
                )
            }
            .shadow(8.dp, shape = RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.White)
            ) {
                val (headerBox, value, infoIconView, divider) = createRefs()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(headerBox) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                            end.linkTo(parent.end)
                        }
                        .background(if (model.isHighlighted) Color.White else Color.Yellow)
                        .padding(10.dp),
                ) {
                    Column {
                        Text(
                            text = model.waiter,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = model.area,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )

                            Text(
                                text = "Table #${model.tableNumber}",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(end = 65.dp),
                                color = Color.Black
                            )
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(
                            text = model.orderName,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .shadow(2.dp)
                        .background(Color.Gray)
                        .constrainAs(divider) {
                            start.linkTo(parent.start)
                            top.linkTo(headerBox.bottom)
                            end.linkTo(parent.end)
                        }
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .constrainAs(value) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(divider.bottom)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "PLN ${model.value}",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = Color.Black
                    )
                }

                Icon(
                    imageVector = infoIcon,
                    contentDescription = "Info",
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(48.dp)
                        .constrainAs(infoIconView) {
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                        }
                )
            }
        }
    }
}