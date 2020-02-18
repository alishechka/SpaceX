package com.example.spacex

import SpaceBaseListModel

interface ContractView {

        fun showRepo(model: List<SpaceBaseListModel>)
        fun showError(t: Throwable)


}