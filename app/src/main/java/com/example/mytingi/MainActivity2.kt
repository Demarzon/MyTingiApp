package com.example.mytingi

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth


class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val user = FirebaseAuth.getInstance().currentUser



        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val navUser = navigationView.getHeaderView(0).findViewById<TextView>(R.id.navuser)
        val navEmail = navigationView.getHeaderView(0).findViewById<TextView>(R.id.navemail)
        val user1 = FirebaseAuth.getInstance().currentUser
        if (user1 != null) {
            var userEmail = user1.email
            navEmail.text = userEmail
            navUser.text = userEmail?.replace("@gmail.com", "")
        } else {
            // No user is signed in
        }
        navigationView.setNavigationItemSelectedListener(this)


        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, InventoryFragment()).commit()
            navigationView.setCheckedItem(R.id.inventory)
            supportActionBar!!.setTitle("Inventory")
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {


            if (item.itemId == R.id.inventory) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, InventoryFragment()).commit()
                supportActionBar!!.setTitle("Inventory")
            } else if (item.itemId == R.id.acc) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AccountFragment()).commit()
                supportActionBar!!.setTitle("Account")

            }else if (item.itemId == R.id.settings) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SettingsFragment()).commit()
                supportActionBar!!.setTitle("Settings")
            }else if (item.itemId == R.id.about) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AboutFragment()).commit()
                supportActionBar!!.setTitle("About")
            }else{
                val backm = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "Logout successful!", Toast.LENGTH_SHORT).show()
                startActivity(backm)
                finishAffinity()

            }


        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            val mBuilder = AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", null)
                .setNegativeButton("No", null)
                .show()

            // Function for the positive button
            // is programmed to exit the application
            val mPositiveButton = mBuilder.getButton(AlertDialog.BUTTON_POSITIVE)
            mPositiveButton.setOnClickListener {
                System.exit(0)
            }

        }
    }

}