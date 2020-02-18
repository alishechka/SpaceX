package com.example.spacex

import SpaceBaseListModel
import android.os.Bundle
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.spacex.adapter.XAdapter
import com.example.spacex.presenter.SpacePresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ContractView {
    private lateinit var presenter: SpacePresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = SpacePresenter(this)
        presenter.getRepo()

        rg_radio.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                presenter.getRepo(checkedId == R.id.rb_active)

//                when (checkedId) {
//                    R.id.rb_active -> presenter.getRepo(true)
//                    R.id.rb_all -> presenter.getRepo()
//
//                }
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


}
