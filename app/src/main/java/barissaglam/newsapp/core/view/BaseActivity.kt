package barissaglam.newsapp.core.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import barissaglam.newsapp.core.viewmodel.BaseViewModel

abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {
    abstract val layoutResourceId: Int
    abstract val viewModel: BaseViewModel

    lateinit var binding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutResourceId)

        intent.extras?.let { viewModel.handleIntent(it) }

        init()
    }


    open fun init(){}
}