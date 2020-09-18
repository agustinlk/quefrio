package com.alotitokehoe.utn.quefrio;
import java.util.UUID;

public class Ciudad {
    private String id;
    private String nombre;
    //private String temperatura;

    public Ciudad(String nombre) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        //this.temperatura = "20";
    }
    public String getId(){
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    /*public String getTemperatura() {
        return this.temperatura;
    }*/

    /*public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }*/

    @Override
    public String toString() {
        return "Ciudad{" +
                "ID='" + this.id + '\'' +
                ", Nombre='" + this.nombre + '}';
    }
}
