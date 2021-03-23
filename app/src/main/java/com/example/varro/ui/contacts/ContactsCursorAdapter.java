package com.example.varro.ui.contacts;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.varro.R;

public class ContactsCursorAdapter extends CursorAdapter {

    public ContactsCursorAdapter(Context context, Cursor cursor){
        super(context, cursor);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView contactName = view.findViewById(R.id.contact_name);
        ImageView contactPhoto = view.findViewById(R.id.contact_photo);

        String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));

        contactName.setText(name);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup container) {
        return LayoutInflater.from(context).inflate(R.layout.fragment_contact_unit, container, false);
    }
}
