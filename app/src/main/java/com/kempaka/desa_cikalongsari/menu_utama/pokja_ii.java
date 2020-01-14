package com.kempaka.desa_cikalongsari.menu_utama;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kempaka.desa_cikalongsari.R;
import com.github.barteksc.pdfviewer.PDFView;

public class pokja_ii extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokja_ii);

        pdfView = findViewById(R.id.pdf_viewer2);

        pdfView.fromAsset("Pokja21.pdf")
                .enableSwipe(true)
                .load();
    }
}
