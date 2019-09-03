package com.example.amapservice;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

/**
 * Created by wangfei on 2019/4/10.
 */
public class LocationManager {

    public long interval;
    public LocationPolicy locationPolicy;
    public OnLocationListener onLocationListener;
    public LocationManager(Builder builder){
        this.interval=builder.interval;
        this.locationPolicy=builder.locationPolicy;
        this.onLocationListener=builder.onLocationListener;
    }

    public OnLocationListener getOnLocationListener(){
        return onLocationListener;
    }

    public long getInterval() {
        return interval;
    }

    public LocationPolicy getLocationPolicy() {
        return locationPolicy;
    }

    public void start(Context context){
        Intent intent=new Intent(context,AMapService.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("key", (Serializable) this);
        intent.putExtras(bundle);
        context.startService(intent);

    }

    public static class Builder{
        public long interval;
        public LocationPolicy locationPolicy;
        public OnLocationListener onLocationListener;
        public Builder(){
            this.interval=1000;
            locationPolicy=LocationPolicy.ONCE;
        }

        public Builder setOnLocationListener(OnLocationListener onLocationListener) {
            this.onLocationListener = onLocationListener;
            return this;
        }

        public Builder setInterval(long interval) {
            this.interval = interval;
            return this;
        }

        public Builder setLocationPolicy(LocationPolicy locationPolicy) {
            this.locationPolicy = locationPolicy;
            return this;
        }

        public LocationManager build(){
            return new LocationManager(this);
        }
    }




















}
