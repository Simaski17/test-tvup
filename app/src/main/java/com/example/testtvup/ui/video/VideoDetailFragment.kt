package com.example.testtvup.ui.video

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.testtvup.R
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import kotlinx.android.synthetic.main.fragment_video_detail.*


class VideoDetailFragment : Fragment() {

    private val args: VideoDetailFragmentArgs by navArgs()
    var videoPlayer = activity?.let { SimpleExoPlayer.Builder(it.applicationContext).build() }
    private var sampleUrl = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_video_detail, container, false)

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sampleUrl = args.url
        initializePlayer()
    }

    private fun buildMediaSource(): MediaSource? {
        val dataSourceFactory = DefaultDataSourceFactory(activity?.applicationContext, "sample")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(Uri.parse(sampleUrl))
    }

    private fun initializePlayer() {
        videoPlayer = activity?.let { SimpleExoPlayer.Builder(it.applicationContext).build() }
        playerView?.player = videoPlayer
       // progressBar.visibility = View.VISIBLE
        buildMediaSource()?.let {
            videoPlayer?.prepare(it)
        }
    }

    override fun onResume() {
        super.onResume()
        videoPlayer?.playWhenReady = true
    }

    override fun onStop() {
        super.onStop()
        videoPlayer?.playWhenReady = false

            releasePlayer()

    }

    private fun releasePlayer() {
        videoPlayer?.release()
    }

}