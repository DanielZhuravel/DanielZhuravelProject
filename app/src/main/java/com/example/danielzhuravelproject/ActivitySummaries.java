package com.example.danielzhuravelproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ActivitySummaries extends AppCompatActivity {

    ListView lstview;
    ArrayList<Summarie> arrSumm = new ArrayList<Summarie>();

    Bitmap image;
    String imgName;
    String subject;
    Dal dal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summaries);

        imgName = "";
        subject= "";

        lstview = findViewById(R.id.listViewSummaries);

        dal = new Dal(this);

        arrSumm = dal.getAllSummaries();
        SummarieAdapter sa = new SummarieAdapter(this, R.layout.summarie,arrSumm);
        lstview.setAdapter(sa);
    }

//    public void getSummarieData() {
//        Summarie s = new Summarie("Math", "Plus Minus rules", this);
//
//        arrSumm.add(s);
//        s = new Summarie("English","Super Mario",this);
//        arrSumm.add(s);
//        s = new Summarie("PE","Jumps and Runs",this);
//        arrSumm.add(s);
//    }

    public void ToaddSummary(View view) {
        Intent i =new Intent(this, ActivityAddSummary.class);
        i.putExtra("userid", getIntent().getIntExtra("userid",0));
        startActivity(i);
    }
//        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Choose your profile picture");
//
//        builder.setItems(options, new DialogInterface.OnClickListener() {
//
//            @Override
//            public void onClick(DialogInterface dialog, int item) {
//
//                if (options[item].equals("Take Photo")) {
//                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(takePicture, 0);
//
//                } else if (options[item].equals("Choose from Gallery")) {
//                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    startActivityForResult(pickPhoto , 1);
//
//                } else if (options[item].equals("Cancel")) {
//                    dialog.dismiss();
//                }
//            }
//        });
//        builder.show();
//
//        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
//        builder1.setTitle("Summary's Title:");
//        final EditText input = new EditText(this);
//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        input.setLayoutParams(lp);
//        builder1.setView(input);
//        builder1.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                imgName = input.getText().toString();
//
//                if(subject.matches("") || imgName.matches("") || image == null)
//                {
//                    Toast.makeText(ActivitySummaries.this, "All Fields must be filled", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
//                    image.compress(Bitmap.CompressFormat.PNG, 100, stream);
//                    byte[] byteArray = stream.toByteArray();
//                    dal.addSummary(subject, imgName, dal.getUserNameByID(getIntent().getIntExtra("usrid",0)), byteArray);
//                    Summarie s = new Summarie(subject, imgName, dal.getUserNameByID(getIntent().getIntExtra("usrid",0)), ActivitySummaries.this);
//                    arrSumm.add(s);
//                }
//            }
//        });
//        builder1.show();
//
//        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
//        builder2.setTitle("In what subject?");
//        final EditText input2 = new EditText(this);
//        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT);
//        input2.setLayoutParams(lp2);
//        builder2.setView(input2);
//        builder2.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                subject = input2.getText().toString();
//            }
//        });
//        builder2.show();
//
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode != RESULT_CANCELED) {
//            switch (requestCode) {
//                case 0:
//                    if (resultCode == RESULT_OK && data != null) {
//                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
//                        image = selectedImage;
//                    }
//
//                    break;
//                case 1:
//                    if (resultCode == RESULT_OK && data != null) {
//                        Uri selectedImage = data.getData();
//                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
//                        if (selectedImage != null) {
//                            Cursor cursor = getContentResolver().query(selectedImage,
//                                    filePathColumn, null, null, null);
//                            if (cursor != null) {
//                                cursor.moveToFirst();
//
//                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
//                                String picturePath = cursor.getString(columnIndex);
//                                image = BitmapFactory.decodeFile(picturePath);
//                                cursor.close();
//                            }
//                        }
//
//                    }
//                    break;
//            }
//        }
//    }
}