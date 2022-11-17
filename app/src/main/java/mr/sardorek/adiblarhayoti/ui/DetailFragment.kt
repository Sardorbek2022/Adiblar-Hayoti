package mr.sardorek.adiblarhayoti.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mr.sardorek.adiblarhayoti.R
import mr.sardorek.adiblarhayoti.model.AdibTogo

class DetailFragment : Fragment() {
    private var adib: AdibTogo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adib = arguments?.getSerializable("adib") as? AdibTogo
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("@@@Adib", "onViewCreated: ${adib.toString()}")
    }
}