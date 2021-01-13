package com.example.roomdatabase_kotlin.fragment.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase_kotlin.R
import com.example.roomdatabase_kotlin.fragment.model.User
import com.example.roomdatabase_kotlin.fragment.viewmodel.userViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {

private lateinit var muserViewModel: userViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        muserViewModel=ViewModelProvider(this).get(userViewModel::class.java)
        view.add_btn.setOnClickListener{
           insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstname=addFirstName_et.text.toString()
        val lastname=addLastName_et.text.toString()
        val age=addAge_et.text

        if(inputCheck(firstname, lastname, age)){
            //create User
            val user= User(0,firstname,lastname,Integer.parseInt(age.toString()))

            //add Data to database
            muserViewModel.addUser(user)
            Toast.makeText(requireContext(),"Successfully Added Data",Toast.LENGTH_SHORT).show()

            //naviagate to list
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(),"please fill out all field",Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstname:String,lastname:String,age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstname) &&TextUtils.isEmpty(lastname) &&TextUtils.isEmpty(age))
    }


}