package br.com.rodrigo.aluvery.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.aluvery.models.Product
import br.com.rodrigo.aluvery.sampledata.sampleProducts
import br.com.rodrigo.aluvery.sampledata.sampleSections
import br.com.rodrigo.aluvery.ui.components.CardProductItem
import br.com.rodrigo.aluvery.ui.components.ProductSection
import br.com.rodrigo.aluvery.ui.components.SearchTextField
import br.com.rodrigo.aluvery.ui.theme.AluveryTheme

@Composable
fun HomeScreen(sections: Map<String, List<Product>>) {

    Column(modifier = Modifier) {
        var txtSearch by remember { mutableStateOf("") }

        val searchedProducts = remember(txtSearch) {
            if(txtSearch.isNotBlank()) {
                sampleProducts.filter { p ->
                    p.name.contains(txtSearch, ignoreCase = true) ||
                            p.description?.contains(txtSearch, ignoreCase = true) ?: false
                }
            } else {
                emptyList()
            }
        }

        SearchTextField(txtSearch, onSearchChange = { search -> txtSearch = search })

        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (!txtSearch.isBlank()) {
                items(searchedProducts) { product ->
                    CardProductItem(
                        product = product,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            } else {
                sections.map { (title, products) ->
                    item { ProductSection(title, products) }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}