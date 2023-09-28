package product.viewmodel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import product.data.Profile
import product.repository.DefaultProductRepository
import product.ui.ProductUI

/**
 * Created by Anurag on 27/09/23 3:00 pm
 **/
class ProductViewModel: ViewModel() {

    private val _profileStateFlow = MutableStateFlow<ProductUI>(ProductUI())
        val profileStateFlow = _profileStateFlow.asStateFlow()
    private val profileRepository = DefaultProductRepository()

    fun getProfileData(){
        viewModelScope.launch(Dispatchers.IO) {
            val profileResponse: Profile = profileRepository.getProfileData()
            _profileStateFlow.update {
                it.copy(profile = profileResponse)
            }
        }
    }

   fun setProductCategory(category: String) {
       _profileStateFlow.update {
           it.copy(category = category)
       }
    }
}