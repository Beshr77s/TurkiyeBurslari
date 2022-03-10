package com.qashar.turkeyscholiership.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.qashar.turkeyscholiership.Activity.ReaderActivity;
import com.qashar.turkeyscholiership.Activity.ReciveActivity;
import com.qashar.turkeyscholiership.Fragments.AddNewsFragment;
import com.qashar.turkeyscholiership.Fragments.DialogFragment;
import com.qashar.turkeyscholiership.Fragments.ImportantDatesFragment;
import com.qashar.turkeyscholiership.Fragments.LogFragment;
import com.qashar.turkeyscholiership.Fragments.TurkeyInfoFragment;
import com.qashar.turkeyscholiership.MyFirebaseMessagingService;
import com.qashar.turkeyscholiership.R;
import com.qashar.turkeyscholiership.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Integer i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        startService(new Intent(this, MyFirebaseMessagingService.class));
        Typeface typeface = Typeface.createFromAsset(getAssets(),"f1.ttf");
        binding.t1.setTypeface(typeface);
        binding.t2.setTypeface(typeface);
        binding.t3.setTypeface(typeface);
        binding.t4.setTypeface(typeface);
        binding.t5.setTypeface(typeface);
        binding.t6.setTypeface(typeface);
        binding.t7.setTypeface(typeface);
        binding.t8.setTypeface(typeface);
        binding.t9.setTypeface(typeface);
        binding.tvNews.setTypeface(typeface);
        if (Settings.Secure.getString(getContentResolver(),Settings.Secure.ANDROID_ID)
                .equals("2d485a699118fde8")) {
            AddNewsFragment fragment  = new AddNewsFragment();
            fragment.show(getSupportFragmentManager(),"");
        }



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("lastNews");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String message = snapshot.getValue(String.class);
                binding.tvNews.setText(message);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

         reference = database.getReference("lastDate");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Long aLong = snapshot.getValue(Long.class);
                Date date = new Date(aLong);
                SimpleDateFormat format = new SimpleDateFormat("E yyyy/MM/dd ");
                binding.tvDate .setText("أخر تحديث في : "+format.format(date));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        binding.bankCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReaderActivity.class);
                intent.putExtra("title","شروط المنحة التركية المشتركة والمميزات");
                intent.putExtra("text",getResources().getString(R.string.bankInfo));
                startActivity(intent);
            }
        });
        binding.interView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReaderActivity.class);
                intent.putExtra("title","مقابلة المنحة التركية");
                intent.putExtra("text",getResources().getString(R.string.interVirw));
                startActivity(intent);
            }
        });
        binding.turkeyCond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReaderActivity.class);
                intent.putExtra("title","شروط المنحة التركية والمميزات");
                intent.putExtra("text",getResources().getString(R.string.turkeyCond));
                startActivity(intent);
            }
        });
        binding.importantDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), ReaderActivity.class);
//                intent.putExtra("title","موأعيد مهمة");
//                intent.putExtra("text",getResources().getString(R.string.importantDates));
//                startActivity(intent);
                ImportantDatesFragment fragment = new ImportantDatesFragment();
                fragment.show(getSupportFragmentManager(),"");
            }
        });
        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ReciveActivity.class);
                startActivity(intent);
            }
        });
        binding.log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogFragment fragment = new LogFragment();
                fragment.show(getSupportFragmentManager(),"");
            }
        });

        binding.veryImportant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("message",getResources().getString(R.string.veryImportant));
                DialogFragment fragment = new DialogFragment();
                fragment.setArguments(bundle);
                fragment.show(getSupportFragmentManager(),"");
            }
        });
        binding.cardTurkeyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("type","turkey");
                TurkeyInfoFragment fragment = new TurkeyInfoFragment();
                fragment.show(getSupportFragmentManager(),"");
                fragment.setArguments(bundle);
            }
        });
        binding.bankInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("type","bank");
                TurkeyInfoFragment fragment = new TurkeyInfoFragment();
                fragment.show(getSupportFragmentManager(),"");
                fragment.setArguments(bundle);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = getSharedPreferences("Root",MODE_PRIVATE);

        if (!preferences.getBoolean("isOpen",false)){
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isOpen",true);
            editor.apply();
            sendNotification("أهلاً وسهلا بك !","لقد اسعدتنا جداً باختيارك لتطبيقنا سيتم إبلاغك باي تطورات ^-^");
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("Users");
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                     i = snapshot.getValue(Integer.class);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
//            reference.setValue((i+1));
        }

        checkUpdates();


    }

    private void checkUpdates() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Updates");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Integer i = snapshot.getValue(Integer.class);
                reference.setValue(1.0);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void sendNotification(String title,String body) {

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(this, "TAC")
                        .setContentTitle(title)
                        .setContentText(body)
                        .setSmallIcon(R.drawable.ic_launcher_background);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 10, new Intent(getApplicationContext(), MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);

        notificationBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        int idd =  (int) System.currentTimeMillis();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("TAC","demo",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(idd,notificationBuilder.build());


    }

}