package com.example.inventorymaterial.ui.login;

import android.text.TextUtils;

import com.example.inventorymaterial.data.db.repository.UserRepository;
import com.example.inventorymaterial.ui.utils.CommonUtils;

/**
 * Created by usuario on 10/11/17.
 */

public class LoginInteractorImpl {

    public void validateCredentials(String user, String password, LoginInteractor.OnLoginFinishedListener listener) {
    //Si el password es vacío
        if(TextUtils.isEmpty(password)) {
            listener.onPasswordEmptyError();
        }else if(TextUtils.isEmpty(user)) {
            listener.onUserEmptyError();
        }else if(!CommonUtils.isPasswordValid(password)) {
            listener.onPasswordError();
        } else if(UserRepository.getInstance().validateCredentials(user,password)) {
            listener.onSuccess();
        }
        //Realiza las comprobaciones

        //UserRepository.getInstance().validateCredentials(user, password) Y es correcto

    }


}
