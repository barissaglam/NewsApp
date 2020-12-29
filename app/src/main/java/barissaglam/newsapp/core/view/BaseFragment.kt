package barissaglam.newsapp.core.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import barissaglam.newsapp.core.viewmodel.BaseViewModel

abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {
    abstract val layoutResourceId: Int
    abstract val viewModel: BaseViewModel

    lateinit var binding: DB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let { viewModel.handleIntent(it) }

        init()
    }

    open fun init(){}

}