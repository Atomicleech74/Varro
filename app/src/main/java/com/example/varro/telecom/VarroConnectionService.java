package com.example.varro.telecom;

import android.os.Bundle;
import android.telecom.Connection;
import android.telecom.ConnectionRequest;
import android.telecom.ConnectionService;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telecom.VideoProfile;
import android.util.Log;

import com.example.varro.telecom.VarroCallList;
import com.example.varro.telecom.VarroConnection;

public class VarroConnectionService extends ConnectionService {
//    private final VarroCallList callList = VarroCallList.getInstance();
//
    @Override
    public Connection onCreateOutgoingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest request) {
        return createSelfManagedConnection(request, false);
//        return new VarroConnection();
    }
    @Override
    public void onCreateOutgoingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest request) {
//        callList.notifyCreateOutgoingConnectionFailed(request);
    }
    @Override
    public Connection onCreateIncomingConnection(PhoneAccountHandle phoneAccountHandle, ConnectionRequest request) {
        return createSelfManagedConnection(request, true);
//        return new VarroConnection();
    }
    @Override
    public void onCreateIncomingConnectionFailed(PhoneAccountHandle phoneAccountHandle, ConnectionRequest request) {
//        callList.notifyCreateIncomingConnectionFailed(request);
    }
    private Connection createSelfManagedConnection(ConnectionRequest request, boolean isIncoming) {
        VarroConnection connection = new VarroConnection(null, getApplicationContext(), isIncoming);
        connection.setConnectionProperties(Connection.PROPERTY_SELF_MANAGED);
        connection.setAddress(request.getAddress(), TelecomManager.PRESENTATION_ALLOWED);
        connection.setExtras(request.getExtras());
        if (isIncoming) {
//            connection.setIsIncomingCallUiShowing(request.shouldShowIncomingCallUi());
        }
        // Track the phone account handle which created this connection so we can distinguish them
        // in the sample call list later.
        Bundle moreExtras = new Bundle();
        moreExtras.putParcelable(VarroConnection.EXTRA_PHONE_ACCOUNT_HANDLE,
                request.getAccountHandle());
        connection.putExtras(moreExtras);
        //connection.setVideoState(request.getVideoState());
        connection.setVideoState(VideoProfile.STATE_BIDIRECTIONAL);
//        Log.i(this, "createSelfManagedConnection %s", connection);
//        callList.addConnection(connection);
        return connection;
    }
}