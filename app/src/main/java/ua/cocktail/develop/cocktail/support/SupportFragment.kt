package ua.cocktail.develop.cocktail.support

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragmet_support.*
import ua.cocktail.develop.cocktail.R
import android.widget.Toast

class SupportFragment : Fragment(), SupportFragmentView {


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }
    private var presenter: SupportFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragmet_support, container, false)

        presenter = SupportFragmentPresenter()

        return view
    }
    override fun setUpUI() {
        toolbarSupport.setNavigationOnClickListener {
            requireActivity().onBackPressed()
        }
        supportTelegram.setOnClickListener {
            val telegram =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/yuri_sika_m"))
            startActivity(telegram)
        }
        supportViber.setOnClickListener {
            val viber =
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://invite.viber.com/?g=ij-4JlGkKU0Gcl7gRAvyXKO4XYaOp3VX")
                )
            startActivity(viber)
        }
        supportCall.setOnClickListener {
            val call =
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "+380995636588"))
            startActivity(call)
        }

        supportEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("yrasika80@gmail.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Відгук про роботу мобільного додатку")
            try {
                startActivity(Intent.createChooser(intent, "Відправити лист..."))
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(requireActivity(), "No mail app found!!!", Toast.LENGTH_SHORT).show()
            } catch (ex: Exception) {
                Toast.makeText(requireActivity(), "Unexpected Error!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


