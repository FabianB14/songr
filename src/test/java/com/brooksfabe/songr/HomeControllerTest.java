package com.brooksfabe.songr;

import com.brooksfabe.songr.contoller.HomeController;
import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {

    @Test
    public void getReversed() {

    assertEquals("This should return a reversed string","pu s'tahW", HomeController.reversed("What's up"));
    }
}