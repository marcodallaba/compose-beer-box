package it.marcodallaba.composebeerbox.ui.screen.beers

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import it.marcodallaba.composebeerbox.data.Beer
import it.marcodallaba.composebeerbox.data.source.BeersRepository
import it.marcodallaba.composebeerbox.ui.screen.common.BaseViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class BeersViewModel @Inject constructor(private val beersRepository: BeersRepository) :
    BaseViewModel() {


    fun getBeers(): Flow<PagingData<Beer>> {
        return beersRepository.getBeersStream().cachedIn(viewModelScope)
    }
}