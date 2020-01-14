package com.kempaka.desa_cikalongsari.menu_utama;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kempaka.desa_cikalongsari.R;
import com.github.barteksc.pdfviewer.PDFView;

public class kesekertariatan extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kesekertariatan);

        pdfView = findViewById(R.id.pdf_viewer5);

        pdfView.fromAsset("sekret.pdf")
                .enableSwipe(true)
                .swipeHorizontal(false)
                .load();

    }
}
