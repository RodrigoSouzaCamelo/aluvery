package br.com.rodrigo.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import br.com.rodrigo.aluvery.R
import br.com.rodrigo.aluvery.extensions.toUSACurrency
import br.com.rodrigo.aluvery.models.Product
import br.com.rodrigo.aluvery.sampledata.sampleProducts
import br.com.rodrigo.aluvery.ui.theme.AluveryTheme
import coil.compose.AsyncImage

@Composable
fun CardProductItem(
    product: Product,
    elevation: Dp = 4.dp
) {
    Card(
        elevation = elevation,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(150.dp)
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
            // TODO: adicionar descrição do produto
            // Text(
            //     text = product.description,
            //     Modifier
            //         .padding(16.dp)
            // )
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