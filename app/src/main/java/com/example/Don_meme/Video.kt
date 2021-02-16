package com.example.Don_meme


import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class Video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video)

        var video: VideoView = findViewById(R.id.vv_test)
        //Creo el Path para insertarlo en el Uri
        var videoPath:String= "android.resource://"+getPackageName()+"/"+R.raw.sacamefoto
        var uri: Uri =Uri.parse(videoPath)
        //Establezo el Uri para el video
        video.setVideoURI(uri)
        //Ahora establezco los controles de video
        var mediacontroller= MediaController(this)
        video.setMediaController(mediacontroller)
        //Para indicar dónde se van a establecer los controles de video
        mediacontroller.setAnchorView(video)
        video.start()

    }
}