package com.example.heyfriend.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.heyfriend.R
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.GoogleMap
import com.google.android.libraries.maps.OnMapReadyCallback
import com.google.android.libraries.maps.SupportMapFragment
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MarkerOptions

class MapFragment : Fragment(), OnMapReadyCallback {
    lateinit var map : GoogleMap
    lateinit var mapFragment:  SupportMapFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mapFragment = getActivity()?.supportFragmentManager?.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        var position = LatLng(21.016890, 105.781691)
        map.addMarker(MarkerOptions().position(position).title("Handico Tower"))
        map.moveCamera(CameraUpdateFactory.newLatLng(position))
    }

}