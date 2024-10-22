import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidautomatedtesting.AboutActivity
import com.example.androidautomatedtesting.R

class Counter {
    private var counter: Int = 0

    fun increment(): Int {
        counter++
        return counter
    }

    fun decrement(): Int {
        counter--
        return counter
    }

    fun getCounter(): Int {
        return counter
    }
}

class CounterActivity : AppCompatActivity() {

    private lateinit var counter: Counter

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_counter)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        counter = Counter()
        val counterTextView = findViewById<TextView>(R.id.counterTextView)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val decrementButton = findViewById<Button>(R.id.decrementButton)
        val aboutButton = findViewById<Button>(R.id.btnAbout)

        incrementButton.setOnClickListener {
            counterTextView.text = counter.increment().toString()
        }

        decrementButton.setOnClickListener {
            counterTextView.text = counter.decrement().toString()
        }

        aboutButton.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }
    }
}
