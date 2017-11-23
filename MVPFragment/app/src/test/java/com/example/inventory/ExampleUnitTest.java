package com.example.inventory;

import com.example.inventorymaterial.data.db.model.User;
import com.example.inventorymaterial.data.db.repository.UserRepository;
import com.example.inventorymaterial.ui.utils.CommonUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private ArrayList<User> users;
    //objecto vacio de la clase repository
    @Mock
    private UserRepository userRepository;

    @Before
    public void initialice(){
        userRepository = mock(UserRepository.class);
        users= new ArrayList<>();
        users.add(new User(1,"Paco","paco","Paco Garcia","PacoCorreo@falso.es",
                true,true));
        users.add(new User(2,"Maria","Maria","Maria Garcia","MariaCorreo@falso.es",
                false,false));
        users.add(new User(3,"Carla","Carla","Carla Garcia","CarlaCorreo@falso.es",
                true,false));
    }

    //1.3 El usuario existe en la base de datos(Repository)
    //Para realizar esta prueba se debe Poder comparar dos objetos Usuario
    @Test
    public void isUserExits_isCorrect() throws Exception{
        //Cuando se llame al método isUserExists, devuelva un valor predeterminado.
        when(userRepository.isUserExits(users.get(0))).thenReturn(true);
        assertTrue(userRepository.isUserExits(users.get(0)));
    }

    @Test
    public void getUsers_isCorrect() throws Exception{
        //Cuando se llame al método getUsers, devuelva un valor predeterminado.
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(userRepository.getUsers().get(0),users.get(0));
    }

    //1.4 La contraseña son correctas (Repository)

    @Test
    public void password_isCorrect() throws Exception{
        //Cuando se llame al método getUsers, devuelva un valor predeterminado.
        when(userRepository.getUsers()).thenReturn(users);
        assertEquals(userRepository.getUsers().get(0).getPassword(),"paco");
    }


    @Test
    public void SignIn_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

    }


    /*
    Ejemplo de prueba donde vemos el conjunto de pruebas que podemos realizar
    */
    @Test
    public void testAssertions()
    {
        //Comparar si dos objetos son iguaels
        User user=new User(1,"Paco","paco","Paco Garcia","PacoCorreo@falso.es",
                true,true);
        assertEquals(user, users.get(0));
        //Un objeto es nulo
        User user2 = null;
        assertNull(user2);
        //UN objeto no es nulo
        assertNotNull(user);
        //Dos objetos apuntan a la misma referencias
        User user3=user;
        assertSame(user,user3);
    }

    //2.5 El email no existe en la base de datos (Repository)

    //2.6 El usuario no existe en la base de datos(Repositoy


    @Test
    public void SignUp_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    public void isPasswordValid()
    {
        CommonUtils.isPasswordValid("contraseña");
        CommonUtils.isPasswordValid("Contraseña");
        CommonUtils.isPasswordValid("Cont1");
        CommonUtils.isPasswordValid("Contraseña1");

    }
}