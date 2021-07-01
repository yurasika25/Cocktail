package ua.cocktail.develop.cocktail.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_search.*
import ua.cocktail.develop.cocktail.R
import ua.cocktail.develop.cocktail.utils.Constants

class SearchFragment : Fragment(), SearchFragmentView {

    val bad = 0..3
    val normal = 4..6
    val nice = 7..9
    val excellent = 10
    val grandeArray = arrayOf(4, 7, 3, 6, 10, 2)
    val nameArray = arrayOf("Антон", "Егор", "Маша", "Света", "Юля", "Семен")
    val badArray = ArrayList<String>()
    val normalArray = ArrayList<String>()
    val niceArray = ArrayList<String>()
    val excellentArray = ArrayList<String>()


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: SearchFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)

        presenter = SearchFragmentPresenter()


        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarSearch)
        tBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()

        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for ((index, name) in nameArray.withIndex()) {
            when (grandeArray[index]) {
                in bad -> badArray.add("Погані оцінки $name - ${grandeArray[index]}")
                in normal -> badArray.add("Погані оцінки $name - ${normalArray[index]}")
                in nice -> badArray.add("Погані оцінки $name - ${niceArray[index]}")
                excellent -> badArray.add("Погані оцінки $name - ${excellentArray[index]}")
            }

        }
        id_text_view_result.text = badArray.toString()

        id_btn_confirm.setOnClickListener {
            presenter!!.onClickBtnConfirm()
        }
    }

    override fun changesToDo() {
        when (id_edit_text.text.toString()) {
            Constants.PROGRAMMER -> {
                id_text_view_result.visibility = View.VISIBLE
                val sum = Constants.PROGRAMMER_SALARY
                val password = Constants.PROGRAMMER_PASSWORD
                if (id_edit_password.text.toString() == password) {
                    id_text_view_result.text = sum
                    id_image_tv.visibility = View.VISIBLE
                    id_image_tv.setBackgroundResource(R.drawable.im_programmer)
                }
                else {
                    Toast.makeText(requireActivity(), "Не правильний пароль", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            Constants.MUSICIAN -> {
                id_text_view_result.visibility = View.VISIBLE
                val sum = Constants.MUSICIAN_SALARY
                val password = Constants.MUSICIAN_PASSWORD
                if (id_edit_password.text.toString() == password) {
                    id_text_view_result.text = sum
                    id_image_tv.visibility = View.VISIBLE
                    id_image_tv.setBackgroundResource(R.drawable.im_mus)
                } else {
                    Toast.makeText(requireActivity(), "Не правильний пароль", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            Constants.LAWYER -> {
                id_text_view_result.visibility = View.VISIBLE
                val sum = Constants.LAWYER_SALARY
                val password = Constants.LAWYER_PASSWORD
                if (id_edit_password.text.toString() == password) {
                    id_text_view_result.text = sum
                    id_image_tv.visibility = View.VISIBLE
                    id_image_tv.setBackgroundResource(R.drawable.im_lawyer)
                } else {
                    Toast.makeText(requireActivity(), "Не правильний пароль", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            Constants.COSMONAUT -> {
                id_text_view_result.visibility = View.VISIBLE
                val sum = Constants.COSMONAUT_SALARY
                val password = Constants.COSMONAUT_PASSWORD
                if (id_edit_password.text.toString() == password) {
                    id_text_view_result.text = sum
                    id_image_tv.visibility = View.VISIBLE
                    id_image_tv.setBackgroundResource(R.drawable.im_cosmonaut)
                } else {
                    Toast.makeText(requireActivity(), "Не правильний пароль", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            Constants.ENGINEER -> {
                id_text_view_result.visibility = View.VISIBLE
                val sum = Constants.ENGINEER_SALARY
                val password = Constants.ENGINEER_PASSWORD
                if (id_edit_password.text.toString() == password) {
                    id_text_view_result.text = sum
                    id_image_tv.visibility = View.VISIBLE
                    id_image_tv.setBackgroundResource(R.drawable.im_ingineer)
                } else {
                    Toast.makeText(requireActivity(), "Не правильний пароль", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            Constants.WRITE_MEN -> {
                id_text_view_result.visibility = View.VISIBLE
                val sum = Constants.WRITE_MEN_SALARY
                val password = Constants.WRITE_MEN_PASSWORD
                if (id_edit_password.text.toString() == password) {
                    id_text_view_result.text = sum
                    id_image_tv.visibility = View.VISIBLE
                    id_image_tv.setBackgroundResource(R.drawable.im_lawyer)
                } else {
                    Toast.makeText(requireActivity(), "Не правильний пароль", Toast.LENGTH_SHORT)
                        .show()
                }
            }

            Constants.DENS_MEN -> {
                id_text_view_result.visibility = View.VISIBLE
                val sum = Constants.DENS_MEN_SALARY
                val password = Constants.DENS_MEN_PASSWORD
                if (id_edit_password.text.toString() == password) {
                    id_image_tv.visibility = View.VISIBLE
                    id_image_tv.setBackgroundResource(R.drawable.ic_dev_easy)
                    id_text_view_result.text = sum
                } else {
                    Toast.makeText(requireContext(), "test", Toast.LENGTH_SHORT).show()
                }
            }


            else -> Toast.makeText(
                requireContext(),
                "Посаду не знайдено! " + "Перевірте правильність написання тексту",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}


