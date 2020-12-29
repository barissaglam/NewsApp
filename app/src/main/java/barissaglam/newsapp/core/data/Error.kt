package barissaglam.newsapp.core.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Error(
    @SerializedName("error_description")
    val description: String? = null,
    @SerializedName("custom_error")
    val customError: String? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("error")
    var error: String? = null,
    @SerializedName("code")
    var code: Int = 0,
    @SerializedName("errors")
    var errors: ArrayList<Message>? = null

) : Throwable()

class Message {
    @SerializedName("type")
    var type: String? = null
    @SerializedName("reason")
    var reason: String? = null
    @SerializedName("message")
    val message: String? = null
    @SerializedName("subject")
    val subject: String? = null

    override fun toString(): String {
        return message ?: ""
    }
}