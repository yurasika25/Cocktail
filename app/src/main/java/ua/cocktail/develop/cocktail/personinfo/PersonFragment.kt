package ua.cocktail.develop.cocktail.personinfo

import android.app.DatePickerDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_person.*
import ua.cocktail.develop.cocktail.R
import java.text.SimpleDateFormat
import java.util.*

class PersonFragment : Fragment(), PersonFragmentView {


    override fun onPause() {
        super.onPause()
        presenter!!.exitFromView()
    }

    override fun onResume() {
        super.onResume()
        presenter!!.enterWithView(this)
    }

    private var presenter: PersonFragmentPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_person, container, false)

        presenter = PersonFragmentPresenter()

        val tBar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarPersonInfo)
        tBar.setNavigationOnClickListener {
            requireActivity().onBackPressed()

        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        edit_block.isEnabled = false
        edit_block_two.isEnabled = false
        edit_block_three.isEnabled = false
        id_text_data.isEnabled = false
        id_edit_surname_Two.isEnabled = false


        val pen = view.findViewById<View>(R.id.pen)
        pen.setOnClickListener {
            edit_block.isEnabled = true
            edit_block_two.isEnabled = true
            edit_block_three.isEnabled = true
            id_text_data.isEnabled = true
            id_edit_surname_Two.isEnabled = true

            id_linear_gone.visibility = View.VISIBLE
            pen.visibility = View.GONE
            toolbarPersonInfo.title = "Редагування даних"
        }

        button_edit_text_save.setOnClickListener {
            saveData()
            edit_block.isEnabled = false
            edit_block_two.isEnabled = false
            edit_block_three.isEnabled = false
            id_text_data.isEnabled = false
            id_edit_surname_Two.isEnabled = false
            id_linear_gone.visibility = View.GONE
            pen.visibility = View.VISIBLE
        }
        val textView = view.findViewById<TextView>(R.id.id_text_data)
        val cal = Calendar.getInstance()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val myFormat = "dd.MM.yyyy"
                val sdf = SimpleDateFormat(myFormat, Locale.US)
                textView.text = sdf.format(cal.time)
            }
        textView.setOnClickListener {
            DatePickerDialog(
                requireContext(), dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
        val title = id_edit_number.text.toString()
        val titleTwo = edit_two_Two.text.toString()
        if (title != "" && titleTwo != "") {
            id_edit_number.isEnabled = false
            edit_two_Two.isEnabled = false
        } else {
            Toast.makeText(requireContext(), "Заповніть усі поля!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun saveData() {
        val insertedText: String = id_edit_name.text.toString()
        id_edit_name.setText(insertedText)

        val insertedTextTwo: String = edit_two.text.toString()
        edit_two.setText(insertedTextTwo)

        val insertedTextThree: String = id_edit_surname.text.toString()
        id_edit_surname.setText(insertedTextThree)

        val insertedTextFour: String = id_text_data.text.toString()
        id_text_data.setText(insertedTextFour)

        val insertedTextFive: String = id_edit_number.text.toString()
        id_edit_number.setText(insertedTextFive)

        val insertedTextSix: String = edit_two_Two.text.toString()
        edit_two_Two.setText(insertedTextSix)

        val insertedTextSeven: String = id_edit_surname_Two.text.toString()
        id_edit_surname_Two.setText(insertedTextSeven)

        val sharePreferences: SharedPreferences =
            requireActivity().getPreferences(Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharePreferences.edit()

        editor.apply {
            putString("STRING_KEY", insertedText)
            putString("STRING_KEY_TWO", insertedTextTwo)
            putString("STRING_KEY_THREE", insertedTextThree)
            putString("STRING_KEY_FOUR", insertedTextFour)
            putString("STRING_KEY_FIVE", insertedTextFive)
            putString("STRING_KEY_SIX", insertedTextSix)
            putString("STRING_KEY_SEVEN", insertedTextSeven)
        }.apply()
    }


    private fun loadData() {
        val sharePreferences: SharedPreferences =
            requireActivity().getPreferences(Context.MODE_PRIVATE)

        val savedString = sharePreferences.getString("STRING_KEY", null)
        val savedStringTwo = sharePreferences.getString("STRING_KEY_TWO", null)
        val savedStringThree = sharePreferences.getString("STRING_KEY_THREE", null)
        val savedStringFour = sharePreferences.getString("STRING_KEY_FOUR", null)
        val savedStringFive = sharePreferences.getString("STRING_KEY_FIVE", null)
        val savedStringSix = sharePreferences.getString("STRING_KEY_SIX", null)
        val savedStringSeven = sharePreferences.getString("STRING_KEY_SEVEN", null)

        id_edit_name.setText(savedString)
        edit_two.setText(savedStringTwo)
        id_edit_surname.setText(savedStringThree)
        id_text_data.setText(savedStringFour)
        id_edit_number.setText(savedStringFive)
        edit_two_Two.setText(savedStringSix)
        id_edit_surname_Two.setText(savedStringSeven)
    }
}


