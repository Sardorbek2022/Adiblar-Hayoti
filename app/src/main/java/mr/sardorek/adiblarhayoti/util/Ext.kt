package mr.sardorek.adiblarhayoti.util

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.toast(text: String) {
    Toast.makeText(this.requireContext(), text, Toast.LENGTH_SHORT).show()
}