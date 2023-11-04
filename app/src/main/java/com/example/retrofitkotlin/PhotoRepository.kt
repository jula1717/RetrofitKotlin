package com.example.retrofitkotlin

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PhotoRepository @Inject constructor(private val photoApi: PhotoApi) {
}