package com.example.typroject;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import androidx.core.content.res.TypedArrayUtils;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.Interpreter;
import org.tensorflow.lite.Tensor;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Collection;

public class SkinCancerClassifier {

    private static final int IMAGE_MEAN = 255;
    private static final int IMAGE_STD = 255;
    static int wigth = 90 , height =120;

    static  int PIXEL_SIZE = 3;
    static AssetManager assetManager;
    static String modelPath = "";
    static Interpreter interpreter;
    static int x=0;
    static String[] label = {
            "Melanocytic nevi",
            "Melanoma",
            "Benign keratosis-like lesions",
            "Basal cell carcinoma",
            "Actinic keratoses",
            "Vascular lesions",
            "Dermatofibroma"};
    public static String predict(Bitmap image) {
        ByteBuffer inpBuffer = preProcessImage(image);

        float[][] out = new float[1][7];
        interpreter.run(inpBuffer, out);
        Log.i("output is ", "predict: " + Arrays.toString(out[0]));
        float max = max(out[0]);
        for(int i = 0 ; i<7;i++){
            if(out[0][i]==max){
                x = i;
                break;
            }
        }
        return Integer.toString(x)+" " + label[x] +" 1|"+  Float.toString(out[0][0])  +" 2|"+ Float.toString(out[0][1]) +" 3|" + Float.toString(out[0][2]) +" 4|"+ Float.toString(out[0][3]) +" 5|"+ Float.toString(out[0][4])+" 6|" + Float.toString(out[0][5])+" 7|"+ Float.toString(out[0][6]);

    }

    public static float max(float[] array) {
        // Validates input
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        } else if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        // Finds and returns max
        float max = array[0];
        for (int j = 1; j < array.length; j++) {
            if (Float.isNaN(array[j])) {
                return Float.NaN;
            }
            if (array[j] > max) {
                max = array[j];
            }
        }

        return max;
    }
    private static ByteBuffer preProcessImage(Bitmap bitmap) {
        bitmap = Bitmap.createScaledBitmap(bitmap, wigth, height, false);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * wigth * height * PIXEL_SIZE);
        byteBuffer.order(ByteOrder.nativeOrder());
        int[] intValues =new int[wigth * height];

        bitmap.getPixels(intValues, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int pixel = 0;
        for (int i=0; i< wigth; i++) {
            for (int j=0; j<height; j++) {
                int input = intValues[pixel++];

                byteBuffer.putFloat((((input>>16  & 0xFF) - IMAGE_MEAN) / IMAGE_STD));
                byteBuffer.putFloat((((input>>8 & 0xFF) - IMAGE_MEAN) / IMAGE_STD));
                byteBuffer.putFloat((((input & 0xFF) - IMAGE_MEAN) / IMAGE_STD));
            }
        }
        return byteBuffer;
    }

    public static void init(AssetManager assetManager, String model_path){
        SkinCancerClassifier.assetManager = assetManager;
        SkinCancerClassifier.modelPath = model_path;
        interpreter = createInterpreter(assetManager, model_path);
    }

    static Interpreter createInterpreter(AssetManager assetManager, String model_path){
        Interpreter.Options options= new Interpreter.Options();
        options.setNumThreads(5);
        options.setUseNNAPI(true);
        return new Interpreter(loadModelFile(assetManager, model_path), options);
    }

    private static ByteBuffer loadModelFile(AssetManager assetManager, String modelPath) {
        AssetFileDescriptor fileDescriptor = null;
        try {
            fileDescriptor = assetManager.openFd(modelPath);
            FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
            FileChannel fileChannel = inputStream.getChannel();
            long startOffset = fileDescriptor.getStartOffset();
            long declaredLength = fileDescriptor.getDeclaredLength();
            return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
