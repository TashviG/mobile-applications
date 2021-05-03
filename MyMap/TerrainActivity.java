package au.edu.canberra.mymap;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

public class TerrainActivity extends AppCompatActivity implements OnMapReadyCallback {

    WebView wv;
    String url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOverflowIcon(getDrawable(R.drawable.uclogo));
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    @Override
    public void onMapReady(final GoogleMap map) {
        LatLng uc = new LatLng(-35.2381916,149.0834995);
        LatLng gym= new LatLng(-35.2383986,149.0859231);
        LatLng coffee= new LatLng(-35.2390426,149.080111);
        LatLng Library= new LatLng(-35.2379585,149.0831518);
        LatLng hub= new LatLng(-35.238713, 149.084173);
        LatLng NATSEM = new LatLng(-35.2381605,149.0753321);
        LatLng parking = new LatLng(-35.241209, 149.082637);
        LatLng Gin= new LatLng(-35.234086, 149.088182);
        LatLng UniD = new LatLng(-35.238412, 149.090220);
        LatLng uni = new LatLng(-35.2381609,149.0818982);

        map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

        final Marker GinMarker = map.addMarker(new MarkerOptions()
                //.title("Main parking area")
                //.snippet("Several hundreds parks available")
                .position(Gin)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pegman))
                .draggable(true));



        final Marker UniDMarker = map.addMarker(new MarkerOptions()
                //.title("Main parking area")
                //.snippet("Several hundreds parks available")
                .position(UniD)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.pegman))
                .draggable(true));

        final Marker ucMarker = map.addMarker(new MarkerOptions()
                .title("UC student centre")
                .snippet("Your gateway access to support and advice")
                .position(uc)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.askuc))
                .draggable(true));


        final Marker gymMarker =map.addMarker(new MarkerOptions()
                .title("UC Gym")
                .snippet("Open to students, staff and the general public")
                .position(gym)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.gym))
                .draggable(true));

       final Marker coffeeMarker= map.addMarker(new MarkerOptions()
                .title("coffee grounds")
                .snippet("The best coffee on campus underneath cooper lodge")
                .position(coffee)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.coffee))
                .draggable(true));

        final Marker LibraryMarker= map.addMarker(new MarkerOptions()
                .title("UC Library")
                .snippet("24 Hr access to all student and staff")
                .position(Library)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.library))
                .draggable(true));

        final Marker HubMarker= map.addMarker(new MarkerOptions()
                .title("The hub")
                .snippet("Below concourse level between building 1 and building 8")
                .position(hub)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.hub))
                .draggable(true));

        final Marker NATSEMMarker= map.addMarker(new MarkerOptions()
                .title("NATSEM CENTRE")
                .snippet("The National centre for social and economic modelling")
                .position(NATSEM)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.natsem))
                .draggable(true));

        final Marker ParkingMarker=map.addMarker(new MarkerOptions()
                .title("Main parking area")
                .snippet("Several hundreds parks available")
                .position(parking)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.parking))
                .draggable(true));


        map.moveCamera(CameraUpdateFactory.newLatLngZoom(uni, 15));

        map.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {


            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View infoWindow = getLayoutInflater().inflate(R.layout.infowindow_with_image, null);
                TextView title = (TextView) infoWindow.findViewById(R.id.textViewTitle);
                TextView snippet = (TextView) infoWindow.findViewById(R.id.textViewSnippet);
                ImageView image = (ImageView) infoWindow.findViewById(R.id.imageView);

                if (marker.getId().equals(GinMarker.getId())) {
                    // title.setText(marker.getTitle());
                    // snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.pegman, getTheme()));
                    //url = "http://www.natsem.canberra.edu.au/";
                    map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            goToGinStreet();
                            return false;
                        }
                    });
                  return null;
                }


                if (marker.getId().equals(ucMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.uc, getTheme()));

                    url= "http://www.canberra.edu.au/current-students/canberra-students/student-centre";
                    map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            goToWebsite();
                        }
                        // map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        //{



                    });


                }

                if (marker.getId().equals(gymMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.gyms, getTheme()));
                     url ="http://www.ucunion.com.au/group-fitness-registration/";

                    map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            goToGWebsite();
                        }
                        // map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        //{



                    });


                }

                if (marker.getId().equals(coffeeMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.coffees, getTheme()));

                    map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            goToCWebsite();
                        }
                        // map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        //{



                    });
                }

                if (marker.getId().equals(LibraryMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.librarys, getTheme()));

                    url="http://www.canberra.edu.au/library";

                    map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            goToLWebsite();
                        }
                        // map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        //{



                    });
                }

                if (marker.getId().equals(HubMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.hubs, getTheme()));
                    url= "http://www.canberra.edu.au/maps/buildings-directory/the-hub";

                    map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            goToHWebsite();
                        }
                        // map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        //{



                    });
                }
                if (marker.getId().equals(NATSEMMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.natsems, getTheme()));
                    url= "http://www.natsem.canberra.edu.au/";

                    map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            goToNWebsite();
                        }
                        // map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        //{



                    });
                }

                if (marker.getId().equals(ParkingMarker.getId())) {
                    title.setText(marker.getTitle());
                    snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.parkings, getTheme()));

                     url= "http://www.canberra.edu.au/on-campus/parking";
                    map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            goToPWebsite();
                        }
                        // map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                        //{



                    });

                }
                if (marker.getId().equals(UniDMarker.getId())) {
                    //title.setText(marker.getTitle());
                    //snippet.setText(marker.getSnippet());
                    image.setImageDrawable(getResources()
                            .getDrawable(R.drawable.pegman, getTheme()));

                    map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            goToUniDStreet();

                            return false;
                        }

                    });
                    return null;

                }
                return infoWindow;

            }

        });


       /* map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                goToWebsite();
            }
        });

        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                goToGWebsite();
            }
        });*/

       // public void goToWebsite(){

            //Intent intent = new Intent(this, MyWebPage.class);
       // intent.putExtra("url",url);
       // startActivity(intent);
    //}

        Polygon p = map.addPolygon(new PolygonOptions().geodesic(true)

                .add(new LatLng(-35.242049, 149.090288))
                .add(new LatLng(-35.242487, 149.088142))
                .add(new LatLng(-35.242505, 149.078057))
                .add(new LatLng(-35.240998, 149.074817))
                .add(new LatLng(-35.2381605,149.0753321))
                .add(new LatLng(-35.238036, 149.077091))
                .add(new LatLng(-35.235687, 149.077713))
                .add(new LatLng(-35.234075, 149.078507))
                .add(new LatLng(-35.232673, 149.079623))
                .add(new LatLng(-35.231095, 149.080460))
                .add(new LatLng(-35.231428, 149.082177))
                .add(new LatLng(-35.231726, 149.083335))
                .add(new LatLng(-35.233689, 149.087198))
                .add(new LatLng(-35.234233, 149.088593))
                .add(new LatLng(-35.235466, 149.089816))
                .add(new LatLng(-35.234881, 149.091940))
                .add(new LatLng(-35.240261, 149.090180))
                .add(new LatLng(-35.242049, 149.090288))

        );

        p.setFillColor(android.support.design.R.color.abc_color_highlight_material);

        p.setClickable(true);

        map.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener(){

                                          @Override
                                          public void onPolygonClick(Polygon polygon){
                                              polygon.setStrokeColor(Color.BLUE);
                                              polygon.setFillColor(R.color.colorPrimary);
                                              final int lengthShort = Toast.LENGTH_SHORT;
            }
        }
        );
    }

    public void goToWebsite(){

    Intent intent = new Intent(this, WebActivity.class);
     //intent.putExtra("url",url);
     startActivity(intent);
    }

    public void goToGWebsite(){

        Intent intent = new Intent(this, GymWebActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }

    public void goToCWebsite(){

        Intent intent = new Intent(this, CWebActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }

    public void goToLWebsite(){

        Intent intent = new Intent(this, LWebActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }

    public void goToHWebsite(){

        Intent intent = new Intent(this, HWebActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }

    public void goToNWebsite(){

        Intent intent = new Intent(this, NWebActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }

    public void goToPWebsite(){

        Intent intent = new Intent(this, PWebActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }

    public void goToUniDStreet(){

        Intent intent = new Intent(this, UniDStreetActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }

    public void goToGinStreet(){

        Intent intent = new Intent(this, GinStreetActivity.class);
        //intent.putExtra("url",url);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_SatelliteActivity) {
            Intent intent = new Intent(this, SatelliteActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_TerrainActivity) {
            Intent intent = new Intent(this, TerrainActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_HybridActivity) {
            Intent intent = new Intent(this, HybridActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_NoneActivity) {
            Intent intent = new Intent(this, NoneActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_MainActivity) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


}
