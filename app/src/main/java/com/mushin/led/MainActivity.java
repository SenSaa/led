package com.mushin.led;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference ImageView in layout XML, and store it in a variable.
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        // Load a Bitmap from file/folder directory of the host device/pc.
        Bitmap bitmap = BitmapFactory.decodeFile("C://Old/Manga panels/vita71.png");
        // Set the bitmap to the Imageview.
        imageView.setImageBitmap(bitmap);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                redLEDNotification();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                greenLEDNotification();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                blueLEDNotification();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                pinkLEDNotification();
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                purpleLEDNotification();
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                deepskyblueLEDNotification();
            }
        });

        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                silverLEDNotification();
            }
        });

        button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                darkorangeLEDNotification();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private void redLEDNotification() {

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Create a Notification.
        Notification notification = new Notification(R.mipmap.bearded_emote,"Notification",System.currentTimeMillis());

        // Create a Result Intent - To navigate to an Activity after notification is clicked/opened.
        //Intent resultIntent = new Intent(getApplicationContext(), null);
        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),requestCode,new Intent(),0);

        // Set the title, text, and behaviour (PendingIntent - the Activity that will be opened after the notification is clicked) of the Notification.
        String subject = "New Notification";
        String body = "Customise Notification Right Here!";
        notification.setLatestEventInfo(this,subject, body, resultPendingIntent);
        // Set Notification defaults and flags.
        notification.defaults =  Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND;
        notification.ledARGB = Color.RED;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 1000;
        notification.flags = Notification.FLAG_SHOW_LIGHTS;

        // Issue the notification - using "notify".
        notificationManager.notify(0,notification);
    }


    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void greenLEDNotification() {
        // Load a Bitmap from Resources/mipmap.
        //Bitmap myIconBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.bearded_emote);

        // Create a Notification Builder.
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Notification") // Set Title.
                .setContentText("Custom Notification") // Set detail Text.
                .setSmallIcon(R.mipmap.ic_launcher) // Set a notification Icon.
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setLights(Color.GREEN,750,750);

        // Create a Result Intent - To navigate to an Activity after notification is clicked/opened.
        //Intent resultIntent = new Intent(getApplicationContext(), null);
        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,requestCode,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(resultPendingIntent);

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Issue the notification - using "notify", and build the notification.
        int notificationID = 0;
        notificationManager.notify(notificationID,builder.build());
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void blueLEDNotification() {
        // Load a Bitmap from Resources/mipmap.
        Bitmap myIconBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.bearded_emote);

        // Create a Result Intent - To navigate to an Activity after notification is clicked/opened.
        //Intent resultIntent = new Intent(getApplicationContext(), null);

        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),requestCode,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a Notification Builder.
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Notification") // Set Title.
                .setContentText("Custom Notification") // Set detail Text.
                .setLargeIcon(myIconBitmap) // Set a notification Icon.
                .setContentIntent(resultPendingIntent) // Set the Notification's Click Behaviour.
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setLights(Color.BLUE,750,1000);

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Issue and build the notification.
        int notificationID = 1;
        notificationManager.notify(notificationID,notification.build());
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void pinkLEDNotification() {
        // Load a Bitmap from Resources/mipmap.
        Bitmap myIconBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.bearded_emote);

        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),requestCode,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a Notification Builder.
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Notification") // Set Title.
                .setContentText("Custom Notification") // Set detail Text.
                .setLargeIcon(myIconBitmap) // Set a notification Icon.
                .setContentIntent(resultPendingIntent) // Set the Notification's Click Behaviour.
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setLights(Color.argb(255,255,105,180), 750, 1000);

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Issue and build the notification.
        int notificationID = 1;
        notificationManager.notify(notificationID,notification.build());
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void purpleLEDNotification() {
        // Load a Bitmap from Resources/mipmap.
        Bitmap myIconBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.bearded_emote);

        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),requestCode,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a Notification Builder.
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Notification") // Set Title.
                .setContentText("Custom Notification") // Set detail Text.
                .setLargeIcon(myIconBitmap) // Set a notification Icon.
                .setContentIntent(resultPendingIntent) // Set the Notification's Click Behaviour.
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setLights(Color.argb(255,128,0,128), 750, 1000);

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Issue and build the notification.
        int notificationID = 1;
        notificationManager.notify(notificationID,notification.build());
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void deepskyblueLEDNotification() {
        // Load a Bitmap from Resources/mipmap.
        Bitmap myIconBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.bearded_emote);

        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),requestCode,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a Notification Builder.
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Notification") // Set Title.
                .setContentText("Custom Notification") // Set detail Text.
                .setLargeIcon(myIconBitmap) // Set a notification Icon.
                .setContentIntent(resultPendingIntent) // Set the Notification's Click Behaviour.
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setLights(Color.argb(255,0,191,255), 750, 1000);

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Issue and build the notification.
        int notificationID = 1;
        notificationManager.notify(notificationID,notification.build());
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void silverLEDNotification() {
        // Load a Bitmap from Resources/mipmap.
        Bitmap myIconBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.bearded_emote);

        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),requestCode,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a Notification Builder.
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Notification") // Set Title.
                .setContentText("Custom Notification") // Set detail Text.
                .setLargeIcon(myIconBitmap) // Set a notification Icon.
                .setContentIntent(resultPendingIntent) // Set the Notification's Click Behaviour.
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setLights(Color.argb(255,192,192,192), 750, 1000);

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Issue and build the notification.
        int notificationID = 1;
        notificationManager.notify(notificationID,notification.build());
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void darkorangeLEDNotification() {
        // Load a Bitmap from Resources/mipmap.
        Bitmap myIconBitmap = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.bearded_emote);

        // Set the Notification's Click Behaviour.
        int requestCode = 0;
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(),requestCode,new Intent(),PendingIntent.FLAG_UPDATE_CURRENT);

        // Create a Notification Builder.
        NotificationCompat.Builder notification = new NotificationCompat.Builder(getApplicationContext())
                .setContentTitle("Notification") // Set Title.
                .setContentText("Custom Notification") // Set detail Text.
                .setLargeIcon(myIconBitmap) // Set a notification Icon.
                .setContentIntent(resultPendingIntent) // Set the Notification's Click Behaviour.
                .setDefaults(Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setLights(Color.argb(255,255,140,0), 750, 1000);

        // Get an instance of the NotificationManager service.
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Issue and build the notification.
        int notificationID = 1;
        notificationManager.notify(notificationID,notification.build());
    }



}
