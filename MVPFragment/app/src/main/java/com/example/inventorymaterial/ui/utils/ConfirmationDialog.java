package com.example.inventorymaterial.ui.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.AdapterView;

import com.example.inventorymaterial.R;
import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.ui.base.BasePresenter;

/**
 * Created by usuario on 30/11/17.
 */

public class ConfirmationDialog {

    public final static int DELETE = 1;

     public static String MESSAGE="message";
    public static  String TITLE="titulo";

    public static Dialog showConfirmDialog(Bundle bnd, Context context, final Object object, final BasePresenter presenter, final int action)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bnd.getString(ConfirmationDialog.MESSAGE))
                .setTitle(bnd.getString(ConfirmationDialog.TITLE))
                .setPositiveButton(R.string.btnOK, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (action)
                        {
                            case DELETE:
                                    presenter.delete(object);
                                break;
                        }
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        return builder.create();
    }
}
