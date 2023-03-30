package jerry.playstore.jsharelibrary;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by jerry on 26/9/19.

 ShareAll sa = new ShareAll();

 sa.writeSharedPreference(getActivity(),"NAME",name.getText().toString().toUpperCase());

 */

public class ShareAll
{

    public static final String mypreference = "mypref";
    protected final static int DEFAULT = 0;


    public String readSharedPreference(Context context, String key)
    {
        SharedPreferences sharedPreferences =  context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,"").toString();
    }

    public void writeSharedPreference(Context context,String key,String data)
    {

        SharedPreferences sharedPreferences = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,data);
        editor.commit();
    }


    public void appendSharedPreference(Context context,String key,String data,String appender){
        SharedPreferences sharedPreferences =  context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        String string = sharedPreferences.getString(key,"").toString();
        string = string + appender + data;

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,string);
        editor.commit();

    }

    public void clearSharedPreference(Context context,String key){
        SharedPreferences sharedPreferences = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,"");
        editor.commit();
    }

    public boolean checkIfExists(Context context,String key)
    {
        SharedPreferences sharedPreferences = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(key))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
