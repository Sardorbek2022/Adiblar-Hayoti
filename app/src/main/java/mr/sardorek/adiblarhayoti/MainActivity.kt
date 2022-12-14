 package mr.sardorek.adiblarhayoti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import mr.sardorek.adiblarhayoti.databinding.ActivityMainBinding


 class MainActivity : AppCompatActivity() {

     private lateinit var binding: ActivityMainBinding

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)

         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)

         supportActionBar?.hide()
         val navController = findNavController(R.id.nav_host_fragment_activity_main)
         val appBarConfiguration = AppBarConfiguration(
             setOf(
                 R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
             )
         )
         setupActionBarWithNavController(navController, appBarConfiguration)
         val popupMenu = PopupMenu(this, null)
         popupMenu.inflate(R.menu.bottom_nav_menu)
         val menu = popupMenu.menu
         binding.bottomBar.setupWithNavController(menu, navController)
     }
 }