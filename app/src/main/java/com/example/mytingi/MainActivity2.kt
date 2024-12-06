package com.example.mytingi

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity2 : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
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

            }


        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}