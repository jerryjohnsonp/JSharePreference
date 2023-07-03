package jerry.playstore.autonote.workers;



import android.content.Context;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.Toast;
import java.util.Random;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.ArrayList;
import java.util.Random;


public class NotiWorker extends Worker {


    Context context;
    byte[] logoByteArray;
    int[] imageArray;
    String[] stringArray;
    String msgIfPictureSelected;
    public NotiWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
        this.stringArray = getInputData().getStringArray("stringArray");
        this.imageArray = getInputData().getIntArray("imageArray");
        this.logoByteArray = getInputData().getByteArray("logo");
        this.msgIfPictureSelected = getInputData().getString("msgIfPictureSelected");
    }

    private static final String TAG = NotiWorker.class.getName();

    /**
     * Override this method to do your actual background processing.  This method is called on a
     * background thread - you are required to <b>synchronously</b> do your work and return the
     * {@link Result} from this method.  Once you return from this
     * method, the Worker is considered to have finished what its doing and will be destroyed.
     * <p>
     * A Worker is given a maximum of ten minutes to finish its execution and return a
     * {@link Result}.  After this time has expired, the Worker will
     * be signalled to stop.
     *
     * @return The {@link Result} of the computation; note that
     * dependent work will not execute if you use
     * {@link Result#failure()} or
     */


    //Context context;

    @NonNull
    @Override
    public Result doWork() {
        try {

            if (((new Random().nextInt(61) + 20) % 2) == 0) {
                // TEXT

                // Assuming you have a String array called stringArray
                int arraySize = stringArray.length;

                // Generate a random number
                Random random = new Random();
                int randomNumber = random.nextInt(arraySize);

                // Adjust the random number to be within the range of 0 to arraySize - 1
                randomNumber = Math.min(randomNumber, arraySize - 1);

                // Use the random number
                String randomElement = stringArray[randomNumber];

                new Utils().sendTextNotification(context,stringArray[randomNumber],convertByteArrayToBitmap(logoByteArray));
                return Result.success();
            } else {
                // PIC


                // Assuming you have a String array called stringArray
                int arraySize = imageArray.length;

                // Generate a random number
                Random random = new Random();
                int randomNumber = random.nextInt(arraySize);

                // Adjust the random number to be within the range of 0 to arraySize - 1
                randomNumber = Math.min(randomNumber, arraySize - 1);

                // Use the random number
                // int randomElement = imageArray[randomNumber];

                new Utils().sendPicNotification(context,msgIfPictureSelected,imageArray[randomNumber],convertByteArrayToBitmap(logoByteArray));
                return Result.success();

            }



        } catch (Throwable throwable) {
            return Result.failure();
        }

    }

    // Convert byte array to Bitmap
    public Bitmap convertByteArrayToBitmap(byte[] byteArray) {
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
    }


}