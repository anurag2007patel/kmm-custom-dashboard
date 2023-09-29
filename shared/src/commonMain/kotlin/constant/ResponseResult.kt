package constant

import kotlinx.serialization.Serializable

/**
 * Created by Anurag on 27/09/23 1:07 pm
 **/
@Serializable
sealed class ResponseResult<out T> {

    data object Loading: ResponseResult<Nothing>()
    data class Success<R>(val result: R?): ResponseResult<R>()
    data class ErrorResponse<R>(val error: Error): ResponseResult<Nothing>()
}
