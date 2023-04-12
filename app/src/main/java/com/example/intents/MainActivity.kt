package com.example.intents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    lateinit var buttonsms:Button
    lateinit var buttonemail:Button
    lateinit var buttonmpesa:Button
    lateinit var buttonshare:Button
    lateinit var buttoncall:Button
    lateinit var buttoncamera:Button
    lateinit var buttonwebsite:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonemail = findViewById(R.id.btnemail)
        buttonsms = findViewById(R.id.btnsms)
        buttonmpesa = findViewById(R.id.btnmpesa)
        buttonshare = findViewById(R.id.btnshare)
        buttoncall = findViewById(R.id.btncall)
        buttoncamera = findViewById(R.id.btncamera)
        buttonwebsite = findViewById(R.id.btnwebsite)

        buttonsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0706792790")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "Hello there...")
            startActivity(intent)
        }

        buttonemail.setOnClickListener {
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abunalawrie@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(
                Intent.EXTRA_TEXT,
                "Dear Sir, following the posting for the striper position on the Daily pub. I am therefore applying for this position. Below you will find an attachment for my qualifications"
            )
            startActivity(Intent.createChooser(emailIntent, "Send Email..."))
        }

        buttoncamera.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }

        buttonmpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }

        buttonshare.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, Download this from....")
            startActivity(shareIntent)
        }

        //  buttoncall.setOnClickListener{
        //      val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0706792790"))
        //      if (ContextCompat.checkSelfPermission(
        //              this@MainActivity,
        //              android.Manifest.permission.CALL_PHONE
        //      ) != PackageManager.PERMISSION_GRANTED
        //      ) {
        //           ActivityCompat.requestPermissions(
        //              this@MainActivity,
        //             arrayOf<String>(android.Manifest.permission.CALL_PHONE)
        //        )
        //    }
        // }

        buttoncall.setOnClickListener {
            val phoneNumber = "tel:0706792790"
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse(phoneNumber)
            }
            startActivity(intent)
        }

        buttonwebsite.setOnClickListener{
            val gotowebsite = Intent(this, websiteactivity::class.java)
            startActivity(gotowebsite)
        }
        }
    }
