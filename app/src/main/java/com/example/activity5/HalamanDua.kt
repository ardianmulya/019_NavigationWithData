package com.example.activity5

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.activity5.data.OrderUiState
import com.example.activity5.ui.komponen.FormatLabelHarga


@Composable
fun HalamanDua(
    orderUiState: OrderUiState,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(R.string.quantity), orderUiState.jumlah),
        Pair(stringResource(R.string.flavor), orderUiState.rasa)
    )
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {

            Column(
                modifier = Modifier
                    .padding(10.dp),

                ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(stringResource(id = R.string.nama))
                    Text(text = "contactUIState.nama")
                }
                Divider()
                Spacer(modifier = Modifier.padding(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(stringResource(id = R.string.no_hp))
                    Text(text = "contactUIState.noTelp")
                }
                Divider()
                Spacer(modifier = Modifier.padding(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(stringResource(id = R.string.alamat))
                    Text(text = "contactUIState.alamat")
                }
                Divider()
                Spacer(modifier = Modifier.padding(16.dp))
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ){
                    Text(
                        text = "PESANAN ANDA", fontWeight = FontWeight.Bold, modifier = Modifier
                            .border(
                                BorderStroke(2.dp, Color.Cyan)
                            )
                            .padding(10.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(16.dp))
                items.forEach { item ->
                    Column {
                        Text(item.first.uppercase())
                        Text(text = item.second.toString(), fontWeight = FontWeight.Bold)
                    }
                    Divider(thickness = dimensionResource(R.dimen.thicness_divider))
                }
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                FormatLabelHarga(
                    subtotal = orderUiState.harga,
                    modifier = Modifier.align(Alignment.End)
                )
            }
            Row(
                modifier = Modifier
                    .weight(1f, false)
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
                ) {
                    Button(modifier = Modifier.fillMaxWidth(), onClick = {}) {
                        Text(stringResource(R.string.send))
                    }
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = onCancelButtonClicked
                    ) {
                        Text(stringResource(R.string.cancel))
                    }
                }
            }
        }
    }
}