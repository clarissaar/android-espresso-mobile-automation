package com.mytaxi.app.Utils;

import android.content.Context;
import android.content.res.AssetManager;

import junit.framework.Assert;

import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private Context context;
    private Properties properties;

    public PropertyReader(Context context){
        this.context=context;
        properties = new Properties();
    }

    public Properties getMyProperties(String file){
        try{
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(file+".properties");
            properties.load(inputStream);

        }catch (Exception e){
            Assert.fail("Couldn't load the properties file because of "+e.getMessage());
        }

        return properties;
    }
}
