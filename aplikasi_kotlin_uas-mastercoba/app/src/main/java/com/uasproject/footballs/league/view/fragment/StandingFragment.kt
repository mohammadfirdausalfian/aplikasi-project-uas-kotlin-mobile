package com.uasproject.footballs.league.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.uasproject.footballs.R
import com.uasproject.footballs.api.ApiRepository
import com.uasproject.footballs.league.adapter.StandingAdapter
import com.uasproject.footballs.league.interfaces.StandingView
import com.uasproject.footballs.league.model.League
import com.uasproject.footballs.league.model.Standing
import com.uasproject.footballs.league.presenter.StandingPresenter
import com.uasproject.footballs.team.view.TeamFragment
import kotlinx.android.synthetic.main.fragment_standing.view.*

/**
 * A simple [Fragment] subclass.
 */
class StandingFragment : Fragment(), StandingView {

    private var standings: MutableList<Standing> = mutableListOf()
    private lateinit var adapter: StandingAdapter
    private lateinit var presenter: StandingPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_standing, container, false)

        val league = activity?.intent?.getParcelableExtra(TeamFragment.EXTRA_LEAGUE) as League

        val request = ApiRepository()
        val gson = Gson()

        presenter = StandingPresenter(this, request, gson)
        presenter.getData(league.leagueId)

        adapter = StandingAdapter(standings) {

        }

        view.rv_standing.adapter = adapter
        view.rv_standing.layoutManager = LinearLayoutManager(activity)

        view.swipe.setOnRefreshListener {
            presenter.getData(league.leagueId)
            view.swipe.isRefreshing = false
        }
        return view
    }

    override fun showLoading() {
        view?.progress?.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        view?.progress?.visibility = View.INVISIBLE
    }

    override fun showData(data: List<Standing>?) {
        standings.clear()
        if (data != null) {
            standings.addAll(data)
        }
        adapter.notifyDataSetChanged()
    }
}
