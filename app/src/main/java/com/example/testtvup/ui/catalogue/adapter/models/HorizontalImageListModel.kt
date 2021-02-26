package com.example.testtvup.ui.catalogue.adapter.models

import com.example.testtvup.ui.catalogue.adapter.Constants

data class HorizontalImageListModel(val Images : ArrayList<HorizontalImageModel>,
                                    val type : Int = Constants.HORIZONTAL_LIST,
                                    val id : Int = Constants.HORIZONTAL_LIST,
                                    var title : String = "") {
}