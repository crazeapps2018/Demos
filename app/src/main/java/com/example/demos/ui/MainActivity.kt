package com.example.demos.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.example.demos.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var menuItemSelected: MenuItem? = null
    private var mMenuItemSelected = 0
    private val SELECTED_ITEM = "selected_item"

    private val TAG = "MainActivity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this);

        val topToolBar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(topToolBar)

        getSupportActionBar()!!.setDisplayShowTitleEnabled(false)

        if (ContextCompat.checkSelfPermission(this@MainActivity,
                Manifest.permission.ACCESS_FINE_LOCATION) !==
            PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            } else {
                ActivityCompat.requestPermissions(this@MainActivity,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)
            }
        }

        if (savedInstanceState == null) {

            openFragment(HomeFragment())

        }

        val uri = intent.data

        // checking if the uri is null or not.
        if (uri != null) {
            // if the uri is not null then we are getting the
            // path segments and storing it in list.
            val parameters = uri.pathSegments

            // after that we are extracting string from that parameters.
            val param = parameters[parameters.size - 1]

            Toast.makeText(this, param, Toast.LENGTH_SHORT).show()
        }


        if (savedInstanceState != null) {
            mMenuItemSelected = savedInstanceState.getInt(SELECTED_ITEM, 0)
            menuItemSelected = bottomNavigationView.menu.findItem(mMenuItemSelected)
        } else {
            menuItemSelected = bottomNavigationView.menu.getItem(0)
        }


        initUi()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED) {
                    if ((ContextCompat.checkSelfPermission(this@MainActivity,
                            Manifest.permission.ACCESS_FINE_LOCATION) ===
                                PackageManager.PERMISSION_GRANTED)) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }


    private fun initUi() {
        bottomNavigationView.setOnNavigationItemSelectedListener(BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_home -> {
                    openFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.ic_settings -> {
                    openFragment(SettingsFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.ic_profile -> {
                    openFragment(ProfileFragment())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.ic_calendar->{
                    openFragment(CalendarFragment())

                }
            }
            false
        })

    }


    private fun openFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SELECTED_ITEM, mMenuItemSelected)
        super.onSaveInstanceState(outState)
    }


    override fun onBackPressed() {

        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
            try {
                bottomNavigationView.menu.getItem(supportFragmentManager.backStackEntryCount - 2).isChecked =
                    true
            } catch (e: Exception) {
            }

        } else {
            AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id ->
                    super.onBackPressed()
                    finish()
                }
                .setNegativeButton("No", null).show()
        }

    }



}