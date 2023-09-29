package com.example.androidfundamental.que_9

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.androidfundamental.R


class QueNineFragment : Fragment() {
    private lateinit var btnActivity : Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_que_nine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnActivity = view.findViewById(R.id.btn_go_to_activity)

        btnActivity.setOnClickListener {
            activity?.let {
                var intent = Intent(it,QueNineActivity::class.java)
                startActivity(intent)
            }

        }
    }


}
