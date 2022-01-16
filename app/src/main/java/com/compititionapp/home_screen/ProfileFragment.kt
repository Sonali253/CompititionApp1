package com.compititionapp.home_screen

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.compititionapp.R
import com.compititionapp.Util.PrefManager
import com.compititionapp.login.ui.login.LoginActivity


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView: View  = inflater.inflate(R.layout.fragment_profile, container, false)

        val textLogout = rootView.findViewById<TextView>(R.id.text_logout)
        textLogout.setOnClickListener {
            val prefManager = PrefManager()
            prefManager.context = requireContext()
            prefManager.logoutUser()
            // After logout redirect user to Login Activity
            val i = Intent(context, LoginActivity::class.java)
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

            // Add new Flag to start new Activity
            i.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            // Staring Login Activity
            context!!.startActivity(i)
        }

        return rootView
    }


}
