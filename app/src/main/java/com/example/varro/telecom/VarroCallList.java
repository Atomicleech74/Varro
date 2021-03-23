package com.example.varro.telecom;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.telecom.ConnectionRequest;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.util.ArrayMap;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VarroCallList {
//    public abstract static class Listener {
//        public void onCreateIncomingConnectionFailed(ConnectionRequest request) {};
//        public void onCreateOutgoingConnectionFailed(ConnectionRequest request) {};
//        public void onConnectionListChanged() {};
//    }
//    public static String SELF_MANAGED_ACCOUNT_1 = "1";
//    public static String SELF_MANAGED_ACCOUNT_2 = "2";
//    private static VarroCallList instance;
//    private static ComponentName COMPONENT_NAME = new ComponentName(VarroCallList.class.getPackage().getName(), VarroConnectionService.class.getName());
//    private static Uri SELF_MANAGED_ADDRESS_1 = Uri.fromParts(PhoneAccount.SCHEME_TEL, "555-1212","");
//    private static Uri SELF_MANAGED_ADDRESS_2 = Uri.fromParts(PhoneAccount.SCHEME_SIP,"me@test.org", "");
//    private static Map<String, PhoneAccountHandle> mPhoneAccounts = new ArrayMap();
//    public static VarroCallList getInstance() {
//        if (instance == null) {
//            instance = new VarroCallList();
//        }
//        return instance;
//    }
//    private Listener mListener;
//    private List<VarroConnection> mConnections = new ArrayList<>();
//    public void setListener(Listener listener) {
//        mListener = listener;
//    }
//    public void registerPhoneAccounts(Context context) {
//        registerPhoneAccount(context, SELF_MANAGED_ACCOUNT_1, SELF_MANAGED_ADDRESS_1);
//        registerPhoneAccount(context, SELF_MANAGED_ACCOUNT_2, SELF_MANAGED_ADDRESS_2);
//    }
//    public void registerPhoneAccount(Context context, String id, Uri address) {
//        PhoneAccountHandle handle = new PhoneAccountHandle(COMPONENT_NAME, id);
//        mPhoneAccounts.put(id, handle);
//        PhoneAccount.Builder builder = PhoneAccount.builder(handle, id)
//                .addSupportedUriScheme(PhoneAccount.SCHEME_TEL)
//                .addSupportedUriScheme(PhoneAccount.SCHEME_SIP)
//                .setAddress(address)
//                .setCapabilities(PhoneAccount.CAPABILITY_SELF_MANAGED |
//                        PhoneAccount.CAPABILITY_VIDEO_CALLING |
//                        PhoneAccount.CAPABILITY_SUPPORTS_VIDEO_CALLING);
//        TelecomManager.from(context).registerPhoneAccount(builder.build());
//    }
//    public PhoneAccountHandle getPhoneAccountHandle(String id) {
//        return mPhoneAccounts.get(id);
//    }
//    public void notifyCreateIncomingConnectionFailed(ConnectionRequest request) {
//        if (mListener != null) {
//            mListener.onCreateIncomingConnectionFailed(request);
//        }
//    }
//    public void notifyCreateOutgoingConnectionFailed(ConnectionRequest request) {
//        if (mListener != null) {
//            mListener.onCreateOutgoingConnectionFailed(request);
//        }
//    }
//    public void addConnection(VarroConnection connection) {
//        Log.i(this, "addConnection %s", connection);
//        mConnections.add(connection);
//        if (mListener != null) {
//            Log.i(this, "addConnection calling onConnectionListChanged %s", connection);
//            mListener.onConnectionListChanged();
//        }
//    }
//    public void removeConnection(VarroConnection connection) {
//        Log.i(this, "removeConnection %s", connection);
//        mConnections.remove(connection);
//        if (mListener != null) {
//            Log.i(this, "removeConnection calling onConnectionListChanged %s", connection);
//            mListener.onConnectionListChanged();
//        }
//    }
//    public List<VarroConnection> getConnections() {
//        return mConnections;
//    }
//    public void notifyCallModified() {
//        if (mListener != null) {
//            mListener.onConnectionListChanged();
//        }
//    }
}