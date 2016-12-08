package edu.purdue.rtenany.app;

import io.realm.RealmObject;

/**
 * Created by Richa on 12/8/16.
 */

public class Allergy extends RealmObject{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
