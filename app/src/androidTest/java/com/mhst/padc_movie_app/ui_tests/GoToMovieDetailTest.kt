package com.mhst.padc_movie_app.ui_tests

import android.content.Intent
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.mhst.padc_movie_app.R
import com.mhst.padc_movie_app.activities.MainActivity
import com.mhst.padc_movie_app.views.viewholders.MovieViewHolder
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Moe Htet on 02,August,2020
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class GoToMovieDetailTest {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    open fun setUp() {
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun tapOnMovie_navigateToMovieDetails() {
        onView(withId(R.id.rvPopularMovies))
            .perform(RecyclerViewActions.actionOnItemAtPosition<MovieViewHolder>(0, click()))

        onView(withId(R.id.tvDuration))
            .check(matches(isDisplayed()))

    }

    @Test
    fun tapOnVideo_navigateVideoPlay(){
   //onView(withId(R.id.vpImageSlider)).perform(swipeLeft())
        onView(allOf(withId(R.id.ivSliderImage), isDescendantOfA(withChild(withId(R.id.vpImageSlider)))))
            .perform(click())
        onView(withId(R.id.playerView)).check(matches(isDisplayed()))
    }

    @Test
    fun checkGenres(){
        Thread.sleep(1000)
        onView(withId(R.id.vpTabAndPager)).perform(scrollTo())

        onView(withId(R.id.vpTabAndPager))
            .check(matches(isDisplayed()))
    }

}