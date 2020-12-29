package barissaglam.newsapp.core.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    open fun handleIntent(extras: Bundle) {}
}