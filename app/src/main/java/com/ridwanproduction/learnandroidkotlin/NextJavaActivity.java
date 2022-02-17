package com.ridwanproduction.learnandroidkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.ar.core.AugmentedFace;
import com.google.ar.core.Frame;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.Renderable;
import com.google.ar.sceneform.rendering.Texture;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.AugmentedFaceNode;

import java.util.Collection;

public class NextJavaActivity extends AppCompatActivity {

    private ModelRenderable modelRenderable;
    private Texture texture;
    private boolean isFaceAdded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_java);

        ArFragment fragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        ModelRenderable.builder().setSource(this, R.raw.fox_face).build().thenAccept(modelRenderable1 -> {
            modelRenderable = modelRenderable1;
            modelRenderable.setShadowCaster(false);
            modelRenderable.setShadowReceiver(false);
        });

        Texture.builder().setSource(this, R.raw.fox_face_mesh_texture).build().thenAccept(texture1 -> {
            texture = texture1;
        });

        fragment.getArSceneView().setCameraStreamRenderPriority(Renderable.RENDER_PRIORITY_FIRST);

        fragment.getArSceneView().getScene().addOnUpdateListener(frameTime -> {

            Frame frame = fragment.getArSceneView().getArFrame();
            Collection<AugmentedFace> faces = frame.getUpdatedTrackables(AugmentedFace.class);

            for (AugmentedFace face: faces){
                if (isFaceAdded) return;

                AugmentedFaceNode faceNode = new AugmentedFaceNode(face);
                faceNode.setParent(fragment.getArSceneView().getScene());
                faceNode.setFaceRegionsRenderable(modelRenderable);
                faceNode.setFaceMeshTexture(texture);

                isFaceAdded = true;
            }
        });
    }
}