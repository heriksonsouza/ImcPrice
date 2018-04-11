package com.price.imc.herikson.imcprice;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/**
 * Created by Herikson Souza on 11/04/18.
 */

public class BuscarImagem extends AsyncTask<String, Integer,Bitmap> {

    Activity activity;

    public BuscarImagem(Activity activity){
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        ImageView imageView = (ImageView) activity.findViewById(R.id.imgProjeto);
        if(bitmap !=null){
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //BUSCAR IMAGEM NA INTERNET
    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap imagem = null;
        try{
            URL url = new URL(strings[0]);
            imagem = BitmapFactory.decodeStream(url.openStream());
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return imagem;
    }
}
