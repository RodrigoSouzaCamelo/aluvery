package br.com.rodrigo.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.aluvery.ui.components.ProductSection
import br.com.rodrigo.aluvery.ui.components.sampleProducts

@Composable
fun HomeScreen() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier)

        ProductSection(title = "Sale", products = sampleProducts)
        ProductSection(title = "Candy", products = sampleProducts)
        ProductSection(title = "Drinks", products = sampleProducts)

        Spacer(Modifier)
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}