package com.example.testtvup.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.domain.Item
import com.example.domain.ResponseIMDB
import com.example.falabellatest.ui.common.*
import com.example.testtvup.R
import kotlinx.android.synthetic.main.fragment_catalogue_detail.*
import kotlinx.android.synthetic.main.fragment_catalogue_main.*


class CatalogueDetailFragment : Fragment() {

    private lateinit var component: CatalogueDetailFragmentComponent
    private val viewModel: CatalogueDetailViewModel by lazy { getViewModel { component.catalogueDetailViewModel } }
    private val args: CatalogueDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_catalogue_detail, container, false)

        component = context?.app?.component?.plus(CatalogueDetailFragmentModule())!!
        viewModel.model.observe(viewLifecycleOwner, Observer(::findMovie))

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.findMovieById(args.id)

    }

    private fun findMovie (event: Data<Item>?) {

        event.with {
            when (dataState) {
                DataState.LOADING -> {}
                DataState.SUCCESS -> {}
                DataState.ERROR -> {}
            }

            data.notNull {

                tvTitlle.text = it.title
                tvDescription.text = it.description
                tvYear.text = it.year.toString()
                tvDirector.text = it.director

                activity?.let { it1 ->
                    Glide
                        .with(it1.applicationContext)
                        .load(it.art)
                        .centerCrop()
                        .into(ivCoverPage)
                }

            }

        }
    }

}