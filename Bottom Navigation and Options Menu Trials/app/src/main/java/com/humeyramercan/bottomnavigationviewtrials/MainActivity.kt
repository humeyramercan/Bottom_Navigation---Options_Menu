package com.humeyramercan.bottomnavigationviewtrials

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var navController:NavController
    private lateinit var bottomNavigationItemView:BottomNavigationView
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment= supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController=navHostFragment.navController
        appBarConfiguration= AppBarConfiguration(
            setOf(R.id.settings,R.id.favorites,R.id.notifications,R.id.chat,R.id.addPost)
        )

        //TOOLBAR
        setSupportActionBar(findViewById(R.id.toolbar))
        setupActionBarWithNavController(navController,appBarConfiguration)

        //BOTTOM NAVIGATION VIEW
        bottomNavigationItemView=findViewById(R.id.bottomNavigationView)
        bottomNavigationItemView.setupWithNavController(navController)

    }
    //UP BUTTON
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    //OPTIONS MENU
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflater=menuInflater
        menuInflater.inflate(R.menu.action_bar_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}





