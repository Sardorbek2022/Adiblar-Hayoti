package mr.sardorek.adiblarhayoti.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import mr.sardorek.adiblarhayoti.R
import mr.sardorek.adiblarhayoti.adapter.AdibTogoAdapter
import mr.sardorek.adiblarhayoti.databinding.FragmentMumtozBinding
import mr.sardorek.adiblarhayoti.model.AdibTogo
import mr.sardorek.adiblarhayoti.util.toast

class MumtozFragment : Fragment() {
    private var _binding: FragmentMumtozBinding? = null
    private val binding get() = _binding!!
    private val adibTogoAdapter by lazy { AdibTogoAdapter() }
    private val firebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMumtozBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = adibTogoAdapter
        }

        uploadAllData()

        adibTogoAdapter.onClick = {
            val bundle = bundleOf("adib" to it)
            findNavController().navigate(R.id.action_navigation_home_to_detailFragment, bundle)
        }
    }

    private fun uploadAllData() {
        firebaseFirestore.collection("Mumtoz")
            .addSnapshotListener { success, error ->
                if (success != null) {
                    binding.progressBar.isVisible = false
                    val adibList = success.toObjects(AdibTogo::class.java)
                    adibTogoAdapter.submitList(adibList)
                } else {
                    toast(error?.message.toString())
                    binding.progressBar.isVisible = false
                }
            }
    }

}