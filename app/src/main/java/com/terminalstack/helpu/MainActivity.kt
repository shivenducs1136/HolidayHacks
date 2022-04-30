package com.terminalstack.helpu

import android.content.ContentValues.TAG
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.terminalstack.helpu.databinding.ActivityMainBinding
import com.terminalstack.helpu.fragments.MinistryOfDisabledWebViewFragment

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var mAuth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.visibility = View.GONE
        var fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.visibility = View.GONE
        setSupportActionBar(toolbar)


        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.navHostFragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_logout, R.id.nav_share_app, R.id.nav_push_notif
            ), drawerLayout
        )

//        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_logout->{
                    FirebaseAuth.getInstance().signOut();
                    var intent=Intent(this@MainActivity,FirstActivity::class.java)
                    startActivity(intent)
                    finish()
                    true
                }
                R.id.nav_push_notif->{
                    val url = "https://anvansh.pythonanywhere.com/"
                    val i = Intent(Intent.ACTION_VIEW)
                    i.data = Uri.parse(url)
                    startActivity(i)
                    true
                }
                R.id.nav_share_app->{
                    Toast.makeText(this,"Share App",Toast.LENGTH_SHORT).show()
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_SUBJECT, "HelpU")
                    intent.putExtra(Intent.EXTRA_TEXT, "Empowering the Ones Who NEVER GIVE UP!!")
                    startActivity(Intent.createChooser(intent, "choose one"))
                    true

                }
                R.id.ministry->{
                    val fragManager: FragmentManager = (this as AppCompatActivity).supportFragmentManager
                    fragManager.beginTransaction()
                        .replace(R.id.navHostFragment, MinistryOfDisabledWebViewFragment(), TAG).commit()
                    true

                }
                else -> {
                    true
                }
            }
        })
        mAuth=FirebaseAuth.getInstance()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)

        return true
    }
    public fun openNavDrawer(){
        val drawerLayout: DrawerLayout = binding.drawerLayout
        drawerLayout.open()
    }
    public fun closeNavDrawer(){
        val drawerLayout: DrawerLayout = binding.drawerLayout
        drawerLayout.closeDrawers()
    }
}


