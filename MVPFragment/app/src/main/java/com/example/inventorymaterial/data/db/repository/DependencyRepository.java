package com.example.inventorymaterial.data.db.repository;

import android.util.Log;

import com.example.inventorymaterial.data.db.model.Dependency;
import com.example.inventorymaterial.data.db.model.Sector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by
 * @creator Juan Francisco
 */

public class DependencyRepository {

    //Declaracion
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;


    //Inicializacion
    //Inicializar todos los atributos de ámbito statico o de clase
    static {
        dependencyRepository = new DependencyRepository();
    }


    //El metodo ha de ser privado para garantizar que sólo hay una instancia de Repository
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        initialize();
    }

    //Metodos

    private void initialize() {
        addDependency(new Dependency(1, "1 Cliclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2 Cliclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(3, "1 Cliclo Formativo Grado Medio", "1CFGS",
                "1CFGM Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(4, "2 Cliclo xcx Grado Medio", "2CFGM",
                "2CFGM Desarrollo Aplicaciones Multiplataforma"));

    }

    public static DependencyRepository getInstance() {
        if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }


    /**
     * Método que añade una dependencia
     *
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        dependencies.add(dependency);

    }
    public void editDependency(int id, String name, String shortname, String description) {

        for (int i = 0; i < dependencies.size(); i++)
        {
            if((dependencies.get(i).get_ID() == id))
            {
                dependencies.get(i).setName(name);
                dependencies.get(i).setShortname(shortname);
                dependencies.get(i).setDescription(description);
            }
        }
    }
    public int foundDependency(String name, String shortname)
    {
        for (int i = 0; i < dependencies.size(); i++)
        {
            if((dependencies.get(i).getName().equals(name)&&dependencies.get(i).getShortname().equals(shortname)))
            {
                return  dependencies.get(i).get_ID();
            }
        }
        return -1;
    }
    public ArrayList<Dependency> getDependencies()
    {
        Collections.sort(dependencies);
        //Collections.sort(dependencies, new Dependency.DependencyOrderByShortName());
        return dependencies;
    }

    public void deleteDependency(Dependency dependency) {
        //para borrar DeleteDependency
        Iterator<Dependency> iterator = dependencies.iterator();
        Dependency dependencyite;
        while(iterator.hasNext())
        {
            dependencyite=iterator.next();
            if(dependencyite.get_ID()==dependency.get_ID())
            {
                iterator.remove();
            }
        }
    }

}
