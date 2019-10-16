package org.improving.tag;

import org.improving.tag.database.ExitDAO;
import org.improving.tag.database.LocationDAO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorldBuilder {
    private List<Location> locationList = new ArrayList<>();
    private final LocationDAO locationDAO;
    private final ExitDAO exitDAO;

    public WorldBuilder(LocationDAO locationDAO, ExitDAO exitDAO) {
        this.locationDAO = locationDAO;
        this.exitDAO = exitDAO;
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public Location buildWorld() {

        try {
            List<Location> locations = locationDAO.findAll();


            System.out.println(locations.size());
            System.out.println(locations);
            locationList = locations;
            if (null == locationList) {
                System.out.println("Locationlist is null");
            }
            return locationList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception has been caught" + e.getMessage());
            return null;
        }

    }

//    public Location buildHardCodedWorld() {
//
//        //*****ROOMS*****//
//        System.out.println("HARD coded world has been built.");
//
//        var tdh = new Location();
//        tdh.setName("The Deathly Hallows");
//        this.locationList.add(tdh);
//
//        var td = new Location();
//        td.setName("The Desert");
//        td.setAdversary(new Adversary("Mr. Potato Head"));
//        td.getAdversary().getInventory().addItem(UniqueItems.BLUE_SHELL);
//
//        this.locationList.add(td);
//
//        var ta = new Location();
//        ta.setName("The Amazon");
//        this.locationList.add(ta);
//
//        var tmcs = new Location();
//        tmcs.setName("The Mac & Cheese Shop");
//        tmcs.setTreasureChest(new TreasureChest(UniqueItems.THE_ONE_RING, "A Kraft box"));
//        this.locationList.add(tmcs);
//
//        var ap = new Location();
//        ap.setName("Airport");
//        this.locationList.add(ap);
//
//        var ict = new Location();
//        ict.setName("The Ice Cream Truck");
//        this.locationList.add(ict);
//
//        var tm = new Location();
//        tm.setName("The Mountains");
//        this.locationList.add(tm);
//
//        var tvm = new Location();
//        tvm.setName("The Velvet Moose");
//        this.locationList.add(tvm);
//
//        var tr = new Location();
//        tr.setName("The Reef");
//        this.locationList.add(tr);
//
//        var mall = new Location();
//        mall.setName("The Mall");
//        this.locationList.add(mall);
//
//        var md = new Location();
//        md.setName("Mount Doom");
//        md.setAdversary(new Adversary("Sauron"));
//        this.locationList.add(md);
//
//        var vod = new Location();
//        vod.setName("The Volcano of Death");
//        this.locationList.add(vod);
//
//        //*****EXITS****//
//
//        tdh.getExits().add(new Exit("Heaven Ave", tmcs, "heaven", "h", "ave"));
//        tdh.getExits().add(new Exit("The Deathly Brownie", td, "brownie", "tdb", "deathly", "the"));
//        td.getExits().add(new Exit("Camel Path", ta, "camel", "cp", "path"));
//        td.getExits().add(new Exit("The Dock", ap, "dock", "d", "a"));
//        td.getExits().add(new Exit("Rocky Road", ict, "road", "rr", "rocky"));
//        tmcs.getExits().add(new Exit("Highway 121", ta, "121", "hwy", "hwy121", "h121"));
//        tmcs.getExits().add(new Exit("Paradise Rd", tr, "paradise", "dice", "pr", "p"));
//        tmcs.getExits().add(new Exit("Highway 21", vod, "21", "death", "hwy21", "h21"));
//        tr.getExits().add(new Exit("The Scenic Route", tvm, "scenic", "route", "tsr", "s"));
//        tr.getExits().add(new Exit("the city walk", mall, "walk", "city", "mall", "tcw", "w"));
//        ta.getExits().add(new Exit("Amaz-ing Moose", tvm, "moose", "am", "path", "a"));
//        tvm.getExits().add(new Exit("The Pudding Slide", ap, "slide", "pudding", "tps", "p"));
//        tvm.getExits().add(new Exit("The Front Door", ta, "front", "door", "f", "tfd"));
//        ap.getExits().add(new Exit("flight 121", tm, "flight", "121", "f121"));
//        ap.getExits().add(new Exit("Flight to the Mall", mall, "mall", "f", "fttm", "m"));
//        tm.getExits().add(new Exit("The Lava Flow", vod, "death", "lava", "flow", "l", "f", "tlf"));
//        tm.getExits().add(new Exit("The narrow trail", md, "doom", "narrow", "trail", "n", "t", "tnt"));
//        tm.getExits().add(new Exit("the plane", vod, "plane", "p", "tp", "amazon"));
//        tm.getExits().add(new Exit("bike trail", tr, "bike", "bt", "b", "t", "reef"));
//        ict.getExits().add(new Exit("Magic Portal", md, "magic", "portal", "mp", "m"));
//        mall.getExits().add(new Exit("Path to Doom", md, "doom", "path", "ptd", "p"));
//        mall.getExits().add(new Exit("An escalator of doom", vod, "death", "escalator", "aeod", "e"));
//        md.getExits().add(new Exit("The Cap", mall, "mall", "cab", "tc", "c"));
//
//
//        return tdh;
//    }

    public Location getLocationOf(String intendedLocationName) {
        for (Location location : locationList) {
            if (intendedLocationName.equalsIgnoreCase(location.getName())) {
                return location;
            }
        }

        return null;
    }
}
