package jerry.playstore.alertlibrary;

//
//<?xml version="1.0" encoding="utf-8"?>
//        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:tools="http://schemas.android.com/tools"
//        android:layout_width="wrap_content"
//        android:layout_gravity="center"
//        android:gravity="center"
//        android:layout_height="wrap_content"
//        android:background="@android:color/transparent"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        android:orientation="vertical">
//
//
//        <LinearLayout
//        android:layout_width="300dp"
//        android:background="@drawable/rounded_dialog_background"
//        android:layout_height="400dp"
//        android:orientation="vertical">
//
//        <LinearLayout
//        android:layout_width="match_parent"
//        android:layout_height="0dp"
//        android:fontFamily="@font/eleven"
//        android:layout_gravity="center"
//        android:layout_weight="2"
//        android:gravity="center">
//
//        <TextView
//        android:layout_width="0dp"
//        android:layout_height="wrap_content"
//        android:layout_gravity="center"
//        android:layout_weight=".25"
//        android:gravity="center"
//        android:textSize="13sp"
//        android:text=""
//        android:textColor="#FFFFFF" />
//
//        <TextView
//        android:layout_width="0dp"
//        android:layout_height="wrap_content"
//        android:layout_gravity="center"
//        android:layout_weight="2"
//        android:textStyle="bold"
//        android:gravity="center"
//        android:textSize="13sp"
//        android:text="@string/permi"
//        android:textColor="#FFFFFF" />
//
//        <ImageView
//        android:layout_width="0dp"
//        android:id="@+id/close"
//        android:padding="2dp"
//        android:layout_weight=".25"
//        android:gravity="top"
//        android:layout_gravity="top"
//        android:layout_height="30dp"
//        android:src="@drawable/ic_baseline_cancel_24">
//        </ImageView>
//
//        </LinearLayout>
//
//        <LinearLayout
//        android:layout_width="match_parent"
//        android:layout_height="0dp"
//        android:layout_gravity="center"
//        android:layout_weight="6"
//        android:gravity="center">
//
//        <TextView
//        android:id="@+id/myTextView"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:layout_gravity="center"
//        android:textSize="9sp"
//        android:gravity="center"
//        android:text="@string/whatsapp"
//        android:textColor="#FFFFFF" />
//
//        </LinearLayout>
//
//        <LinearLayout
//        android:layout_width="match_parent"
//        android:layout_height="0dp"
//        android:layout_gravity="center"
//        android:layout_weight=".03"
//        android:gravity="center">
//
//        <View
//        android:layout_width="match_parent"
//        android:layout_height="2dp"
//        android:background="@color/white"
//        android:layout_marginLeft="20dp"
//        android:layout_marginRight="20dp" />
//
//
//        </LinearLayout>
//
//        <LinearLayout
//        android:layout_width="match_parent"
//        android:layout_height="0dp"
//        android:layout_gravity="center"
//        android:layout_weight="2"
//        android:gravity="center">
//
//        <androidx.appcompat.widget.SwitchCompat
//        android:id="@+id/mySwitch3"
//        app:showText="true"
//        android:layout_width="wrap_content"
//        android:layout_height="wrap_content"
//        android:checked="false"
//        android:text="Grant Permission  "
//        android:textColor="#FFFFFF"
//        android:textOff=""
//        android:textOn="" />
//
//        </LinearLayout>
//
//
//        </LinearLayout>
//
//
//        </LinearLayout>





import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class AlertClass {

    AlertDialog.Builder alertDialogBuilderserverorlocal1;
    AlertDialog alertDialogserverorlocal1;

    Context context;



    public AlertDialog alertDialog;
    public View createAlertClassWithReturnAndSize(Context context, int layout, Boolean cancelable) {

        this.context = context;

        try {

            View dialogView = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(dialogView);

            alertDialog = alertDialogBuilder.create();

            alertDialog.getWindow().setGravity(Gravity.CENTER);

            alertDialog.setCancelable(cancelable);

            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            alertDialog.show();

            return dialogView;

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return null;
    }




    public void createAlertClass(Context context,int layout, Boolean cancelable) {

        this.context = context;

        try {

            final View search1 = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);
            alertDialogBuilderserverorlocal1 = new AlertDialog.Builder(search1.getContext());
            alertDialogBuilderserverorlocal1.setView(search1);


            alertDialogBuilderserverorlocal1.setCancelable(cancelable);


            alertDialogserverorlocal1 = alertDialogBuilderserverorlocal1.create();

            alertDialogserverorlocal1.requestWindowFeature(Window.FEATURE_NO_TITLE);
            WindowManager.LayoutParams wmlp = alertDialogserverorlocal1.getWindow().getAttributes();
            wmlp.gravity = Gravity.CENTER;
alertDialogserverorlocal1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            alertDialogserverorlocal1.show();


        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }





//    public void createAlertClassToaster(Context context,int layout, Boolean cancelable,String string) {
//
//        this.context = context;
//
//        try {
//
//            final View search1 = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);
//            alertDialogBuilderserverorlocal1 = new AlertDialog.Builder(search1.getContext());
//            alertDialogBuilderserverorlocal1.setView(search1);
//
//
//            alertDialogBuilderserverorlocal1.setCancelable(cancelable);
//
//
//
//            TextView textView = (TextView) search1.findViewById(R.id.toastTextView);
//            textView.setText(string);
//
//
//
//            alertDialogserverorlocal1 = alertDialogBuilderserverorlocal1.create();
//
//            alertDialogserverorlocal1.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            WindowManager.LayoutParams wmlp = alertDialogserverorlocal1.getWindow().getAttributes();
//            wmlp.gravity = Gravity.CENTER;
//alertDialogserverorlocal1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//            alertDialogserverorlocal1.show();
//
//
//
//
//        } catch (Exception e) {
//            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//    }



    public void dismiss()
    {
        alertDialogserverorlocal1.dismiss();
    }



    public View createAlertClassWithReturn(Context context,int layout, Boolean cancelable) {

        this.context = context;

        try {

            final View search1 = ((AppCompatActivity) context).getLayoutInflater().inflate(layout, null);
            alertDialogBuilderserverorlocal1 = new AlertDialog.Builder(search1.getContext());
            alertDialogBuilderserverorlocal1.setView(search1);


            alertDialogBuilderserverorlocal1.setCancelable(cancelable);


            alertDialogserverorlocal1 = alertDialogBuilderserverorlocal1.create();

            alertDialogserverorlocal1.requestWindowFeature(Window.FEATURE_NO_TITLE);
            WindowManager.LayoutParams wmlp = alertDialogserverorlocal1.getWindow().getAttributes();
            wmlp.gravity = Gravity.CENTER;
alertDialogserverorlocal1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            alertDialogserverorlocal1.show();

            alertDialogserverorlocal1.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);


            return  search1;

        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }

        return null;
    }




}
