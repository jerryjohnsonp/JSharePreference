package jerry.playstore.autonote;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.widget.RemoteViews;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;


import java.util.Random;



import static android.content.Context.NOTIFICATION_SERVICE;

public class Utils {

//    public static final int NOTIFICATION_ID = 23;
    private static final String CHANNEL_ID = "notify_ha";
//    private static final String CHANNEL_NAME = "workmanager-reminder";
//
//
//    private String NOTIFICATION_TITLE = "Notification Sample App";
//    private String CONTENT_TEXT = "Expand me to see a detailed message!";





    Context context;
    public void sendTextNotification(Context context,String msg,Bitmap logo){
        this.context = context;

        mNotificationManagerCompat = NotificationManagerCompat.from(context);
        createNotificationChannel();

        String[] array = msg.split("@@@");
        createBigTextNotification(array[0],array[1],7,logo);

//        if( ( (new Random().nextInt(61) + 20) % 2 )== 0 ){
//
//        }else{
//            createBigPictureNotification("Attention Please !","You can launch your favourite app "+ new ShareAll().readSharedPreference(context,"APPNAME") + " by long pressing Home Button",7);
//        }

    }


    public void sendPicNotification(Context context,String msg,int image,Bitmap logo){
        this.context = context;

        mNotificationManagerCompat = NotificationManagerCompat.from(context);
        createNotificationChannel();
        String[] array = msg.split("@@@");

        createBigPictureNotification(array[0],array[1],7,logo, image);

    }


    NotificationManagerCompat mNotificationManagerCompat;
    private void createBigTextNotification(String title, String text, int notificationId,Bitmap bitmap) {

        //removes all previously shown notifications.
        mNotificationManagerCompat.cancelAll();


        //THIS LINE WAS THERE
        //Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.logo);

        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle().bigText(text + " ")
                //set different title in expanded mode.
                .setBigContentTitle(null)

                //needed if an app sends notification from multiple sources(accounts).
                .setSummaryText("GK");


        Notification notification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            int color = Color.parseColor("#FFFFFF");

            notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                    //THE BELOWLINE ALSO WAS THERE
                    //.setSmallIcon(R.drawable.logo)
                    .setSmallIcon(IconCompat.createWithBitmap(bitmap))
                    .setContentTitle(title)
                    .setContentText(text + " ")
                    //set Big text template
                                    //.setStyle(style)

                    .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle("").bigText(title+"\n\n"+text) )
                    //.setStyle(new NotificationCompat.BigTextStyle().bigText(text))
                    //Set the large icon in the notification.

                    .setColor(color)


                    .setLargeIcon(bitmap)
                    .build();
        }


        mNotificationManagerCompat.notify(notificationId, notification);

    }



    private void createBigPictureNotification(String title, String text, int notificationId,Bitmap logo,int img) {

        //removes all previously shown notifications.
        mNotificationManagerCompat.cancelAll();


        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), img);

        //Bitmap logo = BitmapFactory.decodeResource(context.getResources(), R.drawable.logo);


        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle()
                //set big picture
                .bigPicture(bitmap)
                //set the content text in expanded form.
                .setSummaryText(text)
                //set different title in expanded mode.
                .setBigContentTitle(null)
                //set different large icon in expanded mode.
                .bigLargeIcon(null);


        Notification notification = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setSmallIcon(IconCompat.createWithBitmap(bitmap))
                    .setContentTitle(title)
                    .setContentText(text)
                    //Set the large icon in the notification.
                    .setLargeIcon(logo)
                    //set Big picture template
                    .setStyle(style)
                    .build();
        }

        mNotificationManagerCompat.notify(notificationId, notification);

    }



    private void createNotificationChannel() {

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            //Channel name
            CharSequence name = "Important_mail_channel";

            //Channel description
            String description = "This channel will show notification only to important people";

            //The importance level you assign to a channel applies to all notifications that you post to it.
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            //Create the NotificationChannel
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);

            //Set channel description
            channel.setDescription(description);

            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



}

