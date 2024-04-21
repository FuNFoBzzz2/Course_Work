package com.example.myapplication.fragments.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.BD.Recipe
import com.example.myapplication.R
import com.example.myapplication.BD.ViewModel

class addFragment : Fragment() {
    private lateinit var viewModel: ViewModel
    private lateinit var view: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_add, container, false)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        view.findViewById<Button>(R.id.buttonadd).setOnClickListener {
            insertDataBase()
        }
        return view
    }

    private fun insertDataBase(){
        val recipeName = view.findViewById<EditText>(R.id.txtNameRecipe).text.toString()
        var discription = view.findViewById<EditText>(R.id.txtdiscription).text.toString()
        if(emptyStringCheck(recipeName,discription)){
            val recipe = Recipe(0, recipeName, discription)
            viewModel.addRecipe(recipe) // Corrected line
            Toast.makeText(requireContext(),"Successfully added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_blankFragment)
        }else{
            Toast.makeText(requireContext(),"Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun emptyStringCheck(vararg strings: String?): Boolean {
        return strings.all { !it.isNullOrBlank() }
    }
}