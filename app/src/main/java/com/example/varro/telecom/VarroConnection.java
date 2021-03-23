package com.example.varro.telecom;

import android.content.Context;
import android.media.MediaPlayer;
import android.telecom.CallAudioState;
import android.telecom.Connection;
import android.telecom.DisconnectCause;

import com.example.varro.R;
import com.example.varro.telecom.VarroCallList;

public class VarroConnection extends Connection {
    public static final String EXTRA_PHONE_ACCOUNT_HANDLE = "com.android.server.telecom.testapps.extra.PHONE_ACCOUNT_HANDLE";
//    private final VarroCallList callList;
//    private final MediaPlayer mediaPlayer;
    private final boolean isIncomingCall;
    private boolean isIncomingCallUiShowing;
    VarroConnection(VarroCallList callList, Context context, boolean isIncoming) {
        callList = callList;
//        mediaPlayer = createMediaPlayer(context);
        isIncomingCall = isIncoming;
    }
    @Override
    public void onShowIncomingCallUi(){

    }
//    /**
//     * Handles updates to the audio state of the connection.
//     * @param state The new connection audio state.
//     */
    @Override
    public void onCallAudioStateChanged(CallAudioState state) {
//        callList.notifyCallModified();
    }
    @Override
    public void onHold(){

    }
    @Override
    public void onUnhold(){

    }
    @Override
    public void onAnswer(){

    }
    @Override
    public void onReject(){

    }
    @Override
    public void onDisconnect(){

    }
//    public void setConnectionActive() {
//        mediaPlayer.start();
//        setActive();
//    }
//    public void setConnectionHeld() {
//        mediaPlayer.pause();
//        setOnHold();
//    }
//    public void setConnectionDisconnected(int cause) {
//        mediaPlayer.stop();
//        setDisconnected(new DisconnectCause(cause));
//        destroy();
//    }
//    public void setIsIncomingCallUiShowing(boolean showing) {
//        isIncomingCallUiShowing = showing;
//    }
//    public boolean isIncomingCallUiShowing() {
//        return isIncomingCallUiShowing;
//    }
//    public boolean isIncomingCall() {
//        return isIncomingCall;
//    }
//    private MediaPlayer createMediaPlayer(Context context) {
//        int audioToPlay = (Math.random() > 0.5f) ? R.raw.sample_audio : R.raw.sample_audio2;
//        MediaPlayer mediaPlayer = MediaPlayer.create(context, audioToPlay);
//        mediaPlayer.setLooping(true);
//        return mediaPlayer;
//    }
}