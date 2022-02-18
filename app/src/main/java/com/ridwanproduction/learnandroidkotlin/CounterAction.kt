package com.ridwanproduction.learnandroidkotlin
import com.workday.redux.Action

sealed class CounterAction : Action {
    object IncrementAction : CounterAction()
    object DecrementAction : CounterAction()
}