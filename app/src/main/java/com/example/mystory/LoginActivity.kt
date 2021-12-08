package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.mystory.R.layout.activity_login

class LoginActivity : AppCompatActivity() {

    private var editTextUsername: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonLogin: Button? = null
    private var checkBoxView: CheckBox? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_login)

        connectViews()
        login()
  //      checkFields()

    }

    private fun connectViews() {
        editTextUsername = findViewById(R.id.etUsername)
        editTextPassword = findViewById(R.id.etPassword)
        buttonLogin = findViewById(R.id.btnLogin)
        checkBoxView = findViewById(R.id.checkbox)
    }

    private fun login() {
        val arr: ArrayList<User> = ArrayList()

        arr.add(User("test@test.com", "1234"))
        arr.add(User("t@gmail.com", "12345"))
        arr.add(User("b@test.com", "123456"))

        buttonLogin?.setOnClickListener {
            val username = editTextUsername?.text.toString()
            val password = editTextPassword?.text.toString()

            val user = User(username, password)

            for (userArray in arr) {
                if (userArray.emil == user.emil
                    && userArray.password == user.password ) {
//                    Toast.makeText(this,"Welcome ${user.emil}",Toast.LENGTH_LONG).show()
                    finish()
                    val i = Intent(this, MainActivity::class.java)
                    i.putExtra("email", userArray.emil)
                    startActivity(i)
                    break
                } else {
                    Toast.makeText(this, "Check your data", Toast.LENGTH_LONG).show()
                }

            }

        }



    }
    private fun checkFields(){
            buttonLogin?.setOnClickListener {
                if (editTextUsername?.text?.isEmpty() == true){
                    editTextUsername?.setError("Enter your email")
                } else if(editTextPassword?.text?.isEmpty() == true){
                    editTextPassword?.error = "Entr your password"
                }
            }

        }

    }

