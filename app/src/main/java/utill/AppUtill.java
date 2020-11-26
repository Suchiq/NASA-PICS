package utill;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import android.widget.ImageView;

import com.android.nasapics.ImageData;
import com.android.nasapics.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AppUtill {

    public static void showImage(String imageURI, ImageView imageView) {
        Log.d("imgUrl", imageURI);
        Picasso.get()
                .load(imageURI)
                .into(imageView);
    }

    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static ArrayList<ImageData> getData(Context context) {
        ArrayList<ImageData> arrData = new ArrayList<>();

       /* File file = new File(context.getFilesDir(), "data.json");
        FileReader fileReader = null;*/
        try {
         /*   fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            String response = stringBuilder.toString();*/
            String response = loadJSONFromAsset(context);
            JSONArray jsonArray = new JSONArray(response);
            for (int n = 0; n < jsonArray.length(); n++) {
                JSONObject object = jsonArray.getJSONObject(n);
                ImageData data = new ImageData();
                data.setCopyright(object.getString("copyright"));
                data.setDate(object.getString("date"));
                data.setExplanation(object.getString("explanation"));
                data.setMedia_type(object.getString("media_type"));
                data.setTitle(object.getString("title"));
                data.setUrl(object.getString("url"));
                arrData.add(data);

            }

        } catch (
                JSONException e) {
            e.printStackTrace();
        }

        return arrData;
    }
}
