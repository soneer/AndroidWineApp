package ss.androidwineappmock;

import android.app.ActionBar;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private   ArrayAdapter<String> adapter;
   private HashMap<String, String[]> wineryInformationMap = new HashMap<String, String[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        setUpHashMap();
        ActionBar bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.maincolorlight)));
       bar.setTitle(Html.fromHtml("</br><h1>WINE TRAIL</h1>"));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.3328700, -121.9027090), 12.0f));


        Button tripButton = (Button) findViewById(R.id.tripButton);
        tripButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(MapsActivity.this);
                dialog.setContentView(R.layout.wineries);
                dialog.show();
            }
        });

        Button wineriesButton = (Button) findViewById(R.id.wineriesButton);
        wineriesButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(MapsActivity.this);
                dialog.setContentView(R.layout.wineries);
                dialog.show();
            }
        });

        Button aboutUsButton = (Button) findViewById(R.id.aboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final Dialog dialog = new Dialog(MapsActivity.this);
                dialog.setContentView(R.layout.aboutus);
                dialog.setTitle("Trip");
                dialog.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * We are setting up the markers here and adding the listener to each individual marker
     */
    private void setUpMap() {


        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.05271, -121.65123)).title("Aver Family Vineyards"));                  //Aver Family Vineyards
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(36.98858, -121.38257)).title("Casa de Fruta Winery"));                  //Casa de Fruta Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.15380, -121.62272)).title("Castillo's Hillside Shire Winery"));       //Castillo's Hillside Shire Winery

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.07294, -121.64331)).title("Clos LaChance Winery"));                 //Clos LaChance Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.27458, -122.05989)).title("Cooper-Garrod Estate Vineyards"));//Cooper-Garrod Estate Vineyards
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.08568, -121.56960)).title("Creekview Vineyards"));//Creekview Vineyards
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.01342, -121.65349)).title("Fortino Winery"));// Fortino Winery

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.14572, -121.63432)).title("Guglielmo Winery"));//Guglielmo Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.01375, -121.65526)).title("Hecker Pass Winery"));//Hecker Pass Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.33379, -121.91264)).title("J. Lohr Vineyards & Wines"));//J. Lohr Vineyards & Wines
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.04538, -121.65573)).title("Jason-Stephens Winery"));//Jason-Stephens Winery

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.04673, -121.65269)).title("Kirigin Cellars"));// Kirigin Cellars
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.08118, -121.62223)).title("Lion Ranch Vineyards and Winery"));//Lion Ranch Vineyards and Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.08684, -121.61669)).title("Lightheart Cellars"));//Lightheart Cellars
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.04023, -121.71114)).title("Martin Ranch Winery"));//Martin Ranch Winery

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(38.42229, -122.90350)).title("Miramar Vineyards"));//Miramar Vineyards
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.13178, -121.62065)).title("Morgan Hill Cellars"));//Morgan Hill Cellars
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(36.96445, -121.55126)).title("Rapazzini Winery"));//Rapazzini Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.11871, -121.69241)).title("Ross Vineyards and Winery"));//Ross Vineyards and Winery

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.01355, -121.64674)).title("Sarah’s Vineyard"));//Sarah’s Vineyard
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.05102, -121.54965)).title("Sa-ri Cellars"));//Sa-ri Cellars
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.05946, -121.61464)).title("Seeker Vineyard"));//Rapazzini Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.01264, -121.64205)).title("Solis Winery"));//Solis Winery

        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.03973, -121.62013)).title("Stefania Wine"));//Stefania Wine
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.02429, -121.50199)).title("Sunlit Oaks Winery"));//Sunlit Oaks Winery
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.wineicon)).position(new LatLng(37.05939, -121.66530)).title("Sycamore Creek Vineyards & Winery"));//Sycamore Creek Vineyards & Winery


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {

            @Override
            public boolean onMarkerClick(Marker arg0) {
                    final Dialog dialog = new Dialog(MapsActivity.this);
                    dialog.setContentView(R.layout.custom);
                    dialog.setTitle(arg0.getTitle());

                        TextView infoBoxHours = (TextView) dialog.findViewById(R.id.informationBoxHours);
                TextView infoBoxAddress = (TextView) dialog.findViewById(R.id.informationBoxAddress);
                TextView infoBoxPhone = (TextView) dialog.findViewById(R.id.informationBoxPhone);
                TextView infoBoxWebsite = (TextView) dialog.findViewById(R.id.informationBoxWebsite);

                infoBoxHours.setText( wineryInformationMap.get(arg0.getTitle())[0]);
                infoBoxAddress.setText( wineryInformationMap.get(arg0.getTitle())[1]);
                infoBoxPhone.setText( wineryInformationMap.get(arg0.getTitle())[2]);
                infoBoxWebsite.setText(Html.fromHtml("<a href="+wineryInformationMap.get(arg0.getTitle())[3]+">"+wineryInformationMap.get(arg0.getTitle())[3]+"</a> "));
                infoBoxWebsite.setMovementMethod(LinkMovementMethod.getInstance());
                    // set the custom dialog components - text, image and button
                    Button text = (Button) dialog.findViewById(R.id.text);
                    text.setText("Add to Trip");
                    Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                    // if button is clicked, close the custom dialog
                    dialogButton .setText("More Info");
                    dialogButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    dialog.show();

                return true;
            }

        });

    }




    /**
     * Adding winery information to the wineries
     */
    public void setUpHashMap()
    {

      //  wineryInformationMap.put("Aver Family Vineyards", new String[]{"Open the first and third weekend every month 12 p.m - 5 p.m. and by appointment", "2900 Soma Way, Gilroy, CA 95020","(408) 203-8575", "www.averfamilyvineyards.com"});
        wineryInformationMap.put("Aver Family Vineyards", new String[]{"Open the first and third weekend every month noon - 5 p.m. and by appointment","2900 Soma Way, Gilroy, CA 95020","(408) 203-8575","www.averfamilyvineyards.com"});
        wineryInformationMap.put("Casa de Fruta Winery", new String[]{"Open Daily from 9 a.m. - 6 p.m.","10021 Pacheco Pass Hwy., Hollister, CA 95023","(408) 842-7282","www.casadefruta.com"});
        wineryInformationMap.put("Castillo's Hillside Shire Winery", new String[]{"Open Saturday 12 p.m. - 7 p.m., Sunday 12 p.m. - 5 p.m. - Holiday weekends call in advance","2215 Liberata Dr., Morgan Hill, CA 95037","(408) 776-8200","www.castilloshillsideshirewinery.com"});
        wineryInformationMap.put("Clos LaChance Winery", new String[]{"Open 11 a.m. - 4 p.m. daily;","1 Hummingbird Lane, San Martin, CA 95046","(408) 686-1050","www.clos.com"});
        wineryInformationMap.put("Cooper-Garrod Estate Vineyards", new String[]{"Open Mon. - Fri. 12 p.m - 5 p.m., Sat. - Sun. 11 a.m. - 5 p.m.","22645 Garrod Rd., Saratoga, CA 95070","(408) 867-7116","www.cgv.com"});
        wineryInformationMap.put("Creekview Vineyards", new String[]{"Open third weekend every month 11 a.m. - 5 p.m. and by appointment","12467 Creekview Ct., San Martin, CA 95046","(408) 288-9463","www.creekviewvineyards.com"});
        wineryInformationMap.put("Fortino Winery", new String[]{"Open Tues. - Sat. 10 a.m - 5 p.m., Sun. 11 a.m. - 5 p.m.","4525 Hecker Pass Hwy., Gilroy, CA 95020","(408) 842-3305","www.fortinowinery.com"});
        wineryInformationMap.put("Guglielmo Winery", new String[]{"Open Daily, 10 a.m. - 5 p.m. Tours by Appointment","1480 East Main Avenue, Morgan Hill, CA 95037","(408) 779-2145","www.guglielmowinery.com"});
        wineryInformationMap.put("Hecker Pass Winery", new String[]{"Open Daily 10 a.m. - 5 p.m.","4605 Hecker Pass Hwy., Gilroy, CA 95020","(408) 842-8755","www.heckerpasswinery.com"});
        wineryInformationMap.put("J. Lohr Vineyards & Wines", new String[]{"Open Daily 10 a.m. - 5 p.m. - Closed New Years Day, Easter, Thanksgiving and Christmas Day","1000 Lenzen Ave., San Jose, CA 95126","(408) 918-2160","www.jlohr.com"});
        wineryInformationMap.put("Jason-Stephens Winery", new String[]{"Open Daily - 12 p.m. - 5 p.m.","11775 Watsonville Road, Gilroy, CA 95020","(408) 846-VINE","www.jstephens.com"});
        wineryInformationMap.put("Kirigin Cellars", new String[]{"Open Daily 10 a.m. - 5 p.m.","11550 Watsonville Rd., Gilroy, CA 95020","(408) 847-8827","www.kirigincellars.com"});
        wineryInformationMap.put("Lightheart Cellars", new String[]{"Open Weekends 12p.m-5p.m","305 Roosevelt Ave., San Martin, CA 95046","(408) 475-8463","www.lightheartcellars.com"});
        wineryInformationMap.put("Lion Ranch Vineyards and Winery", new String[]{"Open the third weekend of every month: Friday 4 p.m. - 7 p.m. , Saturday & Sunday from 12 p.m. - 5 p.m., or by appointment","645 West San Martin Ave., San Martin, CA 95046","(408)713-8501","www.lionranch.com"});
        wineryInformationMap.put("Martin Ranch Winery", new String[]{"Open the 1st and 3rd weekend of every month 12pm-4pm. Our hours will change - 12pm-5pm after March 21th thru Nov. 1st.","6675 Redwood Retreat Road, Gilroy, CA 95020","(408) 842-9197","www.martinranchwinery.com"});
        wineryInformationMap.put("Miramar Vineyards", new String[]{"Open every Saturday and Sunday, 12p.m - 5p.m","12255 New Ave., San Martin, CA 95046","(408) 686-0280",""});
        wineryInformationMap.put("Morgan Hill Cellars", new String[]{"Open Tues. - Sun. 10 a.m. - 5 p.m.","1645 San Pedro Ave., Morgan Hill, CA 95037","(408) 779-7389","www.MorganHillCellars.com"});
        wineryInformationMap.put("Rapazzini Winery", new String[]{"Open Daily 9 a.m. - 5 p.m., Summer Hours 9 a.m. - 6 p.m.","4350 Monterey Rd., (Hwy. 101 & 25, Hollister Exit), Gilroy, CA 95020","(408) 842-5649","www.rapazziniwinery.com"});
        wineryInformationMap.put("Ross Vineyards and Winery", new String[]{"Open third weekend every month 12 p.m. - 5 p.m. beginning in April 2013","17520 Oak Glen Ave., Morgan Hill, CA 95037","(408) 779-4599","rossvineyards@aol.com"});
        wineryInformationMap.put("Sarah’s Vineyard", new String[]{"Open Daily 12 p.m. - 5 p.m.","4005 Hecker Pass Hwy., Gilroy, CA 95020","(408) 847-1947","www.sarahsvineyard.com"});
        wineryInformationMap.put("Sa-ri Cellars", new String[]{"Open for tasting, sales and vineyard tours every weekend from noon - 5 p.m., or by appointment for private tastings.","2100 Buena Vista Ave., Gilroy, CA 95020","(408) 848-5823","www.satoricellars.com"});
        wineryInformationMap.put("Seeker Vineyard", new String[]{"12pm - 5pm on the first and third Saturday of the month and by appointment.","11755 Turlock Ave, San Martin, CA 95046","(408) 683-4993","www.seekervineyard.com"});
        wineryInformationMap.put("Solis Winery", new String[]{"Open Daily 12 p.m. - 5 p.m.","3920 Hecker Pass Hwy., Gilroy, CA 95020","(408) 847-6306","www.soliswinery.com"});
        wineryInformationMap.put("Stefania Wine", new String[]{"Third weekend of each Month Saturday 11 a.m, - 4 p.m, Sunday 12-4 and by appointment","1800 Day Road, Gilroy, CA 95020","(408) 242-8598","www.stefaniawine.com"});
        wineryInformationMap.put("Sunlit Oaks Winery", new String[]{"Tastings 1st & 3rd Full Weekends of Every Month - 12pm - 5pm starting March 2013 Passport Weekend and by appointment","7602 Sunlit Oaks Ct., Gilroy, CA 95020","(408) 930-5815",""});
        wineryInformationMap.put("Sycamore Creek Vineyards & Winery", new String[]{"Open every Friday, Saturday and Sunday, 11 a.m. - 5 p.m.","12775 Uvas Rd., Morgan Hill, CA 95037","(408) 779-4738","www.sycamorecreekvineyards.com"});

    }
}
