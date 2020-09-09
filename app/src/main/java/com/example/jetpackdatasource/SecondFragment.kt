package com.example.jetpackdatasource

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetpackdatasource.datasource.DataStore
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private val adapter by lazy { UserAdapter() }
    private val dataStore by lazy { DataStore.getUserProtoDataStore(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userRecycler.adapter = adapter
        previousFragmentButton.setOnClickListener { findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment) }

        receiveData()
    }

    private fun receiveData() {
        GlobalScope.launch {
            dataStore.data
                .collect { adapter.items = listOf(it) }
        }
    }
}
