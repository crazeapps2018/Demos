package com.example.demos.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.demos.R
import com.example.demos.adapter.PaginationAdapter
import com.example.demos.listener.PaginationScrollListener
import com.example.demos.model.Movie
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment() {

    private val TAG = "MainActivity"

    var adapter: PaginationAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null

    var rv: RecyclerView? = null
    var progressBar: ProgressBar? = null

    private val PAGE_START = 0
    private var isLoading = false
    private var isLastPage = false
    private val TOTAL_PAGES = 3
    private var currentPage = PAGE_START



    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        rv = view.findViewById(R.id.main_recycler) as RecyclerView
        progressBar = view.findViewById(R.id.main_progress) as ProgressBar



        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).toolbar_title.setText("Home")

        adapter = PaginationAdapter(requireContext())

        linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv!!.layoutManager = linearLayoutManager

        rv!!.itemAnimator = DefaultItemAnimator()

        rv!!.adapter = adapter

        rv!!.addOnScrollListener(object : PaginationScrollListener(linearLayoutManager) {
            override fun loadMoreItems() {
                this@HomeFragment.isLoading = true
                currentPage += 1

                // mocking network delay for API call
                Handler().postDelayed({ loadNextPage() }, 1000)
            }

            override fun getTotalPageCount(): Int {
                return TOTAL_PAGES
            }

            override fun isLastPage(): Boolean {
                return this@HomeFragment.isLastPage
            }

            override fun isLoading(): Boolean {
                return  this@HomeFragment.isLoading
            }
        })


        // mocking network delay for API call
        Handler().postDelayed({ loadFirstPage() }, 1000)

    }


    private fun loadFirstPage() {
        Log.d(TAG, "loadFirstPage: ")
        val movies: List<Movie> = Movie.createMovies(adapter!!.itemCount)
        progressBar!!.visibility = View.GONE
        adapter!!.addAll(movies)
        if (currentPage <= TOTAL_PAGES) adapter!!.addLoadingFooter() else isLastPage = true
    }

    private fun loadNextPage() {
        Log.d(TAG, "loadNextPage: $currentPage")
        val movies: List<Movie> = Movie.createMovies(adapter!!.itemCount)
        adapter!!.removeLoadingFooter()
        isLoading = false
        adapter!!.addAll(movies)
        if (currentPage !== TOTAL_PAGES) adapter!!.addLoadingFooter() else isLastPage = true
    }



}