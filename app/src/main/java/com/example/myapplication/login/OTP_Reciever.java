package com.example.myapplication.login;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

import androidx.annotation.RequiresApi;

public class OTP_Reciever extends BroadcastReceiver {
    private static EditText editText;
    String parts[] = new String[2];

    public void setEditText(EditText editText){
        OTP_Reciever.editText = editText;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        SmsMessage[] smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent);
        for (SmsMessage sms : smsMessages){
            String message = sms.getMessageBody();
            String s = "Your authentication code for NAMAHA";
            parts = message.split(" is ");
            System.out.println(parts[0]);
            if (parts[0].equals(s)){
                editText.setText(parts[1].substring(0,6));
            }else {
                editText.setText("");
            }
        }
    }
}
