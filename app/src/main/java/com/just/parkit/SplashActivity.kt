package com.just.parkit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception
import android.content.SharedPreferences


class SplashActivity : AppCompatActivity() {

    companion object {



        //location vars
        var mlat: String = "0"
        var mlong: String = "0"

        //url to add to database
        val addUrl: String = "http://192.168.1.51/restfulApi/insertUser.php"

        //todo change prefs file name
        val prefsFileName = "com.teamtreehouse.colorsarefun.prefs"
        var prefs: SharedPreferences? = null

        //user info's
        var userName: String = "الاسم الأول"
        var familyName: String = "العائلة"

        //define the grade saved in mysql
        var ugrade = "0"

        //define phone number saved in mysql
        var uphone = "0"

        // define phone number before saving
        var rphone = "no_num"

        var target = "http://localhost/"

        //define the userpassword

        var upassword = "كلمة السر"

        // define var for signup sucess
        //0 means fail or signed out, 1 means success
        //2 means he entered phone and waiting for verification message, 3 means he is logged in
        var signupsuccess: String? = null

        // define var for signup result serverside
        //0 means fail, 1 means success
        //2 means user phone exists
        var signupresult: String? = null

        //tawjihi sci subs
        var tawSciPhy = 0
        var tawSciChem = 0
        var tawSciBio = 0
        var tawSciGeo = 0

        //tawjihi lit subs
        var tawLitArHistory = 0
        var tawLitGeog = 0
        var tawLitCs = 0
        var tawLitIslamicSci = 0
        var tawLitEcon = 0
        var tawLitFr = 0

        //define listen grade
        var listenGrade = "0"

        var stream = "empty"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        //the font
        //val typeface = Typeface.createFromAsset(assets, "Arslan-Wessam-B.ttf")



        //sharedpreferences get
        prefs = this.getSharedPreferences(prefsFileName, MODE_PRIVATE)
        signupresult = prefs!!.getString("signupresult", "")
        signupsuccess = prefs!!.getString("signupsuccess", "")

    }

    override fun onResume() {
        super.onResume()

        //check if user signup is successful if its not take him through the signup form else take him to the main activity

        if (signupresult.isNullOrEmpty() || signupresult == "0" || signupresult == "2" || signupsuccess.isNullOrEmpty()) {

            //the delay on splash and goto first activity
            val background = object : Thread() {
                override fun run() {
                    try {
                        Thread.sleep(4000)

                        //todo it was first activity
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            background.start()

        }

        else if (signupsuccess == "2") {

            //the delay on splash and goto auth activity
            val background = object : Thread() {
                override fun run() {
                    try {
                        Thread.sleep(2000)

                        //todo turkish scholarship
                        //todo this was phoneauth activity
                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            background.start()

        }

        else {

            //the delay on splash and goto main activity
            val background = object : Thread() {
                override fun run() {
                    try {
                        Thread.sleep(2000)

                        val intent = Intent(baseContext, MainActivity::class.java)
                        startActivity(intent)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            background.start()
        }
    }
}