package it.marcodallaba.composebeerbox.ui.screen.beers

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import it.marcodallaba.composebeerbox.R
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
        items(lazyPagingItems.itemCount) { index ->
            lazyPagingItems[index]?.let {
                BeerEntry(beer = it)
                Divider(color = Color.Black, modifier = Modifier.padding(start = 8.dp, end = 8.dp))
            }
        }
    }
}

@Composable
fun BeerEntry(beer: Beer) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 16.dp, end = 16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(beer.imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = beer.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .width(84.dp)
                .aspectRatio(0.66f)
        )
        Column(modifier = Modifier.padding(start = 16.dp, end = 24.dp)) {
            with(beer) {
                Text(name)
                tagLine?.let {
                    Text(
                        text = it,
                        maxLines = 1,
                        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                    )
                }
                description?.let { Text(it, maxLines = 2, modifier = Modifier.padding(top = 8.dp)) }
                Text(
                    text = stringResource(R.string.more_info),
                    modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .clickable {
                        })
            }
        }
    }
}
