package xyz.divineugorji.mvvmsearchapp.ui.gallery

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import xyz.divineugorji.mvvmsearchapp.R
import xyz.divineugorji.mvvmsearchapp.databinding.FragmentGalleryBinding

@AndroidEntryPoint
class GalleryFragment: Fragment(R.layout.fragment_gallery) {


    private val viewModel by viewModels<GalleryVIewModel>()

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        _binding = FragmentGalleryBinding.bind(view)

        val adapter = UnsplashPhotoAdapter()

        binding.apply{
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }

        viewModel.photos.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}