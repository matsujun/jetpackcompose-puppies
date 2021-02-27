package dev.matsujun.puppies.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.matsujun.puppies.data.Puppy
import dev.matsujun.puppies.data.puppies

class DetailViewModel: ViewModel() {

    fun setPuppyId(id: Int?) {
        _puppyData.value = puppies.find { it.id == id } ?: puppies[0]
    }
    private val _puppyData = MutableLiveData<Puppy>()
    val puppyData: LiveData<Puppy> = _puppyData
}