package com.example.retrofitkotlin

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class GalleryViewModel @Inject constructor(private val repository: PhotoRepository) :ViewModel() {
}