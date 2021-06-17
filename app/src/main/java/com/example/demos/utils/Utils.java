package com.example.demos.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class Utils {

    public static String getJsonFromAssets(Context context, String fileName){
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }

    String jsonString = " [\n" +
            "{\n" +
            "\"id\": 54,\n" +
            "\"title\": \"\",\n" +
            "\"description\": \"\",\n" +
            "\"final_time\": \"\",\n" +
            "\"thumbnail_file\": \"\",\n" +
            "\"video_file\": \"\",\n" +
            "\"user_id\": 44,\n" +
            "\"state_id\": 2,\n" +
            "\"type_id\": 2,\n" +
            "\"request_type\": 2,\n" +
            "\"created_on\": \"2021-05-14 13:26:38\",\n" +
            "\"created_by_id\": 45,\n" +
            "\"coach_detail\": {\n" +
            "\"id\": 44,\n" +
            "\"full_name\": \"Krishan Singh\",\n" +
            "\"first_name\": \"Krishan\",\n" +
            "\"last_name\": \"Singh\",\n" +
            "\"email\": \"krishan@gmail.com\",\n" +
            "\"date_of_birth\": null,\n" +
            "\"gender\": 0,\n" +
            "\"about_me\": \"it\",\n" +
            "\"contact_no\": \"8699347603\",\n" +
            "\"address\": \"\",\n" +
            "\"latitude\": \"\",\n" +
            "\"longitude\": \"\",\n" +
            "\"city\": null,\n" +
            "\"country\": null,\n" +
            "\"zipcode\": null,\n" +
            "\"interest_address\": null,\n" +
            "\"interest_latitude\": null,\n" +
            "\"interest_longitude\": null,\n" +
            "\"language\": null,\n" +
            "\"profile_file\": \"/sportconx-yii2-1560/user/image/44?file=user-1620987915-profile_file-user_id_44.&thumbnail=500\",\n" +
            "\"video_fmile\": \"/sportconx-yii2-1560/user/video/44?file=%2Fsportconx-yii2-1560%2Fuser%2Fvideo%2F44%3Ffile%3Duser-1620713838-video_file-user_id_.mp4%26thumbnail%3D500&thumbnail=500\",\n" +
            "\"document_file\": \"/sportconx-yii2-1560/user/document/44?file=user-1620987915-document_file-user_id_44.&thumbnail=500\",\n" +
            "\"cover_image_file\": \"\",\n" +
            "\"tos\": null,\n" +
            "\"role_id\": 4,\n" +
            "\"state_id\": 1,\n" +
            "\"type_id\": 0,\n" +
            "\"timezone\": null,\n" +
            "\"created_on\": \"2021-05-11 11:45:58\",\n" +
            "\"is_complete_profile\": 1,\n" +
            "\"is_notification\": 1,\n" +
            "\"sport_category\": \"4\",\n" +
            "\"sport_title\": \"Table Tennis\",\n" +
            "\"response_time\": \"25\",\n" +
            "\"video_rate\": \"100\",\n" +
            "\"dm_rate\": \"202\",\n" +
            "\"average_rating\": null,\n" +
            "\"review_count\": 0,\n" +
            "\"customer_id\": null,\n" +
            "\"video_files\": []\n" +
            "},\n" +
            "\"is_rating\": false\n" +
            "},\n" +
            "{\n" +
            "\"id\": 50,\n" +
            "\"title\": \"\",\n" +
            "\"description\": \"\",\n" +
            "\"final_time\": \"\",\n" +
            "\"thumbnail_file\": \"\",\n" +
            "\"video_file\": \"\",\n" +
            "\"user_id\": 44,\n" +
            "\"state_id\": 1,\n" +
            "\"type_id\": 1,\n" +
            "\"request_type\": 2,\n" +
            "\"created_on\": \"2021-05-13 08:46:28\",\n" +
            "\"created_by_id\": 45,\n" +
            "\"coach_detail\": {\n" +
            "\"id\": 44,\n" +
            "\"full_name\": \"Krishan Singh\",\n" +
            "\"first_name\": \"Krishan\",\n" +
            "\"last_name\": \"Singh\",\n" +
            "\"email\": \"krishan@gmail.com\",\n" +
            "\"date_of_birth\": null,\n" +
            "\"gender\": 0,\n" +
            "\"about_me\": \"it\",\n" +
            "\"contact_no\": \"8699347603\",\n" +
            "\"address\": \"\",\n" +
            "\"latitude\": \"\",\n" +
            "\"longitude\": \"\",\n" +
            "\"city\": null,\n" +
            "\"country\": null,\n" +
            "\"zipcode\": null,\n" +
            "\"interest_address\": null,\n" +
            "\"interest_latitude\": null,\n" +
            "\"interest_longitude\": null,\n" +
            "\"language\": null,\n" +
            "\"profile_file\": \"/sportconx-yii2-1560/user/image/44?file=user-1620987915-profile_file-user_id_44.&thumbnail=500\",\n" +
            "\"video_fmile\": \"/sportconx-yii2-1560/user/video/44?file=%2Fsportconx-yii2-1560%2Fuser%2Fvideo%2F44%3Ffile%3Duser-1620713838-video_file-user_id_.mp4%26thumbnail%3D500&thumbnail=500\",\n" +
            "\"document_file\": \"/sportconx-yii2-1560/user/document/44?file=user-1620987915-document_file-user_id_44.&thumbnail=500\",\n" +
            "\"cover_image_file\": \"\",\n" +
            "\"tos\": null,\n" +
            "\"role_id\": 4,\n" +
            "\"state_id\": 1,\n" +
            "\"type_id\": 0,\n" +
            "\"timezone\": null,\n" +
            "\"created_on\": \"2021-05-11 11:45:58\",\n" +
            "\"is_complete_profile\": 1,\n" +
            "\"is_notification\": 1,\n" +
            "\"sport_category\": \"4\",\n" +
            "\"sport_title\": \"Table Tennis\",\n" +
            "\"response_time\": \"25\",\n" +
            "\"video_rate\": \"100\",\n" +
            "\"dm_rate\": \"202\",\n" +
            "\"average_rating\": null,\n" +
            "\"review_count\": 0,\n" +
            "\"customer_id\": null,\n" +
            "\"video_files\": []\n" +
            "},\n" +
            "\"is_rating\": false\n" +
            "}\n" +
            "]";

}
