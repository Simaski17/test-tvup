package com.example.testtvup.ui.catalogue

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.Backgrounds
import com.example.domain.ResponseIMDB
import com.example.falabellatest.ui.common.*
import com.example.testtvup.R
import com.example.testtvup.ui.catalogue.adapter.Constants
import com.example.testtvup.ui.catalogue.adapter.FeedAdapter
import com.example.testtvup.ui.catalogue.adapter.FeedItemBinder
import com.example.testtvup.ui.catalogue.adapter.FeedItemClass
import com.example.testtvup.ui.catalogue.adapter.models.HorizontalImageListModel
import com.example.testtvup.ui.catalogue.adapter.models.HorizontalImageModel
import com.m.genericadaptersample.adapter.viewholder.HorizontalImagesListViewBinder
import kotlinx.android.synthetic.main.fragment_catalogue_main.*


class CatalogueMainFragment : Fragment() {

    private lateinit var component: CatalogueMainFragmentComponent
    private val viewModel: CatalogueMainViewModel by lazy { getViewModel { component.catalogueMainViewModel } }

    val arrayListImages : ArrayList<Any> = ArrayList()
    var items = ArrayList<ResponseIMDB>()
    private var adapter: FeedAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_catalogue_main, container, false)

        component = context?.app?.component?.plus(CatalogueMainFragmentModule())!!
        viewModel.model.observe(viewLifecycleOwner, Observer(::updateBackground))
        viewModel.modelData.observe(viewLifecycleOwner, Observer(::updateData))

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
                    viewModel.findMovies()
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

    private fun updateData(event: Data<List<ResponseIMDB>>?) {

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

                items = it as ArrayList<ResponseIMDB>
                addData(items)

            }
        }
    }

    fun addData(list: ArrayList<ResponseIMDB>){

        list.forEach {

            var arrayListCoupleVerticalImages : ArrayList<HorizontalImageModel> = ArrayList()

            it.items.forEach {
                val horizontalImageModel1 : HorizontalImageModel =
                    HorizontalImageModel(it.art, it.id, Constants.VERTICAL_LIST)
                arrayListCoupleVerticalImages.add(horizontalImageModel1)
            }

            val horizontalImageListModel1 : HorizontalImageListModel = HorizontalImageListModel(arrayListCoupleVerticalImages,Constants.HORIZONTAL_LIST)
            horizontalImageListModel1.title = it.title

            arrayListImages?.add(horizontalImageListModel1)

        }

        showFeedItems(vertical_recyclerview,arrayListImages)

    }

    fun horizontalImageClick(data : HorizontalImageModel){
        Toast.makeText(activity?.applicationContext,"HORIZONTAL ${data.Image}", Toast.LENGTH_SHORT).show()
//        val action = HomeFragmentDirections.actionHomeFragmentToIndicatorDetailFragment(code = it.codigo)
//        findNavController().navigate(action)


        
    }

    private fun showFeedItems(recyclerView: RecyclerView, list: ArrayList<Any>?) {

        if (adapter == null) {
            val viewBinders = mutableMapOf<FeedItemClass, FeedItemBinder>()

            val horizontalImagesViewBinder = HorizontalImagesListViewBinder { data : HorizontalImageModel ->
                horizontalImageClick(data)}

            @Suppress("UNCHECKED_CAST")
            viewBinders.put(
                horizontalImagesViewBinder.modelClass,
                horizontalImagesViewBinder as FeedItemBinder)

            adapter = FeedAdapter(viewBinders)
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL,false)
        }
        if (recyclerView.adapter == null) {
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as FeedAdapter).submitList(list ?: emptyList())
    }


}