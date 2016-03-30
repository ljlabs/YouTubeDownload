package dl.youtube.ljlabs.kyle.videos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ljlabs.kyle.youtubedownload.R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(ljlabs.kyle.youtubedownload.R.id.toolbar);
        setSupportActionBar(toolbar);


        web = (WebView) findViewById(ljlabs.kyle.youtubedownload.R.id.webView);
        web.setWebViewClient(new WebViewClient());

        WebSettings webSettings = web.getSettings();
        webSettings.setJavaScriptEnabled(true);

        web.loadUrl("http://www.google.com");


        DrawerLayout drawer = (DrawerLayout) findViewById(ljlabs.kyle.youtubedownload.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, ljlabs.kyle.youtubedownload.R.string.navigation_drawer_open, ljlabs.kyle.youtubedownload.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(ljlabs.kyle.youtubedownload.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(ljlabs.kyle.youtubedownload.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (web.canGoBack()) {
                web.goBack();
            } else {
                finish();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(ljlabs.kyle.youtubedownload.R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == ljlabs.kyle.youtubedownload.R.id.nav_Dl_Here) {
            String Dl = web.getUrl();
            if(Dl != "") {
                String[] DlParts = Dl.split("v=");
                if(DlParts.length == 2){
                    Uri uri = Uri.parse("http://www.convert2mp3.cc/v/" + DlParts[1].trim());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this, "This Website Is not Yet Valid", Toast.LENGTH_SHORT).show();
                }


            }else{

                Toast.makeText(MainActivity.this, "This Website Is not Yet Valid", Toast.LENGTH_SHORT).show();
            }

        } else if (id == ljlabs.kyle.youtubedownload.R.id.nav_Dl_There) {
            Intent intent = new Intent(this, specificUrl.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(ljlabs.kyle.youtubedownload.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
