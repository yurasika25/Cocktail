package ua.cocktail.develop.cocktail.help

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_cash.*
import ua.cocktail.develop.cocktail.R

class HelpFragment : Fragment(), HelpFragmentView {


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: HelpFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_help, container, false)

        presenter = HelpFragmentPresenter()
        val btnView = view.findViewById<View>(R.id.id_more_info)
        btnView.setOnClickListener {
            val url = "https://startandroid.ru/ru/uroki/vse-uroki-spiskom.html"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }

//        val backLightSeekBar = view.findViewById<ImageView>(R.id.seekBar)
//        backLightSeekBar.setOnClickListener {
//
//            backLightSeekBar.setImageResource(R.drawable.ic_flas_one)
//            seekBarTwo.visibility = View.VISIBLE
//            backLightSeekBar.visibility = View.GONE
//            val params = requireActivity().window.attributes
//            params.screenBrightness = 1.0f
//            requireActivity().window.attributes = params
//        }
//        val backLightSeekBarTwo = view.findViewById<ImageView>(R.id.seekBarTwo)
//        backLightSeekBarTwo.setOnClickListener {
//            backLightSeekBarTwo.setImageResource(R.drawable.ic_flas_two)
//            seekBar.visibility = View.VISIBLE
//            backLightSeekBarTwo.visibility = View.GONE
//            val params = requireActivity().window.attributes
//            params.screenBrightness = 0.3f
//            requireActivity().window.attributes = params
//        }
//
//        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarCash)
//        tBar.setNavigationOnClickListener { requireActivity().onBackPressed()
//        }


        return view
    }


}


