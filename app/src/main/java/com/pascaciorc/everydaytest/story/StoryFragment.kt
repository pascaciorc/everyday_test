package com.pascaciorc.everydaytest.story

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascaciorc.everydaytest.R
import com.pascaciorc.everydaytest.data.Take
import com.pascaciorc.everydaytest.data.tileView
import kotlinx.android.synthetic.main.fragment_story.*

class StoryFragment : Fragment() {
    private lateinit var viewModel: StoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(StoryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_story, container, false)

        recycler_view.withModels {
            tileView {
                id(hashCode())
                tile(Take(69,69))
            }
        }

        return root
    }
}