package com.example.clase2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.clase2.databinding.FragmentFirstBinding
import com.google.android.material.snackbar.Snackbar

class FirstFragment : Fragment() {
    lateinit var v: View
    lateinit var btnNext: View
    lateinit var editTextEmail: TextView
    lateinit var editTextPass: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_first, container, false)
        btnNext = v.findViewById(R.id.btnNext)
        editTextEmail = v.findViewById(R.id.editTextEmail)
        editTextPass = v.findViewById(R.id.editTextPass)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mainActivity = activity as MainActivity
        val usersList = mainActivity.usersList
        var successFlag : Boolean = false

        btnNext.setOnClickListener {
            Log.d("FirstFragment", "Credentials: ${editTextEmail.text}; ${editTextPass.text}")
            loop@ for(user in usersList){
                Log.d("FirstFragment", "User in loop: ${user.email}; ${user.password}")
                if (editTextEmail.text.toString().trim().equals(user.email) && editTextPass.text.toString().equals(user.password)){
                    displayMessage("Logged in Successfully")
                    Log.d("FirstFragment", "Credentials match with DB")
                    findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
                    successFlag = true
                    break@loop
                }
            }
            if (!successFlag){
                displayMessage("Wrong Credentials")
                Log.d("FirstFragment", "Wrong Credentials!")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    fun displayMessage(message: String) {
        Snackbar.make(v, message, Snackbar.LENGTH_SHORT).show()
    }
}