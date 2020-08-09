package com.beraldo.hpe;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.opengles.GL10;

public class Triangle {
    private FloatBuffer vertexBuffer;  // Buffer for vertex-array
    private FloatBuffer vertexBuffer2;  // Buffer for vertex-array
    //private int numFaces = 742;

    private float[][] colors = {  // Colors of the 6 faces
            {1.0f, 0.5f, 0.0f, 0.01f},  // 0. orange
    };

    public float[] vertices = {  // Vertices of the triangle
            -1.0f,  0.0f, 0.0f, // 0. top
            1.0f, 0.0f, 0.0f, // 1. left-bottom

            1.0f, 1.0f, 0.0f,
            0.75f,1.25f, 0.0f,
            0.5f,1.0f, 0.0f,
            0.25f,1.1f, 0.0f,
            0.0f,1.0f, 0.0f,
            -0.25f,1.25f, 0.0f,
            -0.5f,1.0f, 0.0f,
            -0.75f,1.5f, 0.0f,
            -1.0f, 1.0f, 0.0f,  // 2. right-bottom
            // 2. right-bottom
    };

    public Triangle() {
        // Setup vertex-array buffer. Vertices in float. A float has 4 bytes.
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert byte buffer to float
        vertexBuffer.put(vertices);         // Copy data into buffer
        vertexBuffer.position(0);           // Rewind

    }

    //    // Render this shape
    public void draw(GL10 gl) {
        // Enable vertex-array and define the buffers
        // Draw the primitives via index-array

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
/*
        // Render all the faces
        for (int face = 0; face < numFaces; face++) {
            // Set the color for each of the faces
            gl.glColor4f(colors[0][0], colors[0][1], colors[0][2], colors[0][3]);
            // Draw the primitive from the vertex-array directly
            gl.glDrawArrays(GL10.GL_POINTS, 0, 742);
    }
*/
        gl.glLineWidth(3);
        gl.glColor4f(colors[0][0], colors[0][1], colors[0][2], colors[0][3]);
        gl.glDrawArrays(GL10.GL_LINE_LOOP, 0, 11);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisable(GL10.GL_CULL_FACE);//////////////////////////
    }
}
