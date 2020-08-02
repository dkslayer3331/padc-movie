package com.mhst.padc_movie_app.unit_tests

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.mhst.padc_movie_app.data.models.MockMovieImpl
import com.mhst.padc_movie_app.data.models.MovieModel
import com.mhst.padc_movie_app.data.models.MovieModelImpl
import com.mhst.padc_movie_app.mvp.presenter.GenrePresenterImpl
import com.mhst.padc_movie_app.mvp.presenter.VideoPresenterImpl
import com.mhst.padc_movie_app.mvp.view.GenreListView
import com.mhst.padc_movie_app.mvp.view.VideoView
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
class VideoPresenterTest {

    private lateinit var mPresenter : VideoPresenterImpl

    @RelaxedMockK
    private lateinit var mView: VideoView

    lateinit var movieModel: MovieModel

    @Before
    fun setUpPresenter() {
        MockKAnnotations.init(this)

        MovieModelImpl.initDb(ApplicationProvider.getApplicationContext())

        movieModel = MockMovieImpl

        mPresenter = VideoPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.model = movieModel

    }

    @Test
    fun onUiRady_callVideo(){

        val movieId = 11

        mPresenter.onUiReady(movieId)

        verify {
            mView.showVideo(DummyDatas.getVideoById(movieId).key ?: "")
        }

    }


}