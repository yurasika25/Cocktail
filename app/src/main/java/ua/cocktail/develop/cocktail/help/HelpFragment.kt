package ua.cocktail.develop.cocktail.help

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.databinding.FragmentHelpBinding
import ua.cocktail.develop.cocktail.dialogs.DialogConfirm
import ua.cocktail.develop.cocktail.mainfragment.MainFragment
import ua.cocktail.develop.cocktail.rules.RulesFragment
import ua.cocktail.develop.cocktail.test.TestFragment

class HelpFragment : Fragment(), HelpFragmentView {


    lateinit var binding : FragmentHelpBinding

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

        binding = FragmentHelpBinding.bind(view)

        presenter = HelpFragmentPresenter()


        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarHelpChild)
        tBar.setNavigationOnClickListener { requireActivity().onBackPressed()
        }

        val tickStart: TextView = view.findViewById(R.id.tickStart)
        val tickStartSeek: SeekBar = view.findViewById(R.id.tickStartSeek)
        tickStartSeek.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            @SuppressLint("SetTextI18n")
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                tickStart.text = "Відправити $progress балів"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {
                tickStart.text = seekBar.progress.toString()
            }
        })

        val btnView = view.findViewById<View>(R.id.id_more_info)
        btnView.setOnClickListener {
            val url = "https://dobrodiy.club/"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSentHelp.setOnClickListener {
            val dialogConfirm = DialogConfirm()
            val manager = fragmentManager
            if (manager != null){
                dialogConfirm.show(manager,"Dialog")
            }
        }
    }

    override fun navigateToTest() {
        val fragment: Fragment = TestFragment()
        val fm = requireActivity().supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(R.id.mainContainer, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}


