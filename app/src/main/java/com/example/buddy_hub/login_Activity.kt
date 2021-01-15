package com.example.buddy_hub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_login.*
import java.nio.channels.SelectableChannel

class login_Activity : AppCompatActivity() {
    lateinit var countryCode:String
    lateinit var phoneNumber:String
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        phoneEt.addTextChangedListener {
            nextButton.isEnabled = !(it.isNullOrEmpty() || it.length < 10)
        }

        nextButton.setOnClickListener {
            checkNumber()
        }




    }

    private fun checkNumber() {
        countryCode=ccp.selectedCountryCodeWithPlus
        phoneNumber=phoneEt.text.toString()
        notifyUser()
    }

    private fun notifyUser() {
        MaterialAlertDialogBuilder(this).apply {
            setMessage("We will be verifying the phone number:${countryCode+phoneNumber}\n"+ "Is it OK , Or would you like to edit the \nnumber ?")
            setPositiveButton("Ok") { _, _ ->
                showOtpActivity()
            }
            setNegativeButton("Edit") { dialog, which ->
                dialog.dismiss()
            }
            setCancelable(false)
            create()
            show()

        }
    }

    private fun showOtpActivity() {

    }
}