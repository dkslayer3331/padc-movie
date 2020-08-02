package com.mhst.padc_movie_app.unit_tests

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mhst.padc_movie_app.data.models.MockMovieImpl
import com.mhst.padc_movie_app.data.models.MovieModel
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.mvp.presenter.DetailPresenterImpl
import com.mhst.padc_movie_app.mvp.presenter.MainPresenterImpl
import com.mhst.padc_movie_app.mvp.view.DetailView
import com.mhst.padc_movie_app.mvp.view.MainView
import com.mhst.padc_movie_app.utils.DummyDatas
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.annotation.Config

/**
 * Created by Moe Htet on 02,August,2020
 */
@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class DetailPresenterTest {

    private lateinit var mPresenter: DetailPresenterImpl

    @RelaxedMockK
    private lateinit var mView: DetailView

    lateinit var movieModel: MovieModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDb(ApplicationProvider.getApplicationContext())

        movieModel = MockMovieImpl

        mPresenter = DetailPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.model = movieModel
    }

    @Test
    fun onUiReady_getDetail(){

        val movieId = 9

        val lifeCycleOwner = Mockito.mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        Mockito.`when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(movieId)

       verify {
           mView.showDetail(DummyDatas.getDummyDetail(movieId))
       }

    }


}