package com.ridwanproduction.learnandroidkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import com.google.ar.core.Anchor;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class NextJavaActivity extends AppCompatActivity {
    private ArFragment arFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_java);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arFragment);

        // adding listener for detecting plane
        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            Anchor anchor = hitResult.createAnchor();

            // adding model to the scene
            ModelRenderable.builder()
                    .setSource(this, Uri.parse("TocoToucan.sfb"))
                    .build()
                    .thenAccept(modelRenderable -> addModelToScene(anchor, modelRenderable));
        });
    }

    private void addModelToScene(Anchor anchor, ModelRenderable modelRenderable) {
        AnchorNode node = new AnchorNode(anchor);
        TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem()); //  for moving, resizing object
        transformableNode.setParent(node); // need to attach to parent
        transformableNode.setRenderable(modelRenderable);

        arFragment.getArSceneView().getScene().addChild(node); // adding only parent node, so the child nodes will be added automatically
        transformableNode.select();
    }
}