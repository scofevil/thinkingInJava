package com.scofevil.test.testevent;

import java.util.EventListener;

/**
 * @param
 * @author haifeng.lu
 * @see
 * @since 1.0
 */
public interface  DoorListener extends EventListener {
     void  doorEvent(DoorEvent event);
}
