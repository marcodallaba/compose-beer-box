package it.marcodallaba.composebeerbox.ui.screen.beers

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import it.marcodallaba.composebeerbox.data.Beer
import kotlinx.coroutines.flow.Flow


@Composable
fun BeersScreen(
    beersViewModel: BeersViewModel
) {
    BeersList(beersViewModel.getBeers())
}

@Composable
fun BeersList(flow: Flow<PagingData<Beer>>) {
    val lazyPagingItems = flow.collectAsLazyPagingItems()
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(lazyPagingItems.itemCount) {
            Text("${lazyPagingItems[it]?.name}")
        }
    }
}