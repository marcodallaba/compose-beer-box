package it.marcodallaba.composebeerbox.data.source.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import it.marcodallaba.composebeerbox.data.Beer

private const val STARTING_PAGE_INDEX = 1

class PunkPagingSource(
    private val service: PunkService
) : PagingSource<Int, Beer>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Beer> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val beersList = service.getBeers(page, params.loadSize)
            val reachedLastPage = beersList.isEmpty()
            LoadResult.Page(
                data = beersList,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (reachedLastPage) null else page + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Beer>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            // This loads starting from previous page, but since PagingConfig.initialLoadSize spans
            // multiple pages, the initial load will still load items centered around
            // anchorPosition. This also prevents needing to immediately launch prepend due to
            // prefetchDistance.
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }
}