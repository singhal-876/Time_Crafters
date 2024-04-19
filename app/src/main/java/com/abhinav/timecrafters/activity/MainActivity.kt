package com.abhinav.timecrafters.activity

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.abhinav.timecrafters.R
import com.abhinav.timecrafters.fragment.AboutUsFragment
import com.abhinav.timecrafters.fragment.DashboardFragment
import com.abhinav.timecrafters.fragment.HolidaysFragment
import com.abhinav.timecrafters.fragment.LeaveFragment
import com.abhinav.timecrafters.fragment.MessagesFragment
import com.abhinav.timecrafters.fragment.NotificationFragment
import com.abhinav.timecrafters.fragment.ProfileFragment
import com.google.android.material.navigation.NavigationView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var toolbar: Toolbar
    private lateinit var navigationLayout: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
        navigationLayout = findViewById(R.id.navigation)

        setUpToolbar()
        openDashboard()

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.open,
            R.string.close
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationLayout.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.dashboard -> {
                    Toast.makeText(this@MainActivity, "Dashboard", Toast.LENGTH_SHORT).show()
                    openDashboard()
                }
                R.id.messages -> {
                    Toast.makeText(this@MainActivity, "Messages", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, MessagesFragment())
                        .commit()
                }
                R.id.notifications -> {
                    Toast.makeText(this@MainActivity,"Notifications", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, NotificationFragment())
                        .commit()
                }
                R.id.holidays -> {
                    Toast.makeText(this@MainActivity,"Holidays", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, HolidaysFragment())
                        .commit()
                }
                R.id.leave -> {
                Toast.makeText(this@MainActivity,"Leave Management", Toast.LENGTH_SHORT).show()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, LeaveFragment())
                    .commit()
            }
                R.id.profile -> {
                    Toast.makeText(this@MainActivity, "Profile", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, ProfileFragment())
                        .commit()
                }
                R.id.about_us -> {
                    Toast.makeText(this@MainActivity, "About Us", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame, AboutUsFragment())
                        .commit()
                }
                R.id.logout -> {
                    sharedPreferences = getSharedPreferences(getString(R.string.Preferences_file_name), MODE_PRIVATE)
                    sharedPreferences.edit().putBoolean("isLoggedIn", false).apply()
                    sharedPreferences.edit().remove("title").apply()
                    Toast.makeText(this, "You have been logged out successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, LoginActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Time Crafters"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun openDashboard() {
        val fragment = DashboardFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
        supportActionBar?.title = "Dashboard"
        navigationLayout.setCheckedItem(R.id.dashboard)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
