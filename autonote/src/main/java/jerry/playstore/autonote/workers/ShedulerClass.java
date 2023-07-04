//package jerry.playstore.autonote.workers;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//
//import androidx.work.WorkManager;
//import androidx.work.Constraints;
//import androidx.work.PeriodicWorkRequest;
//import androidx.work.WorkManager;
//import androidx.work.Data;
//
//
//import java.io.ByteArrayOutputStream;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import jerry.playstore.autonote.R;
//
//public class ShedulerClass {
//
//
//
//
//
////    ArrayList<Integer> imageList = new ArrayList<>();
////            imageList.add(R.drawable.first);
////            imageList.add(R.drawable.second);
////            imageList.add(R.drawable.third);
//
//    WorkManager workManager;
//    public void scheduleJob(Context context, int interval, TimeUnit  timeUnit, List<String> stringList, ArrayList<Integer> imageList, int logo,String msgIfPictureSelected) {
//
//        try{
//
//            //TimeUnit.HOURS
//
//            byte[] logoByteArray = convertDrawableToByteArray(context, logo);
//
//
//            // Convert ArrayList<Integer> to int[]
//            int[] imageArray = new int[imageList.size()];
//            for (int i = 0; i < imageList.size(); i++) {
//                imageArray[i] = imageList.get(i);
//            }
//
////            Data inputData = new Data.Builder()
////                    .putString("key1", "value1")
////                    .putInt("key2", 42)
////                    .putIntArray("imageList", imageArray)
////                    .build();
//
//
//            String[] stringArray = stringList.toArray(new String[stringList.size()]);
//
//
//            Data inputData = new Data.Builder()
//                    .putStringArray("stringList",stringArray)
//                    .putIntArray("imageList", imageArray)
//                    .putByteArray("logo",logoByteArray)
//                    .putString("msgIfPictureSelected",msgIfPictureSelected)
//                    .build();
//
//            workManager = WorkManager.getInstance();
//            Constraints constraints = new Constraints.Builder()
//                    .setRequiresCharging(false)
//                    .build();
//
//            PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(
//                    NotiWorker.class, interval,timeUnit)
//                    .setConstraints(constraints)
//                    .setInputData(inputData)
//                    .build();
//            workManager.enqueue(periodicWorkRequest);
//
//        }
//        catch (Exception e){
//            //Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//
//    public byte[] convertDrawableToByteArray(Context context, int drawableResId) {
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), drawableResId);
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//        byte[] byteArray = outputStream.toByteArray();
//        try {
//            outputStream.close();
//        } catch (Exception e) {
//          //  Log.e("Conversion Error", "Error converting drawable to byte array: " + e.getMessage());
//        }
//        return byteArray;
//    }
//
//
//
//
//}
