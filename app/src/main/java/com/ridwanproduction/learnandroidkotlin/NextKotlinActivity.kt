package com.ridwanproduction.learnandroidkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.workday.redux.SingleThreadedStore
import com.workday.redux.Unsubscribe

class NextKotlinActivity : AppCompatActivity() {
    private lateinit var storeUnsubscriber: Unsubscribe
    private lateinit var store: SingleThreadedStore<MainState, CounterAction>

    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private lateinit var counter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next_kotlin)

        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)
        counter = findViewById(R.id.counter)

        store = SingleThreadedStore(
            state = MainState(count = 0),
            reducer = MainReducer(),
            middleware = listOf(LoggingMiddleware())
        )
    }

    override fun onResume() {
        super.onResume()

        storeUnsubscriber = store.subscribe { currentState, dispatch ->
            counter.text = "Count: ${currentState.count}"
            incrementButton.setOnClickListener {
                dispatch(CounterAction.IncrementAction)
            }
            decrementButton.setOnClickListener {
                dispatch(CounterAction.DecrementAction)
            }
        }
    }

    override fun onPause() {
        storeUnsubscriber.invoke()
        super.onPause()
    }
}