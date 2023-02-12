package com.pollub.txt_to_sp;

import android.content.Context;
import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class TTSManager {
    TextToSpeech tts;
    boolean isLoaded;
    public void init(Context context) {
        try {
            tts = new TextToSpeech(context, onInitListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TextToSpeech.OnInitListener onInitListener =
            new TextToSpeech.OnInitListener() {
                public void onInit(int status) {
                    if (status == TextToSpeech.SUCCESS) {

                        Locale loc = new Locale("tr_TR");
                        tts.setLanguage(Locale.UK);
                        isLoaded = true;
                    }
                }
            };

    public void shutDown() {
        tts.shutdown();
    }

    public void initQueue(String text) {
        if (isLoaded)
            // speak(text, queueMode, params, utteranceId)
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
    }
}
