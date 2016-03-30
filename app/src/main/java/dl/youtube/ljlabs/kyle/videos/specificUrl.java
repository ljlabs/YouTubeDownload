package dl.youtube.ljlabs.kyle.videos;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class specificUrl extends AppCompatActivity  implements View.OnClickListener{

    Button download;
    TextView downloadThis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ljlabs.kyle.youtubedownload.R.layout.activity_specific_url);

        download = (Button) findViewById(ljlabs.kyle.youtubedownload.R.id.dl);
        downloadThis = (TextView) findViewById(ljlabs.kyle.youtubedownload.R.id.URL);
        download.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case ljlabs.kyle.youtubedownload.R.id.dl:
                String Dl = downloadThis.getText().toString();
                if(Dl != "") {
                    String[] DlParts = Dl.split("v=");
                    if(DlParts.length == 2){
                        Uri uri = Uri.parse("http://www.convert2mp3.cc/v/" + DlParts[1].trim());
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }else{
                        Toast.makeText(specificUrl.this, "This Website Is not Yet Valid", Toast.LENGTH_SHORT).show();

                    }


                }else{
                    Toast.makeText(specificUrl.this, "This Website Is not Yet Valid", Toast.LENGTH_SHORT).show();

                }
                break;
        }
    }
}