package ua.cocktail.develop.cocktail.scanner

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import ua.cocktail.develop.cocktail.R

class MainActivity : Activity() {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun scanBar(v: View?) {
        try {

            // Запускаем переход на com.google.zxing.client.android.SCAN с помощью intent:
            val intent = Intent(ACTION_SCAN)
            intent.putExtra("SCAN_MODE", "PRODUCT_MODE")
            startActivityForResult(intent, 0)
        } catch (anfe: ActivityNotFoundException) {

            // Предлагаем загрузить с Play Market:
            showDialog(
                this@MainActivity,
                "Сканнер не найден",
                "Установить сканер с Play Market?",
                "Да",
                "Нет"
            ).show()
        }
    }

    fun scanQR(v: View?) {
        try {

            // Запускаем переход на com.google.zxing.client.android.SCAN с помощью intent:
            val intent = Intent(ACTION_SCAN)
            intent.putExtra("SCAN_MODE", "QR_CODE_MODE")
            startActivityForResult(intent, 0)
        } catch (anfe: ActivityNotFoundException) {

            // Предлагаем загрузить с Play Market:
            showDialog(
                this@MainActivity,
                "Сканнер не найден",
                "Установить сканер с Play Market?",
                "Да",
                "Нет"
            ).show()
        }
    }

    // Обрабатываем результат, полученный от приложения сканера:
    public override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                // Получаем данные после работы сканера и выводим их в Toast сообщении:
                val contents = intent.getStringExtra("SCAN_RESULT")
                val format = intent.getStringExtra("SCAN_RESULT_FORMAT")
                val toast = Toast.makeText(
                    this,
                    "Содержание: $contents Формат: $format", Toast.LENGTH_LONG
                )
                toast.show()
            }
        }
    }

    companion object {
        const val ACTION_SCAN = "com.google.zxing.client.android.SCAN"

        // alert dialog для перехода к загрузке приложения сканера:
        private fun showDialog(
            act: Activity, title: CharSequence,
            message: CharSequence, buttonYes: CharSequence, buttonNo: CharSequence
        ): AlertDialog {
            val downloadDialog = AlertDialog.Builder(act)
            downloadDialog.setTitle(title)
            downloadDialog.setMessage(message)
            downloadDialog.setPositiveButton(
                buttonYes
            ) { dialogInterface, i -> // Ссылка поискового запроса для загрузки приложения:
                val uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                try {
                    act.startActivity(intent)
                } catch (anfe: ActivityNotFoundException) {
                }
            }
            downloadDialog.setNegativeButton(
                buttonNo
            ) { dialogInterface, i -> }
            return downloadDialog.show()
        }
    }
}