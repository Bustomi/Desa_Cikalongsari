package com.kempaka.desa_cikalongsari.navig;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kempaka.desa_cikalongsari.R;
import com.github.barteksc.pdfviewer.PDFView;

public class nav1 extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav1);

//        pdfView = findViewById(R.id.pdf_viewe1);

//        pdfView.fromAsset("profil.pdf")
//                .enableSwipe(true)
//                .load();
    }
}
