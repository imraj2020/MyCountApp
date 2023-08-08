package com.example.mycountapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private var score:Int = 0;
    private var  _scoreData = MutableLiveData<Int>()
    var scoreData :LiveData<Int> = _scoreData

    init {
        _scoreData.postValue(score)
    }

    fun increment(){
        score++
        _scoreData.postValue(score)
    }
    fun decrement(){
        score--
        _scoreData.postValue(score)
    }
    fun reset(){
        score=0
        _scoreData.postValue(score)
    }

}