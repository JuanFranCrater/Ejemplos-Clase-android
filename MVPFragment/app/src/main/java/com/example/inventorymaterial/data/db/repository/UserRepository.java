package com.example.inventorymaterial.data.db.repository;

import com.example.inventorymaterial.data.db.model.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {
    //Declaracion
    private ArrayList<User> users;
    private static UserRepository userRepository;


    //Inicializacion
    //Inicializar todos los atributos de ámbito statico o de clase
    static {
        userRepository = new UserRepository();
    }

    //El metodo ha de ser privado para garantizar que sólo hay una instancia de Repository
    private UserRepository() {
        this.users = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        addUser(new User(1,"Paco","paco","Paco Garcia","PacoCorreo@falso.es",
                true,true));
        addUser(new User(2,"Antonio","antonio","Antonio Garcia","AntonioCorreo@falso.es",
                false,false));
        addUser(new User(3,"Pepe","pepe","Pepe Garcia","PepeCorreo@falso.es",
                true,false));
        addUser(new User(4,"Lourdes","Lourdes1", "Lourdes","correo",
                false,false));

    }

    public static UserRepository getInstance() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }


    /**
     * Método que añade una dependencia
     *
     * @param user
     */
    public void addUser(User user) {
        users.add(user);

    }

    public ArrayList<User> getUsers() {
        return users;
    }



    /**
     * Metodo que comprueba si el usuario existe en la base de datos.
     * @return
     */
    public boolean isUserExits(User user)
    {
    return users.contains(user);
    }
    public boolean validateCredentials(String user, String password)
    {
        if()
        {

        }
        return true;
    }
}
