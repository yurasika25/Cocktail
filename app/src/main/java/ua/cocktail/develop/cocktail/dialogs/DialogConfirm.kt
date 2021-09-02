package ua.cocktail.develop.cocktail.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import ua.cocktail.develop.cocktail.main.MainActivity


class DialogConfirm : DialogFragment() {
    @NonNull
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val message = "Ви переказуєте свої бали на допомогу"
        val button1String = "ТАК"
        val button2String = "НІ"
        val builder = AlertDialog.Builder(activity)
        builder.setMessage(message) // сообщение
        builder.setPositiveButton(
            button1String
        ) { dialog, id ->

            Toast.makeText(
                activity, "Допомогу відправлено!",
                Toast.LENGTH_LONG
            ).show()
        }
        builder.setNegativeButton(
            button2String
        ) { _, _ ->
        }
        builder.setCancelable(true)
        return builder.create()
    }
}