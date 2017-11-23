package com.example.inventory;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import com.example.inventorymaterial.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

//1. Login
//1.1 El usuario introduce un usuario/email(Instrumentales)

//1.2 El usuario introduce una contraseña(Instrumentales)

//2.Registro

//2.4 La contraseña tiene que tener al menos 6 caracteres (Instrumentales)

//2.7 Doble comprobacion de la contraseña (Instrumentales)

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    //Caso de prueba que comprueba que el campo Usuario no esta vacío
    @Test
    public void isUserEmpty(){
        onView(withId(R.id.btnSignIN)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorUserEmpty);
    }

    //Caso de prueba que comprueba que el campo Email no esta
    // vacío
    @Test
    public void isEmailEmpty() {
        onView(withId(R.id.btnSignIN)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorEmailEmpty);
    }

    //Caso de prueba que comprueba que el campo Password no esta vacío
    @Test
    public void isPasswordEmpty() {
        onView(withId(R.id.btnSignIN)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordEmpty);
    }



    /**
     * Caso de prueba que comprueba la longitud de la contraseña
     */
    @Test
    public void passwordLength() {
        onView(withId(R.id.edtUser)).perform(typeText("lourdes"),closeSoftKeyboard());
        onView(withId(R.id.edtPassword)).perform(typeText("lu"),closeSoftKeyboard());
        onView(withId(R.id.btnSignIN)).perform(click());
        checkSnackBarDisplayByMessage(R.string.errorPasswordLength);
    }

    @Test
    public void passwordDoubleCheck () {

    }

    private void checkSnackBarDisplayByMessage(@StringRes int message) {
        onView(withText(message)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

    }

    }

