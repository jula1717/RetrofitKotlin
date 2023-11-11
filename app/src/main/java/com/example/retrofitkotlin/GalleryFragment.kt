package com.example.retrofitkotlin

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitkotlin.databinding.FragmentGalleryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GalleryFragment(): Fragment(R.layout.fragment_gallery) {
    private var _binding : FragmentGalleryBinding?=null
    private val binding
        get() = _binding!!
    private val viewModel by viewModels<GalleryViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        _binding = FragmentGalleryBinding.bind(view)
        val photoAdapter = PhotoAdapter()

        binding.apply {
            recyclerView.apply {
                adapter = photoAdapter.withLoadStateHeaderAndFooter(
                    header = PhotoLoadStateAdapter{photoAdapter.retry()},
                    footer = PhotoLoadStateAdapter{photoAdapter.retry()}
                )
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }

        viewModel.photos.observe(viewLifecycleOwner) {
            photoAdapter.submitData(viewLifecycleOwner.lifecycle,it)
        }

}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}