package com.ridwanproduction.learnandroidkotlin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.ridwanproduction.learnandroidkotlin.Adapters.ArAdapter;

import java.util.ArrayList;
import java.util.List;

public class NextJavaActivity extends AppCompatActivity {

    private ArFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_java);

        fragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        fragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            ViewRenderable
                    .builder()
                    .setView(this, R.layout.pager)
                    .build()
                    .thenAccept(viewRenderable -> {
                        addToScene(viewRenderable, hitResult.createAnchor());
                    });
        });
    }

    private void addToScene(ViewRenderable viewRenderable, Anchor anchor) {
        AnchorNode node = new AnchorNode(anchor);
        node.setRenderable(viewRenderable);
        fragment.getArSceneView().getScene().addChild(node);

        View view = viewRenderable.getView();
        ViewPager pager = view.findViewById(R.id.viewPager);

        List<Integer> images = new ArrayList<>();
        images.add(R.drawable.iu);
        images.add(R.drawable.im2);
        images.add(R.drawable.im3);
        images.add(R.drawable.im4);
        images.add(R.drawable.im5);

        ArAdapter adapter = new ArAdapter(images, getApplicationContext());
        pager.setAdapter(adapter);
    }
}