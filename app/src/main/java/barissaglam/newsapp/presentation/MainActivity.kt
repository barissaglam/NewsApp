package barissaglam.newsapp.presentation

import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import androidx.dynamicanimation.animation.SpringForce
import barissaglam.newsapp.R
import barissaglam.newsapp.core.view.BaseActivity
import barissaglam.newsapp.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutResourceId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    lateinit var indicator: ImageView

    override fun init() {
        indicator = findViewById(R.id.imageView)

        findViewById<MaterialButton>(R.id.first).setOnClickListener {
            springAnimationX(indicator,(it.x + it.width/2))
        }

        findViewById<MaterialButton>(R.id.second).setOnClickListener {
            springAnimationX(indicator,(it.x + it.width/2))
        }

        findViewById<MaterialButton>(R.id.third).setOnClickListener {
            springAnimationX(indicator,(it.x + it.width/2))
        }
    }

    private fun springAnimationX(view: View, position: Float) {
        SpringAnimation(view, DynamicAnimation.TRANSLATION_X).apply {
            spring = SpringForce().apply {
                stiffness = SpringForce.STIFFNESS_MEDIUM
                finalPosition = position
                dampingRatio = SpringForce.DAMPING_RATIO_MEDIUM_BOUNCY
            }
        }.start()
    }
}