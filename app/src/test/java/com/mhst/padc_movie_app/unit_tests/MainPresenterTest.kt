package com.mhst.padc_movie_app.unit_tests

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mhst.padc_movie_app.data.models.MockMovieImpl
import com.mhst.padc_movie_app.data.models.MovieModel
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.data.vos.MovieVO
import com.mhst.padc_movie_app.mvp.presenter.MainPresenterImpl
import com.mhst.padc_movie_app.mvp.view.MainView
import com.mhst.padc_movie_app.utils.DummyDatas
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.Before
import io.mockk.MockKAnnotations
import io.mockk.verify
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by Moe Htet on 02,August,2020
 */
@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterTest {

    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView: MainView

    lateinit var movieModel: MovieModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDb(ApplicationProvider.getApplicationContext())

        movieModel = MockMovieImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.model = movieModel
    }

    @Test
    fun onUiReady_callDisplayMovies(){
        val lifeCycleOwner = mock(LifecycleOwner::class.java)
        val lifeCycleRegistry = LifecycleRegistry(lifeCycleOwner)
        lifeCycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME)
        `when`(lifeCycleOwner.lifecycle).thenReturn(lifeCycleRegistry)

        mPresenter.onUiReady(lifeCycleOwner)

        verify {
            mView.displayPopularMovies(DummyDatas.getMovieList())
        }

        verify {
            mView.displayActors(DummyDatas.getAllPeople())
        }

        verify {
            mView.displayGenreList(DummyDatas.getAllGenres())
        }

    }

}