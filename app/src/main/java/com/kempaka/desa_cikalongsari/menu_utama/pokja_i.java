package com.kempaka.desa_cikalongsari.menu_utama;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kempaka.desa_cikalongsari.R;
import com.github.barteksc.pdfviewer.PDFView;

public class pokja_i extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokja_i);

        pdfView = findViewById(R.id.pdf_viewer1);

        pdfView.fromAsset("Pokja11.pdf")
                .enableSwipe(true)
                .load();
    }
}
