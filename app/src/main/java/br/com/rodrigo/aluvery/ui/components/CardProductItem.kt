package br.com.rodrigo.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.rodrigo.aluvery.R
import br.com.rodrigo.aluvery.extensions.toUSACurrency
import br.com.rodrigo.aluvery.models.Product
import br.com.rodrigo.aluvery.sampledata.sampleProducts
import br.com.rodrigo.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage
import java.math.BigDecimal

@Composable
fun CardProductItem(
    product: Product,
    modifier: Modifier = Modifier,
    elevation: Dp = 4.dp
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = elevation,
        shape = RoundedCornerShape(15.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(150.dp)
            .clickable { expanded = !expanded }
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.placeholder),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primaryVariant)
                    .padding(16.dp)
            ) {
                Text(text = product.name)
                Text(text = product.price.toUSACurrency())
            }

            product.description?.let {
                Text(
                    text = product.description,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = if (expanded) Int.MAX_VALUE else 2,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun CardProductItemPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = sampleProducts.random(),
            )
        }
    }
}

@Preview
@Composable
private fun CardProductItemWithDescriptionPreview() {
    AluveryTheme {
        Surface {
            CardProductItem(
                product = Product(
                    name = "Ice Cream",
                    price = BigDecimal("9.99"),
                    description = LoremIpsum(words = 50).values.first()
                ),
            )
        }
    }
}