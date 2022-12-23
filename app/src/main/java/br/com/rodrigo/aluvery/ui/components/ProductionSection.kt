package br.com.rodrigo.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.rodrigo.aluvery.models.Product
import br.com.rodrigo.aluvery.sampledata.sampleProducts
import br.com.rodrigo.aluvery.ui.theme.AluveryTheme

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
        Surface {
            ProductSection(title = "Sale", products = sampleProducts)
        }
    }
}