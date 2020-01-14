package com.kempaka.desa_cikalongsari.menu_utama;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kempaka.desa_cikalongsari.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.util.FitPolicy;

public class pokja_iv extends AppCompatActivity {

    PDFView pdfView,pdfView2,pdfView3,pdfView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokja_iv);


        pdfView = findViewById(R.id.pdf_viewer41);


        pdfView.fromAsset("pokja41.pdf")
                .enableSwipe(true) // allows to block changing pages using swipe
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(null)
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .pageFitPolicy(FitPolicy.WIDTH)
                .load();

    }
}
