package it.marcodallaba.composebeerbox.ui.screen.beers

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import coil.request.ImageRequest
import it.marcodallaba.composebeerbox.R
import it.marcodallaba.composebeerbox.data.Beer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BeersScreen(
    beersViewModel: BeersViewModel
) {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val selectedBeerState: MutableState<Beer> =
        remember { mutableStateOf(Beer(0, "", "", "", "", 0f)) }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(Modifier.fillMaxWidth()) {
                BottomSheetLayoutContent(selectedBeerState.value)
            }
        }) {
        BeersList(beersViewModel.getBeers(), bottomSheetState, selectedBeerState)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BeersList(
    flow: Flow<PagingData<Beer>>,
    modalBottomSheetState: ModalBottomSheetState,
    selectedBeerState: MutableState<Beer>
) {
    val lazyPagingItems = flow.collectAsLazyPagingItems()
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(lazyPagingItems.itemCount) { index ->
            lazyPagingItems[index]?.let {
                BeerEntry(beer = it, modalBottomSheetState, selectedBeerState)
                Divider(color = Color.Black, modifier = Modifier.padding(start = 8.dp, end = 8.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BeerEntry(
    beer: Beer,
    modalBottomSheetState: ModalBottomSheetState,
    selectedBeerState: MutableState<Beer>
) {
    val scope = rememberCoroutineScope()

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
                    color = colorResource(id = R.color.colorAccent),
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(
                            top = 8.dp, bottom = 8.dp
                        )
                        .clickable {
                            scope.launch {
                                selectedBeerState.value = beer
                                modalBottomSheetState.show()
                            }
                        })
            }
        }
    }
}

@Composable
fun BottomSheetLayoutContent(beer: Beer) {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))
            Image(
                painterResource(id = R.drawable.bookmark),
                null,
                modifier = Modifier
                    .padding(end = 36.dp)
                    .size(height = 24.dp, width = 36.dp),
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 8.dp, end = 16.dp, bottom = 16.dp)
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(beer.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = beer.name,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(142.dp)
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
                    description?.let { Text(it, modifier = Modifier.padding(top = 8.dp)) }
                }
            }
        }
    }
}