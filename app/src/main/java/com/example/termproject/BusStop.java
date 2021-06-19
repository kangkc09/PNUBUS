package com.example.termproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.LocationTrackingMode;
import com.naver.maps.map.MapFragment;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.NaverMapOptions;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.UiSettings;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.LocationOverlay;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.util.FusedLocationSource;

public class BusStop extends AppCompatActivity implements OnMapReadyCallback {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1000;
    private FusedLocationSource locationSource;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationSource =
                new FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE);

        NaverMapOptions options = new NaverMapOptions()
                .locationButtonEnabled(true);
        FragmentManager fm = getSupportFragmentManager();
        MapFragment mapFragment = (MapFragment)fm.findFragmentById(R.id.map);
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance(options);
            fm.beginTransaction().add(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,  @NonNull int[] grantResults) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions, grantResults)) {
            return;
        }
        super.onRequestPermissionsResult(
                requestCode, permissions, grantResults);
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {
        naverMap.setLocationSource(locationSource);
        naverMap.setLocationTrackingMode(LocationTrackingMode.Follow);
        UiSettings uiSettings = naverMap.getUiSettings();
        uiSettings.setLocationButtonEnabled(true);

        LocationOverlay locationOverlay=naverMap.getLocationOverlay();

        InfoWindow infoWindow=new InfoWindow();
        //
        Marker markerStn=new Marker();  //부산대역
        Marker markerBB=new Marker();  //부산은행
        Marker markerFD1=new Marker();  //부산대정문 상
        Marker markerHQ1=new Marker();  //부산대본관 상
        Marker markerMH1=new Marker();  //문창회관 상
        Marker markerSL1=new Marker();  //새벽벌도서관 상
        Marker markerSO1=new Marker();  //사회관 상
        Marker markerLA1=new Marker();  //법학관 상
        Marker markerCH1=new Marker();  //화학관 상
        Marker markerAR1=new Marker();  //예술관 상
        Marker markerAT1=new Marker();  //미술관 상
        Marker markerMU1=new Marker();  //음악관 상
        Marker markerGA=new Marker();   //경암
        Marker markerGD=new Marker();   //금정등기소
        Marker markerBD=new Marker();   //부산대 후문
        Marker markerSB=new Marker();   //신한은행
        Marker markerFD2=new Marker();  //부산대 정문 하
        Marker markerHQ2=new Marker();  //부산대 본관 하
        Marker markerMH2=new Marker();  //문창회관 하
        Marker markerSL2=new Marker();  //새벽벌도서관 하
        Marker markerSO2=new Marker();  //사회관 하
        Marker markerLA2=new Marker();  //법학관 하
        Marker markerCH2=new Marker();  //화학관 하
        Marker markerSH=new Marker();   //생활환경
        Marker markerAR2=new Marker();  //예술관 하
        Marker markerAT2=new Marker();  //미술관 하
        Marker markerMU2=new Marker();  //음악관 하

        markerStn.setPosition(new LatLng(35.22876967, 129.0892784));
        markerStn.setMap(naverMap);
        markerBB.setPosition(new LatLng(35.23144217, 129.0857443));
        markerBB.setMap(naverMap);
        markerFD1.setPosition(new LatLng(35.23169851, 129.0845673));
        markerFD1.setMap(naverMap);
        markerHQ1.setPosition(new LatLng(35.2328365, 129.0835395));
        markerHQ1.setMap(naverMap);
        markerMH1.setPosition(new LatLng(35.23420688, 129.0822738));
        markerMH1.setMap(naverMap);
        markerSL1.setPosition(new LatLng(35.23514919, 129.0815564));
        markerSL1.setMap(naverMap);
        markerSO1.setPosition(new LatLng(35.23576513, 129.080085));
        markerSO1.setMap(naverMap);
        markerLA1.setPosition(new LatLng(35.23617376, 129.0786493));
        markerLA1.setMap(naverMap);
        markerCH1.setPosition(new LatLng(35.23451566, 129.0781237));
        markerCH1.setMap(naverMap);
        markerAR1.setPosition(new LatLng(35.23324909, 129.0778882));
        markerAR1.setMap(naverMap);
        markerAT1.setPosition(new LatLng(35.23274384, 129.0763487));
        markerAT1.setMap(naverMap);
        markerMU1.setPosition(new LatLng(35.23339087, 129.0764531));
        markerMU1.setMap(naverMap);
        markerGA.setPosition(new LatLng(35.23368565, 129.0755545));
        markerGA.setMap(naverMap);
        markerMU2.setPosition(new LatLng(35.23325868, 129.0762794));
        markerMU2.setMap(naverMap);
        markerAT2.setPosition(new LatLng(35.23260649, 129.0761631));
        markerAT2.setMap(naverMap);
        markerAR2.setPosition(new LatLng(35.23212966, 129.0773145));
        markerAR2.setMap(naverMap);
        markerSH.setPosition(new LatLng(35.23373314, 129.0780379));
        markerSH.setMap(naverMap);
        markerCH2.setPosition(new LatLng(35.23448619, 129.0782658));
        markerCH2.setMap(naverMap);
        markerLA2.setPosition(new LatLng(35.23626663, 129.0790294));
        markerLA2.setMap(naverMap);
        markerSO2.setPosition(new LatLng(35.2356276, 129.0800151));
        markerSO2.setMap(naverMap);
        markerSL2.setPosition(new LatLng(35.23501513, 129.0815106));
        markerSL2.setMap(naverMap);
        markerMH2.setPosition(new LatLng(35.23408922, 129.08223));
        markerMH2.setMap(naverMap);
        markerHQ2.setPosition(new LatLng(35.23296008, 129.0834273));
        markerHQ2.setMap(naverMap);
        markerFD2.setPosition(new LatLng(35.23137227, 129.0844965));
        markerFD2.setMap(naverMap);
        markerGD.setPosition(new LatLng(35.23058895, 129.0847999));
        markerGD.setMap(naverMap);
        markerBD.setPosition(new LatLng(35.22885132, 129.0845887));
        markerBD.setMap(naverMap);
        markerSB.setPosition(new LatLng(35.22847444, 129.0854765));
        markerSB.setMap(naverMap);
        //
        naverMap.setOnMapClickListener((coord,point)->{
            infoWindow.close();
        });

        Overlay.OnClickListener listener=overlay ->{
            Marker marker=(Marker)overlay;

            if(marker.getInfoWindow()==null){
                infoWindow.open(marker);
            }else{
                infoWindow.close();
            }
            return true;
        };
        //
        markerStn.setOnClickListener(listener);
        markerBB.setOnClickListener(listener);
        markerFD1.setOnClickListener(listener);
        markerHQ1.setOnClickListener(listener);
        markerMH1.setOnClickListener(listener);
        markerSL1.setOnClickListener(listener);
        markerSO1.setOnClickListener(listener);
        markerLA1.setOnClickListener(listener);
        markerCH1.setOnClickListener(listener);
        markerAR1.setOnClickListener(listener);
        markerAT1.setOnClickListener(listener);
        markerMU1.setOnClickListener(listener);
        markerGA.setOnClickListener(listener);
        markerSH.setOnClickListener(listener);
        markerCH2.setOnClickListener(listener);
        markerLA2.setOnClickListener(listener);
        markerSO2.setOnClickListener(listener);
        markerSL2.setOnClickListener(listener);
        markerMH2.setOnClickListener(listener);
        markerHQ2.setOnClickListener(listener);
        markerFD2.setOnClickListener(listener);
        markerGD.setOnClickListener(listener);
        markerBD.setOnClickListener(listener);
        markerSB.setOnClickListener(listener);

        markerStn.setTag("부산대역");
        markerStn.setOnClickListener(overlay->{
            infoWindow.open(markerStn);
            return true;
        });
        markerBB.setTag("부산은행");
        markerBB.setOnClickListener(overlay->{
            infoWindow.open(markerBB);
            return true;
        });
        markerFD1.setTag("부산대정문 상행");
        markerFD1.setOnClickListener(overlay->{
            infoWindow.open(markerFD1);
            return true;
        });
        markerHQ1.setTag("부산대본관 상행");
        markerHQ1.setOnClickListener(overlay->{
            infoWindow.open(markerHQ1);
            return true;
        });
        markerMH1.setTag("부산대문창회관 상행");
        markerMH1.setOnClickListener(overlay->{
            infoWindow.open(markerMH1);
            return true;
        });
        markerSL1.setTag("새벽벌도서관 상행");
        markerSL1.setOnClickListener(overlay->{
            infoWindow.open(markerSL1);
            return true;
        });
        markerSO1.setTag("부산대사회관 상행");
        markerSO1.setOnClickListener(overlay->{
            infoWindow.open(markerSO1);
            return true;
        });
        markerLA1.setTag("부산대법학관 상행");
        markerLA1.setOnClickListener(overlay->{
            infoWindow.open(markerLA1);
            return true;
        });
        markerCH1.setTag("부산대화학관 상행");
        markerCH1.setOnClickListener(overlay->{
            infoWindow.open(markerCH1);
            return true;
        });
        markerAR1.setTag("부산대예술관 상행");
        markerAR1.setOnClickListener(overlay->{
            infoWindow.open(markerAR1);
            return true;
        });
        markerAT1.setTag("부산대미술관 상행");
        markerAT1.setOnClickListener(overlay->{
            infoWindow.open(markerAT1);
            return true;
        });
        markerMU1.setTag("학생회관 상행");
        markerMU1.setOnClickListener(overlay->{
            infoWindow.open(markerMU1);
            return true;
        });
        markerGA.setTag("부산대경암체육관");
        markerGA.setOnClickListener(overlay->{
            infoWindow.open(markerGA);
            return true;
        });
        markerMU2.setTag("부산대음악관 하행");
        markerMU2.setOnClickListener(overlay->{
            infoWindow.open(markerMU2);
            return true;
        });
        markerAT2.setTag("부산대미술관 하행");
        markerAT2.setOnClickListener(overlay->{
            infoWindow.open(markerAT2);
            return true;
        });
        markerAR2.setTag("부산대예술관 하행");
        markerAR2.setOnClickListener(overlay->{
            infoWindow.open(markerAR2);
            return true;
        });
        markerSH.setTag("부산대생활환경관");
        markerSH.setOnClickListener(overlay->{
            infoWindow.open(markerSH);
            return true;
        });
        markerCH2.setTag("부산대화학관 하행");
        markerCH2.setOnClickListener(overlay->{
            infoWindow.open(markerCH2);
            return true;
        });
        markerLA2.setTag("부산대법학관 하행");
        markerLA2.setOnClickListener(overlay->{
            infoWindow.open(markerLA2);
            return true;
        });
        markerSO2.setTag("부산대사회관 하행");
        markerSO2.setOnClickListener(overlay->{
            infoWindow.open(markerSO2);
            return true;
        });
        markerSL2.setTag("새벽벌도서관 하행");
        markerSL2.setOnClickListener(overlay->{
            infoWindow.open(markerSL2);
            return true;
        });
        markerMH2.setTag("부산대문창회관 하행");
        markerMH2.setOnClickListener(overlay->{
            infoWindow.open(markerMH2);
            return true;
        });
        markerHQ2.setTag("부산대본관 하행");
        markerHQ2.setOnClickListener(overlay->{
            infoWindow.open(markerHQ2);
            return true;
        });
        markerFD2.setTag("부산대정문 하행");
        markerFD2.setOnClickListener(overlay->{
            infoWindow.open(markerFD2);
            return true;
        });
        markerGD.setTag("금정등기소");
        markerGD.setOnClickListener(overlay->{
            infoWindow.open(markerGD);
            return true;
        });
        markerBD.setTag("부산대후문");
        markerBD.setOnClickListener(overlay->{
            infoWindow.open(markerBD);
            return true;
        });
        markerSB.setTag("신한은행");
        markerSB.setOnClickListener(overlay->{
            infoWindow.open(markerSB);
            return true;
        });

        //
        infoWindow.setAdapter(new InfoWindow.DefaultTextAdapter(this) {
            @NonNull
            @Override
            public CharSequence getText(@NonNull InfoWindow infoWindow) {
                return (CharSequence)infoWindow.getMarker().getTag();
            }
        });
    }

}