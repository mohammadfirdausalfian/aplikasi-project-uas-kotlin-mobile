package com.uasproject.footballs.team.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.uasproject.footballs.R
import com.uasproject.footballs.team.model.Team
import com.uasproject.footballs.team.view.TeamDetailActivity
import kotlinx.android.synthetic.main.fragment_team_detail_overview.view.*

/**
 * A simple [Fragment] subclass.
 */
class TeamDetailOverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_team_detail_overview, container, false)

        val team = activity?.intent?.getParcelableExtra(TeamDetailActivity.EXTRA_TEAM) as Team
        view.team_detail_desc.text = team.teamDescription
        return view
    }


}
