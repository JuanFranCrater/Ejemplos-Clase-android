package com.example.inventorymaterial.data.db.repository;


import com.example.inventorymaterial.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 30/10/17.
 */

public class SectorRepository {
    //Declaracion
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;


    //Inicializacion
    //Inicializar todos los atributos de ámbito statico o de clase
    static {
        sectorRepository = new SectorRepository();
    }

    //El metodo ha de ser privado para garantizar que sólo hay una instancia de Repository
    private SectorRepository() {
        this.sectors = new ArrayList<>();
        initialize();
    }

    private void initialize() {
        addSector(new Sector(1,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(2,"Armario B","ArmB","Armario de libros y el Papel",2,true,true));
        addSector(new Sector(3,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(4,"Armario B","ArmB","Armario de libros y el Papel",2,true,true));
        addSector(new Sector(5,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(6,"Armario B","ArmB","Armario de libros y el Papel",2,true,true));
        addSector(new Sector(7,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(8,"Armario B","ArmB","Armario de libros y el Papel",2,true,true));
        addSector(new Sector(9,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(10,"Armario B","ArmB","Armario de libros y el Papel",2,true,true));
        addSector(new Sector(11,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(12,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(13,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(14,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));
        addSector(new Sector(15,"Armario A","ArmA","Armario de libros y el Agua de Sebastian",2,true,true));

    }

    public static SectorRepository getInstance() {
        if (sectorRepository == null)
            sectorRepository = new SectorRepository();
        return sectorRepository;
    }


    /**
     * Método que añade una dependencia
     *
     * @param sector
     */
    public void addSector(Sector sector) {
        sectors.add(sector);

    }

    public ArrayList<Sector> getSectors() {
        return sectors;
    }
}
