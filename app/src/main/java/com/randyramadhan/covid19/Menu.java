package com.randyramadhan.covid19;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button btnInput = findViewById(R.id.btn_form);
        Button btnWeb = findViewById(R.id.btn_website);
        Button btnYT = findViewById(R.id.btnYoutube);
        Button btnGM = findViewById(R.id.btn_map);
        Button btnCamera = findViewById(R.id.btn_camera);
        Button btnCalculator = findViewById(R.id.btn_calculator);
        Button btnCalendar = findViewById(R.id.btn_calendar);
        Button btnContact = findViewById(R.id.btn_contact);
        Button btnSetting = findViewById(R.id.btn_setting);
        Button btnProject9 = findViewById(R.id.btn_project_9);
        Button btnLain = findViewById(R.id.btn_lain);
        Button btnCalculate = findViewById(R.id.btn_calculate);

        Button btnAlertOk = findViewById(R.id.btn_ok);
        Button btnAlertYesNo = findViewById(R.id.btn_yes_no);
        Button btnAlertYesNoCancel = findViewById(R.id.btn_yes_no_cancel);
        Button btnAlertSingle = findViewById(R.id.btn_single_choice);
        Button btnAlertMultiple = findViewById(R.id.btn_multiple_choice);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formCalculate = new Intent(getBaseContext(), Calculate.class);
                startActivity(formCalculate);
            }
        });


        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formInput = new Intent(getBaseContext(), MainActivity.class);
                startActivity(formInput);
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WebMenu = new Intent(getBaseContext(), WResmi.class);
                startActivity(WebMenu);
            }
        });

        btnYT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent yt = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com"));
                startActivity(yt);
            }
        });

        btnGM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com"));
                startActivity(map);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivityForResult(camera, 0);
            }
        });

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calc = new Intent();
                calc.setClassName("com.android.calculator2", "com.android.calculator2.Calculator");
                startActivityForResult(calc, 0);
            }
        });


        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calendar = new Intent();
                calendar.setClassName("com.samsung.android.calendar", "com.samsung.android.calendar.Calendar");
                startActivityForResult(calendar, 0);
            }
        });

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact = new Intent();
                contact.setClassName("com.samsung.android.app.contacts", "com.samsung.android.app.contacts.Contacts");
                startActivityForResult(contact, 0);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setting = new Intent();
                setting.setClassName("com.android.settings", "com.android.settings.Settings");
                startActivityForResult(setting, 0);
            }
        });

        btnProject9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent project9 = new Intent();
                project9.setClassName("com.randyramadhan.project9", "com.randyramadhan.project9.MainActivity");
                startActivityForResult(project9, 0);
            }
        });

        btnLain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lain = new Intent();
                lain.setClassName("com.ayoboga.ayobogaeducation", "com.ayoboga.ayobogaeducation.Ayoboga");
                startActivityForResult(lain, 0);
            }
        });

        btnAlertOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Menu.this);
                dialog.setTitle("Ini Judul Alert");
                dialog.setMessage("Ini pesan Info ALert");
                dialog.setIcon(R.drawable.icon_info);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert Ok", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();

            }
        });

        btnAlertYesNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Menu.this);
                dialog.setTitle("Ini Judul Alert YES NO");
                dialog.setMessage("Ini pesan Info ALert YES NO");
                dialog.setIcon(R.drawable.icon_info);

                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert YES Button", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert NO Button", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });

        btnAlertYesNoCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Menu.this);
                dialog.setTitle("Ini Judul Alert YES NO CANCEL");
                dialog.setMessage("Ini pesan Info ALert YES NO CANCEL");
                dialog.setIcon(R.drawable.icon_info);

                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert YES Button", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert NO Button", Toast.LENGTH_LONG).show();
                    }
                });
                dialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert Cancel Button", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(Menu.this, "Toast dari Alert Cancel Diluar", Toast.LENGTH_LONG).show();
                    }
                });
                // Kalo kodisi user jangan cancle di luar
                 dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });

        btnAlertSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Menu.this);
                dialog.setTitle("Ini Judul Alert Single Choice");
                dialog.setIcon(R.drawable.icon_info);

                String[] listBarang = getResources().getStringArray(R.array.val_barang);

                dialog.setSingleChoiceItems(listBarang, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Item yang kamu pilih: " + listBarang[which].toString(), Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert YES Button", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });

        btnAlertMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Menu.this);
                dialog.setTitle("Ini Judul Alert Single Choice");
                dialog.setIcon(R.drawable.icon_info);

                String[] listBarang = getResources().getStringArray(R.array.val_barang);
                boolean[] checkedItems = {false, false, false, false, false};
                String[] pilihBarang = {""};

                dialog.setMultiChoiceItems(listBarang, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                        pilihBarang[0]= "";

                        for (int i = 0; i < checkedItems.length; i++){
                            if (checkedItems[i] == true) {
                                pilihBarang[0] += listBarang[i].toString() + ",";
                            }
                        }

                        Toast.makeText(Menu.this, "Item yang kamu pilih: " + pilihBarang[0], Toast.LENGTH_LONG).show();
                    }
                });


                dialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu.this, "Toast dari Alert YES Button", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setCancelable(false);
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
            }
        });




    }


}
