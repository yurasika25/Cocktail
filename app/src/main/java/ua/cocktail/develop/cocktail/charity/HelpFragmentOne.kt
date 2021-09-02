package ua.cocktail.develop.cocktail.charity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.help_fragment_one.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.databinding.HelpFragmentOneBinding
import ua.cocktail.develop.cocktail.help.HelpFragment

class HelpFragmentOne : Fragment(), CharityFragmentView {

    private var binding: HelpFragmentOneBinding? = null
    private var presenter: CharityFragmentPresenter? = null

    override fun onPause() {
        super.onPause()
        presenter?.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.help_fragment_one, container, false)
        presenter = CharityFragmentPresenter()
        binding = HelpFragmentOneBinding.bind(view)

        val user = CharityFragment("Як допомогти?")
        binding!!.imageMain.text = user.onAddAll()

        val btnHelpChild = view.findViewById<View>(R.id.coordinator_id_help_child)
        btnHelpChild.setOnClickListener {
            presenter?.onNavigateHelpChild()
        }

        val top = view.findViewById<ImageButton>(R.id.btn_Image_Add)
        top.setOnClickListener {

            constraintLayout.visibility = View.VISIBLE
            btn_Image_Add.visibility = View.GONE
            imBtnDelete.visibility = View.VISIBLE
        }

        val bottom = view.findViewById<ImageButton>(R.id.imBtnDelete)
        bottom.setOnClickListener {
            constraintLayout.visibility = View.GONE
            btn_Image_Add.visibility = View.VISIBLE
            imBtnDelete.visibility = View.GONE
        }
        return view
    }

    override fun navigateToHelp() {
        val fragment: Fragment = HelpFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.add(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}