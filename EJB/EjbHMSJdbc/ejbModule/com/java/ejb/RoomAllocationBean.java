package com.java.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class RoomAllocationBean
 */
@Stateless
@LocalBean
public class RoomAllocationBean implements RoomAllocationBeanRemote {

    /**
     * Default constructor. 
     */
    public RoomAllocationBean() {
        // TODO Auto-generated constructor stub
    }

}
