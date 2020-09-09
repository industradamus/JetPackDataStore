package com.example.jetpackdatasource

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetpackdatasource.datasource.DataStore
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private val dataStore by lazy { DataStore.getUserProtoDataStore(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nextFragmentButton.setOnClickListener { findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment) }

        addButton.setOnClickListener {
            GlobalScope.launch {
                dataStore.updateData { user ->
                    user.toBuilder()
                        .setName(nameField.text.toString())
                        .setLastName(lastNameField.text.toString())
                        .setAge(ageField.text.toString().toIntOrNull() ?: 0)
                        .setIsActive(isActiveSwitch.isChecked)
                        .build()
                }
            }

            Snackbar.make(addButton, "Success Added", Snackbar.LENGTH_SHORT).show()
        }
    }
}
