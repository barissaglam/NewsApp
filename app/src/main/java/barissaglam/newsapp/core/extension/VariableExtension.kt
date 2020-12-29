package barissaglam.newsapp.core.extension

fun Int?.orZero(): Int = this ?: 0
fun Double?.orZero(): Double = this ?: 0.0
fun Float?.orZero(): Float = this ?: 0f
fun String?.orEmpty(): String = this ?: ""
fun Boolean?.orFalse(): Boolean = this != null