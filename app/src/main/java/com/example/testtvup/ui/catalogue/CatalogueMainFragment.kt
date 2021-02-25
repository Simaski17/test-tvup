package com.example.testtvup.ui.catalogue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.domain.Backgrounds
import com.example.falabellatest.ui.common.*
import com.example.testtvup.R
import kotlinx.android.synthetic.main.fragment_catalogue_main.*


class CatalogueMainFragment : Fragment() {

    private lateinit var component: CatalogueMainFragmentComponent
    private val viewModel: CatalogueMainViewModel by lazy { getViewModel { component.catalogueMainViewModel } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_catalogue_main, container, false)

        component = context?.app?.component?.plus(CatalogueMainFragmentModule())!!
        viewModel.model.observe(viewLifecycleOwner, Observer(::updateBackground))

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.findBackground()

    }

    private fun updateBackground(event: Data<List<Backgrounds>>?) {

        event.with {
            when (dataState) {
                DataState.LOADING -> {

                }
                DataState.SUCCESS -> {

                }
                DataState.ERROR -> {

                }
            }

            data.notNull {

                val rnds = (0..6).random()
                activity?.let { it1 ->
                    Glide
                        .with(it1.applicationContext)
                        .load(it[rnds].imageUrl.toString())
                        .centerCrop()
                        .into(ivBackground)
                }

            }
        }
    }

}