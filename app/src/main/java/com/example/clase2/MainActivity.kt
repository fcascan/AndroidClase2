package com.example.clase2

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.clase2.databinding.ActivityMainBinding
import com.example.clase2.entities.User

class MainActivity : AppCompatActivity() {
    private val user1: User = User("Fer", "Castro", "fcc@gmail.com", "1234")
    private val user2: User = User("Juan", "Garcia", "jg@mail.com", "7890")
    private val user3: User = User("Pedro", "Perez", "pp@hotmail.com", "0000")
    var usersList: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        usersList.add(user1)
        usersList.add(user2)
        usersList.add(user3)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
    }
}