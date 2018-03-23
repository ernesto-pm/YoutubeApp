package com.ernesto.youtubeapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubePlayerView;
    private String key = "AIzaSyAgOyp6QoqaMH-PWLCW2YOqy6hT4C74auA";
    private String uri = "TXYh4re0j8M";
    private EditText uriText;

    private YouTubePlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.you);
        youTubePlayerView.initialize(key, this);

        uriText = (EditText) findViewById(R.id.youtubeURI);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Toast.makeText(this, "Youtube Enabled", Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, getString(R.string.saludo), Toast.LENGTH_LONG).show();

        player = youTubePlayer;

        if(!b) {
            youTubePlayer.cueVideo(uri);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Youtube Error not available", Toast.LENGTH_SHORT).show();

    }

    public void cueVideo(View view) {
        player.cueVideo(uriText.getText().toString());

    }
}
