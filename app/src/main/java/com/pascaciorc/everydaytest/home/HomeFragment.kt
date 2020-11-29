package com.pascaciorc.everydaytest.home

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.pascaciorc.everydaytest.databinding.FragmentHomeBinding
import com.pascaciorc.everydaytest.main.BaseFragment
import com.pascaciorc.everydaytest.service.PillBroadcastReceiver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class HomeFragment : BaseFragment(), HomeListener {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = this@HomeFragment
            listener = this@HomeFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDate().observe(viewLifecycleOwner, Observer {
            Toast.makeText(activity, it.size.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    override fun onButtonClicked(view: View) {
        launch {
            viewModel.setDate()
        }
    }

    private fun setAlarm() {
        activity?.apply {
            val pendingIntent = PendingIntent.getBroadcast(
                applicationContext,
                1,
                Intent(applicationContext, PillBroadcastReceiver::class.java),
                0
            )
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.set(
                AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(1),
                pendingIntent
            )
        }
    }
}