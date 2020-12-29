package barissaglam.newsapp.data.remote

import barissaglam.newsapp.core.data.Error
import barissaglam.newsapp.util.Resource
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.lang.RuntimeException

class RemoteRepository {


    private fun <T> prepare(block: suspend () -> Response<T>): Flow<Resource<T>> = flow {
        val response = block.invoke()
        if (response.isSuccessful && response.body() != null) emit(Resource.Success(response.body()!!))
        else {
            val error: Error = Gson().fromJson(response.errorBody().toString(), Error::class.java)
            error.code = response.code()
            emit(Resource.Error(RuntimeException(error)))
        }
    }.onStart { Resource.Loading }
        .catch { throwable -> emit(Resource.Error(throwable)) }
        .flowOn(Dispatchers.IO)
}