package com.example.Don_meme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar//Cuidado con que no se quede anticuado este paquete
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {
    //CAMPOS DE CLASE
    //--------------------------------------------------------------------------------------------
    //Aquí declaro la variable Toolbar
   lateinit var toolbar: Toolbar
   //Variables para el banner
   private val TAG = "MainActivity"
    private lateinit var mAdview: AdView
//-------------------------------------------------------------------------------------------------
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Esto es para crear el toolbar en el activity main
        toolbar = findViewById(R.id.atoolbar)
        //Para establecer el toolbar como si fuera la barra de herramientas esta el siguiente método
        setSupportActionBar(toolbar)
        //Esto es para meter el banner en el layout principal
        MobileAds.initialize(this)
        bannerAd()
    }//Fin del método onCreate


    /*
    MÉTODOS PARA EJECUTAR ACTIVITYS
    ------------------------------------------------------------------------------------------------
     */

    fun ejecutar_video(view:View){
        val i = Intent(this,Video::class.java)
        startActivity(i)
    }//Fin del método ejecutar video

    fun ejecutar_informacion(view:View){
        val i = Intent(this,Informacion::class.java)
        startActivity(i)
    }

    /*
        MÉTODOS PARA LA CREACIÓN Y EXPOSICIÓN DEL MENÚ
        ------------------------------------------------------------------------------------------------
         */
    //Método para crear menú
    override fun onCreateOptionsMenu(mimenu:Menu):Boolean{
        getMenuInflater().inflate(R.menu.menu_en_activity,mimenu)
        return true
    }

    //Método para la acción de los botones del menú
    override fun onOptionsItemSelected(opcion_menu: MenuItem):Boolean{
        var id = opcion_menu.itemId
        if(id==R.id.informacion){
           ejecutar_informacion(findViewById(R.id.boton_meme))
            return true
        }
        //Si esta condicion no es verdad debe devolver esto
       return super.onOptionsItemSelected(opcion_menu)
    }

/*
METODO PARA BANNER
----------------------------------------------------------------------------------------------------
 */
private fun bannerAd(){
    mAdview = findViewById(R.id.adView)
    val adRequest= AdRequest.Builder().build()
    mAdview.loadAd(adRequest)
    mAdview.adListener = object: AdListener(){
        override fun onAdLoaded() {
            Log.d(TAG, "Ad loaded")
        }

        override fun onAdFailedToLoad(p0: LoadAdError?){
            Log.d(TAG, "Ad failed to load")
        }

        override fun onAdOpened() {
            // Code to be executed when an ad opens an overlay that
            // covers the screen.
            Log.d(TAG,"Ad opened")
        }
        override fun onAdClicked() {
            // Code to be executed when the user clicks on an ad.
            Log.d(TAG,"Ad clicked")
        }
        override fun onAdLeftApplication() {
            // Code to be executed when the user has left the app.
            Log.d(TAG,"User left app on ad")
        }

        override fun onAdClosed() {
            // Code to be executed when the user is about to return
            // to the app after tapping on an ad.
            Log.d(TAG,"Ad closed")
        }


    }
}


}