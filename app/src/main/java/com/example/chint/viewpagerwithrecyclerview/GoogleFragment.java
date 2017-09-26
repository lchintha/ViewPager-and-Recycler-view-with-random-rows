package com.example.chint.viewpagerwithrecyclerview;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by chint on 6/23/2017.
 */

public class GoogleFragment extends android.support.v4.app.Fragment {
    RecyclerView rv;

    int images;
    String dates;
    String descriptions;

    MenuItem shuffle;
    private final int CAMERA_REQUEST_CODE = 0;
    private ShareActionProvider sa;
    Context c = getContext();
    MyAdapter adapter;
    MyData abc;
    //private View mv;
    public GoogleFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Context ct = getContext();

        View v = inflater.inflate(R.layout.recyclerview_layout, null);
        rv = (RecyclerView)v.findViewById(R.id.recycleview);
        this.setHasOptionsMenu(true);
        rv.setHasFixedSize(true);
        abc = new MyData(dates, descriptions, images);
        rv.setAdapter(new MyAdapter(abc, ct));
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_items, menu);
        shuffle = (MenuItem)findViewById(R.id.shuffle);
        sa = (ShareActionProvider) MenuItemCompat.getActionProvider(shuffle);
        return true;
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_items, menu);
        shuffle = (MenuItem)rv.findViewById(R.id.shuffle);
        sa = (ShareActionProvider)MenuItemCompat.getActionProvider(shuffle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if(id == R.id.shuffle) {
            askPermission(Manifest.permission.CAMERA, CAMERA_REQUEST_CODE);
        }
        return super.onOptionsItemSelected(item);
    }


    private void askPermission(final String permission, final int requestCode) {
        if(ContextCompat.checkSelfPermission(getActivity(),permission)!= PackageManager.PERMISSION_GRANTED){

            //ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
            if(!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)){
                Toast.makeText(getActivity(), "Please go to Setting & Change Permissions", Toast.LENGTH_LONG).show();
            }
            else if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)){
                Snackbar.make(getView(), "Please Give Permission...", Snackbar.LENGTH_INDEFINITE).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        requestPermissions(new String[]{permission}, requestCode);
                    }
                }).show();
            }
        }else{
            //Toast.makeText(this, "Permission has already granted", Toast.LENGTH_LONG).show();
            /*int rimage;
            String rtitle;
            String rdescription;*/
            MyData[] a = new MyData[10];

            Random r = new Random();

            for(int i = 0; i<10; i++){
                int n = r.nextInt(10);
                a[i] = MyData.newData[n];
            }
            abc = new MyData(dates, descriptions, images);
            rv.setAdapter(new MyAdapter(abc,c));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults.length>0&&grantResults[0] == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(getActivity(), "Permission Granted", Toast.LENGTH_LONG).show();
        }else
            Toast.makeText(getActivity(), "Permission Denied", Toast.LENGTH_LONG).show();
    }
}
