package com.example.spacex

import SpaceBaseListModel
import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex.adapter.XAdapter
import com.example.spacex.presenter.RocketRepositoryImpl
import com.example.spacex.presenter.SpacePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractView {
    private lateinit var presenter: SpacePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = SpacePresenter(this, RocketRepositoryImpl())
        presenter.getRepo()

        rg_radio.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                presenter.getRepo(checkedId == R.id.rb_active)
            }
        })

    }

    override fun showRepo(model: List<SpaceBaseListModel>) {
        rv_display.adapter = XAdapter(model)
        rv_display.layoutManager = LinearLayoutManager(this)
    }

    override fun showError(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pb_loading.visibility = View.VISIBLE

    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE

    }


}
