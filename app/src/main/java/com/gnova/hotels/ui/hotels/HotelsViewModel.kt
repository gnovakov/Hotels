package com.gnova.hotels.ui.hotels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gnova.data.repositories.HotelsRepoImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HotelsViewModel@Inject constructor(private val hotelsRepo: HotelsRepoImpl) : ViewModel() {

    // View State
    private val _viewState = MutableLiveData<HotelsViewState>()
    val viewState: LiveData<HotelsViewState>
        get() = _viewState


    fun onViewLoaded() {
        getHotels()
    }

    private fun getHotels() {

        _viewState.value = HotelsViewState.Loading
        add(
            hotelsRepo.getHotels()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _viewState.value = HotelsViewState.Presenting(it)
                }, {
                    //RxJavaPlugins.onError(it)
                    _viewState.value = HotelsViewState.Error
                })
        )
    }

    val compositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
