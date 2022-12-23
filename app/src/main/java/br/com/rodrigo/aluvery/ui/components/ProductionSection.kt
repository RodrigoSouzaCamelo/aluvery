package br.com.rodrigo.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodrigo.aluvery.R
import br.com.rodrigo.aluvery.models.Product
import br.com.rodrigo.aluvery.ui.theme.AluveryTheme
import java.math.BigDecimal

@Composable
fun ProductSection(title: String, products: List<Product>) {
    Column {
        Text(
            text = "Sale",
            fontSize = 20.sp,
            fontWeight = FontWeight(400),
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(Modifier)
            products.map { p -> ProductItem(p) }
            Spacer(Modifier)
        }
    }
}

@Preview(name = "ProductSection", showBackground = true)
@Composable
private fun ProductSectionPreview() {
    AluveryTheme {
        ProductSection(title = "Sale", products = sampleProducts)
    }
}

val sampleProducts = listOf(
    Product(
        name = "Burger",
        price = BigDecimal("12.99"),
        image = R.drawable.burger
    ),
    Product(
        name = "Pizza",
        price = BigDecimal("19.99"),
        image = R.drawable.pizza
    ),
    Product(
        name = "Fries",
        price = BigDecimal("7.99"),
        image = R.drawable.fries
    )
)