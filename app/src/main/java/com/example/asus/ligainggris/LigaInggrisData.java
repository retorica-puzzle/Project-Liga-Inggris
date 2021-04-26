package com.example.asus.ligainggris;

import java.util.ArrayList;

public class LigaInggrisData {
    public static String[][] data = new String[][]{
            {"Liverpool", "You Never Walk Alone", "https://1.bp.blogspot.com/-0F1qu-I0qR4/WUvf0awvW6I/AAAAAAAAA3w/agUfgjlaTOsbNlPZDnfPlG9Rx99b53F2gCLcBGAs/s1600/Logo%2BLiverpool.png"},
            {"Arsenal", "Good Old Arsenal", "https://3.bp.blogspot.com/-zlCgjrgSja0/WUve6wTG3JI/AAAAAAAAA3Q/Z8roQ1aDeFE6rPZs_o5owYRLKR3UEuzuQCLcBGAs/s200/Logo%2BArsenal.png"},
            {"Chelsea", "Blue is The Colour", "https://3.bp.blogspot.com/-mcwx9UJg0aE/WUvfUkdQmvI/AAAAAAAAA3c/nhLvus74GZgWOvV4oWDljFyH17uJAStpACLcBGAs/s200/Logo%2BChelsea.png"},
            {"West Ham", "I Forever Blowing Bubble", "https://2.bp.blogspot.com/-PFaObh8ycE4/WUvg03KlVII/AAAAAAAAA4Y/K6Hs8S19Yzc_FEXTYzDLq6HIDr1BDIIrwCLcBGAs/s200/Logo%2BWest%2BHam%2BUnited.png"},
            {"Mancester United", "Glory Glory Man United", "https://4.bp.blogspot.com/-F7u2OMZFV3g/WUvf-3RODeI/AAAAAAAAA34/e42W-cH4HWEG_JwjsWBswXVWcoMPzdbsQCLcBGAs/s200/Logo%2BManchester%2BUnited.png"},
            {"Mancester City", "Blue Moon", "https://4.bp.blogspot.com/-YlhQcjpqtZc/WUvf53pAM8I/AAAAAAAAA30/a7L1oyLZkCs5eJD-YkjMkRX2oykFdzEBwCLcBGAs/s200/Logo%2BManchester%2BCity.png"},
            {"Tottenham", "Come On You Spurs", "https://3.bp.blogspot.com/-ZdAQw77M7Aw/WUvgg9seVBI/AAAAAAAAA4M/effm6urbUHULS1zF1IoSPNcJhCLIrMgawCLcBGAs/s200/Logo%2BTottenham%2BHotspur.png"}
    };

    public static ArrayList<LigaInggris> getListData(){
        LigaInggris ligaInggris = null;
        ArrayList<LigaInggris> list = new ArrayList<>();
        for (int i = 0; i <data.length; i++) {
            ligaInggris = new LigaInggris();
            ligaInggris.setName(data[i][0]);
            ligaInggris.setRemarks(data[i][1]);
            ligaInggris.setPhoto(data[i][2]);

            list.add(ligaInggris);
        }

        return list;
    }
}
