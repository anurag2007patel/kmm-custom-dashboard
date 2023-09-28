package home.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import home.data.ImageItem
import home.data.ImageUI
import home.repository.DefaultImageRepository
import home.repository.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import networkmodule.KtorModule

/**
 * Created by Anurag on 26/09/23 10:47 am
 **/
class HomeViewModel(): ViewModel() {

    private val _birdItemStateFlow: MutableStateFlow<ImageUI> = MutableStateFlow<ImageUI>(ImageUI())
    val birdItemStateFlow = _birdItemStateFlow.asStateFlow()
    private var repository: ImageRepository = DefaultImageRepository()
    init {
        getImages()
    }

  fun getImages(){
      viewModelScope.launch(Dispatchers.IO) {
          val birdsList: List<ImageItem> = repository.getImages()
          _birdItemStateFlow.update {
              it.copy(birdList = birdsList)
          }

      }
  }

    fun setCategory(category: String){
        _birdItemStateFlow.update {
            it.copy(category = category)
        }
    }

    override fun onCleared() {
        super.onCleared()
        KtorModule.closeHttpClient()
    }
}