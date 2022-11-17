package mr.sardorek.adiblarhayoti.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import mr.sardorek.adiblarhayoti.ui.JahonFragment
import mr.sardorek.adiblarhayoti.ui.MumtozFragment
import mr.sardorek.adiblarhayoti.ui.UzbFragment


class TabLayoutAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MumtozFragment()
            1 -> UzbFragment()
            2 -> JahonFragment()
            else -> Fragment()
        }
    }
}